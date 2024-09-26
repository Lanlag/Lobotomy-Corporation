package net.uniego.aida.lobecorp;

import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.uniego.aida.lobecorp.access.EquipRequireAccess;
import net.uniego.aida.lobecorp.access.LobeCorpSlotAccess;
import net.uniego.aida.lobecorp.access.ManagerAccess;
import net.uniego.aida.lobecorp.init.AttributeInit;
import net.uniego.aida.lobecorp.init.ComponentInit;
import net.uniego.aida.lobecorp.init.DamageInit;
import net.uniego.aida.lobecorp.init.TagInit;
import net.uniego.aida.lobecorp.item.LobeCorpItem;
import net.uniego.aida.lobecorp.item.ego.suit.EGOSuit;
import net.uniego.aida.lobecorp.item.ego.weapon.EGOWeapon;
import net.uniego.aida.lobecorp.manager.LevelManager;
import net.uniego.aida.lobecorp.slot.LobeCorpAttributeModifierSlot;
import net.uniego.aida.lobecorp.slot.LobeCorpAttributeModifiersComponent;
import net.uniego.aida.lobecorp.slot.LobeCorpEquipmentSlot;

import java.util.UUID;
import java.util.function.BiConsumer;

//常用工具
public class LobeCorpUtil {
    //注册ID
    public static Identifier id(String id) {
        return new Identifier(LobeCorpMain.MOD_ID, id);
    }

    //播放声音
    public static void playSound(PlayerEntity player, SoundEvent soundEvent) {
        player.getWorld().playSound(null, player.getBlockPos(), soundEvent, SoundCategory.PLAYERS, 1, 1);
    }

    //获取物品属性名
    public static String getItemModifiersName(LobeCorpEquipmentSlot slot) {
        return "item.modifiers." + slot.getSlotName();
    }

