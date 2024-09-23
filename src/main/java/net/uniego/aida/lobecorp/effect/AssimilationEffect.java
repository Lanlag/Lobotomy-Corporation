package net.uniego.aida.lobecorp.effect;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.uniego.aida.lobecorp.access.ManagerAccess;
import net.uniego.aida.lobecorp.manager.SanityManager;

//认知同化效果
public class AssimilationEffect extends StatusEffect {
    public AssimilationEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity player) {
            SanityManager sanityManager = ((ManagerAccess) player).lobecorp$getSanityManager();
            return sanityManager.getAssimilationAmount() > 0.0F || player.getWorld().isClient;
        }
        return false;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity player) {
            SanityManager sanityManager = ((ManagerAccess) player).lobecorp$getSanityManager();
            sanityManager.setAssimilationAmount(Math.max(sanityManager.getAssimilationAmount(), (float) (4 * (1 + amplifier))));
        }
    }
}
