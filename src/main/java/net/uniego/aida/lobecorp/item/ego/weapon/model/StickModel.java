package net.uniego.aida.lobecorp.item.ego.weapon.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class StickModel extends net.minecraft.client.render.entity.model.EntityModel<Entity> {
    private final ModelPart weapon;

    public StickModel() {
        ModelPart root = getTexturedModelData().createModel();
        this.weapon = root.getChild("weapon");
    }

    public TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData weapon = modelPartData.addChild("weapon", ModelPartBuilder.create().uv(0, 9).cuboid(-1.0F, -2.0F, 2.0F, 2.0F, 2.0F, 4.0F, new Dilation(-0.1F))
                .uv(0, 0).cuboid(-1.0F, -2.0F, -23.0F, 2.0F, 2.0F, 19.0F, new Dilation(-0.1F))
                .uv(0, 0).cuboid(-0.5F, -1.5F, -5.0F, 1.0F, 1.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        weapon.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(Entity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }
}
