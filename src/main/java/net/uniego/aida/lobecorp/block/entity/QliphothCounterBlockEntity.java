package net.uniego.aida.lobecorp.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.entity.abnormality.AbnormalityEntity;
import net.uniego.aida.lobecorp.init.BlockEntityInit;
import net.uniego.aida.lobecorp.block.state.property.LobeCorpProperties;
import org.jetbrains.annotations.Nullable;

public class QliphothCounterBlockEntity extends AbstractSignalReceiverBlockEntity {
    private int qliphoth_count;

    public QliphothCounterBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.QLIPHOTH_COUNTER, pos, state);
    }

    public static void serverTick(World world, BlockPos pos, BlockState state, QliphothCounterBlockEntity counter) {
        counter.setSignalSourcePos(counter.findSignalSource(world));
        counter.updateCounter((ServerWorld)world,pos,state);
    }

    public void updateCounter(ServerWorld world, BlockPos pos,BlockState state){
        setQliphothCount(0);
        if(getSignalSourcePos() != null){
            BlockEntity be = world.getBlockEntity(getSignalSourcePos());
            if (be instanceof ContainerBoxBlockEntity containerBox){
                Entity entity = world.getEntity(containerBox.getAbnormalityUuid());
                if(entity instanceof AbnormalityEntity abnormality){
                    setQliphothCount(abnormality.getQliphothCounter() + 1);
                }
            }
        }
        world.setBlockState(pos,state.with(LobeCorpProperties.QLIPHOTH_COUNT,getQliphothCount()));
    }

    public void setQliphothCount(int qliphothCount){
        this.qliphoth_count = qliphothCount;
    }

    public int getQliphothCount(){
        return this.qliphoth_count;
    }

    @Override
    public void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup wrapper) {
        nbt.putInt("qliphothCount", qliphoth_count);
        super.writeNbt(nbt, wrapper);
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup wrapper) {
        super.readNbt(nbt, wrapper);
        qliphoth_count = nbt.getInt("qliphothCount");
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }
}
