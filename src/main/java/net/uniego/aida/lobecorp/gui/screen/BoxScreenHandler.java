package net.uniego.aida.lobecorp.gui.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.uniego.aida.lobecorp.access.ServerPlayerAccess;
import net.uniego.aida.lobecorp.entity.abnormality.AbnormalityEntity;
import net.uniego.aida.lobecorp.init.ScreenInit;

//盒子屏幕处理器
public class BoxScreenHandler extends ScreenHandler {
    public AbnormalityEntity abnormality;

    public BoxScreenHandler(int syncId, PlayerEntity player, AbnormalityEntity abnormality) {
        this(syncId, player.getInventory());
        ((ServerPlayerAccess) player).lobecorp$openBoxScreenHandler();
        this.abnormality = abnormality;
    }

    public BoxScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(ScreenInit.BOX_SCREEN_HANDLER, syncId);
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
        if (abnormality != null) {
            //结算操作
            abnormality.setWorkResult(abnormality.getPeBox());
            abnormality.setUBox(abnormality.uBox + abnormality.getPeBox());
            //记录操作
            abnormality.setLastWorkPlayer(abnormality.workPlayer);
            abnormality.setLastWorkMethod(abnormality.workMethod);
            abnormality.setLastWorkLevel(abnormality.workLevel);
            abnormality.setLastWorkResult(abnormality.workResult);
            abnormality.setLastPeBox(abnormality.getPeBox());
            abnormality.setLastNeBox(abnormality.getNeBox());
            //重置操作
            abnormality.workPlayer = null;
            abnormality.workMethod = null;
            abnormality.workLevel = 0;
            abnormality.workResult = null;
            abnormality.setPeBox(0);
            abnormality.setNeBox(0);
            abnormality.workDurationTime = 0;
            abnormality.probability = 0;
            abnormality.extraProbability = 0;
            abnormality.setWorking(false);
            abnormality.isApplied = false;
            abnormality.setCooling(true);
        }
        super.onClosed(player);
    }
}
