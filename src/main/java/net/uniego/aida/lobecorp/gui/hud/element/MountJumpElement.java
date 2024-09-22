package net.uniego.aida.lobecorp.gui.hud.element;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.LivingEntity;
import net.uniego.aida.lobecorp.gui.GUIResource;
import net.uniego.aida.lobecorp.gui.hud.BaseElement;

//渲染玩家坐骑的跳跃条
@Environment(EnvType.CLIENT)
public class MountJumpElement extends BaseElement {
    //只有玩家的坐骑是生物，且坐骑跳跃值大于0时才会渲染
    @Override
    protected boolean check(MinecraftClient client) {
        if (client.player != null) {
            return client.player.getVehicle() instanceof LivingEntity
                    && client.player.getMountJumpStrength() > 0.0F;
        }
        return false;
    }

    @Override
    protected void draw(MinecraftClient client, DrawContext drawContext, float tickDelta, int scaledWidth, int scaledHeight) {
        if (client.player != null) {
            float mountJumpStrength = client.player.getMountJumpStrength();//获取玩家坐骑跳跃值
            //参数设置
            int posX = scaledWidth / 2 - 72;
            int posY = scaledHeight - 78;
            int height = 10;
            //渲染坐骑跳跃条背景
            drawRect(drawContext, posX, posY, 144, height, GUIResource.BG1);
            drawRect(drawContext, posX + 2, posY + 2, 140, height - 4, GUIResource.BG2);
            //渲染坐骑跳跃条
            drawRect(drawContext, posX + 2, posY + 2, (int) (140 * mountJumpStrength), height - 4, GUIResource.MOUNT_JUMP);
        }
    }
}
