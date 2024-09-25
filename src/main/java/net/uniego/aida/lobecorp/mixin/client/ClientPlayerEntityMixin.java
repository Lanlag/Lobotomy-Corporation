package net.uniego.aida.lobecorp.mixin.client;

import com.mojang.authlib.GameProfile;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.uniego.aida.lobecorp.access.ManagerAccess;
import net.uniego.aida.lobecorp.manager.ThirstManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin extends AbstractClientPlayerEntity {
    public ClientPlayerEntityMixin(ClientWorld world, GameProfile profile) {
        super(world, profile);
    }

    //新增干渴值大于6才能疾跑的设定
    @Inject(method = "canSprint", at = @At("RETURN"), cancellable = true)
    private void canSprintMixin(CallbackInfoReturnable<Boolean> cir) {
        ThirstManager thirstManager = ((ManagerAccess) this).lobecorp$getThirstManager();
        cir.setReturnValue(hasVehicle()
                || (getHungerManager().getFoodLevel() > 6 && thirstManager.getWaterLevel() > 6)
                || getAbilities().allowFlying);
    }
}
