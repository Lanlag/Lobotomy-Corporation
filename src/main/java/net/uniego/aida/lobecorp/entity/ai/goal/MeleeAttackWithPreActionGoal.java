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
    protected final int cooldownDuration;
    protected final int preCD;
    private final double speed;
    private final boolean pauseWhenMobIdle;
    private final int attackDuration;
    protected int attackTime;
    private Path path;
    private double targetX;
    private double targetY;
    private double targetZ;
    private int updateCountdownTicks;
    private int cooldown;
    private long lastUpdateTime;
    private boolean isAttacking;

    public MeleeAttackWithPreActionGoal(T mob, double speed, boolean pauseWhenMobIdle, float attackSpeed, float maxPreCD, float attackDuration, float cooldownDuration) {
        this.mob = mob;
        this.speed = speed;
        this.pauseWhenMobIdle = pauseWhenMobIdle;
        this.attackDuration = (int) (attackDuration / attackSpeed * 20);
        this.cooldownDuration = (int) (cooldownDuration / attackSpeed * 20);
        this.preCD = (int) (this.attackDuration - maxPreCD / attackSpeed * 20);
        setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    public boolean canStart() {
        if (!isAttacking) {
            long l = mob.getWorld().getTime();
            if (l - lastUpdateTime < 20L) {
                return false;
            } else {
                lastUpdateTime = l;
                LivingEntity livingEntity = mob.getTarget();
                if (livingEntity == null) {
                    return false;
                } else if (!livingEntity.isAlive()) {
                    return false;
                } else {
                    path = mob.getNavigation().findPathTo(livingEntity, 0);
                    if (path != null) {
                        return true;
                    } else {
                        return mob.isInAttackRange(livingEntity);
                    }
                }
            }
        }
        return false;
    }

    public boolean shouldContinue() {
        if (!isAttacking) {
            LivingEntity livingEntity = mob.getTarget();
            if (livingEntity == null) {
                return false;
            } else if (!livingEntity.isAlive()) {
                return false;
            } else if (!pauseWhenMobIdle) {
                return !mob.getNavigation().isIdle();
            } else if (!mob.isInWalkTargetRange(livingEntity.getBlockPos())) {
                return false;
            } else {
                return !(livingEntity instanceof PlayerEntity) || !livingEntity.isSpectator() && !((PlayerEntity) livingEntity).isCreative();
            }
        }
        return true;
    }

    public void start() {
        mob.getNavigation().startMovingAlong(path, speed);
        mob.setAttacking(true);
        updateCountdownTicks = 0;
        cooldown = 0;
    }

    public void stop() {
        LivingEntity livingEntity = mob.getTarget();
        if (!EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.test(livingEntity)) {
            mob.setTarget(null);
        }
        endAttack();
        mob.stopAttackAction();
        mob.getNavigation().stop();
    }

    public boolean shouldRunEveryTick() {
        return true;
    }

    public void tick() {
        LivingEntity livingEntity = mob.getTarget();
        if (livingEntity != null) {
            mob.getLookControl().lookAt(livingEntity, 30.0F, 30.0F);
            updateCountdownTicks = Math.max(updateCountdownTicks - 1, 0);
            if ((pauseWhenMobIdle || mob.getVisibilityCache().canSee(livingEntity))
                    && updateCountdownTicks <= 0
                    && (targetX == 0.0 && targetY == 0.0 && targetZ == 0.0 || livingEntity.squaredDistanceTo(targetX, targetY, targetZ) >= 1.0 || mob.getRandom().nextFloat() < 0.05F)
            ) {
                targetX = livingEntity.getX();
                targetY = livingEntity.getY();
                targetZ = livingEntity.getZ();
                updateCountdownTicks = 4 + mob.getRandom().nextInt(7);
                double d = mob.squaredDistanceTo(livingEntity);
                if (d > 1024.0) {
                    updateCountdownTicks += 10;
                } else if (d > 256.0) {
                    updateCountdownTicks += 5;
                }

                if (!mob.getNavigation().startMovingTo(livingEntity, speed)) {
                    updateCountdownTicks += 15;
                }

                updateCountdownTicks = getTickCount(updateCountdownTicks);
            }

            cooldown = Math.max(cooldown - 1, 0);
            attackTime = Math.max(attackTime - 1, 0);

            if (!isAttacking) {
                startAttack(livingEntity);
            } else {
                if (attackTime == preCD) {
                    attack(livingEntity);
                }
                if (attackTime <= 0) {
                    endAttack();
                }
            }
        }
    }

    protected void setAttacking(boolean flag) {
        isAttacking = flag;
    }

    protected void startAttack(LivingEntity target) {
        if (canAttack(target)) {
            setAttacking(true);
            attackTime = attackDuration;
            mob.startAttackAction();
        }
    }

    protected void attack(LivingEntity target) {
        mob.tryAttack(target);
    }

    protected void endAttack() {
        setAttacking(false);
        resetCooldown();
    }

    protected void resetCooldown() {
        cooldown = getTickCount(cooldownDuration);
    }

    protected boolean isCooledDown() {
        return cooldown <= 0;
    }

    protected boolean canAttack(LivingEntity target) {
        return isCooledDown() && mob.isInAttackRange(target) && mob.getVisibilityCache().canSee(target);
    }
}
