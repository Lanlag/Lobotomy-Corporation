package net.uniego.aida.lobecorp.network.packet;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.network.ServerPlayerEntity;
import net.uniego.aida.lobecorp.access.ManagerAccess;
import net.uniego.aida.lobecorp.network.payload.SyncOffsetPayload;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SyncOffsetPacket {
    private static final Map<UUID, Float> hydrationLevels = new HashMap<>();
    private static final Map<UUID, Float> desiccationLevels = new HashMap<>();
    private static final Map<UUID, Float> saturationLevels = new HashMap<>();
    private static final Map<UUID, Float> exhaustionLevels = new HashMap<>();

    public static void send(ServerPlayerEntity serverPlayer) {
        //饱水度
        Float hydrationLevel = hydrationLevels.get(serverPlayer.getUuid());
        float hydration = ((ManagerAccess) serverPlayer).lobecorp$getThirstManager().getHydrationLevel();
        if (hydrationLevel == null || hydrationLevel != hydration) {
            ServerPlayNetworking.send(serverPlayer, new SyncOffsetPayload(SyncOffsetPayload.HYDRATION, hydration));
            hydrationLevels.put(serverPlayer.getUuid(), hydration);
        }
        //脱水度
        Float desiccationLevel = desiccationLevels.get(serverPlayer.getUuid());
        float desiccation = ((ManagerAccess) serverPlayer).lobecorp$getThirstManager().getDesiccation();
        if (desiccationLevel == null || Math.abs(desiccationLevel - desiccation) >= 0.01F) {
            ServerPlayNetworking.send(serverPlayer, new SyncOffsetPayload(SyncOffsetPayload.DESICCATION, desiccation));
            desiccationLevels.put(serverPlayer.getUuid(), desiccation);
        }
        //饱食度
        Float saturationLevel = saturationLevels.get(serverPlayer.getUuid());
        float saturation = serverPlayer.getHungerManager().getSaturationLevel();
        if (saturationLevel == null || saturationLevel != saturation) {
            ServerPlayNetworking.send(serverPlayer, new SyncOffsetPayload(SyncOffsetPayload.SATURATION, saturation));
            saturationLevels.put(serverPlayer.getUuid(), saturation);
        }
        //消耗度
        Float exhaustionLevel = exhaustionLevels.get(serverPlayer.getUuid());
        float exhaustion = serverPlayer.getHungerManager().getExhaustion();
        if (exhaustionLevel == null || Math.abs(exhaustionLevel - exhaustion) >= 0.01F) {
            ServerPlayNetworking.send(serverPlayer, new SyncOffsetPayload(SyncOffsetPayload.EXHAUSTION, exhaustion));
            exhaustionLevels.put(serverPlayer.getUuid(), exhaustion);
        }
    }

    public static void remove(ServerPlayerEntity serverPlayer) {
        hydrationLevels.remove(serverPlayer.getUuid());
        desiccationLevels.remove(serverPlayer.getUuid());
        saturationLevels.remove(serverPlayer.getUuid());
        exhaustionLevels.remove(serverPlayer.getUuid());
    }
}
