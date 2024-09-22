package net.uniego.aida.lobecorp.gui.hud.element;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.LivingEntity;
import net.uniego.aida.lobecorp.gui.hud.BaseElement;

//渲染玩家坐骑的生命条
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

    }
}
