package net.uniego.aida.lobecorp.network.handle;

import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.uniego.aida.lobecorp.network.payload.SyncEquipmentPayload;
import net.uniego.aida.lobecorp.slot.LobeCorpEquipmentSlot;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;

import java.util.ArrayList;

public class SyncEquipmentHandle {
    public static void receive() {
        ClientPlayNetworking.registerGlobalReceiver(SyncEquipmentPayload.ID, ((payload, context) -> context.client().execute(() -> {
            int serverPlayerId = payload.serverPlayerId();
            ArrayList<Pair<LobeCorpEquipmentSlot, ItemStack>> arrayList = payload.lobecorpEquipmentList();
            //根据ID查找到对应玩家
            if (context.player().getWorld().getEntityById(serverPlayerId) instanceof PlayerEntity player) {
                arrayList.forEach(pair -> {
                    LobeCorpEquipmentSlot slot = pair.getFirst();
                    ItemStack itemStack = pair.getSecond();
                    itemStack.getItem().postProcessComponents(itemStack);
                    LobeCorpUtil.setLobeCorpEquippedStack(player, slot, itemStack);
                });
            }
        })));
    }
}
