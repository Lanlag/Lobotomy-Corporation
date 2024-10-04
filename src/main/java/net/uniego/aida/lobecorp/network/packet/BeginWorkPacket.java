package net.uniego.aida.lobecorp.network.packet;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.uniego.aida.lobecorp.network.payload.BeginWorkPayload;

import java.util.UUID;

public class BeginWorkPacket {
    public static void send(UUID abnormalityUuid, String workMethod) {
        ClientPlayNetworking.send(new BeginWorkPayload(abnormalityUuid, workMethod));
    }
}
