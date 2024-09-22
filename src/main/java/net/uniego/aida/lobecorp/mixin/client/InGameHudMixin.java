package net.uniego.aida.lobecorp.mixin.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.JumpingMount;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(InGameHud.class)
public abstract class InGameHudMixin {
    //取消渲染原版护甲条、生命条、饥饿条、氧气条
    @Inject(method = "renderStatusBars", at = @At("HEAD"), cancellable = true)
    private void renderStatusBarsMixin(DrawContext context, CallbackInfo ci) {
        ci.cancel();
    }

    //取消渲染玩家经验等级
    @Inject(method = "renderExperienceLevel", at = @At("HEAD"), cancellable = true)
    private void renderExperienceLevelMixin(DrawContext context, float x, CallbackInfo ci) {
        ci.cancel();
    }

    //取消渲染玩家经验条
    @Inject(method = "renderExperienceBar", at = @At("HEAD"), cancellable = true)
    private void renderExperienceBarMixin(DrawContext context, int x, CallbackInfo ci) {
        ci.cancel();
    }

    //取消渲染玩家快捷栏
    @Inject(method = "renderHotbar", at = @At("HEAD"), cancellable = true)
    private void renderHotbarMixin(DrawContext context, float tickDelta, CallbackInfo ci) {
        ci.cancel();
    }

    //取消渲染坐骑生命条
    @Inject(method = "renderMountHealth", at = @At("HEAD"), cancellable = true)
    private void renderMountHealthMixin(DrawContext context, CallbackInfo ci) {
        ci.cancel();
    }

    //取消渲染坐骑跳跃条
    @Inject(method = "renderMountJumpBar", at = @At("HEAD"), cancellable = true)
    private void renderMountJumpBarMixin(JumpingMount mount, DrawContext context, int x, CallbackInfo ci) {
        ci.cancel();
    }
}
