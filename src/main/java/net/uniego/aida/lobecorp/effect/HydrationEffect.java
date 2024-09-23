package net.uniego.aida.lobecorp.effect;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.InstantStatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.uniego.aida.lobecorp.access.ManagerAccess;

//滋润效果
public class HydrationEffect extends InstantStatusEffect {
    public HydrationEffect(StatusEffectCategory statusEffectCategory, int i) {
        super(statusEffectCategory, i);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getWorld().isClient && entity instanceof PlayerEntity player) {
            ((ManagerAccess) player).lobecorp$getThirstManager().add(amplifier + 1, 1.0F);
        }
        return true;
    }
}
