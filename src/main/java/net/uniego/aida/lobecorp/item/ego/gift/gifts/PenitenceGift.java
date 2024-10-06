package net.uniego.aida.lobecorp.item.ego.gift.gifts;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.entity.abnormality.onesinandhundredsofgooddeeds.OneSinAndHundredsOfGoodDeedsEntity;
import net.uniego.aida.lobecorp.gui.screen.BoxScreenHandler;
import net.uniego.aida.lobecorp.gui.screen.WorkScreenHandler;
import net.uniego.aida.lobecorp.item.ego.gift.EGOGift;
import net.uniego.aida.lobecorp.slot.LobeCorpAttributeModifierSlot;
import net.uniego.aida.lobecorp.slot.LobeCorpEquipmentSlot;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;

import java.util.List;

//忏悔饰品
public class PenitenceGift extends EGOGift {
    public static final String EGO_SKILL_GIFT_PENITENCE = "ego.skill.gift.penitence";
    public static final PenitenceGift PENITENCE_GIFT = new PenitenceGift();
    private boolean hasExecuted;

    public PenitenceGift() {
        super(0, 2, 0, 0, 0, 0,
                LOBECORP_HEAD_MODIFIER_ID, LobeCorpAttributeModifierSlot.LOBECORP_HEAD, List.of(EGO_SKILL_GIFT_PENITENCE));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof ServerPlayerEntity serverPlayer &&
                LobeCorpUtil.getLobeCorpEquippedStack(serverPlayer, LobeCorpEquipmentSlot.LOBECORP_HEAD_SLOT).getItem() instanceof PenitenceGift) {
            if (serverPlayer.currentScreenHandler instanceof WorkScreenHandler workScreenHandler) {
                if (!hasExecuted && workScreenHandler.abnormality instanceof OneSinAndHundredsOfGoodDeedsEntity oneSinAndHundredsOfGoodDeedsEntity) {
                    oneSinAndHundredsOfGoodDeedsEntity.setExtraProbability(0.10F);
                    hasExecuted = true;
                }
            } else if (serverPlayer.currentScreenHandler instanceof BoxScreenHandler) {
                hasExecuted = false;
            }
        }
    }
}
