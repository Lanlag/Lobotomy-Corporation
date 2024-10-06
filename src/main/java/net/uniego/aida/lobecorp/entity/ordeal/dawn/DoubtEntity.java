package net.uniego.aida.lobecorp.entity.ordeal.dawn;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.util.function.ValueLists;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.AnimationUtil;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.access.ServerPlayerAccess;
import net.uniego.aida.lobecorp.entity.DeadPlayerEntity;
import net.uniego.aida.lobecorp.entity.ai.goal.MeleeAttackWithPreActionGoal;
import net.uniego.aida.lobecorp.entity.ordeal.OrdealEntity;
import net.uniego.aida.lobecorp.init.DamageInit;

import java.util.EnumSet;
import java.util.function.IntFunction;

//疑问实体
public class DoubtEntity extends OrdealEntity {
    public static final TrackedDataHandler<DoubtEntity.State> DOUBT_STATE = TrackedDataHandler.create(DoubtEntity.State.PACKET_CODEC);
    private static final TrackedData<DoubtEntity.State> STATE = DataTracker.registerData(DoubtEntity.class, DOUBT_STATE);
    public final AnimationState attackingAnimationState = new AnimationState();
    public final AnimationState executeAnimationState = new AnimationState();
    public final AnimationState dieAnimationState = new AnimationState();
    public DeadPlayerEntity targetDeadPlayer;
    public float gearAngle;
    public float deadPivotY = 16;
    public float deadPivotZ = 0;

    public DoubtEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world, LobeCorpUtil.EGOLevel.TETH, 0.8F, 1.3F, 2.0F, 1.0F);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 128.0F)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 150.0F)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0F)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0F);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        TrackedDataHandlerRegistry.register(DOUBT_STATE);
        builder.add(STATE, DoubtEntity.State.IDLING);
    }

    @Override
    protected void initGoals() {
        goalSelector.add(8, new LookAroundGoal(this));
        goalSelector.add(7, new LookAtEntityGoal(this, LivingEntity.class, 16.0F));
        goalSelector.add(6, new WanderAroundFarGoal(this, 1.0F));
        goalSelector.add(5, new MeleeAttackWithPreActionGoal<>(this, 1.2F, false, 1.0F, 0.32F, 1.0F, 0.5F));
        goalSelector.add(0, new DoubtExecuteGoal(this, 1.0F, 1.68F, 15, 1.48F, 0.72F, 0.88F, 1.04F, 1.2F));
        targetSelector.add(1, new RevengeGoal(this));
        targetSelector.add(2, new ActiveTargetGoal<>(this, LivingEntity.class, 10, true, true, GREEN_ORDEAL_ATTACK_TARGET_PREDICATE));
    }

    private DoubtEntity.State getState() {
        return dataTracker.get(STATE);
    }

    private void setState(State state) {
        dataTracker.set(STATE, state);
    }

    @Override
    public void onTrackedDataSet(TrackedData<?> data) {
        if (STATE.equals(data)) {
            DoubtEntity.State state = getState();
            stopAnimations();
            switch (state) {
                case ATTACKING:
                    attackingAnimationState.startIfNotRunning(age);
                    break;
                case EXECUTING:
                    executeAnimationState.startIfNotRunning(age);
                    break;
                case DIE:
                    dieAnimationState.startIfNotRunning(age);
                    break;
            }

            calculateDimensions();
        }

        super.onTrackedDataSet(data);
    }

    private void stopAnimations() {
        attackingAnimationState.stop();
    }

