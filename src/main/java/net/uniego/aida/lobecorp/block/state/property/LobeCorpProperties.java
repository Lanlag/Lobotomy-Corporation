package net.uniego.aida.lobecorp.block.state.property;

import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;

public class LobeCorpProperties {
    public static final IntProperty QLIPHOTH_COUNT = IntProperty.of("qliphoth_count", 0, 6);
    public static final BooleanProperty SHOW_CENTER = BooleanProperty.of("show_center");
    public static final BooleanProperty COVERED = BooleanProperty.of("covered");
}
