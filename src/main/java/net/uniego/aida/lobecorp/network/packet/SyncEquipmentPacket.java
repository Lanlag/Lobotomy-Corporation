package net.uniego.aida.lobecorp.network.packet;


import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.init.SoundInit;
import net.uniego.aida.lobecorp.network.payload.SyncEquipmentPayload;
import net.uniego.aida.lobecorp.slot.LobeCorpEquipmentSlot;

import java.util.*;

public class SyncEquipmentPacket {
    private static final Map<UUID, Map<LobeCorpEquipmentSlot, ItemStack>> syncedLobeCorpStacks = new HashMap<>();

    //发送差异的部分装饰
    public static void send(ServerPlayerEntity serverPlayer) {
        Map<LobeCorpEquipmentSlot, ItemStack> map = getLobeCorpEquipmentChanges(serverPlayer);
        if (map != null && !map.isEmpty()) {
            ArrayList<Pair<LobeCorpEquipmentSlot, ItemStack>> arrayList = Lists.newArrayListWithCapacity(map.size());
            map.forEach((slot, stack) -> {
                ItemStack itemStack = stack.copy();
                arrayList.add(Pair.of(slot, itemStack));
                getOrCreateStacks(serverPlayer.getUuid()).put(slot, itemStack);
            });
            Collection<ServerPlayerEntity> otherPlayers = PlayerLookup.tracking(serverPlayer.getServerWorld(), serverPlayer.getBlockPos());
            ArrayList<ServerPlayerEntity> allPlayers = new ArrayList<>(otherPlayers);
            allPlayers.add(serverPlayer);
            allPlayers.forEach(player -> ServerPlayNetworking.send(player, new SyncEquipmentPayload(serverPlayer.getId(), arrayList)));
        }
    }

    //发送存在的全部装饰
    public static void send(ServerPlayerEntity receiver, ServerPlayerEntity sender) {
        Map<LobeCorpEquipmentSlot, ItemStack> map = getLobeCorpEquipment(sender);
        if (!map.isEmpty()) {
            ArrayList<Pair<LobeCorpEquipmentSlot, ItemStack>> arrayList = Lists.newArrayListWithCapacity(map.size());
            map.forEach((slot, stack) -> {
                ItemStack itemStack = stack.copy();
                arrayList.add(Pair.of(slot, itemStack));
                getOrCreateStacks(sender.getUuid()).put(slot, itemStack);
            });
            ServerPlayNetworking.send(receiver, new SyncEquipmentPayload(sender.getId(), arrayList));
        }
    }

    //获取脑叶公司装备变化
    private static Map<LobeCorpEquipmentSlot, ItemStack> getLobeCorpEquipmentChanges(ServerPlayerEntity serverPlayer) {
        EnumMap<LobeCorpEquipmentSlot, ItemStack> enumMap = null;
        for (LobeCorpEquipmentSlot slot : LobeCorpEquipmentSlot.values()) {
            ItemStack oldItemStack = getOrCreateStacks(serverPlayer.getUuid()).getOrDefault(slot, ItemStack.EMPTY);
            ItemStack newItemStack = LobeCorpUtil.getLobeCorpEquippedStack(serverPlayer, slot);
            if (serverPlayer.areItemsDifferent(oldItemStack, newItemStack)) {
                LobeCorpUtil.playSound(serverPlayer, SoundInit.CHANGE_EQUIPMENT);
            } else continue;
            if (enumMap == null) {
                enumMap = new EnumMap<>(LobeCorpEquipmentSlot.class);
            }
            enumMap.put(slot, newItemStack);
            AttributeContainer attributeContainer = serverPlayer.getAttributes();
            if (!oldItemStack.isEmpty()) {
                LobeCorpUtil.applyAttributeModifiers(slot, oldItemStack, (attribute, modifier) -> {
                    EntityAttributeInstance instance = attributeContainer.getCustomInstance(attribute);
                    if (instance != null) {
                        instance.removeModifier(modifier);
                    }
                });
            }
            if (newItemStack.isEmpty()) continue;
            LobeCorpUtil.applyAttributeModifiers(slot, newItemStack, (attribute, modifier) -> {
                EntityAttributeInstance instance = attributeContainer.getCustomInstance(attribute);
                if (instance != null) {
                    instance.removeModifier(modifier);
                    instance.addTemporaryModifier(modifier);
                }
            });
        }
        return enumMap;
    }

    //获取脑叶公司装备
    private static Map<LobeCorpEquipmentSlot, ItemStack> getLobeCorpEquipment(ServerPlayerEntity serverPlayer) {
        EnumMap<LobeCorpEquipmentSlot, ItemStack> enumMap = new EnumMap<>(LobeCorpEquipmentSlot.class);
        for (LobeCorpEquipmentSlot slot : LobeCorpEquipmentSlot.values()) {
            ItemStack oldItemStack = getOrCreateStacks(serverPlayer.getUuid()).getOrDefault(slot, ItemStack.EMPTY);
            ItemStack newItemStack = LobeCorpUtil.getLobeCorpEquippedStack(serverPlayer, slot);
            enumMap.put(slot, newItemStack);
            AttributeContainer attributeContainer = serverPlayer.getAttributes();
            if (!oldItemStack.isEmpty()) {
                LobeCorpUtil.applyAttributeModifiers(slot, oldItemStack, (attribute, modifier) -> {
                    EntityAttributeInstance instance = attributeContainer.getCustomInstance(attribute);
                    if (instance != null) {
                        instance.removeModifier(modifier);
                    }
                });
            }
            if (newItemStack.isEmpty()) continue;
            LobeCorpUtil.applyAttributeModifiers(slot, newItemStack, (attribute, modifier) -> {
                EntityAttributeInstance instance = attributeContainer.getCustomInstance(attribute);
                if (instance != null) {
                    instance.removeModifier(modifier);
                    instance.addTemporaryModifier(modifier);
                }
            });
        }
        return enumMap;
    }

    //获取或创建装备
    private static Map<LobeCorpEquipmentSlot, ItemStack> getOrCreateStacks(UUID playerId) {
        return syncedLobeCorpStacks.computeIfAbsent(playerId, k -> new EnumMap<>(LobeCorpEquipmentSlot.class));
    }

    public static void remove(ServerPlayerEntity serverPlayer) {
        syncedLobeCorpStacks.remove(serverPlayer.getUuid());
    }
}
