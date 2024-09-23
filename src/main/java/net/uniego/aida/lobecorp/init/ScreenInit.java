package net.uniego.aida.lobecorp.init;

import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.gui.screen.LobeCorpScreen;
import net.uniego.aida.lobecorp.gui.screen.LobeCorpScreenHandler;

//初始化屏幕
public class ScreenInit {
    public static final String CONTAINER_EQUIPMENT = "container.equipment";

    //注册屏幕处理器
    public static void registerScreenHandler() {
        Registry.register(Registries.SCREEN_HANDLER, LobeCorpUtil.id("lobecorp_screen_handler"), LOBECORP_SCREEN_HANDLER);
    }

    //注册屏幕
    public static void registerScreen() {
        HandledScreens.register(LOBECORP_SCREEN_HANDLER, LobeCorpScreen::new);
    }

    public static final ScreenHandlerType<LobeCorpScreenHandler> LOBECORP_SCREEN_HANDLER = new ScreenHandlerType<>(LobeCorpScreenHandler::new, FeatureFlags.VANILLA_FEATURES);
}
