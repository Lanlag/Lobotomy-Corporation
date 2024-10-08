package net.uniego.aida.lobecorp.effect;


import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.InstantStatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.uniego.aida.lobecorp.access.ManagerAccess;
import net.uniego.aida.lobecorp.init.DamageInit;
import net.uniego.aida.lobecorp.manager.SanityManager;
import org.jetbrains.annotations.Nullable;

public class InstantSanityOrInjuryStatusEffect extends InstantStatusEffect {
    private final boolean injury;

    public InstantSanityOrInjuryStatusEffect(StatusEffectCategory category, int color, boolean injury) {
        super(category, color);
        this.injury = injury;
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity player) {
            SanityManager sanityManager = ((ManagerAccess) player).lobecorp$getSanityManager();
            if (injury == player.hasInvertedHealingAndHarm()) {
                sanityManager.cure((float) Math.max(4 << amplifier, 0));
            } else {
                player.damage(player.getDamageSources().create(DamageInit.MYSTIC), (float) (6 << amplifier));
            }
        }
        return true;
    }

    @Override
    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
        if (target instanceof PlayerEntity player) {
            int i;
            SanityManager sanityManager = ((ManagerAccess) player).lobecorp$getSanityManager();
            if (injury == player.hasInvertedHealingAndHarm()) {
                i = (int) (proximity * (double) (4 << amplifier) + 0.5);
                sanityManager.cure((float) i);
            } else {
                i = (int) (proximity * (double) (6 << amplifier) + 0.5);
                if (source == null) {
                    player.damage(player.getDamageSources().create(DamageInit.MYSTIC), (float) i);
                } else {
                    player.damage(player.getDamageSources().create(DamageInit.INDIRECT_MYSTIC, source, attacker), (float) i);
                }
            }
        }
    }
}
