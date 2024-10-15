package net.uniego.aida.lobecorp.init;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.uniego.aida.lobecorp.block.ChamberConsoleBlock;
import net.uniego.aida.lobecorp.block.ContainerBoxBlock;
import net.uniego.aida.lobecorp.block.QliphothCounterBlock;
import net.uniego.aida.lobecorp.block.SignalWireBlock;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;

public class BlockInit {
    public static void register() {
    }

    public static final Block CHAMBER_CONSOLE = register("chamber_console", new ChamberConsoleBlock(AbstractBlock.Settings.create().mapColor(MapColor.YELLOW).strength(-1F, -1F)));

    public static final Block QLIPHOTH_COUNTER = register("qliphoth_counter", new QliphothCounterBlock(AbstractBlock.Settings.create().mapColor(MapColor.YELLOW).strength(-1F, -1F)));
    public static final Block SIGNAL_WIRE = register("signal_wire", new SignalWireBlock(AbstractBlock.Settings.create().mapColor(MapColor.YELLOW).strength(-1F, -1F)));
    public static final Block CONTAINER_BOX_O_02_62 = register("container_box_o_02_62", new ContainerBoxBlock(AbstractBlock.Settings.create().mapColor(MapColor.YELLOW).strength(-1F, -1F),EntityInit.JUDGEMENT_BIRD_ENTITY));

    public static Block register(String id, Block block) {
        return Registry.register(Registries.BLOCK, LobeCorpUtil.id(id), block);
    }

    public static Block register(RegistryKey<Block> key, Block block) {
        return Registry.register(Registries.BLOCK, key, block);
    }
}
