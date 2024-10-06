package net.uniego.aida.lobecorp.network.payload;


import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;

//喝水挥手
public record SwingHandPayload() implements CustomPayload {
    public static final PacketCodec<PacketByteBuf, SwingHandPayload> CODEC = CustomPayload
            .codecOf(SwingHandPayload::write, SwingHandPayload::new);
    public static final Id<SwingHandPayload> ID = new Id<>(LobeCorpUtil.id("swing_hand"));

    private SwingHandPayload(PacketByteBuf buf) {
        this();
    }

    private void write(PacketByteBuf buf) {
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
