package net.uniego.aida.lobecorp.item.ego.weapon;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipType;
import net.minecraft.client.util.InputUtil;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.access.EGOLevelAccess;
import net.uniego.aida.lobecorp.access.EquipRequireAccess;
import net.uniego.aida.lobecorp.gui.GUIResource;
import net.uniego.aida.lobecorp.init.TagInit;
import net.uniego.aida.lobecorp.item.ego.EGOItem;
import net.uniego.aida.lobecorp.manager.LevelManager;

import java.util.List;
import java.util.UUID;

//EGO武器
public class EGOWeapon extends EGOItem implements EGOLevelAccess, EquipRequireAccess {
    public static final UUID INTERACTION_RANGE_MODIFIER_ID = UUID.fromString("F17D5E0B-44D0-4E2B-B81B-9C471B547B29");

    public static final String TOOLTIP_EGO_WEAPON_LEVEL = "tooltip.ego.weapon_level";//武器等级
    public static final String TOOLTIP_EGO_WEAPON_TEMPLATE = "tooltip.ego.weapon_template";//武器模板
    public static final String TOOLTIP_EGO_DAMAGE_TYPE = "tooltip.ego.damage_type";//伤害类型
    public static final String TOOLTIP_EGO_WEAPON_RANGE = "tooltip.ego.weapon_range";//攻击距离
    public static final String TOOLTIP_EGO_WEAPON_RED = "tooltip.ego.weapon.red";//红伤
    public static final String TOOLTIP_EGO_WEAPON_WHITE = "tooltip.ego.weapon.white";//白伤
    public static final String TOOLTIP_EGO_WEAPON_BLACK = "tooltip.ego.weapon.black";//黑伤
    public static final String TOOLTIP_EGO_WEAPON_PALE = "tooltip.ego.weapon.pale";//蓝伤

    public static final EGOWeapon CODE_RIOT_STICK = new EGOWeapon(Rarity.RARE, LobeCorpUtil.EGOLevel.ZAYIN,
            EGOWeaponTemplate.MACE, 54498);//代码镇暴棍

    private final LobeCorpUtil.EGOLevel egoLevel;
    private final EGOWeaponTemplate egoWeaponTemplate;
    private final LevelManager.LobeCorpLevel requireF;
    private final LevelManager.LobeCorpLevel requireP;
    private final LevelManager.LobeCorpLevel requireT;
    private final LevelManager.LobeCorpLevel requireJ;

    public EGOWeapon(LobeCorpUtil.EGOLevel egoLevel, EGOWeaponTemplate egoWeaponTemplate, double attackDamage) {
        this(Rarity.COMMON, egoLevel, egoWeaponTemplate, attackDamage, "",
                LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I);
    }

    public EGOWeapon(LobeCorpUtil.EGOLevel egoLevel, EGOWeaponTemplate egoWeaponTemplate, double attackDamage,
                     LevelManager.LobeCorpLevel requireF, LevelManager.LobeCorpLevel requireP, LevelManager.LobeCorpLevel requireT, LevelManager.LobeCorpLevel requireJ) {
        this(Rarity.COMMON, egoLevel, egoWeaponTemplate, attackDamage, "", requireJ, requireT, requireP, requireF);
    }

    public EGOWeapon(Rarity rarity, LobeCorpUtil.EGOLevel egoLevel, EGOWeaponTemplate egoWeaponTemplate, double attackDamage) {
        this(rarity, egoLevel, egoWeaponTemplate, attackDamage, "",
                LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I);
    }

    public EGOWeapon(Rarity rarity, LobeCorpUtil.EGOLevel egoLevel, EGOWeaponTemplate egoWeaponTemplate, double attackDamage,
                     LevelManager.LobeCorpLevel requireF, LevelManager.LobeCorpLevel requireP, LevelManager.LobeCorpLevel requireT, LevelManager.LobeCorpLevel requireJ) {
        this(rarity, egoLevel, egoWeaponTemplate, attackDamage, "", requireJ, requireT, requireP, requireF);
    }

