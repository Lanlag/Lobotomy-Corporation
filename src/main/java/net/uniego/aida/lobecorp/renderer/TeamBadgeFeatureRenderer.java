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
import net.uniego.aida.lobecorp.item.badge.TeamBadge;
import net.uniego.aida.lobecorp.slot.LobeCorpEquipmentSlot;

//部门袖标在袖标位的模型渲染
@Environment(EnvType.CLIENT)
public class TeamBadgeFeatureRenderer extends FeatureRenderer<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> {
    public TeamBadgeFeatureRenderer(FeatureRendererContext<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, AbstractClientPlayerEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        ItemStack itemStack = LobeCorpUtil.getLobeCorpEquippedStack(entity, LobeCorpEquipmentSlot.LOBECORP_BADGE_SLOT);
        if (!itemStack.isEmpty() && itemStack.getItem() instanceof TeamBadge teamBadge) {
            matrices.push();
            LobeCorpItemModel itemModel = ModelInit.getLobeCorpItemModel(teamBadge);
            Identifier id = LobeCorpUtil.id("textures/entity/badge/" + Registries.ITEM.getId(teamBadge).getPath() + ".png");
            getContextModel().copyBipedStateTo(itemModel);
            VertexConsumer vertexConsumer = ItemRenderer.getArmorGlintConsumer(vertexConsumers, RenderLayer.getArmorCutoutNoCull(id), false, itemStack.hasGlint());
            itemModel.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
            matrices.pop();
        }
    }
}
