package net.uniego.aida.lobecorp.network.handle;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.entity.player.HungerManager;
import net.uniego.aida.lobecorp.access.ManagerAccess;
import net.uniego.aida.lobecorp.init.AttributeInit;
import net.uniego.aida.lobecorp.manager.SanityManager;
import net.uniego.aida.lobecorp.manager.ThirstManager;
import net.uniego.aida.lobecorp.network.payload.SyncIconPayload;

import java.util.Objects;

public class SyncIconHandle {
    public static void receive() {
        ClientPlayNetworking.registerGlobalReceiver(SyncIconPayload.ID, (payload, context) -> context.client().execute(() -> {
            SanityManager sanityManager = ((ManagerAccess) context.player()).lobecorp$getSanityManager();
            ThirstManager thirstManager = ((ManagerAccess) context.player()).lobecorp$getThirstManager();
            HungerManager hungerManager = context.player().getHungerManager();
            sanityManager.setSanity(payload.sanity());
            Objects.requireNonNull(context.player().getAttributeInstance(AttributeInit.PLAYER_MAX_ASSIMILATION)).
                    setBaseValue(payload.maxAssimilation());
            sanityManager.setAssimilationAmount(payload.assimilation());
            thirstManager.setWaterLevel(payload.water());
            thirstManager.setHydrationLevel(payload.hydration());
            thirstManager.setDesiccation(payload.desiccation());
            hungerManager.setExhaustion(payload.exhaustion());
        }));
    }
}
