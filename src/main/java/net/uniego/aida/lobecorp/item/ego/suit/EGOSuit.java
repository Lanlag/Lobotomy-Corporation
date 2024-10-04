package net.uniego.aida.lobecorp.item.ego.suit;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipType;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.access.ColorResistAccess;
import net.uniego.aida.lobecorp.access.EGOLevelAccess;
import net.uniego.aida.lobecorp.access.EquipRequireAccess;
import net.uniego.aida.lobecorp.gui.GUIResource;
import net.uniego.aida.lobecorp.init.ComponentInit;
import net.uniego.aida.lobecorp.item.ego.EGOItem;
import net.uniego.aida.lobecorp.manager.LevelManager;
import net.uniego.aida.lobecorp.slot.LobeCorpAttributeModifierSlot;

import java.util.List;

//EGO护甲
public class EGOSuit extends EGOItem implements EGOLevelAccess, EquipRequireAccess, ColorResistAccess {
    public static final String TOOLTIP_EGO_SUIT_LEVEL = "tooltip.ego.suit_level";//护甲等级
    public static final String TOOLTIP_EGO_SUIT_RED = "tooltip.ego.suit.red";//红抗
    public static final String TOOLTIP_EGO_SUIT_WHITE = "tooltip.ego.suit.white";//白抗
    public static final String TOOLTIP_EGO_SUIT_BLACK = "tooltip.ego.suit.black";//黑抗
    public static final String TOOLTIP_EGO_SUIT_PALE = "tooltip.ego.suit.pale";//蓝抗

    public static final EGOSuit CODE_SUIT = new EGOSuit(Rarity.RARE, LobeCorpUtil.EGOLevel.ZAYIN,
            0.0F, 0.0F, 0.0F, 0.0F);//代码西装
    public static final EGOSuit STANDARD_SUIT = new EGOSuit(Rarity.UNCOMMON, LobeCorpUtil.EGOLevel.ZAYIN,
            1.0F, 1.0F, 1.5F, 2.0F);//标准西装
    public static final EGOSuit STANDARD_TRAINING_EGO_SUIT = new EGOSuit(LobeCorpUtil.EGOLevel.TETH,
            0.5F, 1.0F, 1.5F, 2.0F);//教学用E.G.O
    public static final EGOSuit FLESH_BOUND_SUIT = new EGOSuit(LobeCorpUtil.EGOLevel.TETH,
            0.6F, 1.0F, 1.3F, 1.5F,
            LevelManager.LobeCorpLevel.III, LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I,
            LevelManager.LobeCorpLevel.II);//血肉契约

    private final LobeCorpUtil.EGOLevel egoLevel;
    private final float redResist;
    private final float whiteResist;
    private final float blackResist;
    private final float paleResist;
    private final LevelManager.LobeCorpLevel requireF;
    private final LevelManager.LobeCorpLevel requireP;
    private final LevelManager.LobeCorpLevel requireT;
    private final LevelManager.LobeCorpLevel requireJ;
    private final LevelManager.LobeCorpLevel requireTotal;

    public EGOSuit(LobeCorpUtil.EGOLevel egoLevel, float redResist, float whiteResist, float blackResist, float paleResist) {
        this(Rarity.COMMON, egoLevel, redResist, whiteResist, blackResist, paleResist, "",
                LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I);
    }

    public EGOSuit(LobeCorpUtil.EGOLevel egoLevel, float redResist, float whiteResist, float blackResist, float paleResist,
                   LevelManager.LobeCorpLevel requireF, LevelManager.LobeCorpLevel requireP, LevelManager.LobeCorpLevel requireT, LevelManager.LobeCorpLevel requireJ, LevelManager.LobeCorpLevel requireTotal) {
        this(Rarity.COMMON, egoLevel, redResist, whiteResist, blackResist, paleResist, "", requireF, requireP, requireT, requireJ, requireTotal);
    }

    public EGOSuit(Rarity rarity, LobeCorpUtil.EGOLevel egoLevel, float redResist, float whiteResist, float blackResist, float paleResist) {
        this(rarity, egoLevel, redResist, whiteResist, blackResist, paleResist, "",
                LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I);
    }

    public EGOSuit(Rarity rarity, LobeCorpUtil.EGOLevel egoLevel, float redResist, float whiteResist, float blackResist, float paleResist,
                   LevelManager.LobeCorpLevel requireF, LevelManager.LobeCorpLevel requireP, LevelManager.LobeCorpLevel requireT, LevelManager.LobeCorpLevel requireJ, LevelManager.LobeCorpLevel requireTotal) {
        this(rarity, egoLevel, redResist, whiteResist, blackResist, paleResist, "", requireF, requireP, requireT, requireJ, requireTotal);
    }

