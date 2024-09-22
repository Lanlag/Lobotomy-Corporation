package net.uniego.aida.lobecorp.manager;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.uniego.aida.lobecorp.gui.GUIResource;
import net.uniego.aida.lobecorp.gui.hud.BaseElement;
import net.uniego.aida.lobecorp.gui.hud.element.*;

import java.util.HashMap;
import java.util.Map;

//负责管理和注册所有HUD元素
@Environment(EnvType.CLIENT)
public class HUDManager {
    public static final Map<String, BaseElement> elements = new HashMap<>();

    public HUDManager() {
        elements.put(GUIResource.AIR_ELEMENT, new AirElement());
        elements.put(GUIResource.ARMOR_ELEMENT, new ArmorElement());
        elements.put(GUIResource.EXPERIENCE_ELEMENT, new ExperienceElement());
        elements.put(GUIResource.FOOD_ELEMENT, new FoodElement());
        elements.put(GUIResource.HEAD_ELEMENT, new HeadElement());
        elements.put(GUIResource.HEALTH_ELEMENT, new HealthElement());
        elements.put(GUIResource.HOT_BAR_ELEMENT, new HotBarElement());
        elements.put(GUIResource.MOUNT_HEALTH_ELEMENT, new MountHealthElement());
        elements.put(GUIResource.MOUNT_JUMP_ELEMENT, new MountJumpElement());
    }

    //根据HUD元素类型调用对应检查方法
    public boolean checkElements(String type, MinecraftClient client) {
        return elements.get(type).checkElement(client);
    }

    //根据HUD元素类型调用对应绘制方法
    public void drawElements(String type, MinecraftClient client, DrawContext drawContext, float tickDelta, int scaledWidth, int scaledHeight) {
        elements.get(type).drawElement(client, drawContext, tickDelta, scaledWidth, scaledHeight);
    }
}
