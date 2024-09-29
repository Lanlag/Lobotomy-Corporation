package net.uniego.aida.lobecorp.init;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.uniego.aida.lobecorp.entity.DeadPlayerEntityRenderer;
import net.uniego.aida.lobecorp.entity.ordeal.dawn.DoubtEntityRenderer;

//初始化实体渲染器
public class EntityRendererInit {
    public static void register() {
        EntityRendererRegistry.register(EntityInit.DEAD_PLAYER_ENTITY, DeadPlayerEntityRenderer::new);
        EntityRendererRegistry.register(EntityInit.DOUBT_ENTITY, DoubtEntityRenderer::new);
    }
}
