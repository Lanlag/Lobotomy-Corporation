package net.uniego.aida.lobecorp.event;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.uniego.aida.lobecorp.gui.GUIResource;
import net.uniego.aida.lobecorp.manager.HUDManager;

//HUD元素渲染事件
@Environment(EnvType.CLIENT)
public class HudRenderCallbackEvent implements HudRenderCallback {
    private MinecraftClient client;
    private HUDManager hudManager;

    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        client = MinecraftClient.getInstance();
        hudManager = new HUDManager();
        renderHUD(drawContext, tickDelta);
    }

    //渲染所有HUD元素
    private void renderHUD(DrawContext drawContext, float tickDelta) {
        checkAndDrawHUD(GUIResource.AIR_ELEMENT, drawContext, tickDelta);
        checkAndDrawHUD(GUIResource.ARMOR_ELEMENT, drawContext, tickDelta);
        checkAndDrawHUD(GUIResource.EXPERIENCE_ELEMENT, drawContext, tickDelta);
        checkAndDrawHUD(GUIResource.FOOD_ELEMENT, drawContext, tickDelta);
        checkAndDrawHUD(GUIResource.HEAD_ELEMENT, drawContext, tickDelta);
        checkAndDrawHUD(GUIResource.HEALTH_ELEMENT, drawContext, tickDelta);
        checkAndDrawHUD(GUIResource.HOT_BAR_ELEMENT, drawContext, tickDelta);
        checkAndDrawHUD(GUIResource.MOUNT_HEALTH_ELEMENT, drawContext, tickDelta);
        checkAndDrawHUD(GUIResource.MOUNT_JUMP_ELEMENT, drawContext, tickDelta);
    }

    //检查并绘制HUD元素
    private void checkAndDrawHUD(String type, DrawContext drawContext, float tickDelta) {
        if (hudManager.checkElements(type, client)) {
            drawContext.getMatrices().push();
            int scaledWidth = client.getWindow().getScaledWidth();
            int scaledHeight = client.getWindow().getScaledHeight();
            hudManager.drawElements(type, client, drawContext, tickDelta, scaledWidth, scaledHeight);
            drawContext.getMatrices().pop();
        }
    }
}
