package net.uniego.aida.lobecorp.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.gui.GUIResource;
import net.uniego.aida.lobecorp.init.*;
import net.uniego.aida.lobecorp.item.AbnormalitySpawnEgg;
import net.uniego.aida.lobecorp.item.LobeCorpItem;
import net.uniego.aida.lobecorp.item.badge.TeamBadge;
import net.uniego.aida.lobecorp.item.badge.badges.*;
import net.uniego.aida.lobecorp.item.ego.EGOItem;
import net.uniego.aida.lobecorp.item.ego.gift.EGOGift;
import net.uniego.aida.lobecorp.item.ego.gift.gifts.PenitenceGift;
import net.uniego.aida.lobecorp.item.ego.suit.EGOSuit;
import net.uniego.aida.lobecorp.item.ego.suit.suits.PenitenceSuit;
import net.uniego.aida.lobecorp.item.ego.weapon.EGOWeapon;
import net.uniego.aida.lobecorp.item.ego.weapon.weapons.PenitenceWeapon;
import net.uniego.aida.lobecorp.slot.LobeCorpEquipmentSlot;

import java.util.concurrent.CompletableFuture;

//英文翻译文件生成器
public class EnUsLang extends FabricLanguageProvider {
    public EnUsLang(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        //属性名
        translationBuilder.add(AttributeInit.PLAYER_MAX_SANITY_NAME, "Max Sanity");
        translationBuilder.add(AttributeInit.PLAYER_MAX_ASSIMILATION_NAME, "Max Assimilation");
        translationBuilder.add(AttributeInit.PLAYER_WORK_SUCCESS_NAME, "Work Success");
        translationBuilder.add(AttributeInit.PLAYER_WORK_VELOCITY_NAME, "Work Velocity");
        translationBuilder.add(AttributeInit.PLAYER_ATTACK_VELOCITY_NAME, "Attack Velocity");
        translationBuilder.add(AttributeInit.PLAYER_MOVE_VELOCITY_NAME, "Move Velocity");
        //死亡信息
        translationBuilder.add(DamageInit.DEATH_ATTACK_DRY, "%1$s dried to death");
        translationBuilder.add(DamageInit.DEATH_ATTACK_DRY_PLAYER, "%1$s dried to death whilst fighting %2$s");
        translationBuilder.add(DamageInit.DEATH_ATTACK_INSANE, "%1$s died due to insanity");
        translationBuilder.add(DamageInit.DEATH_ATTACK_INSANE_PLAYER, "%1$s experienced insanity to death whilst fighting %2$s");
        translationBuilder.add(DamageInit.DEATH_ATTACK_MYSTIC, "%1$s was killed by mystic");
        translationBuilder.add(DamageInit.DEATH_ATTACK_MYSTIC_PLAYER, "%1$s was killed by mystic whilst trying to escape %2$s");
        translationBuilder.add(DamageInit.DEATH_ATTACK_INDIRECT_MYSTIC, "%1$s was killed by %2$s using mystic");
        translationBuilder.add(DamageInit.DEATH_ATTACK_INDIRECT_MYSTIC_ITEM, "%1$s was killed by %2$s using %3$s");
        translationBuilder.add(DamageInit.DEATH_ATTACK_RED, "%2$s caused %1$s died from Physical Shattering");
        translationBuilder.add(DamageInit.DEATH_ATTACK_RED_PLAYER, "%2$s caused %1$s died from Physical Shattering");
        translationBuilder.add(DamageInit.DEATH_ATTACK_WHITE, "%2$s caused %1$s died from Mental Collapse");
        translationBuilder.add(DamageInit.DEATH_ATTACK_WHITE_PLAYER, "%2$s caused %1$s died from Mental Collapse");
        translationBuilder.add(DamageInit.DEATH_ATTACK_BLACK, "%2$s caused %1$s died from Erosion Penetration");
        translationBuilder.add(DamageInit.DEATH_ATTACK_BLACK_PLAYER, "%2$s caused %1$s died from Erosion Penetration");
        translationBuilder.add(DamageInit.DEATH_ATTACK_PALE, "%2$s caused %1$s died from Soul Erasure");
        translationBuilder.add(DamageInit.DEATH_ATTACK_PALE_PLAYER, "%2$s caused %1$s died from Soul Erasure");
        //效果名
        translationBuilder.add(EffectInit.ABSENT.value(), "Absent");
        translationBuilder.add(EffectInit.ASSIMILATION.value(), "Assimilation");
        translationBuilder.add(EffectInit.HYDRATION.value(), "Hydration");
        translationBuilder.add(EffectInit.INSANE.value(), "Insane");
        translationBuilder.add(EffectInit.RESTORATION.value(), "Restoration");
        translationBuilder.add(EffectInit.SANITY_BOOST.value(), "Sanity Boost");
        translationBuilder.add(EffectInit.THIRST.value(), "Thirst");
        translationBuilder.add(EffectInit.INSTANT_SANITY.value(), "Instant Sanity");
        translationBuilder.add(EffectInit.INSTANT_INJURY.value(), "Instant Injury");
        //物品名
        //脑叶公司
        translationBuilder.add(LobeCorpItem.LOBECORP_LOGO, "LobeCorp Logo");
        translationBuilder.add(LobeCorpItem.BLUE_LEAF, "Blue Leaf");
        translationBuilder.add(EGOSuit.CODE_SUIT, "Code Suit");
        translationBuilder.add(EGOWeapon.CODE_RIOT_STICK, "Code Riot Stick");
        translationBuilder.add(EGOSuit.STANDARD_SUIT, "Standard Suit");
        translationBuilder.add(EGOWeapon.RED_RIOT_STICK, "Red Riot Stick");
        translationBuilder.add(EGOWeapon.WHITE_RIOT_STICK, "White Riot Stick");
        translationBuilder.add(EGOWeapon.BLACK_RIOT_STICK, "Black Riot Stick");
        translationBuilder.add(EGOWeapon.PALE_RIOT_STICK, "Pale Riot Stick");
        translationBuilder.add(ControlBadge.CONTROL_BADGE, "Control Badge");
        translationBuilder.add(InformationBadge.INFORMATION_BADGE, "Information Badge");
        translationBuilder.add(SecurityBadge.SECURITY_BADGE, "Security Badge");
        translationBuilder.add(TrainingBadge.TRAINING_BADGE, "Training Badge");
        translationBuilder.add(CentralCommandBadge.CENTRAL_COMMAND_BADGE, "Central Command Badge");
        translationBuilder.add(WelfareBadge.WELFARE_BADGE, "Welfare Badge");
        translationBuilder.add(DisciplinaryBadge.DISCIPLINARY_BADGE, "Disciplinary Badge");
        translationBuilder.add(RecordBadge.RECORD_BADGE, "Record Badge");
        translationBuilder.add(ExtractionBadge.EXTRACTION_BADGE, "Extraction Badge");
        translationBuilder.add(ArchitectureBadge.ARCHITECTURE_BADGE, "Architecture Badge");
        //EGO武器
        translationBuilder.add(EGOWeapon.STANDARD_TRAINING_EGO_WEAPON, "Standard Training E.G.O");
        translationBuilder.add(PenitenceWeapon.PENITENCE_WEAPON, "Penitence");
        //EGO护甲
        translationBuilder.add(EGOSuit.STANDARD_TRAINING_EGO_SUIT, "Standard Training E.G.O");
        translationBuilder.add(PenitenceSuit.PENITENCE_SUIT, "Penitence");
        translationBuilder.add(EGOSuit.FLESH_BOUND_SUIT, "Flesh Bound");
        //EGO饰品
        translationBuilder.add(EGOGift.STANDARD_TRAINING_EGO_GIFT, "Standard Training E.G.O");
        translationBuilder.add(PenitenceGift.PENITENCE_GIFT, "Penitence");
        translationBuilder.add(EGOGift.BLESS_GIFT, "Bless");
        //异想体生成蛋名
        translationBuilder.add(AbnormalitySpawnEgg.STANDARD_TRAINING_DUMMY_RABBIT_EGG, "Standard Training-Dummy Rabbit");
        translationBuilder.add(AbnormalitySpawnEgg.ONE_SIN_AND_HUNDREDS_OF_GOOD_DEEDS_EGG, "One Sin and Hundreds of Good Deeds");
        //技能描述名
        translationBuilder.add(PenitenceWeapon.EGO_SKILL_WEAPON_PENITENCE, "5% of healing 10 SP upon attacking with JusticeIcon Lvl 2+");
        translationBuilder.add(PenitenceSuit.EGO_SKILL_SUIT_PENITENCE, "5% of heal 10 SP when damaged by Red or Black");
        translationBuilder.add(PenitenceGift.EGO_SKILL_GIFT_PENITENCE, "Success Rate increases %10 with the corresponding Abnormality");
        //物品栏名
        translationBuilder.add(ItemGroupInit.LOBE_CORP_TAB_NAME, "Lobe Corp");
        translationBuilder.add(ItemGroupInit.EGO_WEAPON_TAB_NAME, "E.G.O Weapon");
        translationBuilder.add(ItemGroupInit.EGO_SUIT_TAB_NAME, "E.G.O Suit");
        translationBuilder.add(ItemGroupInit.EGO_GIFT_TAB_NAME, "E.G.O Gift");
        translationBuilder.add(ItemGroupInit.ABNORMALITY_TAB_NAME, "Abnormality");
        //声音名
        translationBuilder.add(SoundInit.CHANGE_EQUIPMENT_ID, "Change Equipment");
        translationBuilder.add(SoundInit.SWALLOW_WATER_ID, "Swallow Water");
        translationBuilder.add(SoundInit.SWITCH_WEAPON_ID, "Switch Weapon");
        //屏幕名
        translationBuilder.add(ScreenInit.CONTAINER_EQUIPMENT, "Equipment");
        translationBuilder.add(ScreenInit.CONTAINER_WORK, "Work");
        translationBuilder.add(ScreenInit.CONTAINER_BOX, "Box");
        //按键类名
        translationBuilder.add(KeyInit.CATEGORIES_LOBECORP, "Lobe Corp");
        translationBuilder.add(KeyInit.KEY_EQUIPMENT_INVENTORY, "Open/Close Equipment");
        translationBuilder.add(KeyInit.KEY_SWITCH_WEAPON, "Switch Weapon");
        //信息名
        translationBuilder.add(GUIResource.STAFF_LEVEL, "Staff Level");
        translationBuilder.add(GUIResource.STAFF_FORTITUDE, "Fortitude");
        translationBuilder.add(GUIResource.STAFF_PRUDENCE, "Prudence");
        translationBuilder.add(GUIResource.STAFF_TEMPERANCE, "Temperance");
        translationBuilder.add(GUIResource.STAFF_JUSTICE, "Justice");
        translationBuilder.add(GUIResource.STAFF_MAX_HEALTH, "Max Health:");
        translationBuilder.add(GUIResource.STAFF_MAX_SANITY, "Max Sanity:");
        translationBuilder.add(GUIResource.STAFF_WORK_SUCCESS, "Work Success:");
        translationBuilder.add(GUIResource.STAFF_WORK_VELOCITY, "Work Velocity:");
        translationBuilder.add(GUIResource.STAFF_ATTACK_VELOCITY, "Attack Velocity:");
        translationBuilder.add(GUIResource.STAFF_MOVE_VELOCITY, "Move Velocity:");
        //标签名
        translationBuilder.add(TagInit.HYDRATING_FOODS, "Hydrating Foods");
        translationBuilder.add(TagInit.RED_EGO_WEAPONS, "Red EGO Weapons");
        translationBuilder.add(TagInit.WHITE_EGO_WEAPONS, "White EGO Weapons");
        translationBuilder.add(TagInit.BLACK_EGO_WEAPONS, "Black EGO Weapons");
        translationBuilder.add(TagInit.PALE_EGO_WEAPONS, "Pale EGO Weapons");
        //插槽名
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_WEAPON_SLOT), "When in Weapon Slot:");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_SUIT_SLOT), "When in Suit Slot:");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_BADGE_SLOT), "When in Badge Slot:");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_TOOL_SLOT), "When in Tool Slot:");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_HAT_SLOT), "When in Hat Slot:");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_HEAD_SLOT), "When in Head Slot:");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_OCCIPUT_SLOT), "When in Occiput Slot:");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_EYE_SLOT), "When in Eye Slot:");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_FACE_SLOT), "When in Face Slot:");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_CHEEK_SLOT), "When in Cheek Slot:");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_MASK_SLOT), "When in Mask Slot:");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_MOUTH_SLOT), "When in Mouth Slot:");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_NECK_SLOT), "When in Neck Slot:");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_CHEST_SLOT), "When in Chest Slot:");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_HAND_SLOT), "When in Hand Slot:");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_GLOVE_SLOT), "When in Glove Slot:");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_RIGHTBACK_SLOT), "When in RightBack Slot:");
        translationBuilder.add(LobeCorpUtil.getItemModifiersName(LobeCorpEquipmentSlot.LOBECORP_LEFTBACK_SLOT), "When in LeftBack Slot:");
        //EGO武器模板名
        translationBuilder.add(EGOWeapon.EGOWeaponTemplate.MACE.getTemplateName(), "Mace");
        //工具提示名
        translationBuilder.add(EGOItem.TOOLTIP_PRESS_LEFT_SHIFT_SHOW_INFO, "Press Left Shift Show Info");
        translationBuilder.add(EGOItem.TOOLTIP_EGO_EQUIP_REQUIRE, "Equip Require:");
        //武器
        translationBuilder.add(EGOWeapon.TOOLTIP_EGO_WEAPON_LEVEL, "Weapon Level:");
        translationBuilder.add(EGOWeapon.TOOLTIP_EGO_WEAPON_TEMPLATE, "Weapon Template:");
        translationBuilder.add(EGOWeapon.TOOLTIP_EGO_DAMAGE_TYPE, "Damage Type:");
        translationBuilder.add(EGOWeapon.TOOLTIP_EGO_WEAPON_RANGE, "Attack Range:");
        translationBuilder.add(EGOWeapon.TOOLTIP_EGO_WEAPON_RED, "Red");
        translationBuilder.add(EGOWeapon.TOOLTIP_EGO_WEAPON_WHITE, "White");
        translationBuilder.add(EGOWeapon.TOOLTIP_EGO_WEAPON_BLACK, "Black");
        translationBuilder.add(EGOWeapon.TOOLTIP_EGO_WEAPON_PALE, "Pale");
        //护甲
        translationBuilder.add(EGOSuit.TOOLTIP_EGO_SUIT_LEVEL, "Suit Level:");
        translationBuilder.add(EGOSuit.TOOLTIP_EGO_SUIT_RED, "Red Resist:");
        translationBuilder.add(EGOSuit.TOOLTIP_EGO_SUIT_WHITE, "White Resist:");
        translationBuilder.add(EGOSuit.TOOLTIP_EGO_SUIT_BLACK, "Black Resist:");
        translationBuilder.add(EGOSuit.TOOLTIP_EGO_SUIT_PALE, "Pale Resist:");
        //部门名
        translationBuilder.add(LobeCorpUtil.getTeamName(TeamBadge.LobeCorpTeam.CONTROL_TEAM), "[Control Team]");
        translationBuilder.add(LobeCorpUtil.getTeamName(TeamBadge.LobeCorpTeam.INFORMATION_TEAM), "[Information Team]");
        translationBuilder.add(LobeCorpUtil.getTeamName(TeamBadge.LobeCorpTeam.SECURITY_TEAM), "[Security Team]");
        translationBuilder.add(LobeCorpUtil.getTeamName(TeamBadge.LobeCorpTeam.TRAINING_TEAM), "[Training Team]");
        translationBuilder.add(LobeCorpUtil.getTeamName(TeamBadge.LobeCorpTeam.CENTRAL_COMMAND_TEAM), "[Central Command Team]");
        translationBuilder.add(LobeCorpUtil.getTeamName(TeamBadge.LobeCorpTeam.WELFARE_TEAM), "[Welfare Team]");
        translationBuilder.add(LobeCorpUtil.getTeamName(TeamBadge.LobeCorpTeam.DISCIPLINARY_TEAM), "[Disciplinary Team]");
        translationBuilder.add(LobeCorpUtil.getTeamName(TeamBadge.LobeCorpTeam.RECORD_TEAM), "[Record Team]");
        translationBuilder.add(LobeCorpUtil.getTeamName(TeamBadge.LobeCorpTeam.EXTRACTION_TEAM), "[Extraction Team]");
        translationBuilder.add(LobeCorpUtil.getTeamName(TeamBadge.LobeCorpTeam.ARCHITECTURE_TEAM), "[Architecture Team]");
        //脑叶公司实体名
        translationBuilder.add(EntityInit.DEAD_PLAYER_ENTITY, "Corpse");
        //异想体名
        translationBuilder.add(EntityInit.STANDARD_TRAINING_DUMMY_RABBIT_ENTITY, "Standard Training-Dummy Rabbit");
        translationBuilder.add(EntityInit.ONE_SIN_AND_HUNDREDS_OF_GOOD_DEEDS_ENTITY, "One Sin and Hundreds of Good Deeds");
        //考验名
        translationBuilder.add(EntityInit.DOUBT_ENTITY, "Doubt");
    }
}
