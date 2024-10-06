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
import net.uniego.aida.lobecorp.item.ego.weapon.weapons.JustitiaWeapon;
import net.uniego.aida.lobecorp.item.ego.weapon.weapons.PenitenceWeapon;
import net.uniego.aida.lobecorp.manager.LevelManager;
import net.uniego.aida.lobecorp.slot.LobeCorpAttributeModifierSlot;

import java.util.List;
import java.util.UUID;

//EGO武器
public class EGOWeapon extends EGOItem implements EGOLevelAccess, EquipRequireAccess {
    public static final UUID INTERACTION_RANGE_MODIFIER_ID = UUID.fromString("F17D5E0B-44D0-4E2B-B81B-9C471B547B29");

    public static final String EGO_SKILL_WEAPON_FIST = "ego.skill.weapon.fist";

    public static final String TOOLTIP_EGO_WEAPON_LEVEL = "tooltip.ego.weapon_level";//武器等级
    public static final String TOOLTIP_EGO_WEAPON_TEMPLATE = "tooltip.ego.weapon_template";//武器模板
    public static final String TOOLTIP_EGO_DAMAGE_TYPE = "tooltip.ego.damage_type";//伤害类型
    public static final String TOOLTIP_EGO_WEAPON_RANGE = "tooltip.ego.weapon_range";//攻击距离
    public static final String TOOLTIP_EGO_WEAPON_RED = "tooltip.ego.weapon.red";//红伤
    public static final String TOOLTIP_EGO_WEAPON_WHITE = "tooltip.ego.weapon.white";//白伤
    public static final String TOOLTIP_EGO_WEAPON_BLACK = "tooltip.ego.weapon.black";//黑伤
    public static final String TOOLTIP_EGO_WEAPON_PALE = "tooltip.ego.weapon.pale";//蓝伤
    public static final String EGO_TEMPLATE_WEAPON_SPECIAL = "ego.template.weapon.special";//特殊

    public static final EGOWeapon CODE_RIOT_STICK = new EGOWeapon(Rarity.RARE, LobeCorpUtil.EGOLevel.ZAYIN, EGOWeaponTemplate.MACE, 54498);//代码镇暴棍
    public static final EGOWeapon RED_RIOT_STICK = new EGOWeapon(Rarity.UNCOMMON, LobeCorpUtil.EGOLevel.ZAYIN, EGOWeaponTemplate.MACE, 4);//物理镇暴棍
    public static final EGOWeapon WHITE_RIOT_STICK = new EGOWeapon(Rarity.UNCOMMON, LobeCorpUtil.EGOLevel.ZAYIN, EGOWeaponTemplate.MACE, 4);//精神镇暴棍
    public static final EGOWeapon BLACK_RIOT_STICK = new EGOWeapon(Rarity.UNCOMMON, LobeCorpUtil.EGOLevel.ZAYIN, EGOWeaponTemplate.MACE, 4);//侵蚀镇暴棍
    public static final EGOWeapon PALE_RIOT_STICK = new EGOWeapon(Rarity.UNCOMMON, LobeCorpUtil.EGOLevel.ZAYIN, EGOWeaponTemplate.MACE, 4);//灵魂镇暴棍
    public static final EGOWeapon STANDARD_TRAINING_EGO_WEAPON = new EGOWeapon(LobeCorpUtil.EGOLevel.TETH, EGOWeaponTemplate.MACE, 5);//教学用E.G.O
    public static final EGOWeapon HORN_WEAPON = new EGOWeapon(LobeCorpUtil.EGOLevel.TETH, EGOWeaponTemplate.SPEAR, 6);//犄角
    public static final EGOWeapon BEAR_PAWS_WEAPON = new EGOWeapon(LobeCorpUtil.EGOLevel.HE, EGOWeaponTemplate.FIST, 6, List.of(EGO_SKILL_WEAPON_FIST),
            LevelManager.LobeCorpLevel.II, LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I,
            LevelManager.LobeCorpLevel.I);//熊熊抱

    private final LobeCorpUtil.EGOLevel egoLevel;
    private final EGOWeaponTemplate egoWeaponTemplate;
    private final float attackDamage;
    private final LevelManager.LobeCorpLevel requireF;
    private final LevelManager.LobeCorpLevel requireP;
    private final LevelManager.LobeCorpLevel requireT;
    private final LevelManager.LobeCorpLevel requireJ;
    private final LevelManager.LobeCorpLevel requireTotal;

    public EGOWeapon(LobeCorpUtil.EGOLevel egoLevel, EGOWeaponTemplate egoWeaponTemplate, double attackDamage) {
        this(Rarity.COMMON, egoLevel, egoWeaponTemplate, attackDamage, null,
                LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I);
    }

