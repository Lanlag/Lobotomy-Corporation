package net.uniego.aida.lobecorp.effect;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.uniego.aida.lobecorp.access.ManagerAccess;
import net.uniego.aida.lobecorp.init.DamageInit;
import net.uniego.aida.lobecorp.manager.SanityManager;

//恍惚效果
public class AbsentEffect extends StatusEffect {
    public AbsentEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity player) {
            SanityManager sanityManager = ((ManagerAccess) player).lobecorp$getSanityManager();
            if (sanityManager.getSanity() > 1.0F) {
                player.damage(player.getDamageSources().create(DamageInit.MYSTIC), 1.0F);
            }
        }
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 25 >> amplifier;
        if (i > 0) {
            return duration % i == 0;
        } else {
            return true;
        }
    }
}
