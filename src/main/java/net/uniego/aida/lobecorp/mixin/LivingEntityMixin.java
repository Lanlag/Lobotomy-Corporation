package net.uniego.aida.lobecorp.mixin;

import com.google.common.collect.Iterables;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.access.ManagerAccess;
import net.uniego.aida.lobecorp.entity.LobeCorpEntity;
import net.uniego.aida.lobecorp.init.AttributeInit;
import net.uniego.aida.lobecorp.init.DamageInit;
import net.uniego.aida.lobecorp.item.ego.weapon.EGOWeapon;
import net.uniego.aida.lobecorp.manager.SanityManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    @Unique
    LivingEntity livingEntity = (LivingEntity) (Object) this;

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow
    public abstract float getMaxHealth();

    @Shadow
    public abstract float getHealth();

    @Shadow
    public abstract void setHealth(float health);

    @Shadow
    public abstract float getMaxAbsorption();

    @Shadow
    public abstract float getAbsorptionAmount();

    @Shadow
    public abstract void setAbsorptionAmount(float absorptionAmount);

    //将新增的18插槽列入装备物品列表里
    @Inject(method = "getEquippedItems", at = @At("RETURN"), cancellable = true)
    private void getEquippedItemsMixin(CallbackInfoReturnable<Iterable<ItemStack>> cir) {
        if (livingEntity instanceof PlayerEntity player) {
            List<ItemStack> egoSlotItems = IntStream.rangeClosed(63, 80).mapToObj(player.getInventory()::getStack).collect(Collectors.toList());
            Iterable<ItemStack> equippedItems = cir.getReturnValue();
            cir.setReturnValue(Iterables.concat(equippedItems, egoSlotItems));
        }
    }

    //移除影响效果的时候，使得精神值和认知同化值不超过最大
    @Inject(method = "updateAttribute", at = @At("HEAD"), cancellable = true)
    private void updateAttributeMixin(RegistryEntry<EntityAttribute> attribute, CallbackInfo ci) {
        float f;
        if (attribute.equals(EntityAttributes.GENERIC_MAX_HEALTH)) {
            f = getMaxHealth();
            if (getHealth() > f) {
                setHealth(f);
            }
        } else if (attribute.equals(EntityAttributes.GENERIC_MAX_ABSORPTION)) {
            f = getMaxAbsorption();
            if (getAbsorptionAmount() > f) {
                setAbsorptionAmount(f);
            }
        } else if (livingEntity instanceof PlayerEntity player) {
            SanityManager sanityManager = ((ManagerAccess) player).lobecorp$getSanityManager();
            if (attribute.equals(AttributeInit.PLAYER_MAX_SANITY)) {
                f = sanityManager.getMaxSanity();
                if (sanityManager.getSanity() > f) {
                    sanityManager.setSanity(f);
                }
            } else if (attribute.equals(AttributeInit.PLAYER_MAX_ASSIMILATION)) {
                f = sanityManager.getMaxAssimilation();
                if (sanityManager.getAssimilationAmount() > f) {
                    sanityManager.setAssimilationAmount(f);
                }
            }
        }
        ci.cancel();
    }

    //废除原版伤害吸收机制
    @ModifyArg(method = "applyDamage", at = @At(value = "INVOKE", target = "java/lang/Math.max(FF)F", ordinal = 0), index = 0)
    private float applyDamageMixin1(float a) {
        return a + getAbsorptionAmount();
    }

    //新增四色伤害机制
    @Inject(method = "applyDamage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;setHealth(F)V"))
    private void applyDamageMixin(DamageSource source, float amount, CallbackInfo ci) {
        //等级压制抗性计算
        LobeCorpUtil.EGOLevel defenderLevel = livingEntity instanceof LobeCorpEntity lobecorpEntity ? lobecorpEntity.getEGOLevel() : LobeCorpUtil.EGOLevel.ZAYIN;
        LobeCorpUtil.EGOLevel attackerLevel = LobeCorpUtil.EGOLevel.ZAYIN;
        Entity attacker = source.getAttacker();
        if (attacker instanceof PlayerEntity player) {
            attackerLevel = player.getMainHandStack().getItem() instanceof EGOWeapon egoWeapon ? egoWeapon.getEGOLevel() : LobeCorpUtil.EGOLevel.ZAYIN;
        } else if (attacker instanceof LobeCorpEntity lobecorpEntity) {
            attackerLevel = lobecorpEntity.getEGOLevel();
        }
        float levelResist = LobeCorpUtil.calculateLevelSuppress(defenderLevel, attackerLevel);
        //四色抗性计算
        float redResist = livingEntity instanceof LobeCorpEntity lobecorpEntity ? lobecorpEntity.getRedResist() : 2.0F;
        float whiteResist = livingEntity instanceof LobeCorpEntity lobecorpEntity ? lobecorpEntity.getWhiteResist() : 2.0F;
        float blackResist = livingEntity instanceof LobeCorpEntity lobecorpEntity ? lobecorpEntity.getBlackResist() : 2.0F;
        float paleResist = livingEntity instanceof LobeCorpEntity lobecorpEntity ? lobecorpEntity.getPaleResist() : 2.0F;
        //根据伤害类型分流
        if (source.isOf(DamageTypes.GENERIC_KILL) || source.isOf(DamageTypes.OUT_OF_WORLD) || source.isOf(DamageTypes.OUTSIDE_BORDER)) {
            float healthF = amount;
            if (healthF > getAbsorptionAmount()) setAbsorptionAmount(0);
            healthF = Math.max(healthF - getAbsorptionAmount(), 0);
            setAbsorptionAmount(getAbsorptionAmount() - (amount - healthF));
            setHealth(getHealth() - healthF);
        } else if (source.isOf(DamageInit.RED)) {
            float healthF = amount * redResist * levelResist;
            if (healthF > getAbsorptionAmount()) setAbsorptionAmount(0);
            if (redResist > 0) {
                healthF = Math.max(healthF - getAbsorptionAmount(), 0);
                setAbsorptionAmount(getAbsorptionAmount() - (amount * redResist * levelResist - healthF));
            }
            setHealth(getHealth() - healthF);
        } else if (source.isOf(DamageInit.WHITE)) {
            float healthF = amount * whiteResist * levelResist;
            if (healthF > getAbsorptionAmount()) setAbsorptionAmount(0);
            if (whiteResist > 0) {
                healthF = Math.max(healthF - getAbsorptionAmount(), 0);
                setAbsorptionAmount(getAbsorptionAmount() - (amount * whiteResist * levelResist - healthF));
            }
            setHealth(getHealth() - healthF);
        } else if (source.isOf(DamageInit.BLACK)) {
            float healthF = amount * blackResist * levelResist;
            if (healthF > getAbsorptionAmount()) setAbsorptionAmount(0);
            if (blackResist > 0) {
                healthF = Math.max(healthF - getAbsorptionAmount(), 0);
                setAbsorptionAmount(getAbsorptionAmount() - (amount * blackResist * levelResist - healthF));
            }
            setHealth(getHealth() - healthF);
        } else if (source.isOf(DamageInit.PALE)) {
            float healthF = (amount / 100) * getMaxHealth() * paleResist * levelResist;
            if (healthF > getAbsorptionAmount()) setAbsorptionAmount(0);
            if (paleResist > 0) {
                healthF = Math.max(healthF - getAbsorptionAmount(), 0);
                setAbsorptionAmount(getAbsorptionAmount() - ((amount / 100) * getMaxHealth() * paleResist * levelResist - healthF));
            }
            setHealth(getHealth() - healthF);
        } else {
            float healthF = Math.max(amount * (livingEntity instanceof LobeCorpEntity ? 0 : 1) - getAbsorptionAmount(), 0);
            setAbsorptionAmount(getAbsorptionAmount() - (amount - healthF));
            setHealth(getHealth() - healthF);
        }
    }

    //废除原版减少生命值机制
    @ModifyArg(method = "applyDamage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;setHealth(F)V"))
    private float applyDamageMixin2(float par1) {
        return getHealth();
    }

    //废除原版减少伤害吸收值机制
    @ModifyArg(method = "applyDamage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;setAbsorptionAmount(F)V", ordinal = 1))
    private float applyDamageMixin3(float amount) {
        return getAbsorptionAmount();
    }
}
