package net.uniego.aida.lobecorp.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.item.LobeCorpItem;

//初始化物品栏
public class ItemGroupInit {
    public static final String LOBECORP_TAB_NAME = "itemgroup.lobecorp.lobecorp";//脑叶公司栏

    public static final ItemGroup LOBECORP_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(LobeCorpItem.LOBECORP_LOGO)).displayName(Text.translatable(LOBECORP_TAB_NAME))
            .entries((context, entries) -> {
                entries.add(LobeCorpItem.LOBECORP_LOGO);
                entries.add(LobeCorpItem.BLUE_LEAF);
            }).build();

    public static void register() {
        Registry.register(Registries.ITEM_GROUP, LobeCorpUtil.id("lobecorp_tab"), LOBECORP_TAB);
    }
}
