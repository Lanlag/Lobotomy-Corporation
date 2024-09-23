package net.uniego.aida.lobecorp.network.handle;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.uniego.aida.lobecorp.gui.screen.LobeCorpScreenHandler;
import net.uniego.aida.lobecorp.init.ScreenInit;
import net.uniego.aida.lobecorp.network.payload.OpenClosePayload;
import org.jetbrains.annotations.NotNull;

public class OpenCloseHandle {
    public static void receive() {
        ServerPlayNetworking.registerGlobalReceiver(OpenClosePayload.ID, (payload, context) -> context.server().execute(() ->
                context.player().openHandledScreen(new NamedScreenHandlerFactory() {
                    @Override
                    public @NotNull ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
                        return new LobeCorpScreenHandler(syncId, playerInventory);
                    }

                    @Override
                    public Text getDisplayName() {
                        return Text.translatable(ScreenInit.CONTAINER_EQUIPMENT);
                    }
                })));
    }
}
