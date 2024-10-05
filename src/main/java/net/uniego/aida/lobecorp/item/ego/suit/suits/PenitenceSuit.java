package net.uniego.aida.lobecorp.item.ego.suit.suits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.access.ManagerAccess;
import net.uniego.aida.lobecorp.init.DamageInit;
import net.uniego.aida.lobecorp.item.ego.suit.EGOSuit;
import net.uniego.aida.lobecorp.slot.LobeCorpEquipmentSlot;

//忏悔护甲
public class PenitenceSuit extends EGOSuit {
    public static final String EGO_SKILL_SUIT_PENITENCE = "ego.skill.suit.penitence";
    public static final PenitenceSuit PENITENCE_SUIT = new PenitenceSuit();

    public PenitenceSuit() {
        super(LobeCorpUtil.EGOLevel.ZAYIN, 0.9F, 0.8F, 0.9F, 2.0F, EGO_SKILL_SUIT_PENITENCE);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof ServerPlayerEntity serverPlayer &&
                LobeCorpUtil.getLobeCorpEquippedStack(serverPlayer, LobeCorpEquipmentSlot.LOBECORP_SUIT_SLOT).getItem() instanceof PenitenceSuit) {
            DamageSource recentDamageSource = serverPlayer.getRecentDamageSource();
            if (recentDamageSource != null) {
                if (recentDamageSource.isOf(DamageInit.RED) || recentDamageSource.isOf(DamageInit.BLACK)) {
                    if (serverPlayer.hurtTime == serverPlayer.maxHurtTime / 2 && serverPlayer.getWorld().random.nextFloat() < 0.05F) {
                        ((ManagerAccess) serverPlayer).lobecorp$getSanityManager().cure(10);
                    }
                }
            }
        }
    }
}
