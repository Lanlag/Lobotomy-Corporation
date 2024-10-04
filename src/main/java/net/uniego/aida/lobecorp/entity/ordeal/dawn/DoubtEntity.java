package net.uniego.aida.lobecorp.entity.ordeal.dawn;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
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
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.access.ServerPlayerAccess;
import net.uniego.aida.lobecorp.entity.DeadPlayerEntity;
import net.uniego.aida.lobecorp.entity.ai.goal.MeleeAttackWithPreActionGoal;
import net.uniego.aida.lobecorp.entity.ordeal.OrdealEntity;
import net.uniego.aida.lobecorp.init.DamageInit;

import java.util.function.IntFunction;

//疑问实体
public class DoubtEntity extends OrdealEntity {
    public AnimationState attackingAnimationState = new AnimationState();
    public static final TrackedDataHandler<DoubtEntity.State> DOUBT_STATE = TrackedDataHandler.create(DoubtEntity.State.PACKET_CODEC);
    private static final TrackedData<DoubtEntity.State> STATE = DataTracker.registerData(DoubtEntity.class, DOUBT_STATE);

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
        goalSelector.add(4, new MeleeAttackWithPreActionGoal<>(this,1.0,false,0.32F,1.0F,0.5F));
        targetSelector.add(1, new RevengeGoal(this));
        targetSelector.add(2, new ActiveTargetGoal<>(this, LivingEntity.class, 10, true, true, GREEN_ATTACK_TARGET_PREDICATE));
    }

    private DoubtEntity.State getState() {
        return this.dataTracker.get(STATE);
    }

    private DoubtEntity setState(DoubtEntity.State state) {
        this.dataTracker.set(STATE, state);
        return this;
    }

    @Override
    public void onTrackedDataSet(TrackedData<?> data) {
        if (STATE.equals(data)) {
            DoubtEntity.State state = this.getState();
            this.stopAnimations();
            switch (state) {
                case ATTACKING:
                    this.attackingAnimationState.startIfNotRunning(this.age);
                    break;
            }

            this.calculateDimensions();
        }

        super.onTrackedDataSet(data);
    }

    private void stopAnimations() {
        this.attackingAnimationState.stop();
    }

    public DoubtEntity startState(DoubtEntity.State state) {
        switch (state) {
            case IDLING:
                this.setState(DoubtEntity.State.IDLING);
                break;
            case ATTACKING:
                this.setState(State.ATTACKING);
                break;
        }

        return this;
    }

    @Override
    public void tick() {
        super.tick();
    }

    public void startAttackAction(){
        setState(DoubtEntity.State.ATTACKING);
    }

    public void stopAttackAction(){
        setState(State.IDLING);
    }

    @Override
    public boolean isInAttackRange(LivingEntity target){
        double distance = target.getPos().distanceTo(this.getPos());

        double dx = target.getX() - this.getX();
        double dz = target.getZ() - this.getZ();
        float angle = (float) ((Math.atan2(dz, dx) * 180D) / Math.PI) - 90;
        float difference = MathHelper.abs((this.bodyYaw - angle) % 360);

        boolean bl = false;
        if (target instanceof LivingEntity){
            bl = isInAttackBox((LivingEntity) target);
        }
        return distance <= 3 && difference <= 35 || bl;
    }

    @Override
    public boolean tryAttack(Entity target) {
        if (target instanceof LivingEntity){
            if (this.isInAttackRange((LivingEntity) target)){
                boolean result = tryColorAttack(this, target, DamageInit.RED);
                if (result && target instanceof PlayerEntity player) {
                    if (player.isDead()) {
                        DeadPlayerEntity deadPlayer = ((ServerPlayerAccess) player).lobecorp$getDeadPlayer();
                        deadPlayer.discard();
                    }
                }
                return result;
            }
        }
        return false;

    }

    public enum State {
        IDLING(0),
        ATTACKING(1);

        public static final IntFunction<DoubtEntity.State> INDEX_TO_VALUE = ValueLists.createIdToValueFunction(
                DoubtEntity.State::getIndex, values(), ValueLists.OutOfBoundsHandling.ZERO
        );
        public static final PacketCodec<ByteBuf, DoubtEntity.State> PACKET_CODEC = PacketCodecs.indexed(INDEX_TO_VALUE, DoubtEntity.State::getIndex);
        private final int index;

        State(final int index) {
            this.index = index;
        }

        public int getIndex() {
            return this.index;
        }
    }
}
