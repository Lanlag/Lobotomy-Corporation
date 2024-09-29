package net.uniego.aida.lobecorp.init;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.entity.DeadPlayerEntity;

//初始化实体
public class EntityInit {
    public static final EntityType<DeadPlayerEntity> DEAD_PLAYER_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            LobeCorpUtil.id("dead_player_entity"), EntityType.Builder.create(DeadPlayerEntity::new, SpawnGroup.MISC)
                    .dimensions(0.6F, 0.3F).build("dead_player_entity"));

    public static void register() {

    }
}
