package net.uniego.aida.lobecorp.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.init.ModelInit;
import net.uniego.aida.lobecorp.item.LobeCorpItemModel;
import net.uniego.aida.lobecorp.item.ego.suit.EGOSuit;
import net.uniego.aida.lobecorp.slot.LobeCorpEquipmentSlot;

//EGO护甲在护甲位的模型渲染
@Environment(EnvType.CLIENT)
public class EGOSuitFeatureRenderer extends FeatureRenderer<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> {
    public EGOSuitFeatureRenderer(FeatureRendererContext<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, AbstractClientPlayerEntity entity,
                       float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        ItemStack itemStack = LobeCorpUtil.getLobeCorpEquippedStack(entity, LobeCorpEquipmentSlot.LOBECORP_SUIT_SLOT);
        if (!itemStack.isEmpty() && itemStack.getItem() instanceof EGOSuit egoSuit) {
            matrices.push();
            //获取模型和贴图
            LobeCorpItemModel itemModel = ModelInit.getLobeCorpItemModel(egoSuit);
            Identifier id = LobeCorpUtil.id("textures/entity/suit/" + Registries.ITEM.getId(egoSuit).getPath() + "_model.png");
            //复制状态
            getContextModel().copyBipedStateTo(itemModel);
            //渲染
            VertexConsumer vertexConsumer = ItemRenderer.getArmorGlintConsumer(vertexConsumers, RenderLayer.getArmorCutoutNoCull(id), false, itemStack.hasGlint());
            itemModel.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
            matrices.pop();
        }
    }
}
