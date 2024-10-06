package net.uniego.aida.lobecorp.entity.abnormality.judgementbird;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.entity.LobeCorpEntity;
import net.uniego.aida.lobecorp.entity.abnormality.AbnormalityEntity;
import net.uniego.aida.lobecorp.init.DamageInit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//审判鸟实体
public class JudgementBirdEntity extends AbnormalityEntity {
    private boolean hasExecuted;
    private boolean hasMoved;
    private int cooldownTickTimer = 400;
    private int skillTickTimer = 100;
    private boolean hasPlayer;

    public JudgementBirdEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world, LobeCorpUtil.EGOLevel.WAW, 0.8F, 0.8F, 0.8F, 2.0F,
                "O-02-62", 24, 2, 1, 0.35F, DamageInit.PALE,
                13, 24, 7, 12, 0, 6);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return LobeCorpEntity.createAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 128.0F)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 800.0F)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6.0F);
    }

    @Override
    protected void manage() {
        //Ⅰ. 当工作结果为良时，“审判鸟”的逆卡巴拉计数器有中等概率减少。
        //Ⅱ. 当工作结果为差时，“审判鸟”的逆卡巴拉计数器有大概率减少。
        if (isWorking()) hasExecuted = false;
        if (!hasExecuted && !isWorking() && !isCooling()) {
            if (NORMAL.equals(getLastWorkResult())) {
                if (getWorld().random.nextFloat() <= 0.50F) {
                    setQliphothCounter(qliphothCounter - 1);
                    hasExecuted = true;
                }
            } else if (BAD.equals(getLastWorkResult())) {
                if (getWorld().random.nextFloat() <= 0.70F) {
                    setQliphothCounter(qliphothCounter - 1);
                    hasExecuted = true;
                }
            }
        }
    }

    @Override
    protected void escape() {
        if (qliphothCounter <= 0) {
            if (!hasMoved) {
                setEscaping(true);
                goalSelector.add(9, new SwimGoal(this));
                goalSelector.add(8, new LookAroundGoal(this));
                goalSelector.add(7, new LookAtEntityGoal(this, LivingEntity.class, 16.0F));
                goalSelector.add(6, new WanderAroundFarGoal(this, 1.0F));
                hasMoved = true;
            }
            cooldownTickTimer--;
            //如果审判技能冷却完毕
            if (cooldownTickTimer <= 0 && !hasPlayer) {
                //就会开始搜索自己周围有没有玩家
                List<PlayerEntity> playerEntityList = LobeCorpUtil.getPlayersInRange(this, 16.0F, true);
                //如果这时候玩家不等于空
                if (!playerEntityList.isEmpty()) hasPlayer = true;
            }
            if (hasPlayer) {
                //就会有5秒的技能前摇
                skillTickTimer--;
                if (skillTickTimer <= 0) {
                    //前摇结束以后，再对周围存在的玩家进行一次搜索
                    List<PlayerEntity> players = LobeCorpUtil.getPlayersInRange(this, 16.0F, true);
                    //这时候才会对当前范围内的玩家进行审判
                    if (!players.isEmpty()) {
                        for (PlayerEntity player : players) {
                            player.damage(getDamageSources().create(DamageInit.PALE, this), 35);
                        }
                    }
                    //审判完毕以后进入冷却
                    skillTickTimer = 100;
                    cooldownTickTimer = 400;
                    hasPlayer = false;
                }
            }
        }
    }

    @Override
    protected void setWorkProbabilities() {
//设置本能工作概率
        Map<Integer, Float> instinctProbabilities = new HashMap<>();
        instinctProbabilities.put(1, 0.20F);
        instinctProbabilities.put(2, 0.20F);
        instinctProbabilities.put(3, 0.35F);
        instinctProbabilities.put(4, 0.45F);
        instinctProbabilities.put(5, 0.45F);
        instinctProbabilities.put(6, 0.45F);
        workProbabilities.put(INSTINCT, instinctProbabilities);
        //设置洞察工作概率
        Map<Integer, Float> insightProbabilities = new HashMap<>();
        insightProbabilities.put(1, 0.20F);
        insightProbabilities.put(2, 0.20F);
        insightProbabilities.put(3, 0.40F);
        insightProbabilities.put(4, 0.50F);
        insightProbabilities.put(5, 0.50F);
        insightProbabilities.put(6, 0.50F);
        workProbabilities.put(INSIGHT, insightProbabilities);
        //设置沟通工作概率
        Map<Integer, Float> attachmentProbabilities = new HashMap<>();
        attachmentProbabilities.put(1, 0.20F);
        attachmentProbabilities.put(2, 0.20F);
        attachmentProbabilities.put(3, 0.35F);
        attachmentProbabilities.put(4, 0.45F);
        attachmentProbabilities.put(5, 0.45F);
        attachmentProbabilities.put(6, 0.45F);
        workProbabilities.put(ATTACHMENT, attachmentProbabilities);
        //设置压迫工作概率
        Map<Integer, Float> repressionProbabilities = new HashMap<>();
        repressionProbabilities.put(1, 0.00F);
        repressionProbabilities.put(2, 0.00F);
        repressionProbabilities.put(3, 0.00F);
        repressionProbabilities.put(4, 0.00F);
        repressionProbabilities.put(5, 0.00F);
        repressionProbabilities.put(6, 0.00F);
        workProbabilities.put(REPRESSION, repressionProbabilities);
    }
}
