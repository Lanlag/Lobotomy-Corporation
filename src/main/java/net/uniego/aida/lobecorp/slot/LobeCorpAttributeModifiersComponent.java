package net.uniego.aida.lobecorp.slot;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.function.BiConsumer;

//脑叶公司属性修饰符组件
public record LobeCorpAttributeModifiersComponent(List<Entry> modifiers, boolean showInTooltip) {
    public static final LobeCorpAttributeModifiersComponent DEFAULT = new LobeCorpAttributeModifiersComponent(List.of(), true);
    public static final Codec<LobeCorpAttributeModifiersComponent> CODEC;
    public static final PacketCodec<RegistryByteBuf, LobeCorpAttributeModifiersComponent> PACKET_CODEC;
    public static final DecimalFormat DECIMAL_FORMAT;
    private static final Codec<LobeCorpAttributeModifiersComponent> BASE_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(Entry.CODEC.listOf().fieldOf("modifiers").forGetter(LobeCorpAttributeModifiersComponent::modifiers),
                            Codec.BOOL.optionalFieldOf("show_in_tooltip", true).forGetter(LobeCorpAttributeModifiersComponent::showInTooltip))
                    .apply(instance, LobeCorpAttributeModifiersComponent::new));

    static {
        CODEC = Codec.withAlternative(BASE_CODEC, Entry.CODEC.listOf(), attributeModifiers ->
                new LobeCorpAttributeModifiersComponent(attributeModifiers, true));
        PACKET_CODEC = PacketCodec.tuple(Entry.PACKET_CODEC.collect(PacketCodecs.toList()), LobeCorpAttributeModifiersComponent::modifiers,
                PacketCodecs.BOOL, LobeCorpAttributeModifiersComponent::showInTooltip, LobeCorpAttributeModifiersComponent::new);
        DECIMAL_FORMAT = Util.make(new DecimalFormat("#.##"), format -> format.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ROOT)));
    }

    public static Builder builder() {
        return new Builder();
    }

    public void applyModifiers(LobeCorpEquipmentSlot lobecorpEquipmentSlot,
                               BiConsumer<RegistryEntry<EntityAttribute>, EntityAttributeModifier> attributeModifierBiConsumer) {
        for (Entry entry : modifiers) {
            if (entry.lobecorpSlot.matches(lobecorpEquipmentSlot)) {
                attributeModifierBiConsumer.accept(entry.attribute, entry.modifier);
            }
        }
    }

    //构建组件实例
    public static class Builder {
        private final ImmutableList.Builder<Entry> entries = ImmutableList.builder();

        Builder() {
        }

        public Builder add(RegistryEntry<EntityAttribute> attribute, EntityAttributeModifier modifier,
                           LobeCorpAttributeModifierSlot lobecorpSlot) {
            entries.add(new Entry(attribute, modifier, lobecorpSlot));
            return this;
        }

        public LobeCorpAttributeModifiersComponent builder() {
            return new LobeCorpAttributeModifiersComponent(entries.build(), true);
        }
    }

    //序列化和反序列化
    public record Entry(RegistryEntry<EntityAttribute> attribute, EntityAttributeModifier modifier,
                        LobeCorpAttributeModifierSlot lobecorpSlot) {
        public static final Codec<Entry> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                Registries.ATTRIBUTE.getEntryCodec().fieldOf("type").forGetter(Entry::attribute),
                EntityAttributeModifier.MAP_CODEC.forGetter(Entry::modifier),
                LobeCorpAttributeModifierSlot.CODEC.optionalFieldOf("slot",
                        LobeCorpAttributeModifierSlot.LOBECORP_ANY).forGetter(Entry::lobecorpSlot)
        ).apply(instance, Entry::new));
        public static final PacketCodec<RegistryByteBuf, Entry> PACKET_CODEC;

        static {
            PACKET_CODEC = PacketCodec.tuple(
                    PacketCodecs.registryEntry(RegistryKeys.ATTRIBUTE), Entry::attribute,
                    EntityAttributeModifier.PACKET_CODEC, Entry::modifier,
                    LobeCorpAttributeModifierSlot.PACKET_CODEC, Entry::lobecorpSlot,
                    Entry::new);
        }

        @Override
        public RegistryEntry<EntityAttribute> attribute() {
            return attribute;
        }

        @Override
        public EntityAttributeModifier modifier() {
            return modifier;
        }

        @Override
        public LobeCorpAttributeModifierSlot lobecorpSlot() {
            return lobecorpSlot;
        }
    }
}
