package net.uniego.aida.lobecorp.network.payload;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;

//同步偏移
public record SyncOffsetPayload(String name, float value) implements CustomPayload {
    public static final String HYDRATION = "hydration";
    public static final String DESICCATION = "desiccation";
    public static final String SATURATION = "saturation";
    public static final String EXHAUSTION = "exhaustion";
    public static final PacketCodec<PacketByteBuf, SyncOffsetPayload> CODEC = CustomPayload
            .codecOf(SyncOffsetPayload::write, SyncOffsetPayload::new);
    public static final Id<SyncOffsetPayload> ID = new Id<>(LobeCorpUtil.id("sync_offset"));

    private SyncOffsetPayload(PacketByteBuf buf) {
        this(buf.readString(), buf.readFloat());
    }

    private void write(PacketByteBuf buf) {
        buf.writeString(name);
        buf.writeFloat(value);
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
