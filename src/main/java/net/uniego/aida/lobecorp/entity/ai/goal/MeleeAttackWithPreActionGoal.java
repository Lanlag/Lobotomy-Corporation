package net.uniego.aida.lobecorp.entity.ai.goal;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.predicate.entity.EntityPredicates;
import net.uniego.aida.lobecorp.entity.LobeCorpEntity;

import java.util.EnumSet;

public class MeleeAttackWithPreActionGoal<T extends LobeCorpEntity> extends Goal {
    protected final T mob;
    private final double speed;
    private final boolean pauseWhenMobIdle;
    private Path path;
    private double targetX;
    private double targetY;
    private double targetZ;
    private int updateCountdownTicks;
    private int cooldown;
    protected final int cooldownDuration;
    protected final int preCD;
    protected int attackTime;
    private final int attackDuration;
    private long lastUpdateTime;
    private boolean isAttacking;

    public MeleeAttackWithPreActionGoal(T mob, double speed, boolean pauseWhenMobIdle, float maxPreCD,float attackDuration,float cooldownDuration) {
        this.mob = mob;
        this.speed = speed;
        this.pauseWhenMobIdle = pauseWhenMobIdle;
        this.attackDuration = (int) (attackDuration * 20);
        this.cooldownDuration = (int) (cooldownDuration * 20);
        this.preCD = (int) (this.attackDuration - maxPreCD * 20);
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    public boolean canStart() {
        if (!this.isAttacking){
            long l = this.mob.getWorld().getTime();
            if (l - this.lastUpdateTime < 20L) {
                return false;
            } else {
                this.lastUpdateTime = l;
                LivingEntity livingEntity = this.mob.getTarget();
                if (livingEntity == null) {
                    return false;
                } else if (!livingEntity.isAlive()) {
                    return false;
                } else {
                    this.path = this.mob.getNavigation().findPathTo(livingEntity, 0);
                    if (this.path != null) {
                        return true;
                    } else {
                        return this.mob.isInAttackRange(livingEntity);
                    }
                }
            }
        }
        return false;
    }

    public boolean shouldContinue() {
        if (!this.isAttacking) {
            LivingEntity livingEntity = this.mob.getTarget();
            if (livingEntity == null) {
                return false;
            } else if (!livingEntity.isAlive()) {
                return false;
            } else if (!this.pauseWhenMobIdle) {
                return !this.mob.getNavigation().isIdle();
            } else if (!this.mob.isInWalkTargetRange(livingEntity.getBlockPos())) {
                return false;
            } else {
                return !(livingEntity instanceof PlayerEntity) || !livingEntity.isSpectator() && !((PlayerEntity) livingEntity).isCreative();
            }
        }
        return true;
    }

    public void start() {
        this.mob.getNavigation().startMovingAlong(this.path, this.speed);
        this.mob.setAttacking(true);
        this.updateCountdownTicks = 0;
    }

    public void stop() {
        LivingEntity livingEntity = this.mob.getTarget();
        if (!EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.test(livingEntity)) {
            this.mob.setTarget((LivingEntity)null);
        }
        this.mob.setAttacking(false);
        this.mob.getNavigation().stop();
    }

    public boolean shouldRunEveryTick() {
        return true;
    }

    public void tick() {
        LivingEntity livingEntity = this.mob.getTarget();
        if (livingEntity != null) {
            this.mob.getLookControl().lookAt(livingEntity, 30.0F, 30.0F);
            this.updateCountdownTicks = Math.max(this.updateCountdownTicks - 1, 0);
            if ((this.pauseWhenMobIdle || this.mob.getVisibilityCache().canSee(livingEntity))
                    && this.updateCountdownTicks <= 0
                    && (this.targetX == 0.0 && this.targetY == 0.0 && this.targetZ == 0.0 || livingEntity.squaredDistanceTo(this.targetX, this.targetY, this.targetZ) >= 1.0 || this.mob.getRandom().nextFloat() < 0.05F)
            ) {
                this.targetX = livingEntity.getX();
                this.targetY = livingEntity.getY();
                this.targetZ = livingEntity.getZ();
                this.updateCountdownTicks = 4 + this.mob.getRandom().nextInt(7);
                double d = this.mob.squaredDistanceTo(livingEntity);
                if (d > 1024.0) {
                    this.updateCountdownTicks += 10;
                } else if (d > 256.0) {
                    this.updateCountdownTicks += 5;
                }

                if (!this.mob.getNavigation().startMovingTo(livingEntity, this.speed)) {
                    this.updateCountdownTicks += 15;
                }

                this.updateCountdownTicks = this.getTickCount(this.updateCountdownTicks);
            }

            this.cooldown = Math.max(this.cooldown - 1, 0);
            this.attackTime = Math.max(this.attackTime - 1, 0);

            if (!this.isAttacking) {
                this.startAttack(livingEntity);
            } else {
                if (this.attackTime == this.preCD){
                    this.attack(livingEntity);
                }
                if (this.attackTime <= 0){
                    this.endAttack();
                }
            }
        }
    }

    protected void setAttacking(boolean flag) {
        this.isAttacking = flag;
    }

    protected void startAttack(LivingEntity target) {
        if (this.canAttack(target)) {
            this.setAttacking(true);
            this.attackTime = attackDuration;
            this.mob.startAttackAction();
        }
    }

    protected void attack(LivingEntity target) {
        this.mob.tryAttack(target);
    }

    protected void endAttack() {
        this.resetCooldown();
        this.mob.stopAttackAction();
        this.setAttacking(false);
    }

    protected void resetCooldown() {
        this.cooldown = this.getTickCount(cooldownDuration);
    }

    protected boolean isCooledDown() {
        return this.cooldown <= 0;
    }

    protected boolean canAttack(LivingEntity target) {
        return this.isCooledDown() && this.mob.isInAttackRange(target) && this.mob.getVisibilityCache().canSee(target);
    }

    protected int getCooldown() {
        return this.cooldown;
    }

    protected int getMaxCooldown() {
        return this.getTickCount(20);
    }
}
