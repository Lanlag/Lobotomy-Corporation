package net.uniego.aida.lobecorp.item.ego.gift.models;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.uniego.aida.lobecorp.item.LobeCorpItemModel;

//祝福饰品模型
@Environment(EnvType.CLIENT)
public class BlessGiftModel extends LobeCorpItemModel {
    private final ModelPart hat;
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart right_arm;
    private final ModelPart left_arm;
    private final ModelPart right_leg;
    private final ModelPart left_leg;

    public BlessGiftModel(ModelPart root) {
        super(root);
        this.hat = root.getChild("hat");
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.right_arm = root.getChild("right_arm");
        this.left_arm = root.getChild("left_arm");
        this.right_leg = root.getChild("right_leg");
        this.left_leg = root.getChild("left_leg");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData hat = modelPartData.addChild("hat", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -8.0F, 0.0F));

        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-16.125F, -24.3F, -12.1625F, 32.0F, 32.0F, 12.0F, new Dilation(-6.425F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData right_arm = modelPartData.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.pivot(-5.0F, 2.0F, 0.0F));

        ModelPartData left_arm = modelPartData.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.pivot(5.0F, 2.0F, 0.0F));

        ModelPartData right_leg = modelPartData.addChild("right_leg", ModelPartBuilder.create(), ModelTransform.pivot(-1.9F, 12.0F, 0.0F));

        ModelPartData left_leg = modelPartData.addChild("left_leg", ModelPartBuilder.create(), ModelTransform.pivot(1.9F, 12.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        hat.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        right_arm.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        left_arm.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        right_leg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        left_leg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}