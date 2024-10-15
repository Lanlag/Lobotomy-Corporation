package net.uniego.aida.lobecorp.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.block.entity.ContainerBoxBlockEntity;
import net.uniego.aida.lobecorp.init.BlockEntityInit;
import org.jetbrains.annotations.Nullable;

public class ContainerBoxBlock extends BlockWithEntity {
    public static final MapCodec<ContainerBoxBlock> CODEC = createCodec(ContainerBoxBlock::new);
    private EntityType<?> abnormalityType;

    public ContainerBoxBlock(Settings settings, EntityType<?> abnormality) {
        this(settings);
        this.abnormalityType = abnormality;
    }

    public ContainerBoxBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ContainerBoxBlockEntity(pos,state,abnormalityType);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, BlockEntityInit.CONTAINER_BOX, ContainerBoxBlockEntity::tick);
    }
}
