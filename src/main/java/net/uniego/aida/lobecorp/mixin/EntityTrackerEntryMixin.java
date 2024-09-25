package net.uniego.aida.lobecorp.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.server.network.EntityTrackerEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.uniego.aida.lobecorp.network.packet.SyncEquipmentPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityTrackerEntry.class)
public abstract class EntityTrackerEntryMixin {
    @Shadow
    @Final
    private Entity entity;

    //玩家进服务器后，其余玩家向该名玩家发送全部装备信息，该玩家也向其余玩家发送全部装备信息
    @Inject(method = "startTracking", at = @At("TAIL"))
    private void startTrackingMixin(ServerPlayerEntity player, CallbackInfo ci) {
        if (entity instanceof ServerPlayerEntity serverPlayer) {
            SyncEquipmentPacket.send(serverPlayer, player);
            SyncEquipmentPacket.send(player, serverPlayer);
        }
    }
}
