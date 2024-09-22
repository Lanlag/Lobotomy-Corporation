package net.uniego.aida.lobecorp.gui.hud;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.uniego.aida.lobecorp.manager.ThirstManager;

//所有HUD元素的抽象父类
@Environment(EnvType.CLIENT)
public abstract class BaseElement {
    //逆时针方向从左下角到左上角(posX,posY)绘制矩形，width和height分别是宽和高
    protected static void drawRect(DrawContext drawContext, int posX, int posY, int width, int height, int color) {
        //根据给定的整数颜色值(color)，提取其中的透明度、红色、绿色和蓝色分量，同时处理特殊情况下的无效颜色值(-1)
        if (color == -1) return;
        float alpha;//透明度
        if (color >= 0 && color <= 0xFFFFFF) alpha = 1.0F;
        else alpha = (color >> 24 & 255) / 255.0F;
        float red = (color >> 16 & 255) / 255.0F;//红色
        float green = (color >> 8 & 255) / 255.0F;//绿色
        float blue = (color & 255) / 255.0F;//蓝色

        //启用混合功能、设置默认的混合函数、设置着色器并禁用深度测试
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionColorProgram);
        RenderSystem.disableDepthTest();

        //创建了一个用于绘制的矩阵堆栈和顶点缓冲器，并指定顶点格式为位置和颜色信息
        MatrixStack matrixStack = drawContext.getMatrices();
        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
        bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR);
        //左下角
        bufferBuilder.vertex(matrixStack.peek().getPositionMatrix(), posX, posY + height, 0).color(red, green, blue, alpha).next();
        //右下角
        bufferBuilder.vertex(matrixStack.peek().getPositionMatrix(), posX + width, posY + height, 0).color(red, green, blue, alpha).next();
        //右上角
        bufferBuilder.vertex(matrixStack.peek().getPositionMatrix(), posX + width, posY, 0).color(red, green, blue, alpha).next();
        //左上角
        bufferBuilder.vertex(matrixStack.peek().getPositionMatrix(), posX, posY, 0).color(red, green, blue, alpha).next();
        //绘制顶点完毕
        BufferRenderer.drawWithGlobalProgram(bufferBuilder.end());

        //关闭混合功能，启用深度测试
        RenderSystem.disableBlend();
        RenderSystem.enableDepthTest();
    }

    //逆时针方向从左下角到左上角(posX,posY)绘制梯形，widthTop和widthBottom分别是上宽和下宽，height是高
    //使用double类型是因为这样绘制出来的状态条变化更加丝滑
    protected static void drawTrap(int posX, int posY, double widthTop, double widthBottom, int height, int color) {
        if (color == -1) return;
        float alpha;
        if (color >= 0 && color <= 0xFFFFFF) alpha = 1.0F;
        else alpha = (color >> 24 & 255) / 255.0F;
        float red = (color >> 16 & 255) / 255.0F;
        float green = (color >> 8 & 255) / 255.0F;
        float blue = (color & 255) / 255.0F;

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionColorProgram);
        RenderSystem.disableDepthTest();

        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
        bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR);
        bufferBuilder.vertex(posX, posY + height, 0).color(red, green, blue, alpha).next();
        bufferBuilder.vertex(posX + widthBottom, posY + height, 0).color(red, green, blue, alpha).next();
        bufferBuilder.vertex(posX + widthTop, posY, 0).color(red, green, blue, alpha).next();
        bufferBuilder.vertex(posX, posY, 0).color(red, green, blue, alpha).next();
        BufferRenderer.drawWithGlobalProgram(bufferBuilder.end());

        RenderSystem.disableBlend();
        RenderSystem.enableDepthTest();
    }

    //饥饿条抖动效果
    protected static int getHungerBounceFactor(PlayerEntity player, HungerManager hungerManager, int ticks) {
        if (hungerManager.getSaturationLevel() <= 0.0F && ticks % (hungerManager.getFoodLevel() * 3 + 1) == 0) {
            return player.getWorld().random.nextInt(3) - 1;
        }
        return 0;
    }

    //干渴条抖动效果
    public static int getThirstBounceFactor(PlayerEntity player, ThirstManager thirstManager, int ticks) {
        if (thirstManager.getHydrationLevel() <= 0.0F && ticks % (thirstManager.getWaterLevel() * 3 + 1) == 0) {
            return player.getWorld().random.nextInt(3) - 1;
        }
        return 0;
    }

    //获取图标偏移量
    protected static int getIconOffset(float level, int i) {
        int iconOffset = 0;
        float value = (level / 2.0F) - i;
        if (value > 0 && value < 0.33F) {
            iconOffset = 40;
        } else if (value >= 0.33F && value < 0.66F) {
            iconOffset = 30;
        } else if (value >= 0.66F && value < 1.0F) {
            iconOffset = 20;
        } else if (value >= 1.0F) {
            iconOffset = 10;
        }
        return iconOffset;
    }

    protected abstract boolean check(MinecraftClient client);

    protected abstract void draw(MinecraftClient client, DrawContext drawContext, float tickDelta, int scaledWidth, int scaledHeight);

    //调用子类检查方法
    public boolean checkElement(MinecraftClient client) {
        return check(client);
    }

    //调用子类绘制方法
    public void drawElement(MinecraftClient client, DrawContext drawContext, float tickDelta, int scaledWidth, int scaledHeight) {
        draw(client, drawContext, tickDelta, scaledWidth, scaledHeight);
    }

    //渲染快捷栏物品
    protected void renderHotBarItem(DrawContext drawContext, int x, int y, float tickDelta, ItemStack itemStack, MinecraftClient client) {
        if (!itemStack.isEmpty()) {
            float animationOffset = itemStack.getBobbingAnimationTime() - tickDelta;
            if (animationOffset > 0.0F) {
                float g = 1.0F + animationOffset / 5.0F;
                drawContext.getMatrices().push();
                drawContext.getMatrices().translate(x + 8, y + 12, 0.0F);
                drawContext.getMatrices().scale(1.0F / g, (g + 1.0F) / 2.0F, 1.0F);
                drawContext.getMatrices().translate(-(x + 8), -(y + 12), 0.0F);
            }
            drawContext.drawItem(itemStack, x, y);
            if (animationOffset > 0.0F) {
                drawContext.getMatrices().pop();
            }
            drawContext.drawItemInSlot(client.textRenderer, itemStack, x, y);
        }
    }
}
