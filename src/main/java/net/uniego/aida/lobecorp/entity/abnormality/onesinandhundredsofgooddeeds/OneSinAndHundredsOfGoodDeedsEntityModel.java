package net.uniego.aida.lobecorp.entity.abnormality.onesinandhundredsofgooddeeds;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

//一罪与百善实体模型
@Environment(EnvType.CLIENT)
public class OneSinAndHundredsOfGoodDeedsEntityModel extends EntityModel<OneSinAndHundredsOfGoodDeedsEntity> {
    private final ModelPart one_sin_and_hundreds_of_good_deeds;
    private final ModelPart head;
    private final ModelPart skull;
    private final ModelPart mandible;
    private final ModelPart cross;
    private final ModelPart p1;
    private final ModelPart p2;
    private final ModelPart p3;

    public OneSinAndHundredsOfGoodDeedsEntityModel(ModelPart root) {
        this.one_sin_and_hundreds_of_good_deeds = root.getChild("one_sin_and_hundreds_of_good_deeds");
        this.head = this.one_sin_and_hundreds_of_good_deeds.getChild("head");
        this.skull = this.head.getChild("skull");
        this.mandible = this.skull.getChild("mandible");
        this.cross = this.head.getChild("cross");
        this.p1 = this.cross.getChild("p1");
        this.p2 = this.cross.getChild("p2");
        this.p3 = this.cross.getChild("p3");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData one_sin_and_hundreds_of_good_deeds = modelPartData.addChild("one_sin_and_hundreds_of_good_deeds", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 14.0F, 0.0F));

        ModelPartData head = one_sin_and_hundreds_of_good_deeds.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -9.0F));

        ModelPartData skull = head.addChild("skull", ModelPartBuilder.create().uv(0, 27).cuboid(-8.0F, -18.0F, -1.0F, 16.0F, 13.0F, 11.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-9.0F, -16.0F, -2.0F, 18.0F, 6.0F, 21.0F, new Dilation(0.0F))
                .uv(0, 51).cuboid(-8.0F, -18.0F, 10.0F, 16.0F, 14.0F, 8.0F, new Dilation(0.0F))
                .uv(54, 48).cuboid(-3.0F, -3.0F, -0.5F, 6.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(64, 59).cuboid(-5.0F, -5.0F, -1.0F, 10.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -13.0F, 0.0F));

        ModelPartData mandible = skull.addChild("mandible", ModelPartBuilder.create().uv(70, 48).cuboid(-3.0F, 1.0F, -5.5F, 6.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(54, 43).cuboid(-6.0F, 2.0F, -6.0F, 12.0F, 2.0F, 3.0F, new Dilation(0.0F))
                .uv(42, 76).cuboid(4.0F, -5.0F, 1.0F, 2.0F, 9.0F, 4.0F, new Dilation(0.0F))
                .uv(78, 0).cuboid(-6.0F, -5.0F, 1.0F, 2.0F, 9.0F, 4.0F, new Dilation(0.0F))
                .uv(76, 51).cuboid(4.0F, 2.0F, -3.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(78, 13).cuboid(-6.0F, 2.0F, -3.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 5.0F));

        ModelPartData cross = head.addChild("cross", ModelPartBuilder.create().uv(48, 59).cuboid(-3.0F, 3.0F, -1.0F, 6.0F, 15.0F, 2.0F, new Dilation(0.0F))
                .uv(64, 64).cuboid(-1.75F, 3.0F, -1.5F, 3.5F, 14.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 73).cuboid(-1.75F, -20.0F, -1.5F, 3.5F, 12.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -21.0F, 9.0F));

        ModelPartData cross_r1 = cross.addChild("cross_r1", ModelPartBuilder.create().uv(28, 73).cuboid(-0.75F, 9.0F, -1.5F, 3.5F, 12.0F, 3.0F, new Dilation(0.0F))
                .uv(14, 73).cuboid(-0.75F, -19.0F, -1.5F, 3.5F, 12.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

        ModelPartData p1 = cross.addChild("p1", ModelPartBuilder.create().uv(48, 51).cuboid(-20.0F, -4.0F, -1.0F, 12.0F, 6.0F, 2.0F, new Dilation(0.0F))
                .uv(54, 76).cuboid(-21.4238F, -4.656F, -1.0F, 1.4238F, 7.312F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData p1_r1 = p1.addChild("p1_r1", ModelPartBuilder.create().uv(78, 23).cuboid(-18.0F, 1.0F, -1.01F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-7.2526F, -8.4875F, 0.0F, 0.0F, 0.0F, -0.6109F));

        ModelPartData p1_r2 = p1.addChild("p1_r2", ModelPartBuilder.create().uv(78, 19).cuboid(-18.0F, 0.0F, -1.01F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-5.5319F, 4.0301F, 0.0F, 0.0F, 0.0F, 0.6109F));

        ModelPartData p2 = cross.addChild("p2", ModelPartBuilder.create().uv(54, 27).cuboid(-20.0F, -4.0F, -1.0F, 12.0F, 6.0F, 2.0F, new Dilation(0.0F))
                .uv(78, 64).cuboid(-21.4238F, -4.656F, -1.0F, 1.4238F, 7.312F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        ModelPartData p2_r1 = p2.addChild("p2_r1", ModelPartBuilder.create().uv(82, 27).cuboid(-18.0F, 1.0F, -1.01F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-7.2526F, -8.4875F, 0.0F, 0.0F, 0.0F, -0.6109F));

        ModelPartData p2_r2 = p2.addChild("p2_r2", ModelPartBuilder.create().uv(60, 81).cuboid(-18.0F, 0.0F, -1.01F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-5.5319F, 4.0301F, 0.0F, 0.0F, 0.0F, 0.6109F));

        ModelPartData p3 = cross.addChild("p3", ModelPartBuilder.create().uv(54, 35).cuboid(-20.0F, -4.0F, -1.0F, 12.0F, 6.0F, 2.0F, new Dilation(0.0F))
                .uv(78, 73).cuboid(-21.4238F, -4.656F, -1.0F, 1.4238F, 7.312F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

        ModelPartData p3_r1 = p3.addChild("p3_r1", ModelPartBuilder.create().uv(82, 35).cuboid(-18.0F, 1.0F, -1.01F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-7.2526F, -8.4875F, 0.0F, 0.0F, 0.0F, -0.6109F));

        ModelPartData p3_r2 = p3.addChild("p3_r2", ModelPartBuilder.create().uv(82, 31).cuboid(-18.0F, 0.0F, -1.01F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-5.5319F, 4.0301F, 0.0F, 0.0F, 0.0F, 0.6109F));
        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        one_sin_and_hundreds_of_good_deeds.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(OneSinAndHundredsOfGoodDeedsEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }
}