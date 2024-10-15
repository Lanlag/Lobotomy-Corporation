package net.uniego.aida.lobecorp.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.block.entity.QliphothCounterBlockEntity;
import net.uniego.aida.lobecorp.init.BlockEntityInit;
import net.uniego.aida.lobecorp.block.state.property.LobeCorpProperties;
import net.uniego.aida.lobecorp.util.BlockUtil;
import org.jetbrains.annotations.Nullable;

public class QliphothCounterBlock extends BlockWithEntity {
    public static final MapCodec<QliphothCounterBlock> CODEC = createCodec(QliphothCounterBlock::new);
    public static final DirectionProperty FACING;
    public static final IntProperty COUNT;

    private static final VoxelShape NORTH_SHAPE;
    private static final VoxelShape SOUTH_SHAPE;
    private static final VoxelShape EAST_SHAPE;
    private static final VoxelShape WEST_SHAPE;

    public QliphothCounterBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
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
        builder.add(FACING,COUNT);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    static {
        FACING = HorizontalFacingBlock.FACING;
        COUNT = LobeCorpProperties.QLIPHOTH_COUNT;
        NORTH_SHAPE = BlockUtil.createBBCuboidShape(2,3.0,13.0,12.0,12.0,3.0);
        SOUTH_SHAPE = BlockUtil.rotateShapeHorizontal(Direction.SOUTH,NORTH_SHAPE);
        EAST_SHAPE = BlockUtil.rotateShapeHorizontal(Direction.EAST,NORTH_SHAPE);
        WEST_SHAPE = BlockUtil.rotateShapeHorizontal(Direction.WEST,NORTH_SHAPE);
    }



    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new QliphothCounterBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return (world instanceof ServerWorld) ? validateTicker(type, BlockEntityInit.QLIPHOTH_COUNTER, QliphothCounterBlockEntity::serverTick) : null;
    }
}
