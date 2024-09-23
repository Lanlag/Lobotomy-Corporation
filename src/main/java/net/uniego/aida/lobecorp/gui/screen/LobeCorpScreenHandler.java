package net.uniego.aida.lobecorp.gui.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.uniego.aida.lobecorp.init.ScreenInit;

//脑叶公司屏幕处理器
public class LobeCorpScreenHandler extends ScreenHandler {
    public LobeCorpScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(ScreenInit.LOBECORP_SCREEN_HANDLER, syncId);
        //三排背包和一排快捷栏
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                addSlot(new Slot(playerInventory, j + (i + 1) * 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int i = 0; i < 9; ++i) {
            addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot invSlot = slots.get(slot);
        if (invSlot.hasStack()) {
            ItemStack slotStack = invSlot.getStack();
            newStack = slotStack.copy();
            if (slot >= 0 && slot < 27) {
                if (!insertItem(slotStack, 27, 36, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (slot >= 27 && slot < 36) {
                if (!insertItem(slotStack, 0, 27, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!insertItem(slotStack, 0, 36, false)) {
                return ItemStack.EMPTY;
            }
            if (slotStack.isEmpty()) invSlot.setStack(ItemStack.EMPTY);
            else invSlot.markDirty();
            if (slotStack.getCount() == newStack.getCount()) return ItemStack.EMPTY;
            invSlot.onTakeItem(player, slotStack);
        }
        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}
