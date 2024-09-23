package net.uniego.aida.lobecorp.network.packet;


import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.network.ServerPlayerEntity;
import net.uniego.aida.lobecorp.network.payload.SwingHandPayload;

public class SwingHandPacket {
    public static void send(ServerPlayerEntity serverPlayer) {
        serverPlayer.swingHand(serverPlayer.getActiveHand());
        ServerPlayNetworking.send(serverPlayer, new SwingHandPayload());
    }
}
