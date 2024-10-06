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
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Arm;
import net.minecraft.util.Identifier;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.init.ModelInit;
import net.uniego.aida.lobecorp.item.LobeCorpItemModel;
import net.uniego.aida.lobecorp.item.ego.suit.EGOSuit;
import net.uniego.aida.lobecorp.renderer.*;
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
        addFeature(new EGOHeadFeatureRenderer(this));
        addFeature(new EGOOcciputFeatureRenderer(this));
        addFeature(new EGOEyeFeatureRenderer(this));
    }

    //渲染玩家的手臂部分
    @Inject(method = "renderArm", at = @At("TAIL"))
    private void renderArm(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, AbstractClientPlayerEntity player, ModelPart arm, ModelPart sleeve, CallbackInfo ci) {
        ItemStack itemStack = LobeCorpUtil.getLobeCorpEquippedStack(player, LobeCorpEquipmentSlot.LOBECORP_SUIT_SLOT);
        if (!itemStack.isEmpty() && itemStack.getItem() instanceof EGOSuit egoSuit) {
            matrices.push();
            LobeCorpItemModel itemModel = ModelInit.getLobeCorpItemModel(egoSuit);
            Identifier id = LobeCorpUtil.id("textures/entity/suit/" + Registries.ITEM.getId(egoSuit).getPath() + "_model.png");
            Arm mainArm = player.getMainArm();
            //判断主手是左手还是副手
            ModelPart modelPart = mainArm == Arm.LEFT ? itemModel.getLeftArm() : itemModel.getRightArm();
            //复制手臂的变换
            modelPart.copyTransform(arm);
            VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(id));
            modelPart.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV);
            matrices.pop();
        }
    }

    //禁止尸体名字的渲染
    @Inject(method = "renderLabelIfPresent(Lnet/minecraft/client/network/AbstractClientPlayerEntity;Lnet/minecraft/text/Text;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IF)V", at = @At("HEAD"), cancellable = true)
    private void renderLabelIfPresentMixin(AbstractClientPlayerEntity abstractClientPlayerEntity, Text text, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, float f, CallbackInfo ci) {
        if (!abstractClientPlayerEntity.shouldRenderName()) {
            ci.cancel();
        }
    }
}
