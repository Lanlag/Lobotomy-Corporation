package net.uniego.aida.lobecorp.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Rarity;
import net.uniego.aida.lobecorp.LobeCorpUtil;

//脑叶公司物品
public class LobeCorpItem {
    public static final Item LOBECORP_LOGO = new Item(new Item.Settings().rarity(Rarity.EPIC).maxCount(1).fireproof());
    public static final Item BLUE_LEAF = new Item(new Item.Settings()
            .food(new FoodComponent.Builder().nutrition(1).saturationModifier(0.1F).snack().build()));

    public static void register() {
        Registry.register(Registries.ITEM, LobeCorpUtil.id("lobecorp_logo"), LOBECORP_LOGO);
        Registry.register(Registries.ITEM, LobeCorpUtil.id("blue_leaf"), BLUE_LEAF);
    }
}
