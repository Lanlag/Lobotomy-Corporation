package net.uniego.aida.lobecorp.item.ego.gift.models;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.uniego.aida.lobecorp.item.LobeCorpItemModel;

//正义裁决者饰品模型
@Environment(EnvType.CLIENT)
public class JustitiaGiftModel extends LobeCorpItemModel {
    private final ModelPart hat;
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart right_arm;
    private final ModelPart left_arm;
    private final ModelPart right_leg;
    private final ModelPart left_leg;

    public JustitiaGiftModel(ModelPart root) {
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

        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(80, 10).cuboid(-4.9F, -5.575F, -4.1125F, 1.0F, 1.0F, 9.0F, new Dilation(-0.4F))
                .uv(80, 20).cuboid(-4.9F, -5.475F, -4.9125F, 1.0F, 1.0F, 9.0F, new Dilation(-0.4F))
                .uv(40, 74).cuboid(-4.9F, -5.775F, -4.1125F, 1.0F, 1.0F, 9.0F, new Dilation(-0.4F))
                .uv(60, 74).cuboid(-4.9F, -5.675F, -4.9125F, 1.0F, 1.0F, 9.0F, new Dilation(-0.4F))
                .uv(72, 0).cuboid(-4.9F, -5.975F, -4.1125F, 1.0F, 1.0F, 9.0F, new Dilation(-0.4F))
                .uv(20, 74).cuboid(-4.9F, -5.875F, -4.9125F, 1.0F, 1.0F, 9.0F, new Dilation(-0.4F))
                .uv(64, 64).cuboid(-4.9F, -6.175F, -4.1125F, 1.0F, 1.0F, 9.0F, new Dilation(-0.4F))
                .uv(0, 72).cuboid(-4.9F, -6.075F, -4.9125F, 1.0F, 1.0F, 9.0F, new Dilation(-0.4F))
                .uv(64, 54).cuboid(-4.9F, -6.25F, -4.9125F, 1.0F, 1.0F, 9.0F, new Dilation(-0.4F))
                .uv(64, 32).cuboid(-4.9125F, -4.8625F, -4.1125F, 1.0F, 2.0F, 9.0F, new Dilation(-0.4F))
                .uv(64, 43).cuboid(-4.9125F, -4.8625F, -4.9125F, 1.0F, 2.0F, 9.0F, new Dilation(-0.4F))
                .uv(60, 21).cuboid(3.8625F, -6.8125F, -4.1125F, 1.0F, 2.0F, 9.0F, new Dilation(-0.4F))
                .uv(60, 10).cuboid(3.8625F, -6.8125F, -4.9125F, 1.0F, 2.0F, 9.0F, new Dilation(-0.4F))
                .uv(0, 30).cuboid(-4.5125F, -5.8375F, -4.5F, 9.0F, 1.0F, 9.0F, new Dilation(0.0F))
                .uv(36, 0).cuboid(-4.5125F, -3.9875F, -4.5F, 9.0F, 1.0F, 9.0F, new Dilation(0.0F))
                .uv(0, 10).cuboid(-4.5125F, -3.5875F, -4.5F, 9.0F, 1.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData Helmet_r1 = head.addChild("Helmet_r1", ModelPartBuilder.create().uv(0, 20).cuboid(-4.5F, -0.5F, -4.5F, 9.0F, 1.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(-0.0125F, -4.95F, 0.0F, 0.0F, 0.0F, -0.2182F));

        ModelPartData Helmet_r2 = head.addChild("Helmet_r2", ModelPartBuilder.create().uv(0, 0).cuboid(-4.5F, -0.5F, -4.5F, 9.0F, 1.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(-0.0125F, -4.3875F, 0.0F, 0.0F, 0.0F, 0.2182F));

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