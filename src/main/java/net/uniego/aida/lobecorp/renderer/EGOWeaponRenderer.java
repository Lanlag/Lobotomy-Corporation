package net.uniego.aida.lobecorp.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.uniego.aida.lobecorp.LobeCorpUtil;

//渲染EGO武器在手里时候的模型
@Environment(EnvType.CLIENT)
public class EGOWeaponRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {
    private final EntityModel<Entity> entityModel;
    private final Identifier egoWeaponTexture;

    public EGOWeaponRenderer(EntityModel<Entity> entityModel, String id) {
        this.entityModel = entityModel;
        this.egoWeaponTexture = LobeCorpUtil.id("textures/item/" + id + ".png");
    }

    @Override
    public void render(ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, RenderLayer.getEntityCutoutNoCull(egoWeaponTexture), false, stack.hasGlint());
        entityModel.render(matrices, vertexConsumer, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
    }
}
