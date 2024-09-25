package net.uniego.aida.lobecorp.mixin.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.uniego.aida.lobecorp.renderer.EGOSuitFeatureRenderer;
import net.uniego.aida.lobecorp.renderer.EGOWeaponFeatureRenderer;
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
    }
}
