package net.uniego.aida.lobecorp.init;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.uniego.aida.lobecorp.item.AbnormalitySpawnEgg;
import net.uniego.aida.lobecorp.item.LobeCorpItem;
import net.uniego.aida.lobecorp.item.badge.TeamBadge;
import net.uniego.aida.lobecorp.item.ego.EGOItem;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;

//初始化物品
public class ItemInit {
    public static void register() {
        LobeCorpItem.register();
        EGOItem.register();
        TeamBadge.register();
        AbnormalitySpawnEgg.register();
    }

    public static final Item CHAMBER_CONSOLE = register(BlockInit.CHAMBER_CONSOLE);
    public static final Item QLIPHOTH_COUNTER = register(BlockInit.QLIPHOTH_COUNTER);
    public static final Item SIGNAL_WIRE = register(BlockInit.SIGNAL_WIRE);
    public static final Item CONTAINER_BOX_O_02_62 = register(BlockInit.CONTAINER_BOX_O_02_62);
    public static final Item WARNING_LINE = register(BlockInit.WARNING_LINE);
    public static final Item CONCRETE_WALL = register(BlockInit.CONCRETE_WALL);
    public static final Item CONCRETE_PILLAR = register(BlockInit.CONCRETE_PILLAR);
    public static final Item FOCAL_CONCRETE = register(BlockInit.FOCAL_CONCRETE);
    public static final Item DARK_CONCRETE_WALL = register(BlockInit.DARK_CONCRETE_WALL);
    public static final Item WARNING_BLOCK = register(BlockInit.WARNING_BLOCK);
    public static final Item METAL_BLOCK = register(BlockInit.METAL_BLOCK);

    public static Item register(Block block) {
        return register(new BlockItem(block, new Item.Settings()));
    }

    public static Item register(BlockItem item) {
        return register(item.getBlock(), item);
    }

    public static Item register(Block block, Item item) {
        return register(Registries.BLOCK.getId(block), item);
    }

    public static Item register(String id, Item item) {
        return register(LobeCorpUtil.id(id), item);
    }

    public static Item register(Identifier id, Item item) {
        return register(RegistryKey.of(Registries.ITEM.getKey(), id), item);
    }

    public static Item register(RegistryKey<Item> key, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return Registry.register(Registries.ITEM, key, item);
    }
}
