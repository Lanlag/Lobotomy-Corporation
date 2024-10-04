package net.uniego.aida.lobecorp.network.packet;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.uniego.aida.lobecorp.network.payload.OpenWorkPayload;

import java.util.UUID;

public class OpenWorkPacket {
    public static void send(UUID abnormalityUuid) {
        ClientPlayNetworking.send(new OpenWorkPayload(abnormalityUuid));
    }
}
