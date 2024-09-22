package net.uniego.aida.lobecorp.gui.hud.element;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.registry.tag.FluidTags;
import net.uniego.aida.lobecorp.gui.GUIResource;
import net.uniego.aida.lobecorp.gui.hud.BaseElement;

//渲染玩家的氧气条
@Environment(EnvType.CLIENT)
public class AirElement extends BaseElement {
    //只有玩家拥有状态条，且玩家在水里或者玩家氧气值小于最大值时才会渲染
    @Override
    protected boolean check(MinecraftClient client) {
        if (client.interactionManager != null) {
            if (client.player != null) {
                return client.interactionManager.hasStatusBars()
                        && (client.player.isSubmergedIn(FluidTags.WATER)
                        || client.player.getAir() < client.player.getMaxAir());
            }
        }
        return false;
    }

    @Override
    protected void draw(MinecraftClient client, DrawContext drawContext, float tickDelta, int scaledWidth, int scaledHeight) {
        if (client.player != null) {
            int air = client.player.getAir();//获取玩家氧气值
            int maxAir = client.player.getMaxAir();//获取玩家最大氧气值
            //参数设置
            int posX = scaledWidth / 2 - 72;
            int posY = scaledHeight - 98;
            int height = 10;
            double width = (double) air / maxAir;
            //渲染氧气条背景
            drawRect(drawContext, posX, posY, 144, height, GUIResource.BG1);
            drawRect(drawContext, posX + 2, posY + 2, 140, height - 4, GUIResource.BG2);
            //渲染氧气条
            drawRect(drawContext, posX + 2, posY + 2, (int) (140 * width), height - 4, GUIResource.AIR);
        }
    }
}
