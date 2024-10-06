package net.uniego.aida.lobecorp.mixin;

import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.uniego.aida.lobecorp.init.ComponentInit;
import net.uniego.aida.lobecorp.slot.LobeCorpAttributeModifiersComponent;
import net.uniego.aida.lobecorp.slot.LobeCorpEquipmentSlot;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;
import org.apache.commons.lang3.mutable.MutableBoolean;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Unique
    ItemStack itemStack = (ItemStack) (Object) this;

    //为工具提示加上新的属性提示
    @Inject(method = "appendAttributeModifiersTooltip", at = @At("TAIL"))
    private void appendAttributeModifiersTooltipMixin(Consumer<Text> textConsumer, @Nullable PlayerEntity player, CallbackInfo ci) {
        LobeCorpAttributeModifiersComponent component = itemStack.getOrDefault(ComponentInit.LOBECORP_ATTRIBUTE_MODIFIERS, LobeCorpAttributeModifiersComponent.DEFAULT);
        if (!component.showInTooltip()) return;
        for (LobeCorpEquipmentSlot slot : LobeCorpEquipmentSlot.values()) {
            MutableBoolean mutableBoolean = new MutableBoolean(true);
            LobeCorpUtil.applyAttributeModifiers(slot, itemStack, (attribute, modifier) -> {
                if (mutableBoolean.isTrue()) {
                    textConsumer.accept(ScreenTexts.EMPTY);
                    textConsumer.accept(Text.translatable("item.modifiers." + slot.getSlotName()).formatted(Formatting.GRAY));
                    mutableBoolean.setFalse();
                }
                appendAttributeModifierTooltip(textConsumer, player, attribute, modifier);
            });
        }
    }

    @Unique
    private void appendAttributeModifierTooltip(Consumer<Text> textConsumer, @Nullable PlayerEntity player, RegistryEntry<EntityAttribute> attribute, EntityAttributeModifier modifier) {
        double d = modifier.value();
        boolean bl = false;
        if (player != null) {
            if (modifier.uuid() == Item.ATTACK_DAMAGE_MODIFIER_ID) {
                d += player.getAttributeBaseValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
                d += EnchantmentHelper.getAttackDamage(itemStack, null);
                bl = true;
            } else if (modifier.uuid() == Item.ATTACK_SPEED_MODIFIER_ID) {
                d += player.getAttributeBaseValue(EntityAttributes.GENERIC_ATTACK_SPEED);
                bl = true;
            }
        }
        double e = modifier.operation() == EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE || modifier.operation() == EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL ? d * 100.0 : (attribute.equals(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE) ? d * 10.0 : d);
        if (bl) {
            textConsumer.accept(ScreenTexts.space().append(Text.translatable("attribute.modifier.equals." + modifier.operation().getId(), AttributeModifiersComponent.DECIMAL_FORMAT.format(e), Text.translatable(attribute.value().getTranslationKey()))).formatted(Formatting.DARK_GREEN));
        } else if (d > 0.0) {
            textConsumer.accept(Text.translatable("attribute.modifier.plus." + modifier.operation().getId(), AttributeModifiersComponent.DECIMAL_FORMAT.format(e), Text.translatable(attribute.value().getTranslationKey())).formatted(Formatting.BLUE));
        } else if (d < 0.0) {
            textConsumer.accept(Text.translatable("attribute.modifier.take." + modifier.operation().getId(), AttributeModifiersComponent.DECIMAL_FORMAT.format(-e), Text.translatable(attribute.value().getTranslationKey())).formatted(Formatting.RED));
        }
    }
}
