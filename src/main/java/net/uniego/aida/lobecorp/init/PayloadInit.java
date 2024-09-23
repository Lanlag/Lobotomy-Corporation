package net.uniego.aida.lobecorp.init;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.uniego.aida.lobecorp.network.payload.SyncIconPayload;
import net.uniego.aida.lobecorp.network.payload.SyncOffsetPayload;

//初始化负载
public class PayloadInit {
    public static void register() {
        PayloadTypeRegistry.playS2C().register(SyncIconPayload.ID, SyncIconPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(SyncOffsetPayload.ID, SyncOffsetPayload.CODEC);
    }
}
