package net.uniego.aida.lobecorp.slot;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;

import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

//脑叶公司属性修饰符插槽
public enum LobeCorpAttributeModifierSlot implements StringIdentifiable {
    LOBECORP_ANY(0, "lobecorp_any", lobecorpEquipmentSlot -> true),
    LOBECORP_WEAPON(1, "lobecorp_weapon", LobeCorpEquipmentSlot.LOBECORP_WEAPON_SLOT),
    LOBECORP_SUIT(1, "lobecorp_suit", LobeCorpEquipmentSlot.LOBECORP_SUIT_SLOT),
    LOBECORP_BADGE(1, "lobecorp_badge", LobeCorpEquipmentSlot.LOBECORP_BADGE_SLOT),
    LOBECORP_TOOL(1, "lobecorp_tool", LobeCorpEquipmentSlot.LOBECORP_TOOL_SLOT),
    LOBECORP_HAT(1, "lobecorp_hat", LobeCorpEquipmentSlot.LOBECORP_HAT_SLOT),
    LOBECORP_HEAD(1, "lobecorp_head", LobeCorpEquipmentSlot.LOBECORP_HEAD_SLOT),
    LOBECORP_OCCIPUT(1, "lobecorp_occiput", LobeCorpEquipmentSlot.LOBECORP_OCCIPUT_SLOT),
    LOBECORP_EYE(1, "lobecorp_eye", LobeCorpEquipmentSlot.LOBECORP_EYE_SLOT),
    LOBECORP_FACE(1, "lobecorp_face", LobeCorpEquipmentSlot.LOBECORP_FACE_SLOT),
    LOBECORP_CHEEK(1, "lobecorp_cheek", LobeCorpEquipmentSlot.LOBECORP_CHEEK_SLOT),
    LOBECORP_MASK(1, "lobecorp_mask", LobeCorpEquipmentSlot.LOBECORP_MASK_SLOT),
    LOBECORP_MOUTH(1, "lobecorp_mouth", LobeCorpEquipmentSlot.LOBECORP_MOUTH_SLOT),
    LOBECORP_NECK(1, "lobecorp_neck", LobeCorpEquipmentSlot.LOBECORP_NECK_SLOT),
    LOBECORP_CHEST(1, "lobecorp_chest", LobeCorpEquipmentSlot.LOBECORP_CHEST_SLOT),
    LOBECORP_HAND(1, "lobecorp_hand", LobeCorpEquipmentSlot.LOBECORP_HAND_SLOT),
    LOBECORP_GLOVE(1, "lobecorp_glove", LobeCorpEquipmentSlot.LOBECORP_GLOVE_SLOT),
    LOBECORP_RIGHTBACK(1, "lobecorp_rightback", LobeCorpEquipmentSlot.LOBECORP_RIGHTBACK_SLOT),
    LOBECORP_LEFTBACK(1, "lobecorp_leftback", LobeCorpEquipmentSlot.LOBECORP_LEFTBACK_SLOT);

    public static final IntFunction<LobeCorpAttributeModifierSlot> ID_TO_VALUE = ValueLists.createIdToValueFunction(
            (ToIntFunction<LobeCorpAttributeModifierSlot>) id -> id.id, values(), ValueLists.OutOfBoundsHandling.ZERO);
    public static final Codec<LobeCorpAttributeModifierSlot> CODEC = StringIdentifiable.createCodec(LobeCorpAttributeModifierSlot::values);
    public static final PacketCodec<ByteBuf, LobeCorpAttributeModifierSlot> PACKET_CODEC = PacketCodecs.indexed(ID_TO_VALUE, id -> id.id);
    private final int id;
    private final String name;
    private final Predicate<LobeCorpEquipmentSlot> predicate;

    LobeCorpAttributeModifierSlot(int id, String name, Predicate<LobeCorpEquipmentSlot> predicate) {
        this.id = id;
        this.name = name;
        this.predicate = predicate;
    }

    LobeCorpAttributeModifierSlot(final int id, final String name, final LobeCorpEquipmentSlot lobecorpEquipmentSlot) {
        this(id, name, slot -> slot == lobecorpEquipmentSlot);
    }

    @Override
    public String asString() {
        return name;
    }

    public boolean matches(LobeCorpEquipmentSlot lobecorpEquipmentSlot) {
        return predicate.test(lobecorpEquipmentSlot);
    }
}
