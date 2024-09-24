package net.uniego.aida.lobecorp.gui.screen;

import com.mojang.datafixers.util.Pair;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.Identifier;
import net.uniego.aida.lobecorp.gui.GUIResource;
import net.uniego.aida.lobecorp.init.ScreenInit;
import net.uniego.aida.lobecorp.slot.LobeCorpSlot;
import org.jetbrains.annotations.NotNull;

import java.util.List;

//脑叶公司屏幕处理器
public class LobeCorpScreenHandler extends ScreenHandler {
    private static final List<SlotFactory> SLOT_FACTORIES = List.of(
            new SlotFactory(GUIResource.EMPTY_EGO_WEAPON_TEXTURE, 63, 62, 62),
            new SlotFactory(GUIResource.EMPTY_EGO_SUIT_TEXTURE, 64, 62, 44),
            new SlotFactory(GUIResource.EMPTY_EGO_BADGE_TEXTURE, 65, 62, 26),
            new SlotFactory(GUIResource.EMPTY_EGO_TOOL_TEXTURE, 66, 62, 8),
            new SlotFactory(GUIResource.EMPTY_EGO_HAT_TEXTURE, 67, -24, 11),
            new SlotFactory(GUIResource.EMPTY_EGO_HEAD_TEXTURE, 68, -24, 29),
            new SlotFactory(GUIResource.EMPTY_EGO_OCCIPUT_TEXTURE, 69, -24, 47),
            new SlotFactory(GUIResource.EMPTY_EGO_EYE_TEXTURE, 70, -24, 65),
            new SlotFactory(GUIResource.EMPTY_EGO_FACE_TEXTURE, 71, -24, 83),
            new SlotFactory(GUIResource.EMPTY_EGO_CHEEK_TEXTURE, 72, -24, 101),
            new SlotFactory(GUIResource.EMPTY_EGO_MASK_TEXTURE, 73, -24, 119),
            new SlotFactory(GUIResource.EMPTY_EGO_MOUTH_TEXTURE, 74, -24, 137),
            new SlotFactory(GUIResource.EMPTY_EGO_NECK_TEXTURE, 75, -24, 155),
            new SlotFactory(GUIResource.EMPTY_EGO_CHEST_TEXTURE, 76, -24, 173),
            new SlotFactory(GUIResource.EMPTY_EGO_HAND_TEXTURE, 77, -24, 191),
            new SlotFactory(GUIResource.EMPTY_EGO_GLOVE_TEXTURE, 78, -24, 209),
            new SlotFactory(GUIResource.EMPTY_EGO_RIGHTBACK_TEXTURE, 79, -24, 227),
            new SlotFactory(GUIResource.EMPTY_EGO_LEFTBACK_TEXTURE, 80, -24, 245)
    );

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
        //脑叶公司插槽
        for (SlotFactory slotFactory : SLOT_FACTORIES) {
            addSlot(new LobeCorpSlot(playerInventory, slotFactory.slotIndex, slotFactory.x, slotFactory.y) {
                @Override
                public int getMaxItemCount() {
                    return 1;
                }

                @Override
                public boolean canInsert(ItemStack stack) {
                    return true;
                }

                @Override
                public boolean canTakeItems(PlayerEntity playerEntity) {
                    return true;
                }

                @Environment(EnvType.CLIENT)
                @Override
                public @NotNull Pair<Identifier, Identifier> getBackgroundSprite() {
                    return Pair.of(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE, slotFactory.textureId);
                }
            });
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

    //脑叶公司插槽工厂
    private record SlotFactory(Identifier textureId, int slotIndex, int x, int y) {
    }
}
