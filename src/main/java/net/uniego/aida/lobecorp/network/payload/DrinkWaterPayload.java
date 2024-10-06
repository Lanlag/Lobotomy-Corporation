package net.uniego.aida.lobecorp.network.payload;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;

//喝水行为
public record DrinkWaterPayload(String waterSource) implements CustomPayload {
    public static final String STREAM = "stream";
    public static final String RAIN = "rain";
    public static final String CAULDRON = "cauldron";
    public static final PacketCodec<PacketByteBuf, DrinkWaterPayload> CODEC = CustomPayload
            .codecOf(DrinkWaterPayload::write, DrinkWaterPayload::new);
    public static final Id<DrinkWaterPayload> ID = new Id<>(LobeCorpUtil.id("drink_water"));

    private DrinkWaterPayload(PacketByteBuf buf) {
        this(buf.readString());
    }

    private void write(PacketByteBuf buf) {
        buf.writeString(waterSource);
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
