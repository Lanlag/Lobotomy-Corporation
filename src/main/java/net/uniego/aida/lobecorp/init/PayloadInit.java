package net.uniego.aida.lobecorp.init;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.uniego.aida.lobecorp.network.payload.*;

//初始化负载
public class PayloadInit {
    public static void register() {
        PayloadTypeRegistry.playC2S().register(BeginWorkPayload.ID, BeginWorkPayload.CODEC);
        PayloadTypeRegistry.playC2S().register(DrinkWaterPayload.ID, DrinkWaterPayload.CODEC);
        PayloadTypeRegistry.playC2S().register(OpenClosePayload.ID, OpenClosePayload.CODEC);
        PayloadTypeRegistry.playC2S().register(OpenWorkPayload.ID, OpenWorkPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(SwingHandPayload.ID, SwingHandPayload.CODEC);
        PayloadTypeRegistry.playC2S().register(SwitchWeaponPayload.ID, SwitchWeaponPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(SyncAbnormalityPayload.ID, SyncAbnormalityPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(SyncEquipmentPayload.ID, SyncEquipmentPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(SyncIconPayload.ID, SyncIconPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(SyncOffsetPayload.ID, SyncOffsetPayload.CODEC);
    }
}