    //创建EGO武器属性修饰符
    public static AttributeModifiersComponent createEGOWeaponAttributeModifiers(double attackDamage, double attackSpeed, double interactionRange) {
        return AttributeModifiersComponent.builder()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, egoWeaponModifier(Item.ATTACK_DAMAGE_MODIFIER_ID, attackDamage), AttributeModifierSlot.MAINHAND)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, egoWeaponModifier(Item.ATTACK_SPEED_MODIFIER_ID, attackSpeed), AttributeModifierSlot.MAINHAND)
                .add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, egoWeaponModifier(EGOWeapon.INTERACTION_RANGE_MODIFIER_ID, interactionRange), AttributeModifierSlot.MAINHAND)
                .add(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE, egoWeaponModifier(EGOWeapon.INTERACTION_RANGE_MODIFIER_ID, interactionRange), AttributeModifierSlot.MAINHAND)
                .build();
    }

    //创建EGO护甲属性修饰符
    public static LobeCorpAttributeModifiersComponent createEGOSuitAttributeModifiers(EGOLevel egoLevel, LobeCorpAttributeModifierSlot lobecorpSlot) {
        return LobeCorpAttributeModifiersComponent.builder()
                .add(EntityAttributes.GENERIC_ARMOR, egoSuitModifier((egoLevel.getLevel()) * 6), lobecorpSlot)
                .add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, egoSuitModifier((egoLevel.getLevel() - 1) * 5), lobecorpSlot)
                .builder();
    }

    //创建EGO饰品属性修饰符
    public static LobeCorpAttributeModifiersComponent createEGOGiftAttributeModifiers(double maxHealth, double maxSanity,
                                                                                      double workSuccess, double workVelocity,
                                                                                      double attackVelocity, double moveVelocity,
                                                                                      UUID uuid,
                                                                                      LobeCorpAttributeModifierSlot lobecorpSlot) {
        return LobeCorpAttributeModifiersComponent.builder()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, egoGiftModifier(uuid, maxHealth), lobecorpSlot)
                .add(AttributeInit.PLAYER_MAX_SANITY, egoGiftModifier(uuid, maxSanity), lobecorpSlot)
                .add(AttributeInit.PLAYER_WORK_SUCCESS, egoGiftModifier(uuid, workSuccess), lobecorpSlot)
                .add(AttributeInit.PLAYER_WORK_VELOCITY, egoGiftModifier(uuid, workVelocity), lobecorpSlot)
                .add(AttributeInit.PLAYER_ATTACK_VELOCITY, egoGiftModifier(uuid, attackVelocity), lobecorpSlot)
                .add(AttributeInit.PLAYER_MOVE_VELOCITY, egoGiftModifier(uuid, moveVelocity), lobecorpSlot)
                .builder();
    }

    //EGO武器修饰符
    public static EntityAttributeModifier egoWeaponModifier(UUID uuid, double value) {
        return new EntityAttributeModifier(uuid, "EGO Weapon modifier", value, EntityAttributeModifier.Operation.ADD_VALUE);
    }

    //EGO护甲修饰符
    public static EntityAttributeModifier egoSuitModifier(double value) {
        return new EntityAttributeModifier(LobeCorpItem.LOBECORP_SUIT_MODIFIER_ID, "EGO Suit modifier", value, EntityAttributeModifier.Operation.ADD_VALUE);
    }

    //EGO饰品修饰符
    public static EntityAttributeModifier egoGiftModifier(UUID uuid, double value) {
        return new EntityAttributeModifier(uuid, "EGO Gift modifier", value, EntityAttributeModifier.Operation.ADD_VALUE);
    }

    //应用修饰符
    public static void applyAttributeModifiers(LobeCorpEquipmentSlot slot, ItemStack itemStack,
                                               BiConsumer<RegistryEntry<EntityAttribute>, EntityAttributeModifier> biConsumer) {
        LobeCorpAttributeModifiersComponent component = itemStack.getOrDefault(ComponentInit.LOBECORP_ATTRIBUTE_MODIFIERS, LobeCorpAttributeModifiersComponent.DEFAULT);
        if (!component.modifiers().isEmpty()) {
            component.applyModifiers(slot, biConsumer);
        }
    }

    //获取对应插槽
    public static ItemStack getLobeCorpEquippedStack(PlayerEntity player, LobeCorpEquipmentSlot slot) {
        return player.getInventory().getStack(63 + slot.ordinal());
    }

    //设置对应插槽
    public static void setLobeCorpEquippedStack(PlayerEntity player, LobeCorpEquipmentSlot slot, ItemStack itemStack) {
        player.getInventory().setStack(63 + slot.ordinal(), itemStack.copy());
    }

    //等级压制算法
    public static float calculateLevelSuppress(EGOLevel defendEGOLevel, EGOLevel attackEGOLevel) {
        int result = defendEGOLevel.getLevel() - attackEGOLevel.getLevel();
        return switch (result) {
            case -4 -> 2.0F;
            case -3 -> 1.5F;
            case -2 -> 1.2F;
            case 1 -> 0.8F;
            case 2 -> 0.7F;
            case 3 -> 0.6F;
            case 4 -> 0.4F;
            default -> 1.0F;
        };
    }

    //判断能否装备物品
    public static boolean cantEquipped(PlayerEntity player, LobeCorpSlotAccess lobecorpItem) {
        if (lobecorpItem instanceof EquipRequireAccess equipRequireItem) {
            //获取玩家四大等级
            LevelManager levelManager = ((ManagerAccess) player).lobecorp$getLevelManager();
            int playerFortitude = levelManager.getLevelF().getValue();
            int playerPrudence = levelManager.getLevelP().getValue();
            int playerTemperance = levelManager.getLevelT().getValue();
            int playerJustice = levelManager.getLevelJ().getValue();
            //获取物品装备等级要求
            int requireFortitude = equipRequireItem.getFortitudeRequire().getValue();
            int requirePrudence = equipRequireItem.getPrudenceRequire().getValue();
            int requireTemperance = equipRequireItem.getTemperanceRequire().getValue();
            int requireJustice = equipRequireItem.getJusticeRequire().getValue();
            //进行比较
            boolean isFortitudeEnough = playerFortitude >= requireFortitude;
            boolean isPrudenceEnough = playerPrudence >= requirePrudence;
            boolean isTemperanceEnough = playerTemperance >= requireTemperance;
            boolean isJusticeEnough = playerJustice >= requireJustice;

            return !isFortitudeEnough || !isPrudenceEnough || !isTemperanceEnough || !isJusticeEnough;
        }
        return false;
    }

    //检查EGO武器
    public static void checkEGOWeapon(PlayerEntity player, ItemStack itemStack) {
        if (itemStack.getItem() instanceof EGOWeapon egoWeapon && cantEquipped(player, egoWeapon)) {
            if (itemStack.isIn(TagInit.RED_EGO_WEAPONS)) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200));
                player.damage(noKnockBackDamageSource(DamageInit.RED, player), egoWeapon.getAttackDamage());
            } else if (itemStack.isIn(TagInit.WHITE_EGO_WEAPONS)) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200));
                player.damage(noKnockBackDamageSource(DamageInit.WHITE, player), egoWeapon.getAttackDamage());
            } else if (itemStack.isIn(TagInit.BLACK_EGO_WEAPONS)) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200));
                player.damage(noKnockBackDamageSource(DamageInit.BLACK, player), egoWeapon.getAttackDamage());
            } else if (itemStack.isIn(TagInit.PALE_EGO_WEAPONS)) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200));
                player.damage(noKnockBackDamageSource(DamageInit.PALE, player), egoWeapon.getAttackDamage());
            }
        }
    }

    //检查EGO护甲
    public static void checkEGOSuit(PlayerEntity player, ItemStack itemStack) {
        if (itemStack.getItem() instanceof EGOSuit egoSuit && cantEquipped(player, egoSuit)) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200));
            player.damage(noKnockBackDamageSource(DamageInit.MYSTIC, player), (egoSuit.getEGOLevel().getLevel()));
        }
    }

    //无击退伤害源
    public static DamageSource noKnockBackDamageSource(RegistryKey<DamageType> key, Entity entity) {
        return new DamageSource(entity.getDamageSources().registry.entryOf(key), entity) {
            @Override
            public boolean isIn(TagKey<DamageType> tag) {
                return tag == DamageTypeTags.NO_KNOCKBACK || super.isIn(tag);
            }
        };
    }

    //EGO等级
    public enum EGOLevel {
        ZAYIN(1, Formatting.GREEN),
        TETH(2, Formatting.BLUE),
        HE(3, Formatting.YELLOW),
        WAW(4, Formatting.LIGHT_PURPLE),
        ALEPH(5, Formatting.RED);

        private final int level;
        private final Formatting color;

        EGOLevel(int level, Formatting color) {
            this.level = level;
            this.color = color;
        }

        public int getLevel() {
            return level;
        }

        public Formatting getColor() {
            return color;
        }
    }
}
