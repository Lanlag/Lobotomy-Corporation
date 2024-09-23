package net.uniego.aida.lobecorp.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.uniego.aida.lobecorp.access.ManagerAccess;
import net.uniego.aida.lobecorp.manager.ThirstManager;

//干渴效果
public class ThirstEffect extends StatusEffect {
    public ThirstEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity player) {
            if (!player.getAbilities().invulnerable) {
                ThirstManager thirstManager = ((ManagerAccess) player).lobecorp$getThirstManager();
                thirstManager.addDesiccation(0.005F * (float) (amplifier + 1));
            }
        }
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
