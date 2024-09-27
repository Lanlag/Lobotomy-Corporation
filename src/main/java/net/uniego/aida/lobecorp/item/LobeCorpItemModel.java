package net.uniego.aida.lobecorp.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.model.BipedEntityModel;

//脑叶公司物品模型
@Environment(EnvType.CLIENT)
public class LobeCorpItemModel extends BipedEntityModel<AbstractClientPlayerEntity> {
    private final ModelPart rightArm;
    private final ModelPart leftArm;

    public LobeCorpItemModel(ModelPart root) {
        super(root);
        rightArm = root.getChild("right_arm");
        leftArm = root.getChild("left_arm");
    }

    public ModelPart getRightArm() {
        return rightArm;
    }

    public ModelPart getLeftArm() {
        return leftArm;
    }
}
