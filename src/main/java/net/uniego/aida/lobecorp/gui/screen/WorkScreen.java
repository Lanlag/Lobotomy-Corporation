package net.uniego.aida.lobecorp.gui.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.AbstractInventoryScreen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.uniego.aida.lobecorp.entity.abnormality.AbnormalityEntity;
import net.uniego.aida.lobecorp.gui.GUIResource;
import net.uniego.aida.lobecorp.network.packet.BeginWorkPacket;

//工作屏幕
@Environment(EnvType.CLIENT)
public class WorkScreen extends AbstractInventoryScreen<WorkScreenHandler> {
    public WorkScreen(WorkScreenHandler screenHandler, PlayerInventory playerInventory, Text text) {
        super(screenHandler, playerInventory, text);
    }

    @Override
    protected void init() {
        super.init();
        ButtonWidget instinctWorkButton = ButtonWidget.builder(Text.literal("本能工作"), button -> {
                    if (handler.abnormality != null) {
                        BeginWorkPacket.send(handler.abnormality.getUuid(), AbnormalityEntity.INSTINCT);
                    }
                }).dimensions(width / 2 - 50, height / 2 - 70, 100, 20)
                .tooltip(Tooltip.of(Text.literal("点击即可对该异想体进行本能工作")))
                .build();
        addDrawableChild(instinctWorkButton);
        ButtonWidget insightWorkButton = ButtonWidget.builder(Text.literal("洞察工作"), button -> {
                    if (handler.abnormality != null) {
                        BeginWorkPacket.send(handler.abnormality.getUuid(), AbnormalityEntity.INSIGHT);
                    }
                }).dimensions(width / 2 - 50, height / 2 - 30, 100, 20)
                .tooltip(Tooltip.of(Text.literal("点击即可对该异想体进行洞察工作")))
                .build();
        addDrawableChild(insightWorkButton);
        ButtonWidget attachmentWorkButton = ButtonWidget.builder(Text.literal("沟通工作"), button -> {
                    if (handler.abnormality != null) {
                        BeginWorkPacket.send(handler.abnormality.getUuid(), AbnormalityEntity.ATTACHMENT);
                    }
                }).dimensions(width / 2 - 50, height / 2 + 10, 100, 20)
                .tooltip(Tooltip.of(Text.literal("点击即可对该异想体进行沟通工作")))
                .build();
        addDrawableChild(attachmentWorkButton);
        ButtonWidget repressionWorkButton = ButtonWidget.builder(Text.literal("压迫工作"), button -> {
                    if (handler.abnormality != null) {
                        BeginWorkPacket.send(handler.abnormality.getUuid(), AbnormalityEntity.REPRESSION);
                    }
                }).dimensions(width / 2 - 50, height / 2 + 50, 100, 20)
                .tooltip(Tooltip.of(Text.literal("点击即可对该异想体进行压迫工作")))
                .build();
        addDrawableChild(repressionWorkButton);
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        context.drawTexture(GUIResource.WORK_INVENTORY, x, y, 0, 0, backgroundWidth, backgroundHeight);
    }
}
