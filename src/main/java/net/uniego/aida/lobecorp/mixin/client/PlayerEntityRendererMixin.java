package net.uniego.aida.lobecorp.mixin.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Arm;
import net.minecraft.util.Identifier;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.init.ModelInit;
import net.uniego.aida.lobecorp.item.LobeCorpItemModel;
import net.uniego.aida.lobecorp.item.ego.suit.EGOSuit;
import net.uniego.aida.lobecorp.renderer.EGOSuitFeatureRenderer;
import net.uniego.aida.lobecorp.renderer.EGOWeaponFeatureRenderer;
import net.uniego.aida.lobecorp.renderer.TeamBadgeFeatureRenderer;
import net.uniego.aida.lobecorp.slot.LobeCorpEquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(PlayerEntityRenderer.class)
public abstract class PlayerEntityRendererMixin extends LivingEntityRenderer<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> {
    public PlayerEntityRendererMixin(EntityRendererFactory.Context ctx, PlayerEntityModel<AbstractClientPlayerEntity> model, float shadowRadius) {
        super(ctx, model, shadowRadius);
    }

    //渲染脑叶公司18个插槽模型的入口
    @Inject(method = "<init>", at = @At("TAIL"))
    private void initMixin(EntityRendererFactory.Context ctx, boolean slim, CallbackInfo ci) {
        addFeature(new EGOWeaponFeatureRenderer(this, ctx.getHeldItemRenderer()));
        addFeature(new EGOSuitFeatureRenderer(this));
        addFeature(new TeamBadgeFeatureRenderer(this));
    }

    //渲染玩家的手臂部分
    @Inject(method = "renderArm", at = @At("TAIL"))
    private void renderArm(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, AbstractClientPlayerEntity player, ModelPart arm, ModelPart sleeve, CallbackInfo ci) {
        ItemStack itemStack = LobeCorpUtil.getLobeCorpEquippedStack(player, LobeCorpEquipmentSlot.LOBECORP_SUIT_SLOT);
        if (!itemStack.isEmpty() && itemStack.getItem() instanceof EGOSuit egoSuit) {
            matrices.push();
            LobeCorpItemModel itemModel = ModelInit.getLobeCorpItemModel(egoSuit);
            Identifier id = LobeCorpUtil.id("textures/entity/suit/" + Registries.ITEM.getId(egoSuit).getPath() + ".png");
            Arm mainArm = player.getMainArm();
            //判断主手是左手还是副手
            ModelPart modelPart = mainArm == Arm.LEFT ? itemModel.getLeftArm() : itemModel.getRightArm();
            //切换视角时重置手臂部分
            modelPart.resetTransform();
            VertexConsumer vertexConsumer = ItemRenderer.getArmorGlintConsumer(vertexConsumers, RenderLayer.getArmorCutoutNoCull(id), false, itemStack.hasGlint());
            modelPart.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
            matrices.pop();
        }
    }
}
