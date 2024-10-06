package net.uniego.aida.lobecorp.entity.abnormality.judgementbird;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;

//审判鸟实体渲染器
public class JudgementBirdEntityRenderer extends MobEntityRenderer<JudgementBirdEntity, JudgementBirdEntityModel> {
    public JudgementBirdEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new JudgementBirdEntityModel(JudgementBirdEntityModel.getTexturedModelData().createModel()), 0.5F);
    }

    @Override
    public Identifier getTexture(JudgementBirdEntity entity) {
        return LobeCorpUtil.id("textures/entity/abnormality/judgement_bird.png");
    }
}
