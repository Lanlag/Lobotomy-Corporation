package net.uniego.aida.lobecorp.item.ego.weapon.weapons;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.access.ManagerAccess;
import net.uniego.aida.lobecorp.item.ego.weapon.EGOWeapon;

//忏悔武器
public class PenitenceWeapon extends EGOWeapon {
    public static final String EGO_SKILL_WEAPON_PENITENCE = "ego.skill.weapon.penitence";
    public static final PenitenceWeapon PENITENCE_WEAPON = new PenitenceWeapon();

    public PenitenceWeapon() {
        super(LobeCorpUtil.EGOLevel.ZAYIN, EGOWeaponTemplate.MACE, 5, EGO_SKILL_WEAPON_PENITENCE);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof ServerPlayerEntity serverPlayer && ((ManagerAccess) serverPlayer).lobecorp$getLevelManager().getLevelJ().getValue() > 2) {
            if (serverPlayer.getWorld().random.nextFloat() < 0.05F) {
                ((ManagerAccess) serverPlayer).lobecorp$getSanityManager().cure(10);
                return true;
            }
        }
        return false;
    }
}
