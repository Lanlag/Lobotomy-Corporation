package net.uniego.aida.lobecorp.gui.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.Selectable;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.screen.slot.Slot;
import net.uniego.aida.lobecorp.gui.GUIResource;
import net.uniego.aida.lobecorp.slot.LobeCorpSlot;

//EGO饰品控件
@Environment(EnvType.CLIENT)
public class EGOGiftWidget implements Drawable, Element, Selectable {
    private static final int VISIBLE_SLOTS = 7;//可见插槽数
    private static final int TOTAL_SLOTS = 14;//总插槽数
    private static final int SLOT_HEIGHT = 18;//插槽高度
    private static final int SLIDER_WIDTH = 5;//滑块宽度
    private static final int SLIDER_HEIGHT = 62;//滑块高度
    private static final int SCROLL_BAR_HEIGHT = 124;//滚动条高度
    private boolean open;
    private int parentX;
    private int parentY;
    private LobeCorpScreenHandler handler;
    private int sliderPosY;//滑块当前位置
    private boolean isSliding;//是否正在滑动

    public void initialize(int parentX, int parentY, LobeCorpScreenHandler handler) {
        this.parentX = parentX;
        this.parentY = parentY;
        this.handler = handler;
    }

    //切换打开关闭状态
    public void toggleOpen() {
        setOpen(!isOpen());
    }

    public boolean isOpen() {
        return open;
    }

    protected void setOpen(boolean opened) {
        open = opened;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        if (isOpen()) {
            context.getMatrices().push();
            //参数设置
            int posX = parentX - 32;
            int posY = parentY + 3;
            int width = 32;
            //滑动改变插槽位置
            for (int i = 0; i < TOTAL_SLOTS; i++) {
                updateSlotPosition(i);
            }
            //渲染插槽背景和滑动条背景
            for (int i = 0; i < VISIBLE_SLOTS; i++) {
                context.drawTexture(GUIResource.GIFT_INVENTORY, posX, posY + 7 + i * SLOT_HEIGHT, 0, 32, width, SLOT_HEIGHT);
            }
            //绘制顶部边框
            context.drawTexture(GUIResource.GIFT_INVENTORY, posX, posY, 0, 0, width, 8);
            //绘制底部边框
            context.drawTexture(GUIResource.GIFT_INVENTORY, posX, posY + 7 + VISIBLE_SLOTS * SLOT_HEIGHT - 1, 0, 16, width, 8);
            //绘制滑块
            context.drawTexture(GUIResource.GIFT_INVENTORY, posX + 25 + 1, posY + 7 + 1 + sliderPosY, 32, 0, SLIDER_WIDTH, SLIDER_HEIGHT);
            context.getMatrices().pop();
        }
    }

    //更新滑块位置
    private void updateSliderPosition(double mouseY) {
        double offset = 0;
        if (mouseY > 0) offset = mouseY - (parentY + 11);
        else if (mouseY < 0) offset = -mouseY + (parentY + 29);
        sliderPosY = (int) Math.max(0, Math.min(offset, SCROLL_BAR_HEIGHT - SLIDER_HEIGHT));
    }

    //更新插槽位置
    private void updateSlotPosition(int i) {
        //此处40指的9个快捷栏加27个背包栏以及weapon、suit、badge、tool4个，从0开始索引
        Slot slot = handler.getSlot(40 + i);
        int startSlotIndex = Math.max(0, (sliderPosY * VISIBLE_SLOTS) / (SCROLL_BAR_HEIGHT - SLIDER_HEIGHT));
        if (slot instanceof LobeCorpSlot lobecorpSlot) {
            if (i >= startSlotIndex && i < startSlotIndex + VISIBLE_SLOTS) {
                lobecorpSlot.setEnabled(true);
                lobecorpSlot.y = 11 + ((i - startSlotIndex) % VISIBLE_SLOTS) * SLOT_HEIGHT;
            } else {
                lobecorpSlot.setEnabled(false);
            }
        }
    }

    //EGO饰品界面关闭时禁用饰品插槽
    public void closeSlot() {
        for (int i = 0; i < TOTAL_SLOTS; i++) {
            Slot slot = handler.getSlot(40 + i);
            if (slot instanceof LobeCorpSlot lobecorpSlot) lobecorpSlot.setEnabled(false);
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0
                && mouseX >= parentX - 6 && mouseX <= parentX - 6 + SLIDER_WIDTH
                && mouseY >= parentY + 11 && mouseY <= parentY + 11 + SCROLL_BAR_HEIGHT) {
            isSliding = true;
            updateSliderPosition(mouseY);
            return true;
        }
        return Element.super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        isSliding = false;
        return Element.super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        if (button == 0 && isSliding) {
            updateSliderPosition(mouseY);
            return true;
        }
        return Element.super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        if (mouseX >= parentX - 6 && mouseX <= parentX - 6 + SLIDER_WIDTH
                && mouseY >= parentY + 11 && mouseY <= parentY + 11 + SCROLL_BAR_HEIGHT) {
            updateSliderPosition(verticalAmount);
            return true;
        }
        return Element.super.mouseScrolled(mouseX, mouseY, horizontalAmount, verticalAmount);
    }

    @Override
    public boolean isFocused() {
        return false;
    }

    @Override
    public void setFocused(boolean focused) {
    }

    @Override
    public SelectionType getType() {
        return open ? SelectionType.HOVERED : SelectionType.NONE;
    }

    @Override
    public void appendNarrations(NarrationMessageBuilder builder) {
    }

    //检查是否点击到了边界外
    public boolean isClickOutsideBounds(double mouseX, double mouseY, int x, int y, int backgroundWidth, int backgroundHeight) {
        if (!isOpen()) {
            return true;
        } else {
            boolean bl1 = mouseX < (double) x || mouseY < (double) y || mouseX >= (double) (x + backgroundWidth) || mouseY >= (double) (y + backgroundHeight);
            boolean bl2 = (double) (x - 32) < mouseX && mouseX < (double) x && (double) (y + 3) < mouseY && mouseY < (double) (y + 143);
            return bl1 && !bl2;
        }
    }
}