    public EGOWeapon(Rarity rarity, LobeCorpUtil.EGOLevel egoLevel, EGOWeaponTemplate egoWeaponTemplate, double attackDamage, String egoSkill,
                     LevelManager.LobeCorpLevel requireF, LevelManager.LobeCorpLevel requireP, LevelManager.LobeCorpLevel requireT, LevelManager.LobeCorpLevel requireJ) {
        super(new Settings().rarity(rarity).component(DataComponentTypes.ATTRIBUTE_MODIFIERS, LobeCorpUtil.createEGOWeaponAttributeModifiers
                (attackDamage, -egoWeaponTemplate.attackSpeed, egoWeaponTemplate.interactionRange - 3)), egoSkill);
        this.egoLevel = egoLevel;
        this.egoWeaponTemplate = egoWeaponTemplate;
        this.requireF = requireF;
        this.requireP = requireP;
        this.requireT = requireT;
        this.requireJ = requireJ;
    }

    public static void register() {
        Registry.register(Registries.ITEM, LobeCorpUtil.id("code_riot_stick"), CODE_RIOT_STICK);
    }

    @Override
    public LobeCorpUtil.EGOLevel getEGOLevel() {
        return egoLevel;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        //武器等级
        tooltip.add(Text.translatable(TOOLTIP_EGO_WEAPON_LEVEL).formatted(Formatting.GRAY).append(Text.literal(String.valueOf(egoLevel)).formatted(egoLevel.getColor())));
        //伤害类型
        if (stack.isIn(TagInit.RED_EGO_WEAPONS)) {
            tooltip.add(Text.translatable(TOOLTIP_EGO_DAMAGE_TYPE).formatted(Formatting.DARK_GRAY).append(Text.translatable(TOOLTIP_EGO_WEAPON_RED).formatted(Formatting.DARK_RED)));
        } else if (stack.isIn(TagInit.WHITE_EGO_WEAPONS)) {
            tooltip.add(Text.translatable(TOOLTIP_EGO_DAMAGE_TYPE).formatted(Formatting.DARK_GRAY).append(Text.translatable(TOOLTIP_EGO_WEAPON_WHITE).formatted(Formatting.WHITE)));
        } else if (stack.isIn(TagInit.BLACK_EGO_WEAPONS)) {
            tooltip.add(Text.translatable(TOOLTIP_EGO_DAMAGE_TYPE).formatted(Formatting.DARK_GRAY).append(Text.translatable(TOOLTIP_EGO_WEAPON_BLACK).formatted(Formatting.DARK_PURPLE)));
        } else if (stack.isIn(TagInit.PALE_EGO_WEAPONS)) {
            tooltip.add(Text.translatable(TOOLTIP_EGO_DAMAGE_TYPE).formatted(Formatting.DARK_GRAY).append(Text.translatable(TOOLTIP_EGO_WEAPON_PALE).formatted(Formatting.AQUA)));
        }
        //武器模板
        tooltip.add(Text.translatable(TOOLTIP_EGO_WEAPON_TEMPLATE).formatted(Formatting.DARK_GRAY).append(Text.translatable(egoWeaponTemplate.templateName).formatted(Formatting.GRAY)));
        //攻击距离
        tooltip.add(Text.translatable(TOOLTIP_EGO_WEAPON_RANGE).formatted(Formatting.DARK_GRAY).append(Text.literal(String.valueOf(egoWeaponTemplate.interactionRange)).formatted(Formatting.GRAY)));
        //详细信息
        if (!InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), InputUtil.GLFW_KEY_LEFT_SHIFT)) {
            tooltip.add(Text.translatable(EGOItem.TOOLTIP_PRESS_LEFT_SHIFT_SHOW_INFO).formatted(Formatting.GOLD));
        } else {
            //装备要求
            tooltip.add(Text.translatable(TOOLTIP_EGO_EQUIP_REQUIRE).formatted(Formatting.GRAY));
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

    //EGO武器模板
    public enum EGOWeaponTemplate {
        MACE(2, 3, "ego.template.weapon.mace");//棁类

        private final double attackSpeed;
        private final double interactionRange;
        private final String templateName;

        EGOWeaponTemplate(double attackSpeed, double interactionRange, String templateName) {
            this.attackSpeed = attackSpeed;
            this.interactionRange = interactionRange;
            this.templateName = templateName;
        }

        public String getTemplateName() {
            return templateName;
        }
    }
}
