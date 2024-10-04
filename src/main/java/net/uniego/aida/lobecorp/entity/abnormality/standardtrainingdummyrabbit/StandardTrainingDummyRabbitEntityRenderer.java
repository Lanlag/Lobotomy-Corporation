package net.uniego.aida.lobecorp.entity.abnormality.standardtrainingdummyrabbit;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.uniego.aida.lobecorp.LobeCorpUtil;

//教学兔兔实体渲染器
public class StandardTrainingDummyRabbitEntityRenderer extends MobEntityRenderer<StandardTrainingDummyRabbitEntity, StandardTrainingDummyRabbitEntityModel> {

    public StandardTrainingDummyRabbitEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new StandardTrainingDummyRabbitEntityModel(StandardTrainingDummyRabbitEntityModel.getTexturedModelData().createModel()), 0.5F);
    }

    @Override
    public Identifier getTexture(StandardTrainingDummyRabbitEntity entity) {
        return LobeCorpUtil.id("textures/entity/abnormality/standard_training_dummy_rabbit.png");
    }
}
