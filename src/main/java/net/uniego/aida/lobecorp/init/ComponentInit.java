package net.uniego.aida.lobecorp.init;

import net.minecraft.component.DataComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.slot.LobeCorpAttributeModifiersComponent;

//初始化组件
public class ComponentInit {
    public static final DataComponentType<LobeCorpAttributeModifiersComponent> LOBECORP_ATTRIBUTE_MODIFIERS =
            DataComponentType
                    .<LobeCorpAttributeModifiersComponent>builder()
                    .codec(LobeCorpAttributeModifiersComponent.CODEC)
                    .packetCodec(LobeCorpAttributeModifiersComponent.PACKET_CODEC).build();

    public static void register() {
        Registry.register(Registries.DATA_COMPONENT_TYPE, LobeCorpUtil.id("lobecorp__attribute_modifiers_component"), LOBECORP_ATTRIBUTE_MODIFIERS);
    }
}
