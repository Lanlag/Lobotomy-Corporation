package net.uniego.aida.lobecorp.event.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.uniego.aida.lobecorp.init.KeyInit;
import net.uniego.aida.lobecorp.network.packet.OpenClosePacket;

//客户端每一帧结束时事件
@Environment(EnvType.CLIENT)
public class ClientTickEventsEndTickEvent implements ClientTickEvents.EndTick {
    @Override
    public void onEndTick(MinecraftClient client) {
        while (KeyInit.EQUIPMENT_INVENTORY.wasPressed()) {
            OpenClosePacket.send();
        }//开启/关闭装备
    }
}
