package net.uniego.aida.lobecorp.entity.abnormality.beautyandtheBeast;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;

//美女与野兽实体渲染器
public class BeautyAndTheBeastEntityRenderer extends MobEntityRenderer<BeautyAndTheBeastEntity, BeautyAndTheBeastEntityModel> {

    public BeautyAndTheBeastEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new BeautyAndTheBeastEntityModel(BeautyAndTheBeastEntityModel.getTexturedModelData().createModel()), 0.5F);
    }

    @Override
    public Identifier getTexture(BeautyAndTheBeastEntity entity) {
        return LobeCorpUtil.id("textures/entity/abnormality/beauty_and_the_beast.png");
    }
}
