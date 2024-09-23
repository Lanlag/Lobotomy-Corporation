package net.uniego.aida.lobecorp.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.access.ManagerAccess;
import net.uniego.aida.lobecorp.access.ServerPlayerAccess;
import net.uniego.aida.lobecorp.manager.SanityManager;
import net.uniego.aida.lobecorp.manager.ThirstManager;
import net.uniego.aida.lobecorp.network.packet.SyncIconPacket;
import net.uniego.aida.lobecorp.network.packet.SyncOffsetPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin extends PlayerEntity implements ServerPlayerAccess {
    @Unique
    private final SanityManager sanityManager = ((ManagerAccess) this).lobecorp$getSanityManager();
    @Unique
    private final ThirstManager thirstManager = ((ManagerAccess) this).lobecorp$getThirstManager();
    @Unique
    ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) (Object) this;
    @Unique
    private float syncedSanity = -1.0E8F;
    @Unique
    private float syncedAssimilation = -1.0E8F;
    @Unique
    private int syncedWaterLevel = -99999999;
    @Unique
    private boolean playerChangeDimension = false;

    public ServerPlayerEntityMixin(World world, BlockPos pos, float yaw, GameProfile gameProfile) {
        super(world, pos, yaw, gameProfile);
    }

    @Override
    public void lobecorp$playerChangeDimension() {
        playerChangeDimension = true;
    }

    //实时同步玩家饱水度和脱水度，饱食度和消耗度，以及玩家装饰等机制
    @Inject(method = "tick", at = @At("TAIL"))
    private void tickMixin(CallbackInfo ci) {
        SyncOffsetPacket.send(serverPlayerEntity);
    }

    //当玩家状态发生变化时，发送同步信息的数据包，同时同步服务端客户端的异想体信息
    @Inject(method = "playerTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;tick()V", shift = At.Shift.AFTER))
    private void playerTickMixin(CallbackInfo ci) {
        if (sanityManager.getSanity() != syncedSanity
                || sanityManager.getAssimilationAmount() != syncedAssimilation
                || thirstManager.getWaterLevel() != syncedWaterLevel
                || playerChangeDimension) {
            SyncIconPacket.send(serverPlayerEntity);
            syncedSanity = sanityManager.getSanity();
            syncedAssimilation = sanityManager.getAssimilationAmount();
            syncedWaterLevel = thirstManager.getWaterLevel();
            if (playerChangeDimension) playerChangeDimension = false;
        }
    }
}
