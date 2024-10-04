package net.uniego.aida.lobecorp.network.handle;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.entity.Entity;
import net.uniego.aida.lobecorp.entity.abnormality.AbnormalityEntity;
import net.uniego.aida.lobecorp.gui.screen.BoxScreenHandler;
import net.uniego.aida.lobecorp.gui.screen.WorkScreenHandler;
import net.uniego.aida.lobecorp.network.payload.SyncAbnormalityPayload;

public class SyncAbnormalityHandle {
    public static void receive() {
        ClientPlayNetworking.registerGlobalReceiver(SyncAbnormalityPayload.ID, ((payload, context) -> context.client().execute(() -> {
            Entity entity = context.player().getWorld().getEntityById(payload.abnormalityId());
            if (entity instanceof AbnormalityEntity abnormality) {
                if (context.player().currentScreenHandler instanceof WorkScreenHandler workScreenHandler) {
                    workScreenHandler.abnormality = abnormality;
                } else if (context.player().currentScreenHandler instanceof BoxScreenHandler boxScreenHandler) {
                    boxScreenHandler.abnormality = abnormality;
                }
            }
        })));
    }
}
