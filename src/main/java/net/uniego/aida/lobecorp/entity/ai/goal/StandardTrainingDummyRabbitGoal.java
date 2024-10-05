package net.uniego.aida.lobecorp.entity.ai.goal;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.PathAwareEntity;

public class StandardTrainingDummyRabbitGoal extends Goal {
    private final PathAwareEntity mob;
    private final double speed;
    private final double targetX;
    private final double targetZ;

    public StandardTrainingDummyRabbitGoal(PathAwareEntity mob, double speed, int range) {
        this.mob = mob;
        this.speed = speed;
        this.targetX = this.mob.getX() + (this.mob.getRandom().nextFloat() - 0.5F) * range;
        this.targetZ = this.mob.getZ() + (this.mob.getRandom().nextFloat() - 0.5F) * range;
    }

    @Override
    public boolean canStart() {
        return true;
    }

    @Override
    public void start() {
        mob.getNavigation().startMovingTo(targetX, mob.getY(), targetZ, speed);
    }
}
