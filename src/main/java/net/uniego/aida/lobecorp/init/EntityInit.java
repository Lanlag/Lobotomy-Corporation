package net.uniego.aida.lobecorp.init;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.entity.DeadPlayerEntity;
import net.uniego.aida.lobecorp.entity.ordeal.OrdealEntity;
import net.uniego.aida.lobecorp.entity.ordeal.dawn.DoubtEntity;

//初始化实体
public class EntityInit {
    public static final EntityType<DeadPlayerEntity> DEAD_PLAYER_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            LobeCorpUtil.id("dead_player_entity"), net.minecraft.entity.EntityType.Builder.create(DeadPlayerEntity::new, SpawnGroup.MISC)
                    .dimensions(0.6F, 0.3F).build("dead_player_entity"));

    public static final EntityType<DoubtEntity> DOUBT_ENTITY = registerOrdeal("doubt", DoubtEntity::new, 0.7F, 2.3F);

    public static void register() {
        FabricDefaultAttributeRegistry.register(DOUBT_ENTITY, DoubtEntity.createAttributes());
    }

    //注册考验
    private static <T extends OrdealEntity> EntityType<T> registerOrdeal(String name, EntityType.EntityFactory<T> entityFactory,
                                                                         float width, float height) {
        return Registry.register(Registries.ENTITY_TYPE, LobeCorpUtil.id("ordeal." + name),
                EntityType.Builder.create(entityFactory, SpawnGroup.MONSTER).dimensions(width, height).build("ordeal." + name));
    }
}
