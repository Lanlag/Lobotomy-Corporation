package net.uniego.aida.lobecorp.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.block.entity.ChamberConsoleBlockEntity;
import net.uniego.aida.lobecorp.util.BlockUtil;

public class ChamberConsoleBlock extends BlockWithEntity {
    public static final MapCodec<ChamberConsoleBlock> CODEC = createCodec(ChamberConsoleBlock::new);
    public static final DirectionProperty FACING;

    private static final VoxelShape BASE_SHAPE;
    private static final VoxelShape BASE_SHAPE_2;
    private static final VoxelShape BASE_SHAPE_3;
    private static final VoxelShape BASE_SHAPE_4;
    private static final VoxelShape NORTH_SHAPE;
    private static final VoxelShape SOUTH_SHAPE;
    private static final VoxelShape EAST_SHAPE;
    private static final VoxelShape WEST_SHAPE;

    public ChamberConsoleBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ChamberConsoleBlockEntity(pos,state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);

            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }
        return ActionResult.SUCCESS;
    }

    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case SOUTH -> {
                return SOUTH_SHAPE;
            }
            case EAST -> {
                return EAST_SHAPE;
            }
            case WEST -> {
                return WEST_SHAPE;
            }
            default -> {
                return NORTH_SHAPE;
            }
        }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

//    @Override
//    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
//        return validateTicker(type, BlockEntityInit.CHAMBER_CONSOLE, ChamberConsoleBlockEntity::tick);
//    }

    static {
        FACING = HorizontalFacingBlock.FACING;
        BASE_SHAPE = BlockUtil.createBBCuboidShape(-6.0,0.0,-2.0,28.0,16.0,20.0);
        BASE_SHAPE_2 = BlockUtil.createBBCuboidShape(-6.0,16.0,17.0,28.0,2.0,1.0);
        BASE_SHAPE_3 = BlockUtil.createBBCuboidShape(-6.0,16.0,3.0,1.0,2.0,14.0);
        BASE_SHAPE_4 = BlockUtil.createBBCuboidShape(21.0,16.0,3.0,1.0,2.0,14.0);
        NORTH_SHAPE = VoxelShapes.union(BASE_SHAPE,BASE_SHAPE_2,BASE_SHAPE_3,BASE_SHAPE_4);
        SOUTH_SHAPE = BlockUtil.rotateShapeHorizontal(Direction.SOUTH,NORTH_SHAPE);
        EAST_SHAPE = BlockUtil.rotateShapeHorizontal(Direction.EAST,NORTH_SHAPE);
        WEST_SHAPE = BlockUtil.rotateShapeHorizontal(Direction.WEST,NORTH_SHAPE);
    }
}
