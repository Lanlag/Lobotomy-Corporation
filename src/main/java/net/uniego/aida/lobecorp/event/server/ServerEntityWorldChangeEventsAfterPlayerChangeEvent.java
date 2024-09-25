package net.uniego.aida.lobecorp.event.server;


import net.fabricmc.fabric.api.entity.event.v1.ServerEntityWorldChangeEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.uniego.aida.lobecorp.access.ServerPlayerAccess;
import net.uniego.aida.lobecorp.network.packet.SyncEquipmentPacket;

//玩家切换维度事件
public class ServerEntityWorldChangeEventsAfterPlayerChangeEvent implements ServerEntityWorldChangeEvents.AfterPlayerChange {
    @Override
    public void afterChangeWorld(ServerPlayerEntity player, ServerWorld origin, ServerWorld destination) {
        //玩家切换维度后同步状态
        ((ServerPlayerAccess) player).lobecorp$playerChangeDimension();
        //玩家切换维度后向自己同步全部装备信息
        SyncEquipmentPacket.send(player, player);
    }
}
