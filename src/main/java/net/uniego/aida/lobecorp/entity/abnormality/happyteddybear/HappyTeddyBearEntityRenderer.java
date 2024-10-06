package net.uniego.aida.lobecorp.entity.abnormality.happyteddybear;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;

//快乐泰迪实体渲染器
public class HappyTeddyBearEntityRenderer extends MobEntityRenderer<HappyTeddyBearEntity, HappyTeddyBearEntityModel> {
    public HappyTeddyBearEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new HappyTeddyBearEntityModel(HappyTeddyBearEntityModel.getTexturedModelData().createModel()), 0.5F);
    }

    @Override
    public Identifier getTexture(HappyTeddyBearEntity entity) {
        return LobeCorpUtil.id("textures/entity/abnormality/happy_teddy_bear.png");
    }
}
