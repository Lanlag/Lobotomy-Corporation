package net.uniego.aida.lobecorp.item.ego;

import net.minecraft.client.item.TooltipType;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.uniego.aida.lobecorp.item.LobeCorpItem;
import net.uniego.aida.lobecorp.item.ego.gift.EGOGift;
import net.uniego.aida.lobecorp.item.ego.suit.EGOSuit;
import net.uniego.aida.lobecorp.item.ego.weapon.EGOWeapon;

import java.util.List;
import java.util.Objects;

//EGO物品
public class EGOItem extends LobeCorpItem {
    public static final String TOOLTIP_PRESS_LEFT_SHIFT_SHOW_INFO = "tooltip.press_left_shift_show_info";//按住左Shift显示信息
    public static final String TOOLTIP_EGO_EQUIP_REQUIRE = "tooltip.ego.equip_require";//装备要求

    private final String egoSkill;

    public EGOItem(Settings settings, String egoSkill) {
        super(settings.maxCount(1).fireproof());
        this.egoSkill = egoSkill;
    }

    public static void register() {
        EGOWeapon.register();
        EGOSuit.register();
        EGOGift.register();
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (!Objects.equals(egoSkill, "")) {
            int maxLength = 24;
            MutableText translatableText = Text.translatable(egoSkill);
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
