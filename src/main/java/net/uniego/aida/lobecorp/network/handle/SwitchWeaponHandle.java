package net.uniego.aida.lobecorp.network.handle;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.uniego.aida.lobecorp.init.SoundInit;
import net.uniego.aida.lobecorp.item.ego.weapon.EGOWeapon;
import net.uniego.aida.lobecorp.network.payload.SwitchWeaponPayload;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;

public class SwitchWeaponHandle {
    public static void receive() {
        ServerPlayNetworking.registerGlobalReceiver(SwitchWeaponPayload.ID, ((payload, context) -> context.server().execute(() -> {
            ServerPlayerEntity serverPlayer = context.player();
            int slot = payload.slot();
            PlayerInventory playerInventory = serverPlayer.getInventory();
            ItemStack egoWeaponStack = playerInventory.getStack(slot);
            ItemStack mainHandStack = playerInventory.getMainHandStack();
            if (mainHandStack.isEmpty() && !egoWeaponStack.isEmpty()) {
                playerInventory.setStack(playerInventory.selectedSlot, egoWeaponStack.copy());
                playerInventory.setStack(slot, ItemStack.EMPTY);
                LobeCorpUtil.playSound(serverPlayer, SoundInit.SWITCH_WEAPON);
            } else if (!mainHandStack.isEmpty() && egoWeaponStack.isEmpty()) {
                if (mainHandStack.getItem() instanceof EGOWeapon) {
                    playerInventory.setStack(slot, mainHandStack.copy());
                    playerInventory.setStack(playerInventory.selectedSlot, ItemStack.EMPTY);
                    LobeCorpUtil.playSound(serverPlayer, SoundInit.SWITCH_WEAPON);
                }
            } else if (!mainHandStack.isEmpty()) {
                if (mainHandStack.getItem() instanceof EGOWeapon) {
                    playerInventory.setStack(playerInventory.selectedSlot, egoWeaponStack.copy());
                    playerInventory.setStack(slot, mainHandStack.copy());
                    LobeCorpUtil.playSound(serverPlayer, SoundInit.SWITCH_WEAPON);
                }
            }
        })));
    }
}
