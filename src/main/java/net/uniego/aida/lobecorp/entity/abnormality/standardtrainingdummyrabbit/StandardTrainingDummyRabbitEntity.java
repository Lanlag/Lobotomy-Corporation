package net.uniego.aida.lobecorp.entity.abnormality.standardtrainingdummyrabbit;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.entity.abnormality.AbnormalityEntity;
import net.uniego.aida.lobecorp.init.DamageInit;

import java.util.HashMap;
import java.util.Map;

//教学兔兔实体
public class StandardTrainingDummyRabbitEntity extends AbnormalityEntity {
    private boolean hasExecuted;

    public StandardTrainingDummyRabbitEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world, LobeCorpUtil.EGOLevel.TETH, 0.5F, 1.5F, 1.0F, 1.0F,
                "O-00-00", 10, 1, 200, 0.7F, DamageInit.RED,
                7, 10, 4, 6, 0, 3);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 100.0F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.5F);
    }

    @Override
    protected void manage() {
        //Ⅰ. 对“教学兔兔“Dummy””完成压迫工作后，它的逆卡巴拉计数器会在倒计时结束后减少。
        if (!isWorking() && !isCooling() && REPRESSION.equals(getLastWorkMethod())) {
            setQliphothCounter(qliphothCounter - 1);
        }
    }

    @Override
    protected void escape() {
        if (qliphothCounter <= 0) {
            setEscaping(true);
            if (!hasExecuted) {
                goalSelector.add(1, new StandardTrainingDummyRabbitGoal(this, 0.5F, 64));
                hasExecuted = true;
            }
        }
    }

    @Override
    protected void setWorkProbabilities() {
        //设置本能工作概率
        Map<Integer, Float> instinctProbabilities = new HashMap<>();
        instinctProbabilities.put(1, 0.65F);
        instinctProbabilities.put(2, 0.65F);
        instinctProbabilities.put(3, 0.65F);
        instinctProbabilities.put(4, 0.65F);
        instinctProbabilities.put(5, 0.65F);
        instinctProbabilities.put(6, 0.65F);
        workProbabilities.put(INSTINCT, instinctProbabilities);
        //设置洞察工作概率
        Map<Integer, Float> insightProbabilities = new HashMap<>();
        insightProbabilities.put(1, 0.65F);
        insightProbabilities.put(2, 0.65F);
        insightProbabilities.put(3, 0.65F);
        insightProbabilities.put(4, 0.65F);
        insightProbabilities.put(5, 0.65F);
        insightProbabilities.put(6, 0.65F);
        workProbabilities.put(INSIGHT, insightProbabilities);
        //设置沟通工作概率
        Map<Integer, Float> attachmentProbabilities = new HashMap<>();
        attachmentProbabilities.put(1, 1.00F);
        attachmentProbabilities.put(2, 1.00F);
        attachmentProbabilities.put(3, 1.00F);
        attachmentProbabilities.put(4, 1.00F);
        attachmentProbabilities.put(5, 1.00F);
        attachmentProbabilities.put(6, 1.00F);
        workProbabilities.put(ATTACHMENT, attachmentProbabilities);
        //设置压迫工作概率
        Map<Integer, Float> repressionProbabilities = new HashMap<>();
        repressionProbabilities.put(1, 0.40F);
        repressionProbabilities.put(2, 0.40F);
        repressionProbabilities.put(3, 0.40F);
        repressionProbabilities.put(4, 0.40F);
        repressionProbabilities.put(5, 0.40F);
        repressionProbabilities.put(6, 0.40F);
        workProbabilities.put(REPRESSION, repressionProbabilities);
    }

    public static class StandardTrainingDummyRabbitGoal extends Goal {
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

}
