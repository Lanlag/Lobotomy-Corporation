package net.uniego.aida.lobecorp;

import net.fabricmc.api.ClientModInitializer;
import net.uniego.aida.lobecorp.init.EventInit;
import net.uniego.aida.lobecorp.init.NetworkInit;

public class LobeCorpClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EventInit.registerClientEvents();

        NetworkInit.registerClient();
    }
}
