package net.uniego.aida.lobecorp.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.Difficulty;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.access.ManagerAccess;
import net.uniego.aida.lobecorp.init.AttributeInit;
import net.uniego.aida.lobecorp.manager.LevelManager;
import net.uniego.aida.lobecorp.manager.SanityManager;
import net.uniego.aida.lobecorp.manager.ThirstManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity implements ManagerAccess {
    @Unique
    private final ThirstManager thirstManager = new ThirstManager();
    @Unique
    private final LevelManager levelManager = new LevelManager();
    @Unique
    PlayerEntity playerEntity = (PlayerEntity) (Object) this;
    @Unique
    private final SanityManager sanityManager = new SanityManager(playerEntity);
    @Unique
    private double syncedMaxHealth = -1.0E8F;
    @Unique
    private double syncedMaxSanity = -1.0E8F;
    @Unique
    private double syncedWorkSuccess = -1.0E8F;
    @Unique
    private double syncedWorkVelocity = -1.0E8F;
    @Unique
    private double syncedAttackVelocity = -1.0E8F;
    @Unique
    private double syncedMoveVelocity = -1.0E8F;

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    //为玩家加上自定义属性
    @Inject(method = "createPlayerAttributes", at = @At("RETURN"))
    private static void createPlayerAttributesMixin(CallbackInfoReturnable<DefaultAttributeContainer.Builder> cir) {
        cir.getReturnValue()
                .add(AttributeInit.PLAYER_MAX_SANITY)
                .add(AttributeInit.PLAYER_MAX_ASSIMILATION)
                .add(AttributeInit.PLAYER_WORK_SUCCESS)
                .add(AttributeInit.PLAYER_WORK_VELOCITY)
                .add(AttributeInit.PLAYER_ATTACK_VELOCITY)
                .add(AttributeInit.PLAYER_MOVE_VELOCITY);
    }

    @Override
    public SanityManager lobecorp$getSanityManager() {
        return sanityManager;
    }

    @Override
    public ThirstManager lobecorp$getThirstManager() {
        return thirstManager;
    }

    @Override
    public LevelManager lobecorp$getLevelManager() {
        return levelManager;
    }

    //使精神值和干渴值能在和平模式且游戏规则自然恢复启用下回复
    @Inject(method = "tickMovement", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerInventory;updateItems()V"))
    private void tickMovementMixin1(CallbackInfo ci) {
        if (getWorld().getDifficulty() == Difficulty.PEACEFUL && getWorld().getGameRules().getBoolean(GameRules.NATURAL_REGENERATION)) {
            if (sanityManager.getSanity() < sanityManager.getMaxSanity() && age % 20 == 0 && !getWorld().isClient) {
                sanityManager.cure(1.0F);
            }
            if (thirstManager.isNotFull() && age % 10 == 0) {
                thirstManager.setWaterLevel(thirstManager.getWaterLevel() + 1);
            }
        }
    }

    //对原版攻速和移速进行乘算
    @Inject(method = "tickMovement", at = @At("HEAD"))
    private void tickMovementMixin2(CallbackInfo ci) {
        //参数获取
        double maxHealth = getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH);
        double maxSanity = getAttributeValue(AttributeInit.PLAYER_MAX_SANITY);
        double workSuccess = getAttributeValue(AttributeInit.PLAYER_WORK_SUCCESS);
        double workVelocity = getAttributeValue(AttributeInit.PLAYER_WORK_VELOCITY);
        double attackVelocity = getAttributeValue(AttributeInit.PLAYER_ATTACK_VELOCITY);
        double moveVelocity = getAttributeValue(AttributeInit.PLAYER_MOVE_VELOCITY);
        //根据变化再计算等级
        if (maxHealth != syncedMaxHealth || maxSanity != syncedMaxSanity
                || workSuccess != syncedWorkSuccess || workVelocity != syncedWorkVelocity
                || attackVelocity != syncedAttackVelocity || moveVelocity != syncedMoveVelocity) {
            levelManager.update(maxHealth, maxSanity, workSuccess, workVelocity, attackVelocity, moveVelocity);
            if (!getWorld().isClient) {
                //根据变化再实时用攻击速率和移动速率修改原版攻击速度和移动速度
                if (attackVelocity != syncedAttackVelocity || moveVelocity != syncedMoveVelocity) {
                    EntityAttributeInstance attackSpeed = getAttributeInstance(EntityAttributes.GENERIC_ATTACK_SPEED);
                    EntityAttributeInstance movementSpeed = getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
                    if (attackSpeed != null) {
                        EntityAttributeModifier oldModifier = attackSpeed.getModifier(AttributeInit.ATTACK_VELOCITY_MODIFIER_ID);
                        if (oldModifier != null) attackSpeed.removeModifier(oldModifier);
                        EntityAttributeModifier newModifier = new EntityAttributeModifier(AttributeInit.ATTACK_VELOCITY_MODIFIER_ID,
                                "LobeCorp Attribute modifier",
                                (attackVelocity * 0.2F) / 100, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE);
                        attackSpeed.addPersistentModifier(newModifier);
                    }
                    if (movementSpeed != null) {
                        EntityAttributeModifier oldModifier = movementSpeed.getModifier(AttributeInit.MOVE_VELOCITY_MODIFIER_ID);
                        if (oldModifier != null) movementSpeed.removeModifier(oldModifier);
                        EntityAttributeModifier newModifier = new EntityAttributeModifier(AttributeInit.MOVE_VELOCITY_MODIFIER_ID,
                                "LobeCorp Attribute modifier",
                                (moveVelocity * 0.2F) / 100, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE);
                        movementSpeed.addPersistentModifier(newModifier);
                    }
                }
            }
            syncedMaxHealth = maxHealth;
            syncedMaxSanity = maxSanity;
            syncedWorkSuccess = workSuccess;
            syncedWorkVelocity = workVelocity;
            syncedAttackVelocity = attackVelocity;
            syncedMoveVelocity = moveVelocity;
        }
    }

    //更新精神机制中的恐慌机制，干渴机制，等级机制，EGO适配机制
    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/HungerManager;update(Lnet/minecraft/entity/player/PlayerEntity;)V"))
    private void tickMixin(CallbackInfo ci) {
        sanityManager.panicState();
        thirstManager.update(playerEntity);
    }

    //为干渴机制引入消耗度
    @Inject(method = "addExhaustion", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/HungerManager;addExhaustion(F)V"))
    private void addExhaustionMixin(float exhaustion, CallbackInfo ci) {
        thirstManager.addDesiccation(exhaustion);
    }

    //读取精神机制和干渴机制的nbt
    @Inject(method = "readCustomDataFromNbt", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/HungerManager;readNbt(Lnet/minecraft/nbt/NbtCompound;)V"))
    private void readCustomDataFromNbtMixin(NbtCompound nbt, CallbackInfo ci) {
        sanityManager.readNbt(nbt);
        thirstManager.readNbt(nbt);
    }

    //写入精神机制和干渴机制的nbt
    @Inject(method = "writeCustomDataToNbt", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/HungerManager;writeNbt(Lnet/minecraft/nbt/NbtCompound;)V"))
    private void writeCustomDataToNbtMixin(NbtCompound nbt, CallbackInfo ci) {
        sanityManager.writeNbt(nbt);
        thirstManager.writeNbt(nbt);
    }

    /*//废除原版伤害吸收机制
    @ModifyArg(method = "applyDamage", at = @At(value = "INVOKE", target = "java/lang/Math.max(FF)F", ordinal = 0), index = 0)
    private float applyDamageMixin1(float a) {
        return a + getAbsorptionAmount();
    }

    //新增四色伤害机制以及其他受伤机制
    @Inject(method = "applyDamage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;setHealth(F)V"))
    private void applyDamageMixin(DamageSource source, float amount, CallbackInfo ci) {

    }

    //废除原版减少生命值机制
    @ModifyArg(method = "applyDamage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;setHealth(F)V"))
    private float applyDamageMixin2(float par1) {
        return getHealth();
    }*/
}
