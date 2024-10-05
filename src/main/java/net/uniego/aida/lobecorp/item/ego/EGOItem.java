package net.uniego.aida.lobecorp.item.ego;

import net.minecraft.client.item.TooltipType;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.uniego.aida.lobecorp.access.LobeCorpSlotAccess;
import net.uniego.aida.lobecorp.item.LobeCorpItem;
import net.uniego.aida.lobecorp.item.ego.gift.EGOGift;
import net.uniego.aida.lobecorp.item.ego.suit.EGOSuit;
import net.uniego.aida.lobecorp.item.ego.weapon.EGOWeapon;
import net.uniego.aida.lobecorp.slot.LobeCorpAttributeModifierSlot;

import java.util.List;

//EGO物品
public abstract class EGOItem extends LobeCorpItem implements LobeCorpSlotAccess {
    public static final String TOOLTIP_PRESS_LEFT_SHIFT_SHOW_INFO = "tooltip.press_left_shift_show_info";//按住左Shift显示信息
    public static final String TOOLTIP_EGO_EQUIP_REQUIRE = "tooltip.ego.equip_require";//装备要求

    private final LobeCorpAttributeModifierSlot lobecorpSlot;
    private final List<String> egoSkill;

    public EGOItem(Settings settings, LobeCorpAttributeModifierSlot lobecorpSlot, List<String> egoSkill) {
        super(settings.maxCount(1).fireproof());
        this.lobecorpSlot = lobecorpSlot;
        this.egoSkill = egoSkill;
    }

    public static void register() {
        EGOWeapon.register();
        EGOSuit.register();
        EGOGift.register();
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (egoSkill != null && !egoSkill.isEmpty()) {
            for (String string : egoSkill) {
                if (!string.isEmpty()) {
                    int maxLength = 24;
                    MutableText translatableText = Text.translatable(string);
                    String firstLine = translatableText.getString().substring(0, Math.min(maxLength, translatableText.getString().length()));
                    tooltip.add(Text.literal("●").append(Text.literal(firstLine)).formatted(Formatting.GOLD));
                    if (translatableText.getString().length() > maxLength) {
                        String remainingText = translatableText.getString().substring(maxLength);
                        for (int i = 0; i < remainingText.length(); i += maxLength) {
                            String line = remainingText.substring(i, Math.min(i + maxLength, remainingText.length()));
                            tooltip.add(Text.literal(" ").append(Text.literal(line)).formatted(Formatting.GOLD));
                        }
                    }
                }
            }
        }
    }

    @Override
    public LobeCorpAttributeModifierSlot getLobeCorpSlot() {
        return lobecorpSlot;
    }
}
