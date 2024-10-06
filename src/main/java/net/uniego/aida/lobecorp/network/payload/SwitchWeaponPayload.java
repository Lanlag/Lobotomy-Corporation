package net.uniego.aida.lobecorp.network.payload;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;

//切换武器
public record SwitchWeaponPayload(int slot) implements CustomPayload {
    public static final PacketCodec<PacketByteBuf, SwitchWeaponPayload> CODEC = CustomPayload
            .codecOf(SwitchWeaponPayload::write, SwitchWeaponPayload::new);
    public static final Id<SwitchWeaponPayload> ID = new Id<>(LobeCorpUtil.id("switch_weapon"));

    private SwitchWeaponPayload(PacketByteBuf buf) {
        this(buf.readVarInt());
    }

    private void write(PacketByteBuf buf) {
        buf.writeVarInt(slot);
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
