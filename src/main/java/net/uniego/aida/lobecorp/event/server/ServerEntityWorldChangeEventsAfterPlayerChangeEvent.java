package net.uniego.aida.lobecorp.event.server;


import net.fabricmc.fabric.api.entity.event.v1.ServerEntityWorldChangeEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.uniego.aida.lobecorp.access.ServerPlayerAccess;

//玩家切换维度事件
public class ServerEntityWorldChangeEventsAfterPlayerChangeEvent implements ServerEntityWorldChangeEvents.AfterPlayerChange {
    @Override
    public void afterChangeWorld(ServerPlayerEntity player, ServerWorld origin, ServerWorld destination) {
        //玩家切换维度后同步状态
        ((ServerPlayerAccess) player).lobecorp$playerChangeDimension();
    }
}
