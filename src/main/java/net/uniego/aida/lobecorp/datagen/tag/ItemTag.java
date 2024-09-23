package net.uniego.aida.lobecorp.datagen.tag;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.uniego.aida.lobecorp.init.TagInit;

import java.util.concurrent.CompletableFuture;

//物品标签文件生成器
public class ItemTag extends FabricTagProvider.ItemTagProvider {
    public ItemTag(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        //生成回复干渴值物品标签
        getOrCreateTagBuilder(TagInit.HYDRATING_FOODS)
                .add(Items.SWEET_BERRIES)
                .add(Items.GLOW_BERRIES)
                .add(Items.CARROT)
                .add(Items.APPLE)
                .add(Items.CHORUS_FRUIT)
                .add(Items.MELON_SLICE)
                .add(Items.BEETROOT_SOUP)
                .add(Items.MUSHROOM_STEW)
                .add(Items.RABBIT_STEW)
                .add(Items.SUSPICIOUS_STEW)
                .add(Items.MILK_BUCKET)
                .add(Items.POTION);
        //生成红伤EGO武器标签
        getOrCreateTagBuilder(TagInit.RED_EGO_WEAPONS);

        //生成白伤EGO武器标签
        getOrCreateTagBuilder(TagInit.WHITE_EGO_WEAPONS);

        //生成黑伤EGO武器标签
        getOrCreateTagBuilder(TagInit.BLACK_EGO_WEAPONS);

        //生成蓝伤EGO武器标签
        getOrCreateTagBuilder(TagInit.PALE_EGO_WEAPONS);

    }
}
