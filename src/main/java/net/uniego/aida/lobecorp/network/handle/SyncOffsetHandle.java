package net.uniego.aida.lobecorp.network.handle;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.entity.player.HungerManager;
import net.uniego.aida.lobecorp.access.ManagerAccess;
import net.uniego.aida.lobecorp.manager.ThirstManager;
import net.uniego.aida.lobecorp.network.payload.SyncOffsetPayload;

public class SyncOffsetHandle {
    public static void receive() {
        ClientPlayNetworking.registerGlobalReceiver(SyncOffsetPayload.ID, (payload, context) -> context.client().execute(() -> {
            ThirstManager thirstManager = ((ManagerAccess) context.player()).lobecorp$getThirstManager();
            HungerManager hungerManager = context.player().getHungerManager();
            if (SyncOffsetPayload.HYDRATION.equals(payload.name())) {//饱水度
                thirstManager.setHydrationLevel(payload.value());
            } else if (SyncOffsetPayload.DESICCATION.equals(payload.name())) {//脱水度
                thirstManager.setDesiccation(payload.value());
            } else if (SyncOffsetPayload.SATURATION.equals(payload.name())) {//饱食度
                hungerManager.setSaturationLevel(payload.value());
            } else if (SyncOffsetPayload.EXHAUSTION.equals(payload.name())) {//消耗度
                hungerManager.setExhaustion(payload.value());
            }
        }));
    }
}
