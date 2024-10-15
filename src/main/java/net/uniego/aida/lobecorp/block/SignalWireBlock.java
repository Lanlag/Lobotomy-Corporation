package net.uniego.aida.lobecorp.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.uniego.aida.lobecorp.access.SignalSourceAccess;
import net.uniego.aida.lobecorp.block.entity.AbstractSignalReceiverBlockEntity;
import net.uniego.aida.lobecorp.block.state.property.LobeCorpProperties;
import net.uniego.aida.lobecorp.init.TagInit;
import net.uniego.aida.lobecorp.util.BlockUtil;

import java.util.*;

public class SignalWireBlock extends Block {
    public static final MapCodec<SignalWireBlock> CODEC = createCodec(SignalWireBlock::new);
    public static final BooleanProperty NORTH;
    public static final BooleanProperty EAST;
    public static final BooleanProperty SOUTH;
    public static final BooleanProperty WEST;
    public static final BooleanProperty UP;
    public static final BooleanProperty DOWN;
    public static final BooleanProperty SHOW_CENTER;
    public static final Map<Direction,BooleanProperty> DIRECTION_PROPERTY;
    public static final Map<Direction,VoxelShape> DIRECTION_SHAPE;
    protected static final VoxelShape CENTER_SHAPE;
    protected static final VoxelShape NORTH_SIDE_SHAPE;
    protected static final VoxelShape SOUTH_SIDE_SHAPE;
    protected static final VoxelShape WEST_SIDE_SHAPE;
    protected static final VoxelShape EAST_SIDE_SHAPE;
    protected static final VoxelShape UP_SIDE_SHAPE;
    protected static final VoxelShape DOWN_SIDE_SHAPE;


    public SignalWireBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends Block> getCodec() {
        return CODEC;
    }

    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape shape = VoxelShapes.empty();
        for(Direction dir : Direction.values()){
            if(state.get(DIRECTION_PROPERTY.get(dir))){
                shape = VoxelShapes.union(shape,DIRECTION_SHAPE.get(dir));
            }
        }
        if(state.get(SHOW_CENTER)){
            shape = VoxelShapes.union(shape,CENTER_SHAPE);
        }
        return shape;
    }

    public boolean canConnect(BlockView world, BlockPos pos) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        BlockState state = world.getBlockState(pos);
        return blockEntity instanceof SignalSourceAccess
                || blockEntity instanceof AbstractSignalReceiverBlockEntity
                || state.isIn(TagInit.SIGNAL_WIRE);
    }

    public BlockState shouldShowCenter(BlockState state){
        List<Direction> connections = new ArrayList<>();
        for(Direction dir : Direction.values()){
            if(state.get(DIRECTION_PROPERTY.get(dir))){
                connections.add(dir);
            }
        }
        if (connections.size() == 2 && connections.getFirst() == connections.getLast().getOpposite()){
            return state.with(SHOW_CENTER,false);
        }
        return state.with(SHOW_CENTER,true);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockView world = ctx.getWorld();
        BlockPos pos = ctx.getBlockPos();
        BlockState state = Objects.requireNonNull(super.getPlacementState(ctx))
                .with(NORTH,canConnect(world,pos.offset(Direction.SOUTH)))
                .with(EAST,canConnect(world,pos.offset(Direction.WEST)))
                .with(SOUTH,canConnect(world,pos.offset(Direction.NORTH)))
                .with(WEST,canConnect(world,pos.offset(Direction.EAST)))
                .with(UP,canConnect(world,pos.offset(Direction.DOWN)))
                .with(DOWN,canConnect(world,pos.offset(Direction.UP)));
        return shouldShowCenter(state);
    }

    protected BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        BlockState state1 = state
                .with(DIRECTION_PROPERTY.get(direction),canConnect(world,neighborPos));
        return shouldShowCenter(state1);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, WEST, SOUTH, UP,DOWN,SHOW_CENTER);
    }

    static {
        NORTH = Properties.NORTH;
        EAST = Properties.EAST;
        SOUTH = Properties.SOUTH;
        WEST = Properties.WEST;
        UP = Properties.UP;
        DOWN = Properties.DOWN;
        SHOW_CENTER = LobeCorpProperties.SHOW_CENTER;
        DIRECTION_PROPERTY = new HashMap<>();
        DIRECTION_PROPERTY.put(Direction.SOUTH,NORTH);
        DIRECTION_PROPERTY.put(Direction.NORTH,SOUTH);
        DIRECTION_PROPERTY.put(Direction.EAST,WEST);
        DIRECTION_PROPERTY.put(Direction.WEST,EAST);
        DIRECTION_PROPERTY.put(Direction.UP,DOWN);
        DIRECTION_PROPERTY.put(Direction.DOWN,UP);
        CENTER_SHAPE = BlockUtil.createBBCuboidShape(6,6,6,4,4,4);
        NORTH_SIDE_SHAPE = BlockUtil.createBBCuboidShape(6.5,6.5,8,3,3,8);
        SOUTH_SIDE_SHAPE = BlockUtil.rotateShapeHorizontal(Direction.SOUTH,NORTH_SIDE_SHAPE);
        WEST_SIDE_SHAPE = BlockUtil.rotateShapeHorizontal(Direction.WEST,NORTH_SIDE_SHAPE);
        EAST_SIDE_SHAPE = BlockUtil.rotateShapeHorizontal(Direction.EAST,NORTH_SIDE_SHAPE);
        UP_SIDE_SHAPE = BlockUtil.createBBCuboidShape(6.5,8,6.5,3,8,3);
        DOWN_SIDE_SHAPE = BlockUtil.createBBCuboidShape(6.5,0,6.5,3,8,3);
        DIRECTION_SHAPE = new HashMap<>();
        DIRECTION_SHAPE.put(Direction.NORTH,SOUTH_SIDE_SHAPE);
        DIRECTION_SHAPE.put(Direction.SOUTH,NORTH_SIDE_SHAPE);
        DIRECTION_SHAPE.put(Direction.EAST,WEST_SIDE_SHAPE);
        DIRECTION_SHAPE.put(Direction.WEST,EAST_SIDE_SHAPE);
        DIRECTION_SHAPE.put(Direction.UP,UP_SIDE_SHAPE);
        DIRECTION_SHAPE.put(Direction.DOWN,DOWN_SIDE_SHAPE);
    }
}