//    public DoubtEntity startState(DoubtEntity.State state) {
//        switch (state) {
//            case IDLING:
//                setState(DoubtEntity.State.IDLING);
//                break;
//            case ATTACKING:
//                setState(State.ATTACKING);
//                break;
//            case EXECUTING:
//                setState(State.EXECUTING);
//                break;
//            case DIE:
//                setState(State.DIE);
//                break;
//        }
//
//        return this;
//    }

    @Override
    public void tick() {
        super.tick();
        if (isDead()) {
            setState(State.DIE);
        } else {
            this.gearAngle += AnimationUtil.degreeToRadians(1);
        }
    }

    public float getGearAngle() {
        return gearAngle;
    }

    public void setDeadPivotY(float deadPivotY){
        this.deadPivotY = deadPivotY;
    }

    public void setDeadPivotZ(float deadPivotZ){
        this.deadPivotZ = deadPivotZ;
    }

    public void startAttackAction() {
        setState(DoubtEntity.State.ATTACKING);
    }

    public void stopAttackAction() {
        setState(State.IDLING);
        setAttacking(false);
    }

    public boolean shouldAttack() {
        return this.isAlive() && this.getState() == State.IDLING;
    }

    @Override
    public boolean isInAttackRange(LivingEntity target) {
        double distance = target.getPos().distanceTo(getPos());

        double dx = target.getX() - getX();
        double dz = target.getZ() - getZ();
        float angle = (float) ((Math.atan2(dz, dx) * 180D) / Math.PI) - 90;
        float difference = MathHelper.abs((bodyYaw - angle) % 360);

        boolean bl = this.getAttackBox().intersects(target.getHitbox());
        return (distance <= 3 && difference <= 35) || bl;
    }

    @Override
    public boolean tryAttack(Entity target) {
        boolean result = tryColorAttack(this, target, DamageInit.RED);
        if (result && target instanceof PlayerEntity player) {
            if (player.isDead()) {
                this.targetDeadPlayer = ((ServerPlayerAccess) player).lobecorp$getDeadPlayer();
            }
        }
        return result;
    }

    public enum State {
        IDLING(0),
        ATTACKING(1),
        EXECUTING(2),
        DIE(3);

        public static final IntFunction<DoubtEntity.State> INDEX_TO_VALUE = ValueLists.createIdToValueFunction(
                DoubtEntity.State::getIndex, values(), ValueLists.OutOfBoundsHandling.ZERO
        );
        public static final PacketCodec<ByteBuf, DoubtEntity.State> PACKET_CODEC = PacketCodecs.indexed(INDEX_TO_VALUE, DoubtEntity.State::getIndex);
        private final int index;

        State(final int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }

    public static class DoubtExecuteGoal extends Goal {
        protected final DoubtEntity mob;
        private final int executeDuration;
        private final float[] attackMoments;
        private final float executeMoment;
//        private final TargetPredicate targetPredicate;
        private float executeTime;

        public DoubtExecuteGoal(DoubtEntity mob, float executeSpeed, float executeDuration, float attackRange, float executeMoment, float... attackMoments) {
            this.mob = mob;
//            this.targetPredicate = TargetPredicate.createAttackable().setBaseMaxDistance(attackRange);
            this.executeDuration = (int) (executeDuration / executeSpeed * 20);
            this.executeMoment = this.executeDuration - (int) (executeMoment / executeSpeed * 20);
            this.attackMoments = attackMoments;
            for (int i = 0; i < attackMoments.length; i++) {
                this.attackMoments[i] = this.executeDuration - (int) (attackMoments[i] / executeSpeed * 20);
            }
            setControls(EnumSet.of(Control.MOVE, Control.LOOK));
        }

        public boolean canStart() {
            if (mob.isAlive()) {
                DeadPlayerEntity targetDeadPlayer = mob.targetDeadPlayer;
                if (targetDeadPlayer == null) {
                    return false;
                } else return !targetDeadPlayer.isRemoved();
            }
            return false;
        }

        public boolean shouldContinue() {
            return mob.getState() == State.EXECUTING && !isExecuteFinished();
        }

        public boolean shouldRunEveryTick() {
            return true;
        }

        public void tick() {
            executeTime = Math.max(executeTime - 1, 0);
            if (executeTime <= 0) {
                stop();
            } else if (executeTime == executeMoment) {
                finalAttack();
            } else {
                for (float attackMoment : attackMoments) {
                    if (executeTime == attackMoment && mob.targetDeadPlayer != null) {
                        attack();
                    }
                }
            }
        }

        public void start() {
            mob.setState(State.EXECUTING);
            mob.setVelocity(Vec3d.ZERO);
            executeTime = executeDuration;
        }

        public void stop() {
            mob.setState(State.IDLING);
        }

        public boolean isExecuteFinished() {
            return executeTime <= 0;
        }

        public void attack() {
        }

        public void finalAttack() {
            attack();
            mob.targetDeadPlayer.discard();
        }
    }
}
