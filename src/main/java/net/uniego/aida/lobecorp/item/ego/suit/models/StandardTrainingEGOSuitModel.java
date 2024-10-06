package net.uniego.aida.lobecorp.item.ego.suit.models;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.uniego.aida.lobecorp.item.LobeCorpItemModel;

//教学用E.G.O护甲模型
@Environment(EnvType.CLIENT)
public class StandardTrainingEGOSuitModel extends LobeCorpItemModel {
    private final ModelPart hat;
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart right_arm;
    private final ModelPart left_arm;
    private final ModelPart right_leg;
    private final ModelPart left_leg;

    public StandardTrainingEGOSuitModel(ModelPart root) {
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

        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.3F))
                .uv(0, 17).cuboid(-3.5F, 3.175F, -2.6125F, 7.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(19, 17).cuboid(-3.5F, 3.4875F, -2.6125F, 7.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(34, 21).cuboid(-1.5F, 5.4875F, -2.625F, 3.0F, 3.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 21).cuboid(-3.5F, 4.675F, -2.6125F, 7.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(28, 29).cuboid(-2.292F, 4.9899F, -2.6125F, 3.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(25, 12).cuboid(-1.8295F, 9.2649F, -2.5125F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(17, 29).cuboid(-4.542F, 9.4774F, -0.475F, 2.0F, 3.0F, 3.0F, new Dilation(0.0F))
                .uv(18, 23).cuboid(-1.508F, 11.4774F, -2.625F, 6.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(44, 0).cuboid(2.542F, 9.4774F, -2.6125F, 2.0F, 3.0F, 3.0F, new Dilation(0.0F))
                .uv(17, 29).mirrored().cuboid(2.542F, 9.4774F, -0.475F, 2.0F, 3.0F, 3.0F, new Dilation(0.0F)).mirrored(false)
                .uv(18, 23).cuboid(-1.4955F, 10.4774F, 0.5375F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(21, 21).cuboid(-0.783F, 5.0399F, 0.525F, 3.0F, 5.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 37).mirrored().cuboid(2.7795F, 5.0399F, 0.525F, 1.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(19, 20).mirrored().cuboid(-1.233F, -0.1601F, 0.525F, 5.0F, 5.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(28, 29).mirrored().cuboid(-0.708F, 4.9899F, -2.6125F, 3.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(19, 20).cuboid(-3.767F, -0.1601F, 0.525F, 5.0F, 5.0F, 2.0F, new Dilation(0.0F))
                .uv(18, 23).mirrored().cuboid(-4.492F, 11.4774F, -2.625F, 6.0F, 1.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(44, 0).mirrored().cuboid(-4.542F, 9.4774F, -2.6125F, 2.0F, 3.0F, 3.0F, new Dilation(0.0F)).mirrored(false)
                .uv(18, 23).mirrored().cuboid(-4.5045F, 10.4774F, 0.5375F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 37).cuboid(-3.7795F, 5.0399F, 0.525F, 1.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(21, 21).mirrored().cuboid(-2.217F, 5.0399F, 0.525F, 3.0F, 5.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(25, 12).mirrored().cuboid(-1.1705F, 9.2649F, -2.5125F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r1 = body.addChild("cube_r1", ModelPartBuilder.create().uv(-2, 0).mirrored().cuboid(-0.4125F, -1.775F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(36, 4).cuboid(-0.95F, -1.775F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.9448F, 7.4725F, -1.6125F, 0.0F, 0.0F, -1.9199F));

        ModelPartData cube_r2 = body.addChild("cube_r2", ModelPartBuilder.create().uv(22, 21).mirrored().cuboid(-1.9F, 0.1375F, -1.0F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.6841F, 1.8396F, -1.6125F, 0.0F, 0.0F, -1.8282F));

        ModelPartData cube_r3 = body.addChild("cube_r3", ModelPartBuilder.create().uv(-2, 0).mirrored().cuboid(0.3875F, -0.475F, -1.0F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.125F, 3.675F, -1.6125F, 0.0F, 0.0F, -1.3483F));

        ModelPartData cube_r4 = body.addChild("cube_r4", ModelPartBuilder.create().uv(11, 36).cuboid(-1.2F, -0.8875F, -1.0F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.9657F, 2.0641F, -1.6125F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r5 = body.addChild("cube_r5", ModelPartBuilder.create().uv(11, 36).mirrored().cuboid(-1.8F, -0.8875F, -1.0F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.9657F, 2.0641F, -1.6125F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r6 = body.addChild("cube_r6", ModelPartBuilder.create().uv(22, 21).cuboid(-1.1F, 0.1375F, -1.0F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(2.6841F, 1.8396F, -1.6125F, 0.0F, 0.0F, 1.8282F));

        ModelPartData cube_r7 = body.addChild("cube_r7", ModelPartBuilder.create().uv(-2, 0).cuboid(-3.3875F, -0.475F, -1.0F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(3.125F, 3.675F, -1.6125F, 0.0F, 0.0F, 1.3483F));

        ModelPartData cube_r8 = body.addChild("cube_r8", ModelPartBuilder.create().uv(36, 4).mirrored().cuboid(-2.05F, -1.775F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-2, 0).cuboid(-2.5875F, -1.775F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.9448F, 7.4725F, -1.6125F, 0.0F, 0.0F, 1.9199F));

        ModelPartData right_arm = modelPartData.addChild("right_arm", ModelPartBuilder.create().uv(35, 8).mirrored().cuboid(-3.3F, -2.3375F, -1.775F, 2.0F, 3.0F, 4.0F, new Dilation(0.3F)).mirrored(false)
                .uv(22, 35).mirrored().cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.3F)).mirrored(false)
                .uv(24, 0).mirrored().cuboid(-3.1625F, 3.7375F, -1.8375F, 1.0F, 1.0F, 4.0F, new Dilation(0.3F)).mirrored(false)
                .uv(35, 8).mirrored().cuboid(-3.3F, -2.3375F, -2.2F, 2.0F, 3.0F, 4.0F, new Dilation(0.3F)).mirrored(false)
                .uv(43, 16).cuboid(-2.725F, 4.8875F, -2.2F, 0.0F, 1.0F, 4.0F, new Dilation(0.3F))
                .uv(24, 0).mirrored().cuboid(-3.1625F, 3.7375F, -2.2F, 1.0F, 1.0F, 4.0F, new Dilation(0.3F)).mirrored(false)
                .uv(24, 5).mirrored().cuboid(-3.1625F, 4.8875F, -1.85F, 0.0F, 1.0F, 4.0F, new Dilation(0.3F)).mirrored(false)
                .uv(24, 5).mirrored().cuboid(-3.1625F, 4.8875F, -2.2F, 0.0F, 1.0F, 4.0F, new Dilation(0.3F)).mirrored(false), ModelTransform.pivot(-5.0F, 2.0F, 0.0F));

        ModelPartData left_arm = modelPartData.addChild("left_arm", ModelPartBuilder.create().uv(22, 35).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.3F))
                .uv(35, 8).cuboid(1.3F, -2.3375F, -2.2F, 2.0F, 3.0F, 4.0F, new Dilation(0.3F))
                .uv(24, 0).cuboid(2.1625F, 3.7375F, -2.2F, 1.0F, 1.0F, 4.0F, new Dilation(0.3F))
                .uv(24, 5).cuboid(3.1625F, 4.8875F, -2.2F, 0.0F, 1.0F, 4.0F, new Dilation(0.3F))
                .uv(24, 5).cuboid(3.1625F, 4.8875F, -1.85F, 0.0F, 1.0F, 4.0F, new Dilation(0.3F))
                .uv(24, 0).cuboid(2.1625F, 3.7375F, -1.8375F, 1.0F, 1.0F, 4.0F, new Dilation(0.3F))
                .uv(35, 8).cuboid(1.3F, -2.3375F, -1.775F, 2.0F, 3.0F, 4.0F, new Dilation(0.3F)), ModelTransform.pivot(5.0F, 2.0F, 0.0F));

        ModelPartData right_leg = modelPartData.addChild("right_leg", ModelPartBuilder.create().uv(49, 6).mirrored().cuboid(-2.3455F, 2.9524F, -2.3375F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(25, 12).mirrored().cuboid(-1.683F, 2.9524F, -2.325F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 48).cuboid(-2.0F, -0.2F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.2F)), ModelTransform.pivot(-1.9F, 12.0F, 0.0F));

        ModelPartData left_leg = modelPartData.addChild("left_leg", ModelPartBuilder.create().uv(49, 6).cuboid(-1.6545F, 2.9524F, -2.3375F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(25, 12).cuboid(-2.317F, 2.9524F, -2.325F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 48).mirrored().cuboid(-2.0F, -0.2F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.2F)).mirrored(false), ModelTransform.pivot(1.9F, 12.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
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