package net.uniego.aida.lobecorp.network.payload;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.uniego.aida.lobecorp.LobeCorpUtil;

//打开关闭脑叶公司屏幕
public record OpenClosePayload() implements CustomPayload {
    public static final PacketCodec<PacketByteBuf, OpenClosePayload> CODEC = CustomPayload
            .codecOf(OpenClosePayload::write, OpenClosePayload::new);
    public static final Id<OpenClosePayload> ID = new Id<>(LobeCorpUtil.id("open_close"));

    private OpenClosePayload(PacketByteBuf buf) {
        this();
    }

    private void write(PacketByteBuf buf) {
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