    public EGOWeapon(LobeCorpUtil.EGOLevel egoLevel, EGOWeaponTemplate egoWeaponTemplate, double attackDamage,
                     LevelManager.LobeCorpLevel requireF, LevelManager.LobeCorpLevel requireP, LevelManager.LobeCorpLevel requireT, LevelManager.LobeCorpLevel requireJ, LevelManager.LobeCorpLevel requireTotal) {
        this(Rarity.COMMON, egoLevel, egoWeaponTemplate, attackDamage, null, requireF, requireP, requireT, requireJ, requireTotal);
    }

    public EGOWeapon(LobeCorpUtil.EGOLevel egoLevel, EGOWeaponTemplate egoWeaponTemplate, double attackDamage, List<String> egoSkill,
                     LevelManager.LobeCorpLevel requireF, LevelManager.LobeCorpLevel requireP, LevelManager.LobeCorpLevel requireT, LevelManager.LobeCorpLevel requireJ, LevelManager.LobeCorpLevel requireTotal) {
        this(Rarity.COMMON, egoLevel, egoWeaponTemplate, attackDamage, egoSkill, requireF, requireP, requireT, requireJ, requireTotal);
    }

    public EGOWeapon(LobeCorpUtil.EGOLevel egoLevel, EGOWeaponTemplate egoWeaponTemplate, double attackDamage, List<String> egoSkill) {
        this(Rarity.COMMON, egoLevel, egoWeaponTemplate, attackDamage, egoSkill,
                LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I);
    }

    public EGOWeapon(Rarity rarity, LobeCorpUtil.EGOLevel egoLevel, EGOWeaponTemplate egoWeaponTemplate, double attackDamage) {
        this(rarity, egoLevel, egoWeaponTemplate, attackDamage, null,
                LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I, LevelManager.LobeCorpLevel.I);
    }

    public EGOWeapon(Rarity rarity, LobeCorpUtil.EGOLevel egoLevel, EGOWeaponTemplate egoWeaponTemplate, double attackDamage,
                     LevelManager.LobeCorpLevel requireF, LevelManager.LobeCorpLevel requireP, LevelManager.LobeCorpLevel requireT, LevelManager.LobeCorpLevel requireJ, LevelManager.LobeCorpLevel requireTotal) {
        this(rarity, egoLevel, egoWeaponTemplate, attackDamage, null, requireF, requireP, requireT, requireJ, requireTotal);
    }

    public EGOWeapon(Rarity rarity, LobeCorpUtil.EGOLevel egoLevel, EGOWeaponTemplate egoWeaponTemplate, double attackDamage, List<String> egoSkill,
                     LevelManager.LobeCorpLevel requireF, LevelManager.LobeCorpLevel requireP, LevelManager.LobeCorpLevel requireT, LevelManager.LobeCorpLevel requireJ, LevelManager.LobeCorpLevel requireTotal) {
        super(new Settings().rarity(rarity).component(DataComponentTypes.ATTRIBUTE_MODIFIERS, LobeCorpUtil.createEGOWeaponAttributeModifiers
                (attackDamage, -egoWeaponTemplate.attackSpeed, egoWeaponTemplate.interactionRange - 3)), LobeCorpAttributeModifierSlot.LOBECORP_WEAPON, egoSkill);
        this.egoLevel = egoLevel;
        this.egoWeaponTemplate = egoWeaponTemplate;
        this.attackDamage = (float) attackDamage;
        this.requireF = requireF;
        this.requireP = requireP;
        this.requireT = requireT;
        this.requireJ = requireJ;
        this.requireTotal = requireTotal;
    }

    public static void register() {
        Registry.register(Registries.ITEM, LobeCorpUtil.id("code_riot_stick"), CODE_RIOT_STICK);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("red_riot_stick"), RED_RIOT_STICK);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("white_riot_stick"), WHITE_RIOT_STICK);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("black_riot_stick"), BLACK_RIOT_STICK);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("pale_riot_stick"), PALE_RIOT_STICK);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("standard_training_ego_weapon"), STANDARD_TRAINING_EGO_WEAPON);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("penitence_weapon"), PenitenceWeapon.PENITENCE_WEAPON);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("horn_weapon"), HORN_WEAPON);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("bear_paws_weapon"), BEAR_PAWS_WEAPON);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("justitia_weapon"), JustitiaWeapon.JUSTITIA_WEAPON);
    }

    public float getAttackDamage() {
        return attackDamage;
    }

    public EGOWeaponTemplate getEgoWeaponTemplate() {
        return egoWeaponTemplate;
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

    //EGO武器模板
    public enum EGOWeaponTemplate {
        MACE(2, 3, "ego.template.weapon.mace"),//棁
        SPEAR(1.5, 4, "ego.template.weapon.spear"),//矛
        FIST(2, 2, "ego.template.weapon.fist"),//拳套
        JUSTITA(2, 4, EGO_TEMPLATE_WEAPON_SPECIAL);

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
