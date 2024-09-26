package net.uniego.aida.lobecorp.network.packet;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.uniego.aida.lobecorp.network.payload.SwitchWeaponPayload;

public class SwitchWeaponPacket {
    public static void send() {
        ClientPlayNetworking.send(new SwitchWeaponPayload(63));
    }
}
