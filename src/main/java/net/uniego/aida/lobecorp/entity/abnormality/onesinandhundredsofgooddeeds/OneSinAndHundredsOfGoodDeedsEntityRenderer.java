package net.uniego.aida.lobecorp.entity.abnormality.onesinandhundredsofgooddeeds;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;

//一罪与百善实体渲染器
public class OneSinAndHundredsOfGoodDeedsEntityRenderer extends MobEntityRenderer<OneSinAndHundredsOfGoodDeedsEntity, OneSinAndHundredsOfGoodDeedsEntityModel> {

    public OneSinAndHundredsOfGoodDeedsEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new OneSinAndHundredsOfGoodDeedsEntityModel(OneSinAndHundredsOfGoodDeedsEntityModel.getTexturedModelData().createModel()), 0.5F);
    }

    @Override
    public Identifier getTexture(OneSinAndHundredsOfGoodDeedsEntity entity) {
        return LobeCorpUtil.id("textures/entity/abnormality/one_sin_and_hundreds_of_good_deeds.png");
    }
}
