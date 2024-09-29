package net.uniego.aida.lobecorp.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.init.EntityInit;

import java.util.Optional;
import java.util.UUID;

//玩家尸体
public class DeadPlayerEntity extends Entity {
    private static final TrackedData<Optional<UUID>> PLAYER_UUID = DataTracker.registerData(DeadPlayerEntity.class, TrackedDataHandlerRegistry.OPTIONAL_UUID);
    private int timeFalling;
    private boolean hasPlayedSound;

    public DeadPlayerEntity(EntityType<?> type, World world) {
        super(type, world);
    }

    public static void create(ServerPlayerEntity serverPlayer) {
        DeadPlayerEntity deadPlayer = new DeadPlayerEntity(EntityInit.DEAD_PLAYER_ENTITY, serverPlayer.getWorld());
        deadPlayer.setPos(serverPlayer.getX(), serverPlayer.getY(), serverPlayer.getZ());
        deadPlayer.setRotation(0, -25);//yaw是水平，pitch是垂直
        deadPlayer.setPlayerUuid(serverPlayer.getUuid());
        deadPlayer.resetPosition();
        deadPlayer.refreshPosition();
        serverPlayer.getWorld().spawnEntity(deadPlayer);
    }

    public Optional<UUID> getPlayerUuid() {
        return dataTracker.get(PLAYER_UUID);
    }

    public void setPlayerUuid(UUID playerUuid) {
        dataTracker.set(PLAYER_UUID, Optional.of(playerUuid));
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        builder.add(PLAYER_UUID, Optional.empty());
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        setPlayerUuid(nbt.getUuid("PlayerUuid"));
        timeFalling = nbt.getInt("TimeFalling");
        hasPlayedSound = nbt.getBoolean("HasPlayedSound");
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
        if (getPlayerUuid().isPresent()) {
            nbt.putUuid("PlayerUuid", getPlayerUuid().get());
            nbt.putInt("TimeFalling", timeFalling);
            nbt.putBoolean("HasPlayedSound", hasPlayedSound);
        }
    }

    @Override
    public boolean canHit() {
        return true;
    }

    @Override
    protected Box calculateBoundingBox() {
        Box box = super.calculateBoundingBox();
        return new Box(box.minX, box.minY, box.minZ, box.maxX, box.maxY, box.maxZ).expand(0.6, 0.0, 0.2);
    }

    @Override
    protected double getGravity() {
        return 0.08;
    }

    @Override
    public void tick() {
        ++timeFalling;
        applyGravity();
        move(MovementType.SELF, getVelocity());
        if (!getWorld().isClient) {
            BlockPos blockPos = getBlockPos();
            if (!isOnGround()) {
                if (timeFalling > 100 && (blockPos.getY() <= getWorld().getBottomY() || blockPos.getY() > getWorld().getTopY()) || timeFalling > 600) {
                    discard();
                }
                hasPlayedSound = false;
            } else {
                if (!hasPlayedSound) {
                    PlayerEntity player = getWorld().getClosestPlayer(this, 10);
                    if (player != null) {
                        LobeCorpUtil.playSound(player, SoundEvents.ENTITY_PLAYER_BIG_FALL);
                    }
                    hasPlayedSound = true;
                }
                setVelocity(getVelocity().multiply(0.7, -0.5, 0.7));
            }
        }
        setVelocity(getVelocity().multiply(0.98));
    }

    @Override
    protected void fall(double heightDifference, boolean onGround, BlockState state, BlockPos landedPosition) {
        if (!getWorld().isClient && onGround && fallDistance > 0.0F) {
            double safeFallDistance = 3;
            if ((double) fallDistance > safeFallDistance && !state.isAir()) {
                double e = getX();
                double f = getY();
                double g = getZ();
                BlockPos blockPos = getBlockPos();
                if (landedPosition.getX() != blockPos.getX() || landedPosition.getZ() != blockPos.getZ()) {
                    double h = e - (double) landedPosition.getX() - 0.5;
                    double i = g - (double) landedPosition.getZ() - 0.5;
                    double j = Math.max(Math.abs(h), Math.abs(i));
                    e = (double) landedPosition.getX() + 0.5 + h / j * 0.5;
                    g = (double) landedPosition.getZ() + 0.5 + i / j * 0.5;
                }

                float k = (float) MathHelper.ceil((double) fallDistance - safeFallDistance);
                double l = Math.min(0.2F + k / 15.0F, 2.5);
                int m = (int) (150.0 * l);
                ((ServerWorld) getWorld()).spawnParticles(new BlockStateParticleEffect(ParticleTypes.BLOCK, state), e, f, g, m,
                        0.0, 0.0, 0.0, 0.15000000596046448);
            }
        }
        super.fall(heightDifference, onGround, state, landedPosition);
    }
}
