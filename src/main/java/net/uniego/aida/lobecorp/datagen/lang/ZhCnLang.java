package net.uniego.aida.lobecorp.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.gui.GUIResource;
import net.uniego.aida.lobecorp.init.*;
import net.uniego.aida.lobecorp.item.LobeCorpItem;
import net.uniego.aida.lobecorp.item.ego.EGOItem;
import net.uniego.aida.lobecorp.item.ego.suit.EGOSuit;
import net.uniego.aida.lobecorp.item.ego.weapon.EGOWeapon;
import net.uniego.aida.lobecorp.slot.LobeCorpEquipmentSlot;

import java.util.concurrent.CompletableFuture;

//中文翻译文件生成器
public class ZhCnLang extends FabricLanguageProvider {
    public ZhCnLang(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "zh_cn", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        //属性名
        translationBuilder.add(AttributeInit.PLAYER_MAX_SANITY_NAME, "最大精神值");
        translationBuilder.add(AttributeInit.PLAYER_MAX_ASSIMILATION_NAME, "最大认知同化值");
        translationBuilder.add(AttributeInit.PLAYER_WORK_SUCCESS_NAME, "工作胜率");
        translationBuilder.add(AttributeInit.PLAYER_WORK_VELOCITY_NAME, "工作速率");
        translationBuilder.add(AttributeInit.PLAYER_ATTACK_VELOCITY_NAME, "攻击速率");
        translationBuilder.add(AttributeInit.PLAYER_MOVE_VELOCITY_NAME, "移动速率");
        //死亡信息
        translationBuilder.add(DamageInit.DEATH_ATTACK_DRY, "%1$s渴死了");
        translationBuilder.add(DamageInit.DEATH_ATTACK_DRY_PLAYER, "%1$s在与%2$s战斗中因口渴而死");
        translationBuilder.add(DamageInit.DEATH_ATTACK_INSANE, "%1$s因为发狂死掉了");
        translationBuilder.add(DamageInit.DEATH_ATTACK_INSANE_PLAYER, "%1$s在陷入与%2$s战斗时，因为承受不住疯狂而死了");
        translationBuilder.add(DamageInit.DEATH_ATTACK_MYSTIC, "%1$s被神秘杀死了");
        translationBuilder.add(DamageInit.DEATH_ATTACK_MYSTIC_PLAYER, "%1$s在试图逃离%2$s时被神秘杀死了");
        translationBuilder.add(DamageInit.DEATH_ATTACK_INDIRECT_MYSTIC, "%1$s被%2$s使用神秘杀死");
        translationBuilder.add(DamageInit.DEATH_ATTACK_INDIRECT_MYSTIC_ITEM, "%1$s被%2$s使用%3$s杀死了");
        translationBuilder.add(DamageInit.DEATH_ATTACK_RED, "%2$s致使%1$s死于物理破碎");
        translationBuilder.add(DamageInit.DEATH_ATTACK_RED_PLAYER, "%2$s致使%1$s死于物理破碎");
        translationBuilder.add(DamageInit.DEATH_ATTACK_WHITE, "%2$s致使%1$s死于精神崩溃");
        translationBuilder.add(DamageInit.DEATH_ATTACK_WHITE_PLAYER, "%2$s致使%1$s死于精神崩溃");
        translationBuilder.add(DamageInit.DEATH_ATTACK_BLACK, "%2$s致使%1$s死于侵蚀贯穿");
        translationBuilder.add(DamageInit.DEATH_ATTACK_BLACK_PLAYER, "%2$s致使%1$s死于侵蚀贯穿");
        translationBuilder.add(DamageInit.DEATH_ATTACK_PALE, "%2$s致使%1$s死于灵魂削除");
        translationBuilder.add(DamageInit.DEATH_ATTACK_PALE_PLAYER, "%2$s致使%1$s死于灵魂削除");
        //效果名
        translationBuilder.add(EffectInit.ABSENT.value(), "恍惚");
        translationBuilder.add(EffectInit.ASSIMILATION.value(), "认知同化");
        translationBuilder.add(EffectInit.HYDRATION.value(), "滋润");
        translationBuilder.add(EffectInit.INSANE.value(), "狂乱");
        translationBuilder.add(EffectInit.RESTORATION.value(), "精神恢复");
        translationBuilder.add(EffectInit.SANITY_BOOST.value(), "精神提升");
        translationBuilder.add(EffectInit.THIRST.value(), "干渴");
        translationBuilder.add(EffectInit.INSTANT_SANITY.value(), "瞬间镇定");
        translationBuilder.add(EffectInit.INSTANT_INJURY.value(), "瞬间损伤");
        //物品名
        translationBuilder.add(LobeCorpItem.LOBECORP_LOGO, "脑叶公司Logo");
        translationBuilder.add(LobeCorpItem.BLUE_LEAF, "蓝叶");
        translationBuilder.add(EGOSuit.CODE_SUIT, "代码西装");
        translationBuilder.add(EGOWeapon.CODE_RIOT_STICK, "代码镇暴棍");
        translationBuilder.add(EGOSuit.STANDARD_SUIT, "标准西装");
        translationBuilder.add(EGOWeapon.RED_RIOT_STICK, "物理镇暴棍");
        translationBuilder.add(EGOWeapon.WHITE_RIOT_STICK, "精神镇暴棍");
        translationBuilder.add(EGOWeapon.BLACK_RIOT_STICK, "侵蚀镇暴棍");
        translationBuilder.add(EGOWeapon.PALE_RIOT_STICK, "灵魂镇暴棍");
        //物品栏名
        translationBuilder.add(ItemGroupInit.LOBECORP_TAB_NAME, "脑叶公司");
        //声音名
        translationBuilder.add(SoundInit.CHANGE_EQUIPMENT_ID, "变换装备");
        translationBuilder.add(SoundInit.SWALLOW_WATER_ID, "吞水");
        translationBuilder.add(SoundInit.SWITCH_WEAPON_ID, "切换武器");
        //屏幕名
        translationBuilder.add(ScreenInit.CONTAINER_EQUIPMENT, "装备");
        //按键类名
        translationBuilder.add(KeyInit.CATEGORIES_LOBECORP, "脑叶公司");
        translationBuilder.add(KeyInit.KEY_EQUIPMENT_INVENTORY, "开启/关闭装备");
        translationBuilder.add(KeyInit.KEY_SWITCH_WEAPON, "切换武器");
        //信息名
        translationBuilder.add(GUIResource.STAFF_LEVEL, "职员等级");
        translationBuilder.add(GUIResource.STAFF_FORTITUDE, "勇气");
        translationBuilder.add(GUIResource.STAFF_PRUDENCE, "谨慎");
        translationBuilder.add(GUIResource.STAFF_TEMPERANCE, "自律");
        translationBuilder.add(GUIResource.STAFF_JUSTICE, "正义");
        translationBuilder.add(GUIResource.STAFF_MAX_HEALTH, "最大生命：");
        translationBuilder.add(GUIResource.STAFF_MAX_SANITY, "最大精神：");
        translationBuilder.add(GUIResource.STAFF_WORK_SUCCESS, "工作胜率：");
        translationBuilder.add(GUIResource.STAFF_WORK_VELOCITY, "工作速率：");
        translationBuilder.add(GUIResource.STAFF_ATTACK_VELOCITY, "攻击速率：");
        translationBuilder.add(GUIResource.STAFF_MOVE_VELOCITY, "移动速率：");
        //标签名
        translationBuilder.add(TagInit.HYDRATING_FOODS, "含水食物");
        translationBuilder.add(TagInit.RED_EGO_WEAPONS, "红伤EGO武器");
        translationBuilder.add(TagInit.WHITE_EGO_WEAPONS, "白伤EGO武器");
        translationBuilder.add(TagInit.BLACK_EGO_WEAPONS, "黑伤EGO武器");
        translationBuilder.add(TagInit.PALE_EGO_WEAPONS, "蓝伤EGO武器");
        //插槽名
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_WEAPON_SLOT), "在武器位时：");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_SUIT_SLOT), "在护甲位时：");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_BADGE_SLOT), "在袖标位时：");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_TOOL_SLOT), "在工具位时：");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_HAT_SLOT), "在头饰位时：");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_HEAD_SLOT), "在头部位时：");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_OCCIPUT_SLOT), "在后脑位时：");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_EYE_SLOT), "在眼部位时：");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_FACE_SLOT), "在面部位时：");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_CHEEK_SLOT), "在脸颊位时：");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_MASK_SLOT), "在面罩位时：");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_MOUTH_SLOT), "在口部位时：");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_NECK_SLOT), "在颈部位时：");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_CHEST_SLOT), "在胸部位时：");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_HAND_SLOT), "在手部位时：");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_GLOVE_SLOT), "在手套位时：");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_RIGHTBACK_SLOT), "在右背位时：");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_LEFTBACK_SLOT), "在左背位时：");
        //EGO武器模板名
        translationBuilder.add(EGOWeapon.EGOWeaponTemplate.MACE.getTemplateName(), "棁类");
        //工具提示名
        translationBuilder.add(EGOItem.TOOLTIP_PRESS_LEFT_SHIFT_SHOW_INFO, "按住左Shift显示信息");
        translationBuilder.add(EGOItem.TOOLTIP_EGO_EQUIP_REQUIRE, "装备要求：");
        //武器
        translationBuilder.add(EGOWeapon.TOOLTIP_EGO_WEAPON_LEVEL, "武器等级：");
        translationBuilder.add(EGOWeapon.TOOLTIP_EGO_WEAPON_TEMPLATE, "武器模板：");
        translationBuilder.add(EGOWeapon.TOOLTIP_EGO_DAMAGE_TYPE, "伤害类型：");
        translationBuilder.add(EGOWeapon.TOOLTIP_EGO_WEAPON_RANGE, "攻击距离：");
        translationBuilder.add(EGOWeapon.TOOLTIP_EGO_WEAPON_RED, "物理");
        translationBuilder.add(EGOWeapon.TOOLTIP_EGO_WEAPON_WHITE, "精神");
        translationBuilder.add(EGOWeapon.TOOLTIP_EGO_WEAPON_BLACK, "侵蚀");
        translationBuilder.add(EGOWeapon.TOOLTIP_EGO_WEAPON_PALE, "灵魂");
        //护甲
        translationBuilder.add(EGOSuit.TOOLTIP_EGO_SUIT_LEVEL, "护甲等级：");
        translationBuilder.add(EGOSuit.TOOLTIP_EGO_SUIT_RED, "物理抗性：");
        translationBuilder.add(EGOSuit.TOOLTIP_EGO_SUIT_WHITE, "精神抗性：");
        translationBuilder.add(EGOSuit.TOOLTIP_EGO_SUIT_BLACK, "侵蚀抗性：");
        translationBuilder.add(EGOSuit.TOOLTIP_EGO_SUIT_PALE, "灵魂抗性：");
    }
}
