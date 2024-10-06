package net.uniego.aida.lobecorp.network.payload;


import com.mojang.datafixers.util.Pair;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.uniego.aida.lobecorp.slot.LobeCorpEquipmentSlot;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;

import java.util.ArrayList;

//同步装备
public record SyncEquipmentPayload(int serverPlayerId,
                                   ArrayList<Pair<LobeCorpEquipmentSlot, ItemStack>> lobecorpEquipmentList) implements CustomPayload {
    public static final PacketCodec<RegistryByteBuf, SyncEquipmentPayload> CODEC = CustomPayload
            .codecOf(SyncEquipmentPayload::write, SyncEquipmentPayload::new);
    public static final Id<SyncEquipmentPayload> ID = new Id<>(LobeCorpUtil.id("sync_equipment"));

    private SyncEquipmentPayload(RegistryByteBuf buf) {
        this(buf.readVarInt(), readEquipmentList(buf));
    }

    private static ArrayList<Pair<LobeCorpEquipmentSlot, ItemStack>> readEquipmentList(RegistryByteBuf buf) {
        ArrayList<Pair<LobeCorpEquipmentSlot, ItemStack>> lobecorpEquipmentList = new ArrayList<>();
        LobeCorpEquipmentSlot[] lobecorpEquipmentSlots = LobeCorpEquipmentSlot.values();
        int size = buf.readVarInt();
        for (int i = 0; i < size; i++) {
            int ordinal = buf.readVarInt();
            LobeCorpEquipmentSlot lobecorpEquipmentSlot = lobecorpEquipmentSlots[ordinal];
            ItemStack itemStack = ItemStack.OPTIONAL_PACKET_CODEC.decode(buf);
            lobecorpEquipmentList.add(Pair.of(lobecorpEquipmentSlot, itemStack));
        }
        return lobecorpEquipmentList;
    }

    private void write(RegistryByteBuf buf) {
        buf.writeVarInt(serverPlayerId);
        int size = lobecorpEquipmentList.size();
        buf.writeVarInt(size);
        for (int i = 0; i < size; i++) {
            Pair<LobeCorpEquipmentSlot, ItemStack> pair = lobecorpEquipmentList.get(i);
            LobeCorpEquipmentSlot lobecorpEquipmentSlot = pair.getFirst();
            buf.writeVarInt(lobecorpEquipmentSlot.ordinal());
            ItemStack.OPTIONAL_PACKET_CODEC.encode(buf, pair.getSecond());
        }
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
