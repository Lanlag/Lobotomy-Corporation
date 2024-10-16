package net.uniego.aida.lobecorp.init;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.PillarBlock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.uniego.aida.lobecorp.block.*;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;

public class BlockInit {
    public static void register() {
    }

    public static final Block CHAMBER_CONSOLE = register("chamber_console", new ChamberConsoleBlock(AbstractBlock.Settings.create().mapColor(MapColor.YELLOW).strength(-1F, -1F)));

    public static final Block QLIPHOTH_COUNTER = register("qliphoth_counter", new QliphothCounterBlock(AbstractBlock.Settings.create().mapColor(MapColor.YELLOW).strength(-1F, -1F)));
    public static final Block SIGNAL_WIRE = register("signal_wire", new SignalWireBlock(AbstractBlock.Settings.create().mapColor(MapColor.YELLOW).strength(-1F, -1F)));
    public static final Block CONTAINER_BOX_O_02_62 = register("container_box_o_02_62", new ContainerBoxBlock(AbstractBlock.Settings.create().mapColor(MapColor.YELLOW).strength(-1F, -1F),EntityInit.JUDGEMENT_BIRD_ENTITY));
    public static final Block WARNING_LINE = register("warning_line", new PillarBlock(AbstractBlock.Settings.create().mapColor(MapColor.YELLOW).strength(-1F, -1F)));
    public static final Block CONCRETE_WALL = register("concrete_wall", new Block(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_WHITE).strength(-1F, -1F)));
    public static final Block CONCRETE_PILLAR = register("concrete_pillar", new PillarBlock(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_WHITE).strength(-1F, -1F)));
    public static final Block FOCAL_CONCRETE = register("focal_concrete", new PillarBlock(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_GRAY).strength(-1F, -1F)));
    public static final Block DARK_CONCRETE_WALL = register("dark_concrete_wall", new Block(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_WHITE).strength(-1F, -1F)));
    public static final Block METAL_BLOCK = register("metal_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_WHITE).strength(-1F, -1F).sounds(BlockSoundGroup.NETHERITE)));
    public static final Block WARNING_BLOCK = register("warning_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.YELLOW).strength(-1F, -1F)));

    public static Block register(String id, Block block) {
        return Registry.register(Registries.BLOCK, LobeCorpUtil.id(id), block);
    }

    public static Block register(RegistryKey<Block> key, Block block) {
        return Registry.register(Registries.BLOCK, key, block);
    }
}
