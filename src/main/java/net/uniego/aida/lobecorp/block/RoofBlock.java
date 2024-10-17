package net.uniego.aida.lobecorp.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.uniego.aida.lobecorp.util.BlockUtil;

public class RoofBlock extends Block {

    private static final VoxelShape BASE_SHAPE = BlockUtil.createBBCuboidShape(0,1,0,16,15,16);

    public RoofBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BASE_SHAPE;
    }
}
