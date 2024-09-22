package net.uniego.aida.lobecorp.gui.hud.element;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.uniego.aida.lobecorp.access.ManagerAccess;
import net.uniego.aida.lobecorp.gui.GUIResource;
import net.uniego.aida.lobecorp.gui.hud.BaseElement;
import net.uniego.aida.lobecorp.init.EffectInit;
import net.uniego.aida.lobecorp.manager.ThirstManager;

//渲染玩家的干渴条
@Environment(EnvType.CLIENT)
public class WaterElement extends BaseElement {
    //只有当玩家拥有状态条时才开启
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
            ThirstManager thirstManager = ((ManagerAccess) client.player).cogito$getThirstManager();//获取玩家干渴机制
            int waterLevel = thirstManager.getWaterLevel();//获取玩家干渴值
            float hydrationLevel = thirstManager.getHydrationLevel();//获取玩家饱水度
            float desiccation = thirstManager.getDesiccation();//获取玩家脱水度
            int ticks = client.inGameHud.getTicks();//获取tick
            int bounceFactor;
            int thirstFactor = 0;
            if (client.player.hasStatusEffect(EffectInit.THIRST)) thirstFactor = 30;
            //参数设置
            int posX = scaledWidth / 2 - 91;
            int posY = scaledHeight - 39;
            float ratio = Math.min(1, Math.max(0, desiccation / 4.0F));
            int offset = (int) ratio * 81;
            //渲染脱水度条
            drawContext.drawTexture(GUIResource.LOBECORP_ICONS, posX, posY, 0, 0, offset, 9, 128, 128);
            //渲染空干渴条
            for (int i = 0; i < 10; i++) {
                bounceFactor = getThirstBounceFactor(client.player, thirstManager, ticks);
                drawContext.drawTexture(GUIResource.LOBECORP_ICONS, posX + 8 * i, posY + bounceFactor,
                        thirstFactor, 40, 9, 9, 128, 128);
            }
            //渲染半干渴条
            for (int i = 0; i < 10; i++) {
                if (waterLevel != 0) {
                    if (((waterLevel + 1) / 2) > i) {
                        bounceFactor = getThirstBounceFactor(client.player, thirstManager, ticks);
                        drawContext.drawTexture(GUIResource.LOBECORP_ICONS, posX + 8 * i, posY + bounceFactor,
                                20 + thirstFactor, 40, 9, 9, 128, 128);
                    } else {
                        break;
                    }
                }
            }
            //渲染满干渴条
            for (int i = 0; i < 10; i++) {
                if (waterLevel != 0) {
                    if ((waterLevel / 2) > i) {
                        bounceFactor = getThirstBounceFactor(client.player, thirstManager, ticks);
                        drawContext.drawTexture(GUIResource.LOBECORP_ICONS, posX + 8 * i, posY + bounceFactor,
                                10 + thirstFactor, 40, 9, 9, 128, 128);
                    } else {
                        break;
                    }
                }
            }
            //渲染饱水度条
            for (int i = 0; i < (int) Math.ceil(hydrationLevel / 2.0F); i++) {
                int iconOffset = getIconOffset(hydrationLevel, i);
                drawContext.drawTexture(GUIResource.LOBECORP_ICONS, posX + 8 * i, posY,
                        iconOffset, 60, 9, 9, 128, 128);
            }
        }
    }
}
