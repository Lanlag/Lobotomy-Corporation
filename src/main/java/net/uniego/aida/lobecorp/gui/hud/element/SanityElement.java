package net.uniego.aida.lobecorp.gui.hud.element;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.math.MathHelper;
import net.uniego.aida.lobecorp.access.ManagerAccess;
import net.uniego.aida.lobecorp.gui.GUIResource;
import net.uniego.aida.lobecorp.gui.hud.BaseElement;
import net.uniego.aida.lobecorp.init.EffectInit;
import net.uniego.aida.lobecorp.manager.SanityManager;

//渲染玩家的精神条
@Environment(EnvType.CLIENT)
public class SanityElement extends BaseElement {
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
            SanityManager sanityManager = ((ManagerAccess) client.player).lobecorp$getSanityManager();//获取玩家精神机制
            int sanity = MathHelper.ceil(sanityManager.getSanity());//获取玩家精神值
            int maxSanity = MathHelper.ceil(sanityManager.getMaxSanity());//获取玩家最大精神值
            int assimilation = MathHelper.ceil(sanityManager.getAssimilationAmount());//获取玩家认知同化值
            //字符串拼接
            String sanityString;
            if (assimilation > 0) sanityString = "(" + sanity + "+" + assimilation + ")" + "/" + maxSanity;
            else sanityString = sanity + "/" + maxSanity;
            //参数设置
            int posX = 23;
            int posY = 12;
            int height = 9;
            double width1 = (double) (sanity + assimilation) / (maxSanity + assimilation);
            double width2 = (double) sanity / (maxSanity + assimilation);
            int offset = client.textRenderer.getWidth(sanityString) / 2 + 2;
            int icon = 11;
            //渲染icon和字体背景
            drawRect(drawContext, posX, posY, icon + offset, height, GUIResource.BG1);
            //渲染精神条外框背景
            drawTrap(posX + icon + offset + 1, posY, 83, 97, height + 1, GUIResource.BG1);
            //渲染精神条内框背景
            drawTrap(posX + icon + offset + 1 + 2, posY + 1, 79, 89, height + 1 - 3, GUIResource.BG2);
            //渲染精神值图标和各种状态精神条的颜色
            if (assimilation > 1) {//有认知同化的时候
                drawTrap(posX + icon + offset + 1 + 2, posY + 1, 79 * width1, 89 * width1, height + 1 - 3, GUIResource.SHIELD);
            }
            if (client.player.hasStatusEffect(EffectInit.ABSENT)) {//恍惚情况
                drawContext.drawTexture(GUIResource.LOBECORP_ICONS, posX + 1, posY, 20, 20, 9, 9, 128, 128);
                drawTrap(posX + icon + offset + 1 + 2, posY + 1, 79 * width2, 89 * width2, height + 1 - 3, GUIResource.ABSENT);
            } else if (client.player.hasStatusEffect(EffectInit.INSANE)) {//狂乱情况
                drawContext.drawTexture(GUIResource.LOBECORP_ICONS, posX + 1, posY, 30, 20, 9, 9, 128, 128);
                drawTrap(posX + icon + offset + 1 + 2, posY + 1, 79 * width2, 89 * width2, height + 1 - 3, GUIResource.INSANE);
            } else {//正常情况
                drawContext.drawTexture(GUIResource.LOBECORP_ICONS, posX + 1, posY, 0, 20, 9, 9, 128, 128);
                drawTrap(posX + icon + offset + 1 + 2, posY + 1, 79 * width2, 89 * width2, height + 1 - 3, GUIResource.SANITY);
            }

            drawContext.getMatrices().scale(0.5F, 0.5F, 0.5F);
            //渲染精神值字体以及字体颜色
            drawContext.drawCenteredTextWithShadow(client.textRenderer, sanityString, (posX + icon) * 2 + offset, posY * 2 + height - 4, GUIResource.SANITY);
            drawContext.getMatrices().scale(2.0F, 2.0F, 2.0F);
        }
    }
}
