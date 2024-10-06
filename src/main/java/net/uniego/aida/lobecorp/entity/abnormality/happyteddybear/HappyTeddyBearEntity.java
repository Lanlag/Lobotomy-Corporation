package net.uniego.aida.lobecorp.entity.abnormality.happyteddybear;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.entity.LobeCorpEntity;
import net.uniego.aida.lobecorp.entity.abnormality.AbnormalityEntity;
import net.uniego.aida.lobecorp.init.DamageInit;

import java.util.HashMap;
import java.util.Map;

//快乐泰迪实体
public class HappyTeddyBearEntity extends AbnormalityEntity {
    public HappyTeddyBearEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world, LobeCorpUtil.EGOLevel.HE,
                "T-04-06", 15, 200, 0.25F, DamageInit.WHITE,
                11, 15, 6, 10, 0, 5);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return LobeCorpEntity.createAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 1.0F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0F);
    }

    @Override
    protected void manage() {
        //Ⅰ. 某个对“快乐泰迪”连续进行多次工作的员工死在了它的怀里，死因是窒息。
        //Ⅱ. 某个员工被“快乐泰迪”折断了脖子。我们认为这是由于该员工进入其收容单元的频率过于频繁所导致的。（翻译少了一句“参考文件：《一封标有“不可寄出”的旧信封》”。）
        if (isWorking() && workPlayer == getLastWorkPlayer()) workPlayer.kill();
    }

    @Override
    protected void escape() {
    }

    @Override
    protected void setWorkProbabilities() {
        //设置本能工作概率
        Map<Integer, Float> instinctProbabilities = new HashMap<>();
        instinctProbabilities.put(1, 0.00F);
        instinctProbabilities.put(2, 0.00F);
        instinctProbabilities.put(3, 0.00F);
        instinctProbabilities.put(4, 0.00F);
        instinctProbabilities.put(5, 0.00F);
        instinctProbabilities.put(6, 0.00F);
        workProbabilities.put(INSTINCT, instinctProbabilities);
        //设置洞察工作概率
        Map<Integer, Float> insightProbabilities = new HashMap<>();
        insightProbabilities.put(1, 0.40F);
        insightProbabilities.put(2, 0.45F);
        insightProbabilities.put(3, 0.45F);
        insightProbabilities.put(4, 0.35F);
        insightProbabilities.put(5, 0.35F);
        insightProbabilities.put(6, 0.35F);
        workProbabilities.put(INSIGHT, insightProbabilities);
        //设置沟通工作概率
        Map<Integer, Float> attachmentProbabilities = new HashMap<>();
        attachmentProbabilities.put(1, 0.60F);
        attachmentProbabilities.put(2, 0.60F);
        attachmentProbabilities.put(3, 0.60F);
        attachmentProbabilities.put(4, 0.50F);
        attachmentProbabilities.put(5, 0.45F);
        attachmentProbabilities.put(6, 0.45F);
        workProbabilities.put(ATTACHMENT, attachmentProbabilities);
        //设置压迫工作概率
        Map<Integer, Float> repressionProbabilities = new HashMap<>();
        repressionProbabilities.put(1, 0.40F);
        repressionProbabilities.put(2, 0.45F);
        repressionProbabilities.put(3, 0.45F);
        repressionProbabilities.put(4, 0.40F);
        repressionProbabilities.put(5, 0.35F);
        repressionProbabilities.put(6, 0.35F);
        workProbabilities.put(REPRESSION, repressionProbabilities);
    }
}
