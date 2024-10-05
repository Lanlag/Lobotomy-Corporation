package net.uniego.aida.lobecorp.init;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.uniego.aida.lobecorp.entity.DeadPlayerEntityRenderer;
import net.uniego.aida.lobecorp.entity.abnormality.beautyandtheBeast.BeautyAndTheBeastEntityRenderer;
import net.uniego.aida.lobecorp.entity.abnormality.onesinandhundredsofgooddeeds.OneSinAndHundredsOfGoodDeedsEntityRenderer;
import net.uniego.aida.lobecorp.entity.abnormality.standardtrainingdummyrabbit.StandardTrainingDummyRabbitEntityRenderer;
import net.uniego.aida.lobecorp.entity.ordeal.dawn.DoubtEntityRenderer;

//初始化实体渲染器
public class EntityRendererInit {
    public static void register() {
        EntityRendererRegistry.register(EntityInit.DEAD_PLAYER_ENTITY, DeadPlayerEntityRenderer::new);
        //异想体
        EntityRendererRegistry.register(EntityInit.STANDARD_TRAINING_DUMMY_RABBIT_ENTITY, StandardTrainingDummyRabbitEntityRenderer::new);
        EntityRendererRegistry.register(EntityInit.ONE_SIN_AND_HUNDREDS_OF_GOOD_DEEDS_ENTITY, OneSinAndHundredsOfGoodDeedsEntityRenderer::new);
        EntityRendererRegistry.register(EntityInit.BEAUTY_AND_THE_BEAST_ENTITY, BeautyAndTheBeastEntityRenderer::new);
        //考验
        EntityRendererRegistry.register(EntityInit.DOUBT_ENTITY, DoubtEntityRenderer::new);
    }
}
