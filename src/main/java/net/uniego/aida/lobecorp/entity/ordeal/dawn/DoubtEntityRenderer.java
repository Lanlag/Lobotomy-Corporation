package net.uniego.aida.lobecorp.entity.ordeal.dawn;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.uniego.aida.lobecorp.LobeCorpUtil;

//疑问实体渲染器
public class DoubtEntityRenderer extends MobEntityRenderer<DoubtEntity, DoubtEntityModel> {
    public DoubtEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new DoubtEntityModel(DoubtEntityModel.getTexturedModelData().createModel()), 0.5F);
    }

    @Override
    public Identifier getTexture(DoubtEntity entity) {
        return LobeCorpUtil.id("textures/entity/ordeal/doubt_alpha.png");
    }
}
