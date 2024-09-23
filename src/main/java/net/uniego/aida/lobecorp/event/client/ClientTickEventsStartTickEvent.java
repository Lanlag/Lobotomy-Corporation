package net.uniego.aida.lobecorp.event.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.network.packet.DrinkWaterPacket;
import net.uniego.aida.lobecorp.network.payload.DrinkWaterPayload;

//客户端每一帧开始时事件
@Environment(EnvType.CLIENT)
public class ClientTickEventsStartTickEvent implements ClientTickEvents.StartTick {
    private PlayerEntity player;
    private World world;
    private BlockPos pos;

    @Override
    public void onStartTick(MinecraftClient client) {
        if (client.player != null && client.world != null) {
            if (client.options.useKey.wasPressed()) {
                player = client.player;
                world = client.world;
                checkDrink();
            }
        }
    }

    //检查饮水事件
    private void checkDrink() {
        //设置玩家饮水极限距离为1.5
        HitResult result = player.raycast(1.5F, 0.0F, true);
        pos = ((BlockHitResult) result).getBlockPos();
        //当玩家不为观察模式且下蹲时且主手为空
        if (!player.isSpectator() && player.isSneaking() && player.getActiveHand() == Hand.MAIN_HAND && player.getMainHandStack().isEmpty()) {
            if (canDrinkStream()) {
                DrinkWaterPacket.send(DrinkWaterPayload.STREAM);
            } else if (canDrinkRain()) {
                DrinkWaterPacket.send(DrinkWaterPayload.RAIN);
            } else if (canDrinkCauldron()) {
                DrinkWaterPacket.send(DrinkWaterPayload.CAULDRON);
            }
        }
    }

    //检查饮水对象是否为水流
    private boolean canDrinkStream() {
        return world.getFluidState(pos).isIn(FluidTags.WATER);
    }

    //检查饮水对象是否为雨水
    private boolean canDrinkRain() {
        return player.getPitch() < -80.0F && world.hasRain(player.getBlockPos().add(0, 2, 0));
    }

    //检查饮水对象是否为坩埚
    private boolean canDrinkCauldron() {
        BlockState state = world.getBlockState(pos);
        if (state.getBlock() == Blocks.WATER_CAULDRON) {
            return state.get(LeveledCauldronBlock.LEVEL) != 0;
        }
        return false;
    }
}
