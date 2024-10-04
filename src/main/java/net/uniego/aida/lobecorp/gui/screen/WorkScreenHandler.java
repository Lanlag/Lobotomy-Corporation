package net.uniego.aida.lobecorp.gui.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.uniego.aida.lobecorp.access.ServerPlayerAccess;
import net.uniego.aida.lobecorp.entity.abnormality.AbnormalityEntity;
import net.uniego.aida.lobecorp.init.ScreenInit;

//工作屏幕处理器
public class WorkScreenHandler extends ScreenHandler {
    public AbnormalityEntity abnormality;

    public WorkScreenHandler(int syncId, PlayerEntity player, AbnormalityEntity abnormality) {
        this(syncId, player.getInventory());
        ((ServerPlayerAccess) player).lobecorp$openWorkScreenHandler();
        this.abnormality = abnormality;
    }

    public WorkScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(ScreenInit.WORK_SCREEN_HANDLER, syncId);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return null;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }

    @Override
    public void onClosed(PlayerEntity player) {
        if (abnormality != null) abnormality.interactPlayer = null;
        super.onClosed(player);
    }
}
