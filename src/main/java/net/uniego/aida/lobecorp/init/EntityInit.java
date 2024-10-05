package net.uniego.aida.lobecorp.init;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.uniego.aida.lobecorp.LobeCorpUtil;
import net.uniego.aida.lobecorp.entity.DeadPlayerEntity;
import net.uniego.aida.lobecorp.entity.abnormality.AbnormalityEntity;
import net.uniego.aida.lobecorp.entity.abnormality.beautyandtheBeast.BeautyAndTheBeastEntity;
import net.uniego.aida.lobecorp.entity.abnormality.happyteddybear.HappyTeddyBearEntity;
import net.uniego.aida.lobecorp.entity.abnormality.onesinandhundredsofgooddeeds.OneSinAndHundredsOfGoodDeedsEntity;
import net.uniego.aida.lobecorp.entity.abnormality.standardtrainingdummyrabbit.StandardTrainingDummyRabbitEntity;
import net.uniego.aida.lobecorp.entity.ordeal.OrdealEntity;
import net.uniego.aida.lobecorp.entity.ordeal.dawn.DoubtEntity;

//初始化实体
public class EntityInit {
    public static final EntityType<DeadPlayerEntity> DEAD_PLAYER_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            LobeCorpUtil.id("dead_player_entity"), net.minecraft.entity.EntityType.Builder.create(DeadPlayerEntity::new, SpawnGroup.MISC)
                    .dimensions(0.6F, 0.3F).build("dead_player_entity"));
    //异想体
    public static final EntityType<StandardTrainingDummyRabbitEntity> STANDARD_TRAINING_DUMMY_RABBIT_ENTITY = registerAbnormality("standard_training_dummy_rabbit",
            StandardTrainingDummyRabbitEntity::new, 0.6F, 0.9F);
    public static final EntityType<OneSinAndHundredsOfGoodDeedsEntity> ONE_SIN_AND_HUNDREDS_OF_GOOD_DEEDS_ENTITY = registerAbnormality("one_sin_and_hundreds_of_good_deeds",
            OneSinAndHundredsOfGoodDeedsEntity::new, 1.2F, 2.4F);
    public static final EntityType<BeautyAndTheBeastEntity> BEAUTY_AND_THE_BEAST_ENTITY = registerAbnormality("beauty_and_the_beast",
            BeautyAndTheBeastEntity::new, 0.6F, 0.9F);
    public static final EntityType<HappyTeddyBearEntity> HAPPY_TEDDY_BEAR_ENTITY = registerAbnormality("happy_teddy_bear",
            HappyTeddyBearEntity::new, 0.6F, 0.9F);
    //考验
    public static final EntityType<DoubtEntity> DOUBT_ENTITY = registerOrdeal("doubt", DoubtEntity::new, 0.6F, 2.4F);

    public static void register() {
        //异想体
        FabricDefaultAttributeRegistry.register(STANDARD_TRAINING_DUMMY_RABBIT_ENTITY, StandardTrainingDummyRabbitEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ONE_SIN_AND_HUNDREDS_OF_GOOD_DEEDS_ENTITY, OneSinAndHundredsOfGoodDeedsEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(BEAUTY_AND_THE_BEAST_ENTITY, BeautyAndTheBeastEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(HAPPY_TEDDY_BEAR_ENTITY, HappyTeddyBearEntity.createAttributes());
        //考验
        FabricDefaultAttributeRegistry.register(DOUBT_ENTITY, DoubtEntity.createAttributes());
    }

    //注册异想体
    private static <T extends AbnormalityEntity> EntityType<T> registerAbnormality(String name, EntityType.EntityFactory<T> entityFactory,
                                                                                   float width, float height) {
        return Registry.register(Registries.ENTITY_TYPE, LobeCorpUtil.id("abnormality." + name),
                EntityType.Builder.create(entityFactory, SpawnGroup.MONSTER).dimensions(width, height).build("abnormality." + name));
    }

    //注册考验
    private static <T extends OrdealEntity> EntityType<T> registerOrdeal(String name, EntityType.EntityFactory<T> entityFactory,
                                                                         float width, float height) {
        return Registry.register(Registries.ENTITY_TYPE, LobeCorpUtil.id("ordeal." + name),
                EntityType.Builder.create(entityFactory, SpawnGroup.MONSTER).dimensions(width, height).build("ordeal." + name));
    }
}
