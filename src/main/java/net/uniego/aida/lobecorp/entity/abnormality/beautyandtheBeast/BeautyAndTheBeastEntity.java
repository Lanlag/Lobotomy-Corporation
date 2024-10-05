package net.uniego.aida.lobecorp.entity.abnormality.beautyandtheBeast;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.access.ServerPlayerAccess;
import net.uniego.aida.lobecorp.entity.DeadPlayerEntity;
import net.uniego.aida.lobecorp.entity.abnormality.AbnormalityEntity;
import net.uniego.aida.lobecorp.init.DamageInit;

import java.util.HashMap;
import java.util.Map;

//美女与野兽实体
public class BeautyAndTheBeastEntity extends AbnormalityEntity {
    private boolean hasExecuted;
    private boolean isWeakened;
    private String lastWorkMethod;

    public BeautyAndTheBeastEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world, LobeCorpUtil.EGOLevel.TETH,
                "F-02-44", 12, 20, 1.00F, DamageInit.WHITE,
                9, 12, 5, 8, 0, 4);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 1.0F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0F);
    }

    @Override
    protected void manage() {
        //Ⅰ. 对“美女和野兽”进行压迫工作时有着非常高的成功率。压迫工作能显著提高这个异想体的PE-BOX产量，但会恶化其健康状况。
        //Ⅱ. 对“美女和野兽”完成除压迫以外的其他工作后，它的健康状况将会得到改善。
        //Ⅲ. 在被施以连续的压迫工作后，“美女和野兽”倒在了地上，而刚刚对它完成压迫工作的员工经历了一系列可怕的突变。很快，一只新的“美女和野兽”突然出现在收容单元中。
        if (isWorking() && !hasExecuted) {
            lastWorkMethod = getLastWorkMethod();
            isWeakened = REPRESSION.equals(workMethod);
            hasExecuted = true;
        }
        if (isCooling() && hasExecuted) {
            if (isWeakened && REPRESSION.equals(lastWorkMethod)) {
                getLastWorkPlayer().kill();
                if (getLastPeBox() + getLastNeBox() == eBox) {
                    DeadPlayerEntity deadPlayer = ((ServerPlayerAccess) getLastWorkPlayer()).lobecorp$getDeadPlayer();
                    getWorld().sendEntityStatus(this, (byte) 60);
                    deadPlayer.discard();
                }
                setLastWorkMethod("");
                isWeakened = false;
            }
            hasExecuted = false;
        }
    }

    @Override
    protected void escape() {
    }

    @Override
    protected void setWorkProbabilities() {
        //设置本能工作概率
        Map<Integer, Float> instinctProbabilities = new HashMap<>();
        instinctProbabilities.put(1, 0.40F);
        instinctProbabilities.put(2, 0.20F);
        instinctProbabilities.put(3, -0.20F);
        instinctProbabilities.put(4, -0.20F);
        instinctProbabilities.put(5, -0.20F);
        instinctProbabilities.put(6, -0.20F);
        workProbabilities.put(INSTINCT, instinctProbabilities);
        //设置洞察工作概率
        Map<Integer, Float> insightProbabilities = new HashMap<>();
        insightProbabilities.put(1, 0.50F);
        insightProbabilities.put(2, 0.50F);
        insightProbabilities.put(3, 0.40F);
        insightProbabilities.put(4, 0.30F);
        insightProbabilities.put(5, 0.30F);
        insightProbabilities.put(6, 0.30F);
        workProbabilities.put(INSIGHT, insightProbabilities);
        //设置沟通工作概率
        Map<Integer, Float> attachmentProbabilities = new HashMap<>();
        attachmentProbabilities.put(1, 0.30F);
        attachmentProbabilities.put(2, 0.15F);
        attachmentProbabilities.put(3, -0.50F);
        attachmentProbabilities.put(4, -0.50F);
        attachmentProbabilities.put(5, -0.50F);
        attachmentProbabilities.put(6, -0.50F);
        workProbabilities.put(ATTACHMENT, attachmentProbabilities);
        //设置压迫工作概率
        Map<Integer, Float> repressionProbabilities = new HashMap<>();
        repressionProbabilities.put(1, 0.65F);
        repressionProbabilities.put(2, 0.65F);
        repressionProbabilities.put(3, 0.65F);
        repressionProbabilities.put(4, 0.65F);
        repressionProbabilities.put(5, 0.65F);
        repressionProbabilities.put(6, 0.65F);
        workProbabilities.put(REPRESSION, repressionProbabilities);
    }
}
