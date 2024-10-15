package net.uniego.aida.lobecorp.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.uniego.aida.lobecorp.entity.abnormality.AbnormalityEntity;
import net.uniego.aida.lobecorp.gui.screen.WorkScreenHandler;
import net.uniego.aida.lobecorp.init.BlockEntityInit;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;
import org.jetbrains.annotations.Nullable;

public class ChamberConsoleBlockEntity extends AbstractSignalReceiverBlockEntity implements NamedScreenHandlerFactory {
    public ChamberConsoleBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.CHAMBER_CONSOLE, pos, state);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        if (getWorld() instanceof ServerWorld world1) {
            setSignalSourcePos(findSignalSource(world));
            if(getSignalSourcePos() != null){
                BlockEntity be = world1.getBlockEntity(getSignalSourcePos());
                if (be instanceof ContainerBoxBlockEntity containerBox){
                    Entity entity = world1.getEntity(containerBox.getAbnormalityUuid());
                    if (player.squaredDistanceTo(entity) <= LobeCorpUtil.MAX_INTERACT_ABNORMALITY_DISTANCE){
                        if (entity instanceof AbnormalityEntity abnormality){
                            return new WorkScreenHandler(syncId, player, abnormality);
                        }
                    }
                }
            }
        }
        return null;
    }
}
