package net.uniego.aida.lobecorp;

import net.fabricmc.api.ModInitializer;
import net.uniego.aida.lobecorp.init.EffectInit;
import net.uniego.aida.lobecorp.init.EventInit;
import net.uniego.aida.lobecorp.init.NetworkInit;
import net.uniego.aida.lobecorp.init.PayloadInit;

public class LobeCorpMain implements ModInitializer {
    public static final String MOD_ID = "lobecorp";

    @Override
    public void onInitialize() {
        EventInit.registerServerEvents();
        NetworkInit.registerServer();
        EffectInit.register();
        PayloadInit.register();
    }
}
