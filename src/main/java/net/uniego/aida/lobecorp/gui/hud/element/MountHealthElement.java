package net.uniego.aida.lobecorp.gui.hud.element;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import net.uniego.aida.lobecorp.access.ManagerAccess;
import net.uniego.aida.lobecorp.gui.GUIResource;
import net.uniego.aida.lobecorp.gui.hud.BaseElement;
import net.uniego.aida.lobecorp.manager.SanityManager;

//渲染坐骑的生命条
@Environment(EnvType.CLIENT)
public class MountHealthElement extends BaseElement {
    //只有当玩家的坐骑是生物类型且玩家拥有状态条才开启
    @Override
    protected boolean check(MinecraftClient client) {
        if (client.player != null) {
            if (client.interactionManager != null) {
                return client.player.getVehicle() instanceof LivingEntity
                        && client.interactionManager.hasStatusBars();
            }
        }
        return false;
    }

    @Override
    protected void draw(MinecraftClient client, DrawContext drawContext, float tickDelta, int scaledWidth, int scaledHeight) {
        if (client.player != null) {
            SanityManager sanityManager = ((ManagerAccess) client.player).lobecorp$getSanityManager();
            int sanity = MathHelper.ceil(sanityManager.getSanity());
            int maxSanity = MathHelper.ceil(sanityManager.getMaxSanity());
            int assimilation = MathHelper.ceil(sanityManager.getAssimilationAmount());
            //字符串拼接
            String sanityString;
            if (assimilation > 0) sanityString = "(" + sanity + "+" + assimilation + ")" + "/" + maxSanity;
            else sanityString = sanity + "/" + maxSanity;
            if (client.player.getVehicle() instanceof LivingEntity mount) {
                int mountHealth = MathHelper.ceil(mount.getHealth());//获取坐骑生命值
                int mountMaxHealth = MathHelper.ceil(mount.getMaxHealth());//获取坐骑最大生命值
                //字符串拼接
                String mountHealthString = mountHealth + "/" + mountMaxHealth;
                //参数设置
                int posX = 35;
                int posY = 22;
                int height = 3;
                double width = (double) mountHealth / mountMaxHealth;
                int sanityOffset = client.textRenderer.getWidth(sanityString) / 2 + 2;
                int mountOffset = client.textRenderer.getWidth(mountHealthString) / 2 + 2;
                //渲染坐骑生命值字体背景
                drawRect(drawContext, posX + sanityOffset + 2, posY + height, mountOffset, height + 2, GUIResource.BG1);
                //渲染坐骑生命条背景
                drawTrap(posX + sanityOffset, posY, 58, 54, height, GUIResource.BG1);
                //渲染坐骑生命条
                drawTrap(posX + sanityOffset + 2, posY, 53 * width, 51 * width, height - 2, GUIResource.HEALTH);

                drawContext.getMatrices().scale(0.5F, 0.5F, 0.5F);
                //渲染坐骑生命值字体
                drawContext.drawCenteredTextWithShadow(client.textRenderer, mountHealthString, (posX + sanityOffset + 2) * 2 + mountOffset, (posY + height) * 2 + (height + 2) - 4, -1);
                drawContext.getMatrices().scale(2.0F, 2.0F, 2.0F);
            }
        }
    }
}
