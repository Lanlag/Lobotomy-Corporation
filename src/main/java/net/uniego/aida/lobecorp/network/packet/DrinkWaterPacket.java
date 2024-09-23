package net.uniego.aida.lobecorp.network.packet;


import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.uniego.aida.lobecorp.network.payload.DrinkWaterPayload;

public class DrinkWaterPacket {
    public static void send(String waterSource) {
        ClientPlayNetworking.send(new DrinkWaterPayload(waterSource));
    }
}
