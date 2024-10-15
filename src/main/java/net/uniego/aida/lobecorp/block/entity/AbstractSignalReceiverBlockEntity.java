package net.uniego.aida.lobecorp.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.access.SignalSourceAccess;
import net.uniego.aida.lobecorp.init.TagInit;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSignalReceiverBlockEntity extends BlockEntity {
    protected BlockPos signalSourcePos;

    protected AbstractSignalReceiverBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    protected void setSignalSourcePos(BlockPos signalSourcePos) {
        this.signalSourcePos = signalSourcePos;
    }

    protected BlockPos getSignalSourcePos() {
        return signalSourcePos;
    }

    protected BlockPos findSignalSource(World world){
        List<BlockPos> checked_centers = new ArrayList<>();
        List<BlockPos> checking_centers = new ArrayList<>();
        List<BlockPos> new_centers = new ArrayList<>();
        List<BlockPos> sources = new ArrayList<>();
        new_centers.add(getPos());
        while (!new_centers.isEmpty()){
            checking_centers.addAll(new_centers);
            new_centers.clear();
            for (BlockPos center : checking_centers){
                for (Direction dir : Direction.values()) {
                    BlockPos check_pos = center.offset(dir);
                    if (world.getBlockEntity(check_pos) instanceof SignalSourceAccess) {
                        if(!sources.contains(check_pos)){
                            sources.add(check_pos);
                        }
                    } else if (world.getBlockState(check_pos).isIn(TagInit.SIGNAL_WIRE)) {
                        if(!checked_centers.contains(check_pos)){
                            new_centers.add(check_pos);
                        }
                    }
                }
            }
            checked_centers.addAll(checking_centers);
            checking_centers.clear();
        }
        if (sources.size() == 1){
            return sources.getFirst();
        }
        return null;
    }
}
