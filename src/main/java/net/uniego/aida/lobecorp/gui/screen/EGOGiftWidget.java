package net.uniego.aida.lobecorp.gui.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.Selectable;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.uniego.aida.lobecorp.gui.GUIResource;

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
    private int sliderPosY;//滑块当前位置
    private boolean isSliding;//是否正在滑动
    private MinecraftClient client;

    public void initialize(int parentX, int parentY, MinecraftClient client) {
        this.parentX = parentX;
        this.parentY = parentY;
        this.client = client;
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
            //渲染插槽背景和滑动条背景
            for (int i = 0; i < VISIBLE_SLOTS; i++) {
                context.drawTexture(GUIResource.GIFT_CONTAINER, posX, posY + 7 + i * SLOT_HEIGHT, 0, 32, width, SLOT_HEIGHT);
            }
            //绘制顶部边框
            context.drawTexture(GUIResource.GIFT_CONTAINER, posX, posY, 0, 0, width, 8);
            //绘制底部边框
            context.drawTexture(GUIResource.GIFT_CONTAINER, posX, posY + 7 + VISIBLE_SLOTS * SLOT_HEIGHT - 1, 0, 16, width, 8);
            //绘制滑块
            context.drawTexture(GUIResource.GIFT_CONTAINER, posX + 25 + 1, posY + 7 + 1 + sliderPosY, 32, 0, SLIDER_WIDTH, SLIDER_HEIGHT);
            context.getMatrices().pop();
        }
    }

    //更新滑块位置
    private void updateSliderPosition(double mouseY) {
        sliderPosY = (int) Math.max(0, Math.min(mouseY - (parentY + 11), SCROLL_BAR_HEIGHT - SLIDER_HEIGHT));
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
}
