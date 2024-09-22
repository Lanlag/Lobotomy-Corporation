package net.uniego.aida.lobecorp.gui.hud.element;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.GameMode;
import net.uniego.aida.lobecorp.gui.GUIResource;
import net.uniego.aida.lobecorp.gui.hud.BaseElement;

//渲染玩家的头像
@Environment(EnvType.CLIENT)
public class HeadElement extends BaseElement {
    //当前视角所属实体是玩家且非观察模式才渲染
    @Override
    protected boolean check(MinecraftClient client) {
        if (client.interactionManager != null) {
            return client.getCameraEntity() instanceof PlayerEntity
                    && client.interactionManager.getCurrentGameMode() != GameMode.SPECTATOR;
        }
        return false;
    }

    @Override
    protected void draw(MinecraftClient client, DrawContext drawContext, float tickDelta, int scaledWidth, int scaledHeight) {
        if (client.player != null) {
            Identifier skin = client.player.getSkinTextures().texture();//获取玩家皮肤
            //渲染玩家头部背景
            drawRect(drawContext, 2, 2, 20, 20, GUIResource.BG1);

            drawContext.getMatrices().scale(0.5F, 0.5F, 0.5F);
            //渲染玩家内层头像
            drawContext.drawTexture(skin, 8, 8, 32, 32, 32, 32);
            drawContext.getMatrices().scale(2.0F, 2.0F, 2.0F);

            drawContext.getMatrices().scale(0.6F, 0.6F, 0.6F);
            //渲染玩家外层头像
            drawContext.drawTexture(skin, 4, 4, 160, 32, 32, 32);
            drawContext.getMatrices().scale(2.0F, 2.0F, 2.0F);
        }
    }
}
