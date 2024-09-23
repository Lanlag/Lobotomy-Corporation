package net.uniego.aida.lobecorp.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.access.ManagerAccess;
import net.uniego.aida.lobecorp.init.AttributeInit;
import net.uniego.aida.lobecorp.init.DamageInit;
import net.uniego.aida.lobecorp.manager.SanityManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    @Unique
    LivingEntity livingEntity = (LivingEntity) (Object) this;

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

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
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
        return a + this.getAbsorptionAmount();
    }

    //新增四色伤害机制
    @Inject(method = "applyDamage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;setHealth(F)V"))
    private void applyDamageMixin(DamageSource source, float amount, CallbackInfo ci) {
        if (source.isOf(DamageTypes.GENERIC_KILL) || source.isOf(DamageTypes.OUT_OF_WORLD) || source.isOf(DamageTypes.OUTSIDE_BORDER)) {
            float healthF = amount;
            if (healthF > this.getAbsorptionAmount()) this.setAbsorptionAmount(0.0f);
            healthF = Math.max(healthF - this.getAbsorptionAmount(), 0.0f);
            this.setAbsorptionAmount(this.getAbsorptionAmount() - (amount - healthF));
            this.setHealth(this.getHealth() - healthF);
        } else if (source.isOf(DamageInit.RED)) {
            float healthF = amount;
            if (healthF > this.getAbsorptionAmount()) this.setAbsorptionAmount(0.0f);
            healthF = Math.max(healthF - this.getAbsorptionAmount(), 0.0f);
            this.setAbsorptionAmount(this.getAbsorptionAmount() - (amount - healthF));
            this.setHealth(this.getHealth() - healthF);
        } else if (source.isOf(DamageInit.WHITE)) {
            float healthF = amount;
            if (healthF > this.getAbsorptionAmount()) this.setAbsorptionAmount(0.0f);
            healthF = Math.max(healthF - this.getAbsorptionAmount(), 0.0f);
            this.setAbsorptionAmount(this.getAbsorptionAmount() - (amount - healthF));
            this.setHealth(this.getHealth() - healthF);
        } else if (source.isOf(DamageInit.BLACK)) {
            float healthF = amount;
            if (healthF > this.getAbsorptionAmount()) this.setAbsorptionAmount(0.0f);
            healthF = Math.max(healthF - this.getAbsorptionAmount(), 0.0f);
            this.setAbsorptionAmount(this.getAbsorptionAmount() - (amount - healthF));
            this.setHealth(this.getHealth() - healthF);
        } else if (source.isOf(DamageInit.PALE)) {
            float healthF = (amount / 100.0f) * this.getMaxHealth();
            if (healthF > this.getAbsorptionAmount()) this.setAbsorptionAmount(0.0f);
            healthF = Math.max(healthF - this.getAbsorptionAmount(), 0.0f);
            this.setAbsorptionAmount(this.getAbsorptionAmount() - ((amount / 100.0f) * this.getMaxHealth() - healthF));
            this.setHealth(this.getHealth() - healthF);
        } else {
            float healthF = Math.max(amount * -this.getAbsorptionAmount(), 0.0f);
            this.setAbsorptionAmount(this.getAbsorptionAmount() - (amount - healthF));
            this.setHealth(this.getHealth() - healthF);
        }
    }

    //废除原版减少生命值机制
    @ModifyArg(method = "applyDamage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;setHealth(F)V"))
    private float applyDamageMixin2(float par1) {
        return this.getHealth();
    }

    //废除原版减少伤害吸收值机制
    @ModifyArg(method = "applyDamage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;setAbsorptionAmount(F)V", ordinal = 1))
    private float applyDamageMixin3(float amount) {
        return this.getAbsorptionAmount();
    }
}
