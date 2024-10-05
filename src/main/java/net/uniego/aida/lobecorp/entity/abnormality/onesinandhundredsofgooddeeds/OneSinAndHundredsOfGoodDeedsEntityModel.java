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
        ModelPartData one_sin_and_hundreds_of_good_deeds = modelPartData.addChild("one_sin_and_hundreds_of_good_deeds", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -8.0F, 0.0F));

        ModelPartData head = one_sin_and_hundreds_of_good_deeds.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -9.0F));

        ModelPartData skull = head.addChild("skull", ModelPartBuilder.create().uv(1, 53).cuboid(-14.95F, 1.6375F, -8.05F, 30.0F, 27.0F, 25.0F, new Dilation(-6.9375F))
                .uv(31, 128).cuboid(-17.9625F, 8.15F, -12.0F, 36.0F, 12.0F, 41.0F, new Dilation(-9.0F))
                .uv(12, 66).cuboid(-8.0F, 8.5875F, 10.0F, 16.0F, 14.0F, 8.0F, new Dilation(0.0F))
                .uv(33, 41).cuboid(-3.0F, 23.5875F, -0.5F, 6.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 39).cuboid(-5.9625F, 18.3375F, -3.8625F, 12.0F, 8.0F, 8.0F, new Dilation(-2.775F))
                .uv(0, 39).cuboid(-5.9625F, 18.3375F, -3.275F, 12.0F, 8.0F, 8.0F, new Dilation(-2.775F)), ModelTransform.pivot(0.0F, -13.0F, 0.0F));

        ModelPartData mandible = skull.addChild("mandible", ModelPartBuilder.create().uv(22, 27).cuboid(-3.0F, 27.5875F, -5.5F, 6.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 37).cuboid(-6.0F, 28.5875F, -6.0F, 12.0F, 2.0F, 3.0F, new Dilation(0.0F))
                .uv(31, 29).cuboid(4.0F, 21.5875F, 1.0F, 2.0F, 9.0F, 4.0F, new Dilation(0.0F))
                .uv(22, 30).cuboid(-6.0F, 21.5875F, 1.0F, 2.0F, 9.0F, 4.0F, new Dilation(0.0F))
                .uv(70, 67).cuboid(4.0F, 28.5875F, -3.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(22, 34).cuboid(-6.0F, 28.5875F, -3.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 5.0F));

        ModelPartData cross = head.addChild("cross", ModelPartBuilder.create().uv(78, 30).cuboid(-3.0F, 29.5875F, -1.0F, 6.0F, 15.0F, 2.0F, new Dilation(0.0F))
                .uv(106, 39).cuboid(-1.75F, 29.5875F, -1.5F, 3.5F, 14.0F, 3.0F, new Dilation(0.0F))
                .uv(112, 41).cuboid(-1.75F, 6.5875F, -1.5F, 3.5F, 12.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -21.0F, 9.0F));

        ModelPartData cross_r1 = cross.addChild("cross_r1", ModelPartBuilder.create().uv(115, 40).cuboid(-0.75F, 9.0F, -1.5F, 3.5F, 12.0F, 3.0F, new Dilation(0.0F))
                .uv(108, 41).cuboid(-0.75F, -19.0F, -1.5F, 3.5F, 12.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 26.5875F, 0.0F, 0.0F, 0.0F, -1.5708F));

        ModelPartData p1 = cross.addChild("p1", ModelPartBuilder.create().uv(62, 33).cuboid(-20.0F, 22.5875F, -1.0F, 12.0F, 6.0F, 2.0F, new Dilation(0.0F))
                .uv(74, 39).cuboid(-21.4238F, 21.9315F, -1.0F, 1.4238F, 7.312F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData p1_r1 = p1.addChild("p1_r1", ModelPartBuilder.create().uv(92, 5).cuboid(-18.0F, 1.0F, -1.01F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-7.2526F, 18.1F, 0.0F, 0.0F, 0.0F, -0.6109F));

        ModelPartData p1_r2 = p1.addChild("p1_r2", ModelPartBuilder.create().uv(92, 1).cuboid(-18.0F, 0.0F, -1.01F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-5.5319F, 30.6176F, 0.0F, 0.0F, 0.0F, 0.6109F));

        ModelPartData p2 = cross.addChild("p2", ModelPartBuilder.create().uv(68, 9).cuboid(-20.0F, 22.5875F, -1.0F, 12.0F, 6.0F, 2.0F, new Dilation(0.0F))
                .uv(84, 37).cuboid(-21.4238F, 21.9315F, -1.0F, 1.4238F, 7.312F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        ModelPartData p2_r1 = p2.addChild("p2_r1", ModelPartBuilder.create().uv(96, 9).cuboid(-33.25F, 22.7792F, -1.01F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-7.2526F, -8.4875F, 0.0F, 0.0F, 0.0F, -0.6109F));

        ModelPartData p2_r2 = p2.addChild("p2_r2", ModelPartBuilder.create().uv(74, 55).cuboid(-2.75F, 21.7792F, -1.01F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-5.5319F, 4.0301F, 0.0F, 0.0F, 0.0F, 0.6109F));

        ModelPartData p3 = cross.addChild("p3", ModelPartBuilder.create().uv(67, 43).cuboid(6.5875F, -4.0F, -1.0F, 12.0F, 6.0F, 2.0F, new Dilation(0.0F))
                .uv(84, 46).cuboid(5.1637F, -4.656F, -1.0F, 1.4238F, 7.312F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

        ModelPartData p3_r1 = p3.addChild("p3_r1", ModelPartBuilder.create().uv(96, 17).cuboid(3.7792F, 16.25F, -1.01F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-7.2526F, -8.4875F, 0.0F, 0.0F, 0.0F, -0.6109F));

        ModelPartData p3_r2 = p3.addChild("p3_r2", ModelPartBuilder.create().uv(96, 13).cuboid(3.7792F, -15.25F, -1.01F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-5.5319F, 4.0301F, 0.0F, 0.0F, 0.0F, 0.6109F));
        return TexturedModelData.of(modelData, 200, 200);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        one_sin_and_hundreds_of_good_deeds.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(OneSinAndHundredsOfGoodDeedsEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }
}