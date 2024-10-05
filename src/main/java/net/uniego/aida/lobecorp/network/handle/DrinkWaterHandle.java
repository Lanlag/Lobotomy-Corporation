package net.uniego.aida.lobecorp.network.handle;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.access.ManagerAccess;
import net.uniego.aida.lobecorp.init.EffectInit;
import net.uniego.aida.lobecorp.manager.ThirstManager;
import net.uniego.aida.lobecorp.network.packet.SwingHandPacket;
import net.uniego.aida.lobecorp.network.payload.DrinkWaterPayload;

public class DrinkWaterHandle {
    public static void receive() {
        ServerPlayNetworking.registerGlobalReceiver(DrinkWaterPayload.ID, (payload, context) -> context.server().execute(() -> {
            ThirstManager thirstManager = ((ManagerAccess) context.player()).lobecorp$getThirstManager();
            if (DrinkWaterPayload.STREAM.equals(payload.waterSource()) && (thirstManager.isNotFull()
                    || context.player().isCreative()) && thirstManager.isNotDrink()) {
                drinkWater(context.player(), thirstManager, 2, 0.05F);
                context.player().addStatusEffect(new StatusEffectInstance(EffectInit.THIRST, 600));
                thirstManager.hasDrankStream = true;
            } else if (DrinkWaterPayload.RAIN.equals(payload.waterSource()) && (thirstManager.isNotFull()
                    || context.player().isCreative()) && thirstManager.isNotDrink()) {
                drinkWater(context.player(), thirstManager, 1, 0.01F);
                thirstManager.hasDrankRain = true;
            } else if (DrinkWaterPayload.CAULDRON.equals(payload.waterSource()) && (thirstManager.isNotFull()
                    || context.player().isCreative()) && thirstManager.isNotDrink()) {
                drinkWater(context.player(), thirstManager, 2, 0.1F);
                context.player().addStatusEffect(new StatusEffectInstance(EffectInit.THIRST, 600));
                thirstManager.hasDrankCauldron = true;
            }
        }));
    }

    //喝水行为
    private static void drinkWater(ServerPlayerEntity serverPlayer, ThirstManager thirstManager, int waterLevel, float hydrationLevel) {
        SwingHandPacket.send(serverPlayer);
        LobeCorpUtil.playSound(serverPlayer, SoundEvents.ENTITY_GENERIC_DRINK);
        thirstManager.add(waterLevel, hydrationLevel);
    }
}
