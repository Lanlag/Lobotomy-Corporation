package net.uniego.aida.lobecorp.network.packet;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.uniego.aida.lobecorp.network.payload.OpenClosePayload;

public class OpenClosePacket {
    public static void send() {
        ClientPlayNetworking.send(new OpenClosePayload());
    }
}
