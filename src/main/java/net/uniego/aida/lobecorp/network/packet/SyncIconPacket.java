package net.uniego.aida.lobecorp.network.packet;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.uniego.aida.lobecorp.access.ManagerAccess;
import net.uniego.aida.lobecorp.manager.SanityManager;
import net.uniego.aida.lobecorp.manager.ThirstManager;
import net.uniego.aida.lobecorp.network.payload.SyncIconPayload;

public class SyncIconPacket {
    public static void send(ServerPlayerEntity serverPlayer) {
        SanityManager sanityManager = ((ManagerAccess) serverPlayer).lobecorp$getSanityManager();
        ThirstManager thirstManager = ((ManagerAccess) serverPlayer).lobecorp$getThirstManager();
        HungerManager hungerManager = serverPlayer.getHungerManager();
        ServerPlayNetworking.send(serverPlayer, new SyncIconPayload(
                sanityManager.getSanity(),
                sanityManager.getMaxAssimilation(),
                sanityManager.getAssimilationAmount(),
                thirstManager.getWaterLevel(),
                thirstManager.getHydrationLevel(),
                thirstManager.getDesiccation(),
                hungerManager.getExhaustion()
        ));
    }
}
