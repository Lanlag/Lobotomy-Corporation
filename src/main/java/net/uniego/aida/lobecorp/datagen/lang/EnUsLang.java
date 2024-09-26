package net.uniego.aida.lobecorp.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.uniego.aida.lobecorp.gui.GUIResource;
import net.uniego.aida.lobecorp.init.*;
import net.uniego.aida.lobecorp.item.LobeCorpItem;
import net.uniego.aida.lobecorp.item.ego.EGOItem;
import net.uniego.aida.lobecorp.item.ego.suit.EGOSuit;
import net.uniego.aida.lobecorp.item.ego.weapon.EGOWeapon;
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
        translationBuilder.add(LobeCorpItem.LOBECORP_LOGO, "LobeCorp Logo");
        translationBuilder.add(LobeCorpItem.BLUE_LEAF, "Blue Leaf");
        //物品栏名
        translationBuilder.add(ItemGroupInit.LOBECORP_TAB_NAME, "LobeCorp");
        //声音名
        translationBuilder.add(SoundInit.SWALLOW_WATER_ID, "Swallow Water");
        translationBuilder.add(SoundInit.SWITCH_WEAPON_ID, "Switch Weapon");
        //屏幕名
        translationBuilder.add(ScreenInit.CONTAINER_EQUIPMENT, "Equipment");
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
        translationBuilder.add(LobeCorpEquipmentSlot.LOBECORP_WEAPON_SLOT.getSlotName(), "When in Weapon Slot:");
        translationBuilder.add(LobeCorpEquipmentSlot.LOBECORP_SUIT_SLOT.getSlotName(), "When in Suit Slot:");
        translationBuilder.add(LobeCorpEquipmentSlot.LOBECORP_BADGE_SLOT.getSlotName(), "When in Badge Slot:");
        translationBuilder.add(LobeCorpEquipmentSlot.LOBECORP_TOOL_SLOT.getSlotName(), "When in Tool Slot:");
        translationBuilder.add(LobeCorpEquipmentSlot.LOBECORP_HAT_SLOT.getSlotName(), "When in Hat Slot:");
        translationBuilder.add(LobeCorpEquipmentSlot.LOBECORP_HEAD_SLOT.getSlotName(), "When in Head Slot:");
        translationBuilder.add(LobeCorpEquipmentSlot.LOBECORP_OCCIPUT_SLOT.getSlotName(), "When in Occiput Slot:");
        translationBuilder.add(LobeCorpEquipmentSlot.LOBECORP_EYE_SLOT.getSlotName(), "When in Eye Slot:");
        translationBuilder.add(LobeCorpEquipmentSlot.LOBECORP_FACE_SLOT.getSlotName(), "When in Face Slot:");
        translationBuilder.add(LobeCorpEquipmentSlot.LOBECORP_CHEEK_SLOT.getSlotName(), "When in Cheek Slot:");
        translationBuilder.add(LobeCorpEquipmentSlot.LOBECORP_MASK_SLOT.getSlotName(), "When in Mask Slot:");
        translationBuilder.add(LobeCorpEquipmentSlot.LOBECORP_MOUTH_SLOT.getSlotName(), "When in Mouth Slot:");
        translationBuilder.add(LobeCorpEquipmentSlot.LOBECORP_NECK_SLOT.getSlotName(), "When in Neck Slot:");
        translationBuilder.add(LobeCorpEquipmentSlot.LOBECORP_CHEST_SLOT.getSlotName(), "When in Chest Slot:");
        translationBuilder.add(LobeCorpEquipmentSlot.LOBECORP_HAND_SLOT.getSlotName(), "When in Hand Slot:");
        translationBuilder.add(LobeCorpEquipmentSlot.LOBECORP_GLOVE_SLOT.getSlotName(), "When in Glove Slot:");
        translationBuilder.add(LobeCorpEquipmentSlot.LOBECORP_RIGHTBACK_SLOT.getSlotName(), "When in RightBack Slot:");
        translationBuilder.add(LobeCorpEquipmentSlot.LOBECORP_LEFTBACK_SLOT.getSlotName(), "When in LeftBack Slot:");
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
    }
}
