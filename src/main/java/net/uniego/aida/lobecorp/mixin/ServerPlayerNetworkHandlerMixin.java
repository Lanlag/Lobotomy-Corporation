package net.uniego.aida.lobecorp.mixin;

import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.access.ManagerAccess;
import net.uniego.aida.lobecorp.manager.SanityManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayNetworkHandler.class)
public abstract class ServerPlayerNetworkHandlerMixin {
    @Shadow
    public ServerPlayerEntity player;

    //如果玩家在恐慌状态下退出就杀死玩家
    @Inject(method = "onDisconnected", at = @At("HEAD"))
    private void onDisconnectedMixin(Text reason, CallbackInfo ci) {
        SanityManager sanityManager = ((ManagerAccess) player).lobecorp$getSanityManager();
        if (sanityManager.isCrazy()) {
            sanityManager.setShouldKill(true);
            LobeCorpUtil.sanityKill(player);
        }
    }
}
