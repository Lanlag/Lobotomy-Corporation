package net.uniego.aida.lobecorp.init;

import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.uniego.aida.lobecorp.LobeCorpUtil;

//初始化属性
public class AttributeInit {
    public static final String PLAYER_MAX_SANITY_NAME = "attribute.name.player.max_sanity";//最大精神值
    public static final String PLAYER_MAX_ASSIMILATION_NAME = "attribute.name.player.max_assimilation";//最大认知同化值

    public static final RegistryEntry<EntityAttribute> PLAYER_MAX_SANITY = register("player.max_sanity",
            (new ClampedEntityAttribute(PLAYER_MAX_SANITY_NAME, 20.0, 1.0, 1024.0)).setTracked(true));
    public static final RegistryEntry<EntityAttribute> PLAYER_MAX_ASSIMILATION = register("player.max_assimilation",
            (new ClampedEntityAttribute(PLAYER_MAX_ASSIMILATION_NAME, 0.0, 0.0, 2048.0)).setTracked(true));

    private static RegistryEntry<EntityAttribute> register(String id, EntityAttribute attribute) {
        return Registry.registerReference(Registries.ATTRIBUTE, LobeCorpUtil.id(id), attribute);
    }
}
