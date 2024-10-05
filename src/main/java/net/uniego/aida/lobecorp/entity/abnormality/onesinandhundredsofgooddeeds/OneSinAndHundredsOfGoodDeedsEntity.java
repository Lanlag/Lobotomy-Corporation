package net.uniego.aida.lobecorp.entity.abnormality.onesinandhundredsofgooddeeds;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.access.ManagerAccess;
import net.uniego.aida.lobecorp.entity.abnormality.AbnormalityEntity;
import net.uniego.aida.lobecorp.init.DamageInit;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//一罪与百善实体
public class OneSinAndHundredsOfGoodDeedsEntity extends AbnormalityEntity {
    private boolean hasExecuted;

    public OneSinAndHundredsOfGoodDeedsEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world, LobeCorpUtil.EGOLevel.ZAYIN,
                "O-03-03", 10, 200, 0.3F, DamageInit.WHITE,
                8, 10, 4, 7, 0, 3);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 1.0F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.5F);
    }

    @Override
    protected void manage() {
        //Ⅰ. 当工作结果为优时，“一罪与百善”会为完成工作的员工恢复一些精神值。某个员工解释说那是一种“释然”的感觉。
        //Ⅱ. 如果员工在一次工作中成功产出了所有的PE-BOX，那么“一罪与百善”会为该部门的所有员工恢复精神值。
        if (isWorking()) hasExecuted = false;
        if (!isWorking() && Objects.equals(getLastWorkResult(), GOOD) && !hasExecuted) {
            ((ManagerAccess) getLastWorkPlayer()).lobecorp$getSanityManager().cure(4);
            if (getLastPeBox() == eBox) {
                Team team = getLastWorkPlayer().getScoreboardTeam();
                if (team != null) {
                    for (String playerName : team.getPlayerList()) {
                        ServerPlayerEntity serverPlayer = Objects.requireNonNull(getServer()).getPlayerManager().getPlayer(playerName);
                        if (serverPlayer != null) {
                            ((ManagerAccess) serverPlayer).lobecorp$getSanityManager().cure(4);
                        }
                    }
                }
            }
            hasExecuted = true;
        }
    }

    @Override
    protected void escape() {
    }

    @Override
    protected void setWorkProbabilities() {
        //设置本能工作概率
        Map<Integer, Float> instinctProbabilities = new HashMap<>();
        instinctProbabilities.put(1, 0.50F);
        instinctProbabilities.put(2, 0.40F);
        instinctProbabilities.put(3, 0.30F);
        instinctProbabilities.put(4, 0.30F);
        instinctProbabilities.put(5, 0.30F);
        instinctProbabilities.put(6, 0.30F);
        workProbabilities.put(INSTINCT, instinctProbabilities);
        //设置洞察工作概率
        Map<Integer, Float> insightProbabilities = new HashMap<>();
        insightProbabilities.put(1, 0.70F);
        insightProbabilities.put(2, 0.70F);
        insightProbabilities.put(3, 0.50F);
        insightProbabilities.put(4, 0.50F);
        insightProbabilities.put(5, 0.50F);
        insightProbabilities.put(6, 0.50F);
        workProbabilities.put(INSIGHT, insightProbabilities);
        //设置沟通工作概率
        Map<Integer, Float> attachmentProbabilities = new HashMap<>();
        attachmentProbabilities.put(1, 0.70F);
        attachmentProbabilities.put(2, 0.70F);
        attachmentProbabilities.put(3, 0.70F);
        attachmentProbabilities.put(4, 0.70F);
        attachmentProbabilities.put(5, 0.70F);
        attachmentProbabilities.put(6, 0.70F);
        workProbabilities.put(ATTACHMENT, attachmentProbabilities);
        //设置压迫工作概率
        Map<Integer, Float> repressionProbabilities = new HashMap<>();
        repressionProbabilities.put(1, 0.50F);
        repressionProbabilities.put(2, 0.40F);
        repressionProbabilities.put(3, 0.30F);
        repressionProbabilities.put(4, 0.30F);
        repressionProbabilities.put(5, 0.30F);
        repressionProbabilities.put(6, 0.30F);
        workProbabilities.put(REPRESSION, repressionProbabilities);
    }
}
