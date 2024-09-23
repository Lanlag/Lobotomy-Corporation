package net.uniego.aida.lobecorp.mixin;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.uniego.aida.lobecorp.access.ManagerAccess;
import net.uniego.aida.lobecorp.init.TagInit;
import net.uniego.aida.lobecorp.item.LobeCorpItem;
import net.uniego.aida.lobecorp.manager.ThirstManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class ItemMixin {
    //允许玩家在饥饿值满，干渴值未满时食用回复干渴值和饱水度的食物
    @Inject(method = "use", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/TypedActionResult;fail(Ljava/lang/Object;)Lnet/minecraft/util/TypedActionResult;", opcode = 0, shift = At.Shift.AFTER), cancellable = true)
    private void useMixin(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir) {
        ThirstManager thirstManager = ((ManagerAccess) user).lobecorp$getThirstManager();
        ItemStack stackInHand = user.getStackInHand(hand);
        if (thirstManager.isNotFull()) {
            if (stackInHand.isIn(TagInit.HYDRATING_FOODS)) {
                user.setCurrentHand(hand);
                cir.setReturnValue(TypedActionResult.consume(stackInHand));
            }
        }
    }

    //食用食物回复干渴值和饱水度
    @Inject(method = "finishUsing", at = @At(value = "HEAD"))
    private void finishUsingMixin(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir) {
        if (user instanceof PlayerEntity player && !world.isClient()) {
            int waterLevel = 0;
            float hydrationLevel = 0;
            Item item = stack.getItem();
            if (item == Items.SWEET_BERRIES || item == Items.GLOW_BERRIES || item == Items.CARROT) {
                waterLevel = 1;
                hydrationLevel = 0.05F;
            } else if (item == Items.APPLE || item == Items.CHORUS_FRUIT) {
                waterLevel = 2;
                hydrationLevel = 0.1F;
            } else if (item == Items.MELON_SLICE) {
                waterLevel = 3;
                hydrationLevel = 0.15F;
            } else if (item == Items.BEETROOT_SOUP || item == Items.MUSHROOM_STEW || item == Items.RABBIT_STEW || item == Items.SUSPICIOUS_STEW) {
                waterLevel = 4;
                hydrationLevel = 0.4F;
            } else if (item == LobeCorpItem.BLUE_LEAF) {
                waterLevel = 6;
                hydrationLevel = 1.2F;
            }
            ((ManagerAccess) player).lobecorp$getThirstManager().add(waterLevel, hydrationLevel);
        }
    }
}
