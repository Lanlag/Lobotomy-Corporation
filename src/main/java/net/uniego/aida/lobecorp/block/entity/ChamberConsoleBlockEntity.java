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
import org.jetbrains.annotations.Nullable;

public class ChamberConsoleBlockEntity extends AbstractSignalReceiverBlockEntity implements NamedScreenHandlerFactory {
    private static final int search_range = 10;
    public ChamberConsoleBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.CHAMBER_CONSOLE, pos, state);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }

//    public static void tick(World world, BlockPos pos, BlockState state, ChamberConsoleBlockEntity be) {
//        be.checkAb(world,pos);
//    }

//    public void checkAb(World world,BlockPos pos){
//        if (abnormality_id == -1){
//            Box search_box = Box.of(pos.toCenterPos(),search_range,search_range,search_range);
//            abnormality = world.getClosestEntity(world.getEntitiesByClass(AbnormalityEntity.class, search_box, (livingEntity) -> true), TargetPredicate.DEFAULT, null, pos.getX(), pos.getY(), pos.getZ());
//            if (abnormality != null) {
//                abnormality_id = abnormality.getId();
//            }
//        } else if (abnormality == null || abnormality.isRemoved()){
//            if (world.getEntityById(abnormality_id) instanceof AbnormalityEntity ab){
//                this.abnormality = ab;
//            } else {
//                abnormality_id = -1;
//            }
//        }
//    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        if (getWorld() instanceof ServerWorld world1) {
            setSignalSourcePos(findSignalSource(world));
            if(getSignalSourcePos() != null){
                BlockEntity be = world1.getBlockEntity(getSignalSourcePos());
                if (be instanceof ContainerBoxBlockEntity containerBox){
                    Entity entity = world1.getEntity(containerBox.getAbnormalityUuid());
                    if (entity instanceof AbnormalityEntity abnormality){
                        return new WorkScreenHandler(syncId, player, abnormality);
                    }
                }
            }
        }
        return null;
    }
}
