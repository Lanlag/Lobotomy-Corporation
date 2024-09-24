package net.uniego.aida.lobecorp.mixin;

import com.google.common.collect.ImmutableList;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(PlayerInventory.class)
public abstract class PlayerInventoryMixin {
    @Unique
    private static final int LOBECORP_SLOT_COUNT = 40;//脑叶公司插槽数
    @Shadow
    @Final
    public PlayerEntity player;
    @Mutable
    @Shadow
    @Final
    private List<DefaultedList<ItemStack>> combinedInventory;
    @Unique
    private List<DefaultedList<ItemStack>> lobecorpSlots;

    //将脑叶公司插槽合并进玩家原本的槽位
    @Inject(method = "<init>", at = @At("TAIL"))
    private void initMixin(PlayerEntity player, CallbackInfo ci) {
        lobecorpSlots = new ArrayList<>();
        for (int i = 0; i < LOBECORP_SLOT_COUNT; i++) {
            lobecorpSlots.add(DefaultedList.ofSize(1, ItemStack.EMPTY));
        }
        combinedInventory = new ArrayList<>(combinedInventory);
        combinedInventory.addAll(lobecorpSlots);
        combinedInventory = ImmutableList.copyOf(combinedInventory);
    }

    @Inject(method = "writeNbt", at = @At("TAIL"))
    private void writeNbtMixin(NbtList nbtList, CallbackInfoReturnable<NbtList> cir) {
        for (int i = 0; i < LOBECORP_SLOT_COUNT; i++) {
            DefaultedList<ItemStack> itemStacks = lobecorpSlots.get(i);
            if (!itemStacks.getFirst().isEmpty()) {
                NbtCompound nbtCompound = new NbtCompound();
                nbtCompound.putByte("Slot", (byte) (i + 200));
                nbtList.add(itemStacks.getFirst().encode(player.getRegistryManager(), nbtCompound));
            }
        }
    }

    @Inject(method = "readNbt", at = @At("TAIL"))
    private void readNbtMixin(NbtList nbtList, CallbackInfo ci) {
        for (DefaultedList<ItemStack> lobecorpSlot : lobecorpSlots) {
            lobecorpSlot.clear();
        }
        for (int i = 0; i < nbtList.size(); i++) {
            NbtCompound nbtCompound = nbtList.getCompound(i);
            int slot = nbtCompound.getByte("Slot") & 255;
            ItemStack itemStack = ItemStack.fromNbt(player.getRegistryManager(), nbtCompound).orElse(ItemStack.EMPTY);
            if (!itemStack.isEmpty() && slot >= 200 && slot < 200 + LOBECORP_SLOT_COUNT) {
                lobecorpSlots.get(slot - 200).set(0, itemStack);
            }
        }
    }

    @Inject(method = "size", at = @At("HEAD"), cancellable = true)
    private void sizeMixin(CallbackInfoReturnable<Integer> cir) {
        int size = combinedInventory.stream().mapToInt(List::size).sum();
        cir.setReturnValue(size);
    }

    @Inject(method = "isEmpty", at = @At("HEAD"), cancellable = true)
    private void isEmptyMixin(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(combinedInventory.stream().allMatch(DefaultedList::isEmpty));
    }
}
