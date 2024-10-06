package net.uniego.aida.lobecorp.item.ego.weapon.weapons;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.init.DamageInit;
import net.uniego.aida.lobecorp.item.ego.weapon.EGOWeapon;

import java.util.List;

//正义裁决者武器
public class JustitiaWeapon extends EGOWeapon {
    public static final String EGO_SKILL_WEAPON_JUSTITIA1 = "ego.skill.weapon.justitia1";
    public static final String EGO_SKILL_WEAPON_JUSTITIA2 = "ego.skill.weapon.justitia2";
    public static final JustitiaWeapon JUSTITIA_WEAPON = new JustitiaWeapon();

    public JustitiaWeapon() {
        super(LobeCorpUtil.EGOLevel.ALEPH, EGOWeaponTemplate.JUSTITA, 2, List.of(EGO_SKILL_WEAPON_JUSTITIA1, EGO_SKILL_WEAPON_JUSTITIA2));
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof ServerPlayerEntity serverPlayer) {
            if (serverPlayer.getWorld().random.nextFloat() <= 0.60F) {
                int timeUntilRegen = target.timeUntilRegen;
                target.timeUntilRegen = 0;
                for (int i = 0; i < 5; i++) {
                    target.damage(serverPlayer.getDamageSources().create(DamageInit.PALE, serverPlayer), 3);
                }
                target.timeUntilRegen = timeUntilRegen;
                return true;
            }
            if (serverPlayer.getWorld().random.nextFloat() <= 0.40F) {
                int timeUntilRegen = target.timeUntilRegen;
                target.timeUntilRegen = 0;
                for (int i = 0; i < 3; i++) {
                    target.damage(serverPlayer.getDamageSources().create(DamageInit.PALE, serverPlayer), 8.5F);
                }
                for (int i = 0; i < 7; i++) {
                    target.damage(serverPlayer.getDamageSources().create(DamageInit.PALE, serverPlayer), 3);
                }
                target.timeUntilRegen = timeUntilRegen;
                return true;
            }
        }
        return false;
    }
}
