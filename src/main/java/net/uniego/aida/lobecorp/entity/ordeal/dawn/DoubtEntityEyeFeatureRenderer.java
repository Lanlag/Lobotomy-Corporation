package net.uniego.aida.lobecorp.entity.ordeal.dawn;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.uniego.aida.lobecorp.LobeCorpUtil;

@Environment(EnvType.CLIENT)
public class DoubtEntityEyeFeatureRenderer<T extends DoubtEntity, M extends DoubtEntityModel<T>> extends EyesFeatureRenderer<T, M> {
    private static final RenderLayer SKIN = RenderLayer.getEyes(LobeCorpUtil.id("textures/entity/ordeal/doubt_alpha_eye.png"));

    public DoubtEntityEyeFeatureRenderer(FeatureRendererContext<T, M> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}
