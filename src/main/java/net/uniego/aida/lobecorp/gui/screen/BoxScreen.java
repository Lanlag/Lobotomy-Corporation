package net.uniego.aida.lobecorp.gui.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.AbstractInventoryScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.uniego.aida.lobecorp.gui.GUIResource;
import net.uniego.aida.lobecorp.gui.hud.BaseElement;

//盒子屏幕
@Environment(EnvType.CLIENT)
public class BoxScreen extends AbstractInventoryScreen<BoxScreenHandler> {
    public BoxScreen(BoxScreenHandler screenHandler, PlayerInventory playerInventory, Text text) {
        super(screenHandler, playerInventory, text);
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        if (handler.abnormality != null) {
            int eBox = handler.abnormality.eBox;
            int neBox = handler.abnormality.getNeBox();
            int peBox = handler.abnormality.getPeBox();

            int posX = 50;
            int posY = 8;
            int width = 76;
            int height = 10;
            float scaleFactor = (float) 150 / (eBox * height);

            //NE-BOX
            if (neBox > 0) {
                context.getMatrices().push();
                context.getMatrices().translate(posX, posY, 0);
                context.getMatrices().scale(1.0F, scaleFactor, 1.0F);
                context.getMatrices().translate(-posX, -posY, 0);
                for (int i = 0; i < neBox; i++) {
                    int currentPosY = posY + i * height;

                    BaseElement.drawRect(context, posX, currentPosY, width, height, 0);
                    BaseElement.drawRect(context, posX + 1, currentPosY + 1, width - 2, height - 2, GUIResource.NE_BOX);
                    context.drawTexture(GUIResource.LOBECORP_ICONS, posX + 1 + 33, currentPosY + 1, 9, 80, 8, 8, 128, 128);
                }
                context.getMatrices().pop();
            }

            //PE-BOX
            if (peBox > 0) {
                context.getMatrices().push();
                context.getMatrices().translate(posX, posY + 150, 0);
                context.getMatrices().scale(1.0F, scaleFactor, 1.0F);
                context.getMatrices().translate(-posX, -(posY + 150), 0);
                for (int i = 0; i < peBox; i++) {
                    int currentPosY = posY + 150 - height - i * height;

                    BaseElement.drawRect(context, posX, currentPosY, width, height, 0);
                    BaseElement.drawRect(context, posX + 1, currentPosY + 1, width - 2, height - 2, GUIResource.PE_BOX);
                    context.drawTexture(GUIResource.LOBECORP_ICONS, posX + 1 + 33, currentPosY + 1, 0, 80, 8, 8, 128, 128);
                }
                context.getMatrices().pop();
            }
        }
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        context.drawTexture(GUIResource.BOX_INVENTORY, width / 2 - 46, y, 0, 0, 92, backgroundHeight);
    }
}
