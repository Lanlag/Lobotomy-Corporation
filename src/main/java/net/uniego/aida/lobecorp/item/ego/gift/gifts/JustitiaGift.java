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

//正义裁决者饰品
public class JustitiaGift extends EGOGift {
    public static final String EGO_SKILL_GIFT_JUSTITIA = "ego.skill.gift.justitia";
    public static final JustitiaGift JUSTITIA_GIFT = new JustitiaGift();
    private boolean hasExecuted;

    public JustitiaGift() {
        super(0, 0, 0, 0, 6, 6,
                LOBECORP_EYE_MODIFIER_ID, LobeCorpAttributeModifierSlot.LOBECORP_EYE, List.of(EGO_SKILL_GIFT_JUSTITIA));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof ServerPlayerEntity serverPlayer &&
                LobeCorpUtil.getLobeCorpEquippedStack(serverPlayer, LobeCorpEquipmentSlot.LOBECORP_EYE_SLOT).getItem() instanceof JustitiaGift) {
            if (serverPlayer.currentScreenHandler instanceof BoxScreenHandler boxScreenHandler) {
                if (!hasExecuted && AbnormalityEntity.REPRESSION.equals(boxScreenHandler.abnormality.workMethod)) {
                    boxScreenHandler.abnormality.setExtraProbability(0.06F);
                    hasExecuted = true;
                }
            } else {
                hasExecuted = false;
            }
        }
    }
}
