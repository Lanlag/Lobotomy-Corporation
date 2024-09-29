package net.uniego.aida.lobecorp.entity;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientConnectionState;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EntityPose;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.NetworkSide;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.UUID;

//玩家尸体渲染器
public class DeadPlayerEntityRenderer extends EntityRenderer<DeadPlayerEntity> {
    public DeadPlayerEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public void render(DeadPlayerEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        MinecraftClient client = MinecraftClient.getInstance();
        Optional<UUID> playerUuid = entity.getPlayerUuid();
        if (playerUuid.isPresent()) {
            UUID uuid = playerUuid.get();
            matrices.push();
            matrices.translate(1.0, 0.0, 0.0);
            if (client.world != null) {
                ClientPlayerEntity clientPlayer = new ClientPlayerEntity(client, client.world,
                        new ClientPlayNetworkHandler(client, new ClientConnection(NetworkSide.CLIENTBOUND),
                                new ClientConnectionState(new GameProfile(uuid, "null"), null, null, FeatureSet.empty(),
                                        null, null, null, null, null, false)),
                        null, null, false, false) {
                    @Override
                    public boolean shouldRenderName() {
                        return false;
                    }

                    @Override
                    public boolean isSpectator() {
                        return false;
                    }
                };
                clientPlayer.setPose(EntityPose.SLEEPING);
                clientPlayer.prevHeadYaw = 25;
                clientPlayer.setHeadYaw(25);
                clientPlayer.setUuid(uuid);

                client.getEntityRenderDispatcher().getRenderer(clientPlayer).render(clientPlayer, 0, tickDelta, matrices, vertexConsumers, light);
            }
            matrices.pop();
        }
    }

    @Override
    public Identifier getTexture(DeadPlayerEntity entity) {
        return null;
    }
}
