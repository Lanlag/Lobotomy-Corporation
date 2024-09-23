package net.uniego.aida.lobecorp.mixin;

import net.minecraft.entity.effect.HungerStatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(HungerStatusEffect.class)
public abstract class HungerStatusEffectMixin {
    //分离饥饿效果对干渴值的影响，同时让不会受伤的玩家避免饥饿效果影响
    @Redirect(method = "applyUpdateEffect", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;addExhaustion(F)V"))
    private void applyUpdateEffectMixin(PlayerEntity instance, float exhaustion) {
        if (!instance.getAbilities().invulnerable) {
            if (!instance.getWorld().isClient) {
                instance.getHungerManager().addExhaustion(exhaustion);
            }
        }
    }
}
