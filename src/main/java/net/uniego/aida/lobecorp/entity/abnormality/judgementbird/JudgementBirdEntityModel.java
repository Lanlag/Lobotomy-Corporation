package net.uniego.aida.lobecorp.entity.abnormality.judgementbird;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

//审判鸟实体模型
@Environment(EnvType.CLIENT)
public class JudgementBirdEntityModel extends EntityModel<JudgementBirdEntity> {
    private final ModelPart total;
    private final ModelPart bozi;
    private final ModelPart left_leg;
    private final ModelPart body;
    private final ModelPart right_leg;
    private final ModelPart right_wing;
    private final ModelPart head;
    private final ModelPart tianping;
    private final ModelPart middle;
    private final ModelPart right;
    private final ModelPart left;
    private final ModelPart left_wing;

    public JudgementBirdEntityModel(ModelPart root) {
        this.total = root.getChild("total");
        this.bozi = this.total.getChild("bozi");
        this.left_leg = this.total.getChild("left_leg");
        this.body = this.total.getChild("body");
        this.right_leg = this.total.getChild("right_leg");
        this.right_wing = this.total.getChild("right_wing");
        this.head = this.total.getChild("head");
        this.tianping = this.total.getChild("tianping");
        this.middle = this.tianping.getChild("middle");
        this.right = this.tianping.getChild("right");
        this.left = this.tianping.getChild("left");
        this.left_wing = this.total.getChild("left_wing");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData total = modelPartData.addChild("total", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 19.0F, 3.0F));

        ModelPartData bozi = total.addChild("bozi", ModelPartBuilder.create().uv(14, 38).cuboid(-1.0F, -10.0F, -9.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(14, 45).cuboid(-1.0F, -22.0F, -10.0F, 1.0F, 13.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -27.0F, -4.0F, 0.3054F, 0.0F, 0.0F));

        ModelPartData bozi_r1 = bozi.addChild("bozi_r1", ModelPartBuilder.create().uv(26, 45).cuboid(-10.0F, -18.0F, 0.0F, 1.0F, 8.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(9.0F, 8.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

        ModelPartData left_leg = total.addChild("left_leg", ModelPartBuilder.create(), ModelTransform.pivot(-7.0F, -18.0F, -3.0F));

        ModelPartData left_leg_r1 = left_leg.addChild("left_leg_r1", ModelPartBuilder.create().uv(30, 46).cuboid(0.0F, 0.0F, -2.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 22.0F, 1.0F, 0.0F, -0.2182F, 0.0F));

        ModelPartData left_leg_r2 = left_leg.addChild("left_leg_r2", ModelPartBuilder.create().uv(22, 45).cuboid(-0.5F, -19.0F, -12.0F, 1.0F, 11.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 22.0F, 1.0F, -0.48F, 0.0F, 0.0F));

        ModelPartData left_leg_r3 = left_leg.addChild("left_leg_r3", ModelPartBuilder.create().uv(44, 37).cuboid(-0.5F, -14.0F, 0.0F, 1.0F, 14.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 22.0F, 1.0F, 0.5236F, 0.0F, 0.0F));

        ModelPartData left_leg_r4 = left_leg.addChild("left_leg_r4", ModelPartBuilder.create().uv(22, 38).cuboid(-1.0F, 0.0F, -2.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 22.0F, 1.0F, 0.0F, 0.3491F, 0.0F));

        ModelPartData body = total.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -7.0F, -7.0F, 16.0F, 10.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -21.0F, -2.0F));

        ModelPartData right_leg = total.addChild("right_leg", ModelPartBuilder.create(), ModelTransform.pivot(-2.0F, -18.0F, -3.0F));

        ModelPartData right_leg_r1 = right_leg.addChild("right_leg_r1", ModelPartBuilder.create().uv(0, 20).cuboid(-2.0F, 0.0F, -2.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(11.0F, 22.0F, 1.0F, 0.0F, -0.2182F, 0.0F));

        ModelPartData right_leg_r2 = right_leg.addChild("right_leg_r2", ModelPartBuilder.create().uv(18, 45).cuboid(-2.5F, -19.0F, -12.0F, 1.0F, 11.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(11.0F, 22.0F, 1.0F, -0.48F, 0.0F, 0.0F));

        ModelPartData right_leg_r3 = right_leg.addChild("right_leg_r3", ModelPartBuilder.create().uv(44, 22).cuboid(-2.5F, -14.0F, 0.0F, 1.0F, 14.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(11.0F, 22.0F, 1.0F, 0.5236F, 0.0F, 0.0F));

        ModelPartData right_leg_r4 = right_leg.addChild("right_leg_r4", ModelPartBuilder.create().uv(0, 24).cuboid(-3.0F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(11.0F, 22.0F, 1.0F, 0.0F, 0.3491F, 0.0F));

        ModelPartData right_wing = total.addChild("right_wing", ModelPartBuilder.create(), ModelTransform.pivot(9.0F, -19.0F, -4.0F));

        ModelPartData right_wing_r1 = right_wing.addChild("right_wing_r1", ModelPartBuilder.create().uv(30, 20).cuboid(-1.0F, -4.0F, -3.0F, 1.0F, 20.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

        ModelPartData head = total.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -45.0F, -20.0F));

        ModelPartData head_r1 = head.addChild("head_r1", ModelPartBuilder.create().uv(42, 52).cuboid(3.0F, -2.0F, -9.0F, 1.0F, 2.0F, 10.0F, new Dilation(0.0F))
                .uv(44, 54).cuboid(-5.0F, -2.0F, -8.0F, 1.0F, 2.0F, 8.0F, new Dilation(0.0F))
                .uv(46, 61).cuboid(-5.0F, -2.0F, -9.0F, 8.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(46, 61).cuboid(-5.0F, -2.0F, 0.0F, 8.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(3.0F, -8.0F, -5.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F))
                .uv(42, 0).cuboid(-6.0F, -8.0F, -5.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 20).cuboid(-4.0F, -4.0F, -8.0F, 7.0F, 10.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

        ModelPartData tianping = total.addChild("tianping", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, -34.0F, -11.0F));

        ModelPartData middle = tianping.addChild("middle", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData middle_r1 = middle.addChild("middle_r1", ModelPartBuilder.create().uv(38, 20).cuboid(-5.0F, -2.0F, -1.0F, 12.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

        ModelPartData right = tianping.addChild("right", ModelPartBuilder.create().uv(22, 20).cuboid(5.0F, -1.0F, -2.0F, 3.0F, 2.0F, 3.0F, new Dilation(0.0F))
                .uv(22, 25).cuboid(6.0F, -3.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData left = tianping.addChild("left", ModelPartBuilder.create().uv(26, 25).cuboid(-1.0F, -3.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(8, 38).cuboid(-2.0F, -1.0F, -2.0F, 3.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, 3.0F, 0.0F));

        ModelPartData left_wing = total.addChild("left_wing", ModelPartBuilder.create(), ModelTransform.pivot(-8.0F, -19.0F, -4.0F));

        ModelPartData left_wing_r1 = left_wing.addChild("left_wing_r1", ModelPartBuilder.create().uv(0, 38).cuboid(-1.0F, -4.0F, -3.0F, 1.0F, 20.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        total.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(JudgementBirdEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }
}