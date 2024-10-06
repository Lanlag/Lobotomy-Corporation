package net.uniego.aida.lobecorp.network.payload;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;

import java.util.UUID;

//开始工作
public record BeginWorkPayload(UUID abnormalityUuid, String workMethod) implements CustomPayload {
    public static final PacketCodec<PacketByteBuf, BeginWorkPayload> CODEC = CustomPayload
            .codecOf(BeginWorkPayload::write, BeginWorkPayload::new);
    public static final Id<BeginWorkPayload> ID = new Id<>(LobeCorpUtil.id("begin_work"));

    private BeginWorkPayload(PacketByteBuf buf) {
        this(buf.readUuid(), buf.readString());
    }

    private void write(PacketByteBuf buf) {
        buf.writeUuid(abnormalityUuid);
        buf.writeString(workMethod);
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
