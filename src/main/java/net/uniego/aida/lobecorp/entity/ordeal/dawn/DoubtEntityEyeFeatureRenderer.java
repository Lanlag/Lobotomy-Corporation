package net.uniego.aida.lobecorp.entity.ordeal.dawn;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.util.math.MatrixStack;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;

@Environment(EnvType.CLIENT)
public class DoubtEntityEyeFeatureRenderer<T extends DoubtEntity, M extends DoubtEntityModel<T>> extends EyesFeatureRenderer<T, M> {
    private static final RenderLayer SKIN = RenderLayer.getEyes(LobeCorpUtil.id("textures/entity/ordeal/doubt_alpha_eye.png"));

    public DoubtEntityEyeFeatureRenderer(FeatureRendererContext<T, M> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        if (entity.isAlive()) {
            VertexConsumer vertexConsumer = vertexConsumers.getBuffer(this.getEyesTexture());
            this.getContextModel().render(matrices, vertexConsumer, 15728640, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}
