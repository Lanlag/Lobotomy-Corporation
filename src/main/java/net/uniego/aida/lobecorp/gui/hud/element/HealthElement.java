package net.uniego.aida.lobecorp.gui.hud.element;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.MathHelper;
import net.uniego.aida.lobecorp.gui.GUIResource;
import net.uniego.aida.lobecorp.gui.hud.BaseElement;

//渲染玩家的生命条
@Environment(EnvType.CLIENT)
public class HealthElement extends BaseElement {
    //只有拥有状态条时才会渲染
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
            int health = MathHelper.ceil(client.player.getHealth());//获取玩家生命值
            int maxHealth = MathHelper.ceil(client.player.getMaxHealth());//获取玩家最大生命值
            int absorption = MathHelper.ceil(client.player.getAbsorptionAmount());//获取玩家伤害吸收值
            //字符串拼接
            String healthString;
            if (absorption > 0) healthString = "(" + health + "+" + absorption + ")" + "/" + maxHealth;
            else healthString = health + "/" + maxHealth;
            //参数设置
            int posX = 23;
            int posY = 3;
            int height = 11;
            double width1 = (double) (health + absorption) / (maxHealth + absorption);
            double width2 = (double) health / (maxHealth + absorption);
            int offset = client.textRenderer.getWidth(healthString) / 2 + 2;
            int icon = 11;
            //渲染icon和字体背景
            drawRect(drawContext, posX, posY, icon + offset, height, GUIResource.BG1);
            //渲染生命条外框背景
            drawTrap(posX + icon + offset + 1, posY - 1, 97, 83, height + 1, GUIResource.BG1);
            //渲染生命条内框背景
            drawTrap(posX + icon + offset + 1 + 2, posY - 1 + 2, 89, 79, height + 1 - 3, GUIResource.BG2);
            //渲染生命值图标和各种状态时生命条的颜色
            if (absorption > 0) {//有伤害吸收的时候
                drawTrap(posX + icon + offset + 1 + 2, posY - 1 + 2, 89 * width1, 79 * width1, height + 1 - 3, GUIResource.SHIELD);
            }
            if (client.player.hasStatusEffect(StatusEffects.POISON)) {//中毒情况
                drawContext.drawTexture(GUIResource.LOBECORP_ICONS, posX + 1, posY, 20, 10, 9, 9, 128, 128);
                drawTrap(posX + icon + offset + 1 + 2, posY - 1 + 2, 89 * width2, 79 * width2, height + 1 - 3, GUIResource.POISON);
            } else if (client.player.hasStatusEffect(StatusEffects.WITHER)) {//凋零情况
                drawContext.drawTexture(GUIResource.LOBECORP_ICONS, posX + 1, posY, 30, 10, 9, 9, 128, 128);
                drawTrap(posX + icon + offset + 1 + 2, posY - 1 + 2, 89 * width2, 79 * width2, height + 1 - 3, GUIResource.WITHER);
            } else if (client.player.isFrozen()) {//冻伤情况
                drawContext.drawTexture(GUIResource.LOBECORP_ICONS, posX + 1, posY, 40, 10, 9, 9, 128, 128);
                drawTrap(posX + icon + offset + 1 + 2, posY - 1 + 2, 89 * width2, 79 * width2, height + 1 - 3, GUIResource.FROZEN);
            } else {//正常情况
                drawContext.drawTexture(GUIResource.LOBECORP_ICONS, posX + 1, posY, 0, 10, 9, 9, 128, 128);
                drawTrap(posX + icon + offset + 1 + 2, posY - 1 + 2, 89 * width2, 79 * width2, height + 1 - 3, GUIResource.HEALTH);
            }

            drawContext.getMatrices().scale(0.5F, 0.5F, 0.5F);
            //渲染生命值字体以及字体颜色
            drawContext.drawCenteredTextWithShadow(client.textRenderer, healthString, (posX + icon) * 2 + offset, posY * 2 + height - 4, GUIResource.HEALTH);
            drawContext.getMatrices().scale(2.0F, 2.0F, 2.0F);
        }
    }
}
