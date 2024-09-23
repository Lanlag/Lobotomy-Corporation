package net.uniego.aida.lobecorp.network.payload;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.uniego.aida.lobecorp.LobeCorpUtil;

//同步图标
public record SyncIconPayload(float sanity, float maxAssimilation, float assimilation,
                              int water, float hydration, float desiccation,
                              float exhaustion) implements CustomPayload {
    public static final PacketCodec<PacketByteBuf, SyncIconPayload> CODEC = CustomPayload
            .codecOf(SyncIconPayload::write, SyncIconPayload::new);
    public static final Id<SyncIconPayload> ID = new Id<>(LobeCorpUtil.id("sync_icon"));

    private SyncIconPayload(PacketByteBuf buf) {
        this(buf.readFloat(), buf.readFloat(), buf.readFloat(),
                buf.readVarInt(), buf.readFloat(), buf.readFloat()
                , buf.readFloat());
    }

    private void write(PacketByteBuf buf) {
        buf.writeFloat(sanity);
        buf.writeFloat(maxAssimilation);
        buf.writeFloat(assimilation);
        buf.writeVarInt(water);
        buf.writeFloat(hydration);
        buf.writeFloat(desiccation);
        buf.writeFloat(exhaustion);
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
