package net.uniego.aida.lobecorp.gui.hud.element;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.option.AttackIndicator;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.world.GameMode;
import net.uniego.aida.lobecorp.gui.GUIResource;
import net.uniego.aida.lobecorp.gui.hud.BaseElement;

//渲染玩家的快捷栏
@Environment(EnvType.CLIENT)
public class HotBarElement extends BaseElement {
    //视角是玩家这个类型且玩家不是观察模式时才开启
    @Override
    protected boolean check(MinecraftClient client) {
        if (client.interactionManager != null) {
            return client.getCameraEntity() instanceof PlayerEntity
                    && client.interactionManager.getCurrentGameMode() != GameMode.SPECTATOR;
        }
        return false;
    }

    @Override
    protected void draw(MinecraftClient client, DrawContext drawContext, float tickDelta, int scaledWidth, int scaledHeight) {
        if (client.getCameraEntity() instanceof PlayerEntity player) {
            ItemStack offHandStack = player.getOffHandStack();//获取副手物品
            Arm arm = player.getMainArm();//获取主手
            //参数设置
            int posX = scaledWidth / 2;
            int posY = scaledHeight - 27;
            int size = 18;
            //渲染主快捷栏上部分背景
            drawRect(drawContext, posX - 91, posY, (size + 2) * 9 + 2, size + 2, GUIResource.BG1);
            //如果是创造模式，才渲染主快捷栏下部分背景
            if (player.isCreative()) {
                drawRect(drawContext, posX - 91, posY + 20, (size + 2) * 9 + 2, 2, GUIResource.BG1);
            }
            //渲染九个快捷栏内部背景
            for (int i = 0; i < 9; ++i) {
                drawRect(drawContext, posX - 91 + 2 + i * 20, posY + 2, size, size, GUIResource.BG4);
            }
            //渲染玩家当前所选快捷栏
            drawRect(drawContext, posX - 91 + 2 + player.getInventory().selectedSlot * 20, posY + 2, size, size, GUIResource.BG3);
            //当玩家副手不为空时，渲染副手栏
            if (offHandStack != ItemStack.EMPTY) {
                if (arm == Arm.LEFT) {
                    drawRect(drawContext, posX + 91 + 2, posY, size + 2 + 2, size + 2, GUIResource.BG1);
                    drawRect(drawContext, posX + 91 + 2 + 2, posY + 2, size, size, GUIResource.BG4);
                    if (player.isCreative()) {
                        drawRect(drawContext, posX + 91 + 2, posY + 20, size + 2 + 2, 2, GUIResource.BG1);
                    }
                } else {
                    drawRect(drawContext, posX - 91 - 2 - 22, posY, size + 2 + 2, size + 2, GUIResource.BG1);
                    drawRect(drawContext, posX - 91 - 2 - 22 + 2, posY + 2, size, size, GUIResource.BG4);
                    if (player.isCreative()) {
                        drawRect(drawContext, posX - 91 - 2 - 22, posY + 20, size + 2 + 2, 2, GUIResource.BG1);
                    }
                }
            }
            //渲染主手物品
            for (int i = 0; i < 9; ++i) {
                renderHotBarItem(drawContext, posX - 91 + 3 + i * 20, posY + 3, tickDelta, player.getInventory().main.get(i), client);
            }
            //渲染副手物品
            if (offHandStack != ItemStack.EMPTY) {
                if (arm == Arm.LEFT) {
                    renderHotBarItem(drawContext, posX + 91 + 2 + 3, posY + 3, tickDelta, offHandStack, client);
                } else {
                    renderHotBarItem(drawContext, posX - 91 - 2 - 22 + 3, posY + 3, tickDelta, offHandStack, client);
                }
            }
            //渲染快捷栏攻击指示器
            if (client.options.getAttackIndicator().getValue() == AttackIndicator.HOTBAR) {
                float attackCooldownProgress = player.getAttackCooldownProgress(0.0F);
                if (attackCooldownProgress < 1.0F) {
                    int attackCooldownHeight = (int) (attackCooldownProgress * 19.0F);
                    if (arm == Arm.LEFT) {
                        //渲染外壳
                        drawContext.drawTexture(GUIResource.LOBECORP_ICONS, posX - 91 - 22, posY + 2,
                                0, 94, size, size, 128, 128);
                        //渲染动画
                        drawContext.drawTexture(GUIResource.LOBECORP_ICONS, posX - 91 - 22, posY + 2 + 18 - attackCooldownHeight,
                                18, 112 - attackCooldownHeight, size, attackCooldownHeight, 128, 128);
                    } else {
                        drawContext.drawTexture(GUIResource.LOBECORP_ICONS, posX + 91 + 2 + 2, posY + 2,
                                0, 94, size, size, 128, 128);
                        drawContext.drawTexture(GUIResource.LOBECORP_ICONS, posX + 91 + 2 + 2, posY + 2 + 18 - attackCooldownHeight,
                                18, 112 - attackCooldownHeight, size, attackCooldownHeight, 128, 128);
                    }
                }
            }
        }
    }
}
