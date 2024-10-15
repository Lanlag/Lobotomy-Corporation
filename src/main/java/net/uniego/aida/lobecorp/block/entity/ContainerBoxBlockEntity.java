package net.uniego.aida.lobecorp.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.access.SignalSourceAccess;
import net.uniego.aida.lobecorp.entity.abnormality.AbnormalityEntity;
import net.uniego.aida.lobecorp.init.BlockEntityInit;

import java.util.Optional;
import java.util.UUID;

public class ContainerBoxBlockEntity extends BlockEntity implements SignalSourceAccess {
    private EntityType<?> abnormalityType;
    private UUID abnormalityUuid;
    private Direction direction;
    private int uBox;

    public ContainerBoxBlockEntity(BlockPos pos, BlockState state, EntityType<?> abnormalityType,Direction direction) {
        this(pos,state);
        this.abnormalityType = abnormalityType;
        this.direction = direction;
    }

    public ContainerBoxBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.CONTAINER_BOX, pos, state);
    }

    public UUID getAbnormalityUuid() {
        return abnormalityUuid;
    }

    public void setAbnormalityUuid(UUID abnormalityUuid) {
        this.abnormalityUuid = abnormalityUuid;
    }

    public void setUBox(int peBox) {
        this.uBox += peBox;
        this.uBox = Math.max(0, Math.min(this.uBox, 999));
    }

    public int getUBox() {
        return uBox;
    }

    public void spawnAbnormality(ServerWorld world, BlockPos pos){
        if (abnormalityType != null){
            AbnormalityEntity abnormality = (AbnormalityEntity) abnormalityType.spawn(world, pos.up(), SpawnReason.SPAWN_EGG);
            if (abnormality != null) {
                float rotation = direction.getOpposite().asRotation();
                abnormality.setYaw(rotation);
                abnormality.setBodyYaw(rotation);
                abnormality.setHeadYaw(rotation);
                abnormality.setContainerBox(this);
                setAbnormalityUuid(abnormality.getUuid());
                markDirty();
            }
        }
    }

    @Override
    public void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup wrapper) {
        super.writeNbt(nbt, wrapper);
        nbt.putString("abnormalityType", EntityType.getId(abnormalityType).toString());
        if(getAbnormalityUuid() != null){
            nbt.putUuid("abnormalityUuid", getAbnormalityUuid());
        }
        nbt.putInt("direction", direction.getId());
        nbt.putInt("uBox", getUBox());
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup wrapper) {
        super.readNbt(nbt, wrapper);
        Optional<EntityType<?>> optional = EntityType.get(nbt.getString("abnormalityType"));
        optional.ifPresent(entityType -> this.abnormalityType = entityType);
        setAbnormalityUuid(nbt.getUuid("abnormalityUuid"));
        this.direction = Direction.byId(nbt.getInt("direction"));
        this.uBox = nbt.getInt("uBox");
    }


    public static void tick(World world, BlockPos pos, BlockState state, ContainerBoxBlockEntity be) {
        if(world instanceof ServerWorld world1 && world1.getDifficulty() != Difficulty.PEACEFUL){
            if (be.getAbnormalityUuid() == null || !(world1.getEntity(be.getAbnormalityUuid()) instanceof AbnormalityEntity)){
                be.spawnAbnormality(world1,pos);
            }
        }
    }
}