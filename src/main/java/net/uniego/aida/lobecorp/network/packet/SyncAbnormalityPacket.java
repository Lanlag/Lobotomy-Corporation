package net.uniego.aida.lobecorp.network.packet;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.network.ServerPlayerEntity;
import net.uniego.aida.lobecorp.network.payload.SyncAbnormalityPayload;

public class SyncAbnormalityPacket {
    public static void send(ServerPlayerEntity serverPlayer, int abnormalityId) {
        ServerPlayNetworking.send(serverPlayer, new SyncAbnormalityPayload(abnormalityId));
    }
}
