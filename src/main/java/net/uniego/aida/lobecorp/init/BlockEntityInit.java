package net.uniego.aida.lobecorp.init;

import com.mojang.datafixers.types.Type;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Util;
import net.uniego.aida.lobecorp.block.entity.ChamberConsoleBlockEntity;
import net.uniego.aida.lobecorp.block.entity.ContainerBoxBlockEntity;
import net.uniego.aida.lobecorp.block.entity.QliphothCounterBlockEntity;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;

public class BlockEntityInit {
    private static final Block[] container_boxes = {
            BlockInit.CONTAINER_BOX_O_02_62
    };
    public static final BlockEntityType<ChamberConsoleBlockEntity> CHAMBER_CONSOLE;
    public static final BlockEntityType<QliphothCounterBlockEntity> QLIPHOTH_COUNTER;
    public static final BlockEntityType<ContainerBoxBlockEntity> CONTAINER_BOX;

    public static void register(){
    }

    static {
        CHAMBER_CONSOLE = create("chamber_console", BlockEntityType.Builder.create(ChamberConsoleBlockEntity::new, BlockInit.CHAMBER_CONSOLE));
        QLIPHOTH_COUNTER = create("qliphoth_counter", BlockEntityType.Builder.create(QliphothCounterBlockEntity::new, BlockInit.QLIPHOTH_COUNTER));
        CONTAINER_BOX = create("container_box", BlockEntityType.Builder.create(ContainerBoxBlockEntity::new, container_boxes));
    }

    private static <T extends BlockEntity> BlockEntityType<T> create(String id, BlockEntityType.Builder<T> builder) {
        Type<?> type = Util.getChoiceType(TypeReferences.BLOCK_ENTITY, id);
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, LobeCorpUtil.id(id), builder.build(type));
    }
}
