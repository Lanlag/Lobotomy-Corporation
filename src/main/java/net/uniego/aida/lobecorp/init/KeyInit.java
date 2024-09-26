package net.uniego.aida.lobecorp.init;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

//初始化按键
public class KeyInit {
    public static final String CATEGORIES_LOBECORP = "key.categories.lobecorp";
    public static final String KEY_EQUIPMENT_INVENTORY = "key.equipment_inventory";
    public static final String KEY_SWITCH_WEAPON = "key.switch_weapon";

    public static KeyBinding EQUIPMENT_INVENTORY;
    public static KeyBinding SWITCH_WEAPON;

    public static void register() {
        EQUIPMENT_INVENTORY = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_EQUIPMENT_INVENTORY, GLFW.GLFW_KEY_Z, CATEGORIES_LOBECORP));
        SWITCH_WEAPON = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_SWITCH_WEAPON, GLFW.GLFW_KEY_X, CATEGORIES_LOBECORP
        ));
    }
}
