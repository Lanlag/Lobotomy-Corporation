package net.uniego.aida.lobecorp.network.handle;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.uniego.aida.lobecorp.entity.abnormality.AbnormalityEntity;
import net.uniego.aida.lobecorp.gui.screen.BoxScreenHandler;
import net.uniego.aida.lobecorp.init.ScreenInit;
import net.uniego.aida.lobecorp.network.payload.BeginWorkPayload;
import org.jetbrains.annotations.NotNull;

public class BeginWorkHandle {
    public static void receive() {
        ServerPlayNetworking.registerGlobalReceiver(BeginWorkPayload.ID, ((payload, context) -> context.server().execute(() -> {
            Entity entity = context.player().getServerWorld().getEntity(payload.abnormalityUuid());
            if (entity instanceof AbnormalityEntity abnormality) {
                if (abnormality.workPlayer == null) {
                    abnormality.workPlayer = context.player();
                    abnormality.setWorkDurationTime();
                    abnormality.workMethod = payload.workMethod();
                    abnormality.setWorkLevel(payload.workMethod());
                    abnormality.setWorking(true);
                    context.player().openHandledScreen(new NamedScreenHandlerFactory() {
                        @Override
                        public Text getDisplayName() {
                            return Text.translatable(ScreenInit.CONTAINER_BOX);
                        }

                        @Override
                        public @NotNull ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
                            return new BoxScreenHandler(syncId, player, abnormality);
                        }
                    });
                }
            }
        })));
    }
}
