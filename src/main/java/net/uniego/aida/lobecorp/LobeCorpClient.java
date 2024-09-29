package net.uniego.aida.lobecorp;

import net.fabricmc.api.ClientModInitializer;
import net.uniego.aida.lobecorp.init.*;

public class LobeCorpClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EventInit.registerClientEvents();
        ScreenInit.registerScreen();
        KeyInit.register();
        ModelInit.register();
        EntityRendererInit.register();

        NetworkInit.registerClient();
    }
}
