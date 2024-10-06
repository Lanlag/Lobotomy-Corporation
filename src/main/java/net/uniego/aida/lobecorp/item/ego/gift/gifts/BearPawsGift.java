package net.uniego.aida.lobecorp.item.ego.gift.gifts;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.entity.abnormality.AbnormalityEntity;
import net.uniego.aida.lobecorp.gui.screen.BoxScreenHandler;
import net.uniego.aida.lobecorp.item.ego.gift.EGOGift;
import net.uniego.aida.lobecorp.slot.LobeCorpAttributeModifierSlot;
import net.uniego.aida.lobecorp.slot.LobeCorpEquipmentSlot;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;

import java.util.List;

//熊熊抱饰品
public class BearPawsGift extends EGOGift {
    public static final String EGO_SKILL_GIFT_BEAR_PAWS = "ego.skill.gift.bear_paws";
    public static final BearPawsGift BEAR_PAWS_GIFT = new BearPawsGift();
    private boolean hasExecuted;

    public BearPawsGift() {
        super(0, 4, 0, 0, 0, 0,
                LOBECORP_HEAD_MODIFIER_ID, LobeCorpAttributeModifierSlot.LOBECORP_HEAD, List.of(EGO_SKILL_GIFT_BEAR_PAWS));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof ServerPlayerEntity serverPlayer &&
                LobeCorpUtil.getLobeCorpEquippedStack(serverPlayer, LobeCorpEquipmentSlot.LOBECORP_HEAD_SLOT).getItem() instanceof BearPawsGift) {
            if (serverPlayer.currentScreenHandler instanceof BoxScreenHandler boxScreenHandler) {
                if (!hasExecuted && AbnormalityEntity.ATTACHMENT.equals(boxScreenHandler.abnormality.workMethod)) {
                    boxScreenHandler.abnormality.setExtraProbability(0.03F);
                    hasExecuted = true;
                }
            } else {
                hasExecuted = false;
            }
        }
    }
}
