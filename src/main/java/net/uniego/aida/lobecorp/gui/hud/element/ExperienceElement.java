package net.uniego.aida.lobecorp.gui.hud.element;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.math.MathHelper;
import net.uniego.aida.lobecorp.gui.GUIResource;
import net.uniego.aida.lobecorp.gui.hud.BaseElement;

//渲染玩家的经验条
@Environment(EnvType.CLIENT)
public class ExperienceElement extends BaseElement {
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
            int experienceLevel = client.player.experienceLevel;//获取玩家经验等级
            int maxExperience = client.player.getNextLevelExperience();//获取玩家升级到下一级所需全部经验
            int experience = MathHelper.ceil(client.player.experienceProgress * maxExperience);//获取玩家当前经验
            //字符串拼接
            String expLevelString = "Lvl:" + experienceLevel;
            String expString = experience + "/" + maxExperience;
            //参数设置
            int posX = 1;
            int posY = scaledHeight - 12;
            int height1 = 5;
            int height2 = 7;
            double width = (double) (scaledWidth - 2) / maxExperience;
            int expLevelOffset = client.textRenderer.getWidth(expLevelString) / 2 + 4;
            int expOffset = client.textRenderer.getWidth(expString) / 2 + 2;
            //渲染经验等级背景
            drawRect(drawContext, posX, posY, expLevelOffset, height1, GUIResource.BG1);
            //渲染经验值背景
            drawRect(drawContext, scaledWidth - expOffset, posY, expOffset, height1, GUIResource.BG1);
            //渲染经验条背景
            drawRect(drawContext, 0, posY + height1, scaledWidth, height2, GUIResource.BG1);
            //渲染经验条
            drawRect(drawContext, posX, posY + height1 + 1, (int) (experience * width), height2 - 3, GUIResource.EXPERIENCE);

            drawContext.getMatrices().scale(0.5F, 0.5F, 0.5F);
            //渲染经验等级字体
            drawContext.drawCenteredTextWithShadow(client.textRenderer, expLevelString, posX * 2 + expLevelOffset + 1, posY * 2 + height1 - 3, GUIResource.EXPERIENCE);
            //渲染经验值字体
            drawContext.drawCenteredTextWithShadow(client.textRenderer, expString, (scaledWidth - expOffset) * 2 + expOffset + 1, posY * 2 + height1 - 3, -1);
            drawContext.getMatrices().scale(2.0F, 2.0F, 2.0F);
        }
    }
}
