package net.uniego.aida.lobecorp;

import net.fabricmc.api.ClientModInitializer;
import net.uniego.aida.lobecorp.init.EventInit;
import net.uniego.aida.lobecorp.init.KeyInit;
import net.uniego.aida.lobecorp.init.NetworkInit;
import net.uniego.aida.lobecorp.init.ScreenInit;

public class LobeCorpClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EventInit.registerClientEvents();
        ScreenInit.registerScreen();
        KeyInit.register();

        NetworkInit.registerClient();
    }
}
