package net.uniego.aida.lobecorp.network.payload;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;

import java.util.UUID;

//打开工作
public record OpenWorkPayload(UUID abnormalityUuid) implements CustomPayload {
    public static final PacketCodec<PacketByteBuf, OpenWorkPayload> CODEC = CustomPayload
            .codecOf(OpenWorkPayload::write, OpenWorkPayload::new);
    public static final Id<OpenWorkPayload> ID = new Id<>(LobeCorpUtil.id("open_work"));

    private OpenWorkPayload(PacketByteBuf buf) {
        this(buf.readUuid());
    }

    private void write(PacketByteBuf buf) {
        buf.writeUuid(abnormalityUuid);
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
