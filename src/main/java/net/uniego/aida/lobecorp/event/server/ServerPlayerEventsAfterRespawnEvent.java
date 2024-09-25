package net.uniego.aida.lobecorp.event.server;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import net.uniego.aida.lobecorp.network.packet.SyncEquipmentPacket;

//玩家死后复活事件
public class ServerPlayerEventsAfterRespawnEvent implements ServerPlayerEvents.AfterRespawn {
    @Override
    public void afterRespawn(ServerPlayerEntity oldPlayer, ServerPlayerEntity newPlayer, boolean alive) {
        //玩家死后向自己同步全部装备信息
        SyncEquipmentPacket.send(newPlayer, newPlayer);
    }
}
