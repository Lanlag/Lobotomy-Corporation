package net.uniego.aida.lobecorp;

import net.fabricmc.api.ClientModInitializer;
import net.uniego.aida.lobecorp.block.entity.renderer.LobecorpBlockEntityRenderLayers;
import net.uniego.aida.lobecorp.init.*;

public class LobeCorpClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EventInit.registerClientEvents();
        ScreenInit.registerScreen();
        KeyInit.register();
        ModelInit.register();
        LobecorpBlockEntityRenderLayers.register();
        BlockEntityRendererInit.register();
        EntityRendererInit.register();
        ParticleInit.registerClient();

        NetworkInit.registerClient();
    }
}
