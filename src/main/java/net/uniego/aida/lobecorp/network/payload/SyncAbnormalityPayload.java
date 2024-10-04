package net.uniego.aida.lobecorp.network.payload;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.uniego.aida.lobecorp.LobeCorpUtil;

//同步异想体
public record SyncAbnormalityPayload(int abnormalityId) implements CustomPayload {

    public static final PacketCodec<PacketByteBuf, SyncAbnormalityPayload> CODEC = CustomPayload
            .codecOf(SyncAbnormalityPayload::write, SyncAbnormalityPayload::new);
    public static final Id<SyncAbnormalityPayload> ID = new Id<>(LobeCorpUtil.id("sync_abnormality"));

    private SyncAbnormalityPayload(PacketByteBuf buf) {
        this(buf.readVarInt());
    }

    private void write(PacketByteBuf buf) {
        buf.writeVarInt(abnormalityId);
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
