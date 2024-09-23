package net.uniego.aida.lobecorp.network.handle;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.uniego.aida.lobecorp.network.payload.SwingHandPayload;

public class SwingHandHandle {
    public static void receive() {
        ClientPlayNetworking.registerGlobalReceiver(SwingHandPayload.ID, (payload, context) -> context.client().execute(() ->
                context.player().swingHand(context.player().getActiveHand())
        ));
    }
}
