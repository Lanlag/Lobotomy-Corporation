package net.uniego.aida.lobecorp.gui.hud.element;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.HungerManager;
import net.uniego.aida.lobecorp.gui.GUIResource;
import net.uniego.aida.lobecorp.gui.hud.BaseElement;

//渲染玩家的饥饿条
@Environment(EnvType.CLIENT)
public class FoodElement extends BaseElement {
    //只有玩家拥有状态条时才会渲染
    @Override
    protected boolean check(MinecraftClient client) {
        if (client.interactionManager != null) {
            return client.interactionManager.hasStatusBars();
        }
        return false;
    }

    @Override
    protected void draw(MinecraftClient client, DrawContext drawContext, float tickDelta, int scaledWidth, int scaledHeight) {
        if (client.player != null) {
            HungerManager hungerManager = client.player.getHungerManager();//获取玩家饥饿机制
            int foodLevel = hungerManager.getFoodLevel();//获取玩家饥饿值
            float saturationLevel = hungerManager.getSaturationLevel();//获取玩家饱食度
            float exhaustion = hungerManager.getExhaustion();//获取玩家消耗度
            int ticks = client.inGameHud.getTicks();//获取tick
            int bounceFactor;
            int hungerFactor = 0;
            if (client.player.hasStatusEffect(StatusEffects.HUNGER)) hungerFactor = 30;
            //参数设置
            int posX = scaledWidth / 2 + 82;
            int posY = scaledHeight - 39;
            float ratio = Math.min(1, Math.max(0, exhaustion / 4.0F));
            int offset = (int) (ratio * 81);
            //渲染消耗度条
            drawContext.drawTexture(GUIResource.LOBECORP_ICONS, posX + 9 - offset, posY, 81 - offset, 0, offset, 9, 128, 128);
            //渲染空饥饿条
            for (int i = 0; i < 10; i++) {
                bounceFactor = getHungerBounceFactor(client.player, hungerManager, ticks);
                drawContext.drawTexture(GUIResource.LOBECORP_ICONS, posX - 8 * i, posY + bounceFactor,
                        hungerFactor, 30, 9, 9, 128, 128);
            }
            //渲染半饥饿条
            for (int i = 0; i < 10; i++) {
                if (foodLevel != 0) {
                    if (((foodLevel + 1) / 2) > i) {
                        bounceFactor = getHungerBounceFactor(client.player, hungerManager, ticks);
                        drawContext.drawTexture(GUIResource.LOBECORP_ICONS, posX - 8 * i, posY + bounceFactor,
                                20 + hungerFactor, 30, 9, 9, 128, 128);
                    } else {
                        break;
                    }
                }
            }
            //渲染满饥饿条
            for (int i = 0; i < 10; i++) {
                if (foodLevel != 0) {
                    if ((foodLevel / 2) > i) {
                        bounceFactor = getHungerBounceFactor(client.player, hungerManager, ticks);
                        drawContext.drawTexture(GUIResource.LOBECORP_ICONS, posX - 8 * i, posY + bounceFactor,
                                10 + hungerFactor, 30, 9, 9, 128, 128);
                    } else {
                        break;
                    }
                }
            }
            //渲染饱食度条
            for (int i = 0; i < (int) Math.ceil(saturationLevel / 2.0F); i++) {
                int iconOffset = getIconOffset(saturationLevel, i);
                drawContext.drawTexture(GUIResource.LOBECORP_ICONS, posX - 8 * i, posY,
                        iconOffset, 50, 9, 9, 128, 128);
            }
        }
    }
}
