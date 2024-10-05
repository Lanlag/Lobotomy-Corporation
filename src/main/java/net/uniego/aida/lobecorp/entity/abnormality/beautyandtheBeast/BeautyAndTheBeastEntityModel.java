package net.uniego.aida.lobecorp.entity.abnormality.beautyandtheBeast;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

//美女与野兽实体模型
@Environment(EnvType.CLIENT)
public class BeautyAndTheBeastEntityModel extends EntityModel<BeautyAndTheBeastEntity> {
    private final ModelPart bb_main;

    public BeautyAndTheBeastEntityModel(ModelPart root) {
        this.bb_main = root.getChild("bb_main");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
                .uv(0, 27).cuboid(-3.0F, -14.05F, -3.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F))
                .uv(24, 27).cuboid(2.0F, -16.25F, -1.0F, 1.0F, 3.0F, 2.0F, new Dilation(0.0F))
                .uv(30, 27).cuboid(1.4F, -16.25F, -1.0F, 1.0F, 3.0F, 2.0F, new Dilation(0.0F))
                .uv(32, 5).cuboid(-3.0F, -16.25F, -1.0F, 1.0F, 3.0F, 2.0F, new Dilation(0.0F))
                .uv(32, 0).cuboid(-2.4F, -16.25F, -1.0F, 1.0F, 3.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 16).cuboid(-4.0F, -9.45F, -4.0F, 8.0F, 3.0F, 8.0F, new Dilation(-0.6625F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(BeautyAndTheBeastEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }
}