    public EGOSuit(Rarity rarity, LobeCorpUtil.EGOLevel egoLevel, float redResist, float whiteResist, float blackResist, float paleResist, String egoSkill,
                   LevelManager.LobeCorpLevel requireF, LevelManager.LobeCorpLevel requireP, LevelManager.LobeCorpLevel requireT, LevelManager.LobeCorpLevel requireJ, LevelManager.LobeCorpLevel requireTotal) {
        super(new Settings().rarity(rarity).component(ComponentInit.LOBECORP_ATTRIBUTE_MODIFIERS, LobeCorpUtil.createEGOSuitAttributeModifiers
                (egoLevel, LobeCorpAttributeModifierSlot.LOBECORP_SUIT)), LobeCorpAttributeModifierSlot.LOBECORP_SUIT, egoSkill);
        this.egoLevel = egoLevel;
        this.redResist = redResist;
        this.whiteResist = whiteResist;
        this.blackResist = blackResist;
        this.paleResist = paleResist;
        this.requireF = requireF;
        this.requireP = requireP;
        this.requireT = requireT;
        this.requireJ = requireJ;
        this.requireTotal = requireTotal;
    }

    public static void register() {
        Registry.register(Registries.ITEM, LobeCorpUtil.id("code_suit"), CODE_SUIT);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("standard_suit"), STANDARD_SUIT);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("standard_training_ego_suit"), STANDARD_TRAINING_EGO_SUIT);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("flesh_bound_suit"), FLESH_BOUND_SUIT);
    }

    @Override
    public float getRedResist() {
        return redResist;
    }

    @Override
    public float getWhiteResist() {
        return whiteResist;
    }

    @Override
    public float getBlackResist() {
        return blackResist;
    }

    @Override
    public float getPaleResist() {
        return paleResist;
    }

    @Override
    public LobeCorpUtil.EGOLevel getEGOLevel() {
        return egoLevel;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        //护甲等级
        tooltip.add(Text.translatable(TOOLTIP_EGO_SUIT_LEVEL).formatted(Formatting.GRAY).append(Text.literal(String.valueOf(egoLevel)).formatted(egoLevel.getColor())));
        //物理抗性
        tooltip.add(Text.translatable(TOOLTIP_EGO_SUIT_RED).formatted(Formatting.DARK_GRAY).append(Text.literal(String.valueOf(redResist)).formatted(Formatting.DARK_RED)));
        //精神抗性
        tooltip.add(Text.translatable(TOOLTIP_EGO_SUIT_WHITE).formatted(Formatting.DARK_GRAY).append(Text.literal(String.valueOf(whiteResist)).formatted(Formatting.WHITE)));
        //侵蚀抗性
        tooltip.add(Text.translatable(TOOLTIP_EGO_SUIT_BLACK).formatted(Formatting.DARK_GRAY).append(Text.literal(String.valueOf(blackResist)).formatted(Formatting.DARK_PURPLE)));
        //灵魂抗性
        tooltip.add(Text.translatable(TOOLTIP_EGO_SUIT_PALE).formatted(Formatting.DARK_GRAY).append(Text.literal(String.valueOf(paleResist)).formatted(Formatting.AQUA)));
        //详细信息
        if (!InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), InputUtil.GLFW_KEY_LEFT_SHIFT)) {
            tooltip.add(Text.translatable(TOOLTIP_PRESS_LEFT_SHIFT_SHOW_INFO).formatted(Formatting.GOLD));
        } else {
            //装备要求
            tooltip.add(Text.translatable(TOOLTIP_EGO_EQUIP_REQUIRE).formatted(Formatting.GRAY));
            //总等级
            tooltip.add(Text.translatable(GUIResource.STAFF_LEVEL).append(Text.literal(getTotalRequire().getLevel())).formatted(Formatting.GOLD));
            //勇气等级和谨慎等级
            tooltip.add(Text.translatable(GUIResource.STAFF_FORTITUDE).append(Text.literal(getFortitudeRequire().getLevel())).formatted(Formatting.DARK_RED).append("   ")
                    .append(Text.translatable(GUIResource.STAFF_PRUDENCE).append(Text.literal(getPrudenceRequire().getLevel())).formatted(Formatting.WHITE)));
            //自律等级和正义等级
            tooltip.add(Text.translatable(GUIResource.STAFF_TEMPERANCE).append(Text.literal(getTemperanceRequire().getLevel())).formatted(Formatting.DARK_PURPLE).append("   ")
                    .append(Text.translatable(GUIResource.STAFF_JUSTICE).append(Text.literal(getJusticeRequire().getLevel())).formatted(Formatting.AQUA)));
            super.appendTooltip(stack, context, tooltip, type);
        }
    }

    @Override
    public LevelManager.LobeCorpLevel getFortitudeRequire() {
        return requireF;
    }

    @Override
    public LevelManager.LobeCorpLevel getPrudenceRequire() {
        return requireP;
    }

    @Override
    public LevelManager.LobeCorpLevel getTemperanceRequire() {
        return requireT;
    }

    @Override
    public LevelManager.LobeCorpLevel getJusticeRequire() {
        return requireJ;
    }

    @Override
    public LevelManager.LobeCorpLevel getTotalRequire() {
        return requireTotal;
    }
}
