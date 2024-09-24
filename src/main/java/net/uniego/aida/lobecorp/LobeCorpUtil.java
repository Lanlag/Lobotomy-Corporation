package net.uniego.aida.lobecorp;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.uniego.aida.lobecorp.init.AttributeInit;
import net.uniego.aida.lobecorp.slot.LobeCorpAttributeModifierSlot;
import net.uniego.aida.lobecorp.slot.LobeCorpAttributeModifiersComponent;

import java.util.UUID;

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

    //创建EGO武器属性修饰符
    public static LobeCorpAttributeModifiersComponent createEGOWeaponAttributeModifiers(double maxHealth, double maxSanity,
                                                                                        double workSuccess, double workVelocity,
                                                                                        double attackVelocity, double moveVelocity,
                                                                                        UUID uuid,
                                                                                        LobeCorpAttributeModifierSlot lobecorpAttributeModifierSlot) {
        return LobeCorpAttributeModifiersComponent.builder()
                .builder();
    }

    //创建EGO护甲属性修饰符
    public static LobeCorpAttributeModifiersComponent createEGOSuitAttributeModifiers(double armor, double armorToughness,
                                                                                      UUID uuid,
                                                                                      LobeCorpAttributeModifierSlot lobecorpAttributeModifierSlot) {
        return LobeCorpAttributeModifiersComponent.builder()
                .builder();
    }

    //创建EGO饰品属性修饰符
    public static LobeCorpAttributeModifiersComponent createEGOGiftAttributeModifiers(double maxHealth, double maxSanity,
                                                                                      double workSuccess, double workVelocity,
                                                                                      double attackVelocity, double moveVelocity,
                                                                                      UUID uuid,
                                                                                      LobeCorpAttributeModifierSlot lobecorpAttributeModifierSlot) {
        return LobeCorpAttributeModifiersComponent.builder()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, egoGiftAttributeModifier(uuid, maxHealth), lobecorpAttributeModifierSlot)
                .add(AttributeInit.PLAYER_MAX_SANITY, egoGiftAttributeModifier(uuid, maxSanity), lobecorpAttributeModifierSlot)
                .add(AttributeInit.PLAYER_WORK_SUCCESS, egoGiftAttributeModifier(uuid, workSuccess), lobecorpAttributeModifierSlot)
                .add(AttributeInit.PLAYER_WORK_VELOCITY, egoGiftAttributeModifier(uuid, workVelocity), lobecorpAttributeModifierSlot)
                .add(AttributeInit.PLAYER_ATTACK_VELOCITY, egoGiftAttributeModifier(uuid, attackVelocity), lobecorpAttributeModifierSlot)
                .add(AttributeInit.PLAYER_MOVE_VELOCITY, egoGiftAttributeModifier(uuid, moveVelocity), lobecorpAttributeModifierSlot)
                .builder();
    }

    //EGO武器修饰符
    public static EntityAttributeModifier egoWeaponAttributeModifier(UUID uuid, double value) {
        return new EntityAttributeModifier(uuid, "EGO Weapon modifier", value, EntityAttributeModifier.Operation.ADD_VALUE);
    }

    //EGO护甲修饰符
    public static EntityAttributeModifier egoSuitAttributeModifier(UUID uuid, double value) {
        return new EntityAttributeModifier(uuid, "EGO Suit modifier", value, EntityAttributeModifier.Operation.ADD_VALUE);
    }

    //EGO饰品修饰符
    public static EntityAttributeModifier egoGiftAttributeModifier(UUID uuid, double value) {
        return new EntityAttributeModifier(uuid, "EGO Gift modifier", value, EntityAttributeModifier.Operation.ADD_VALUE);
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
