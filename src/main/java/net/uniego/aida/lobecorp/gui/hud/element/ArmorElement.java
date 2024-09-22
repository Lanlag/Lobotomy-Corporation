package net.uniego.aida.lobecorp.gui.hud.element;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.util.math.MathHelper;
import net.uniego.aida.lobecorp.gui.GUIResource;
import net.uniego.aida.lobecorp.gui.hud.BaseElement;

//渲染玩家的护甲值和护甲韧性
@Environment(EnvType.CLIENT)
public class ArmorElement extends BaseElement {
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
            int armor = client.player.getArmor();//获取玩家的护甲值
            //获取玩家的护甲韧性
            int armor_toughness = MathHelper.floor(client.player.getAttributeValue(EntityAttributes.GENERIC_ARMOR_TOUGHNESS));
            //字符串拼接
            String armorString = String.valueOf(armor);
            String armorToughnessString = String.valueOf(armor_toughness);
            //参数设置
            int posX = 2;
            int posY = 23;
            int height = 9;
            int armorOffset = client.textRenderer.getWidth(armorString) / 2 + 2;
            int armorToughnessOffset = client.textRenderer.getWidth(armorToughnessString) / 2 + 2;
            int icon = 11;
            //渲染护甲值背景和图标
            drawRect(drawContext, posX, posY, icon + armorOffset, height, GUIResource.BG1);
            drawContext.drawTexture(GUIResource.LOBECORP_ICONS, posX + 1, posY, 0, 70, 9, 9, 128, 128);
            //渲染护甲韧性背景和图标
            drawRect(drawContext, posX, posY + height + 1, icon + armorToughnessOffset, height, GUIResource.BG1);
            drawContext.drawTexture(GUIResource.LOBECORP_ICONS, posX + 1, posY + height + 1, 10, 70, 9, 9, 128, 128);

            drawContext.getMatrices().scale(0.5F, 0.5F, 0.5F);
            //渲染护甲值字体
            drawContext.drawCenteredTextWithShadow(client.textRenderer, armorString, (posX + icon) * 2 + armorOffset, posY * 2 + 5, -1);
            //渲染护甲韧性字体
            drawContext.drawCenteredTextWithShadow(client.textRenderer, armorToughnessString, (posX + icon) * 2 + armorToughnessOffset, (posY + height + 1) * 2 + 5, -1);
            drawContext.getMatrices().scale(2.0F, 2.0F, 2.0F);
        }
    }
}
