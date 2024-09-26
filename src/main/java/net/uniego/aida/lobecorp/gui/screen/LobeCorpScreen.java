package net.uniego.aida.lobecorp.gui.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.AbstractInventoryScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.uniego.aida.lobecorp.access.ManagerAccess;
import net.uniego.aida.lobecorp.gui.GUIResource;
import net.uniego.aida.lobecorp.init.KeyInit;
import net.uniego.aida.lobecorp.manager.LevelManager;

import java.util.Objects;

//脑叶公司屏幕
@Environment(EnvType.CLIENT)
public class LobeCorpScreen extends AbstractInventoryScreen<LobeCorpScreenHandler> {
    private final EGOGiftWidget egoGiftWidget = new EGOGiftWidget();

    public LobeCorpScreen(LobeCorpScreenHandler screenHandler, PlayerInventory playerInventory, Text text) {
        super(screenHandler, playerInventory, text);
    }

    @Override
    protected void init() {
        super.init();
        egoGiftWidget.initialize(x, y, handler);
        addDrawableChild(new TexturedButtonWidget(x + 10, y + 10, 10, 10, GUIResource.EGO_GIFT_BUTTON,
                button -> {
                    egoGiftWidget.toggleOpen();
                    if (!egoGiftWidget.isOpen()) egoGiftWidget.closeSlot();
                }));
        addSelectableChild(egoGiftWidget);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        egoGiftWidget.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        //参数设置
        int posX = titleX + 73;
        int posY = titleY + 60;
        //获取等级机制
        LevelManager levelManager = ((ManagerAccess) Objects.requireNonNull(Objects.requireNonNull(client).player)).lobecorp$getLevelManager();
        //渲染总等级和四大等级
        context.drawText(client.textRenderer, Text.translatable(GUIResource.STAFF_LEVEL).append(" " + levelManager.getTotalLevel().getLevel()).formatted(Formatting.GOLD),
                posX, posY - 60, -1, true);
        context.drawText(client.textRenderer, Text.translatable(GUIResource.STAFF_FORTITUDE).append(" " + levelManager.getLevelF().getLevel()).formatted(Formatting.DARK_RED),
                posX, posY - 50, -1, true);
        context.drawText(client.textRenderer, Text.translatable(GUIResource.STAFF_PRUDENCE).append(" " + levelManager.getLevelP().getLevel()).formatted(Formatting.WHITE),
                posX, posY - 36, -1, true);
        context.drawText(client.textRenderer, Text.translatable(GUIResource.STAFF_TEMPERANCE).append(" " + levelManager.getLevelT().getLevel()).formatted(Formatting.DARK_PURPLE),
                posX, posY - 22, -1, true);
        context.drawText(client.textRenderer, Text.translatable(GUIResource.STAFF_JUSTICE).append(" " + levelManager.getLevelJ().getLevel()).formatted(Formatting.AQUA),
                posX, posY - 4, -1, true);
        //渲染六大属性
        context.getMatrices().scale(0.5F, 0.5F, 0.5F);
        context.drawText(client.textRenderer, Text.translatable(GUIResource.STAFF_MAX_HEALTH).append(String.valueOf(levelManager.getMaxHealth())).formatted(Formatting.BLACK),
                posX * 2, (posY - 50 + 18) * 2 - 18, -1, false);
        context.drawText(client.textRenderer, Text.translatable(GUIResource.STAFF_MAX_SANITY).append(String.valueOf(levelManager.getMaxSanity())).formatted(Formatting.BLACK),
                posX * 2, (posY - 36 + 18) * 2 - 18, -1, false);
        context.drawText(client.textRenderer, Text.translatable(GUIResource.STAFF_WORK_SUCCESS).append(String.valueOf(levelManager.getWorkSuccess())).formatted(Formatting.BLACK),
                posX * 2, (posY - 22 + 18) * 2 - 18, -1, false);
        context.drawText(client.textRenderer, Text.translatable(GUIResource.STAFF_WORK_VELOCITY).append(String.valueOf(levelManager.getWorkVelocity())).formatted(Formatting.BLACK),
                posX * 2, (posY - 22 + 18) * 2 - 9, -1, false);
        context.drawText(client.textRenderer, Text.translatable(GUIResource.STAFF_ATTACK_VELOCITY).append(String.valueOf(levelManager.getAttackVelocity())).formatted(Formatting.BLACK),
                posX * 2, (posY - 4 + 18) * 2 - 18, -1, false);
        context.drawText(client.textRenderer, Text.translatable(GUIResource.STAFF_MOVE_VELOCITY).append(String.valueOf(levelManager.getMoveVelocity())).formatted(Formatting.BLACK),
                posX * 2, (posY - 4 + 18) * 2 - 9, -1, false);
        context.getMatrices().scale(2.0F, 2.0F, 2.0F);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        context.drawTexture(GUIResource.LOBECORP_INVENTORY, x, y, 0, 0, backgroundWidth, backgroundHeight);
        if (client != null && client.player != null) {
            InventoryScreen.drawEntity(context, x + 26 - 33, y + 8, x + 75, y + 78, 30, 0.0625F, mouseX, mouseY, client.player);
        }
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (KeyInit.EQUIPMENT_INVENTORY.matchesKey(keyCode, scanCode)) {
            close();
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    protected boolean isClickOutsideBounds(double mouseX, double mouseY, int left, int top, int button) {
        boolean bl = mouseX < (double) left || mouseY < (double) top || mouseX >= (double) (left + backgroundWidth) || mouseY >= (double) (top + backgroundHeight);
        return egoGiftWidget.isClickOutsideBounds(mouseX, mouseY, x, y, backgroundWidth, backgroundHeight) && bl;
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        egoGiftWidget.mouseClicked(mouseX, mouseY, button);
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        egoGiftWidget.mouseReleased(mouseX, mouseY, button);
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        egoGiftWidget.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
        return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        egoGiftWidget.mouseScrolled(mouseX, mouseY, horizontalAmount, verticalAmount);
        return super.mouseScrolled(mouseX, mouseY, horizontalAmount, verticalAmount);
    }
}
