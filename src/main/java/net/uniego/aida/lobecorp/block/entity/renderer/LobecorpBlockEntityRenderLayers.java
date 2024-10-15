package net.uniego.aida.lobecorp.block.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.uniego.aida.lobecorp.util.LobeCorpUtil;

@Environment(EnvType.CLIENT)
public class LobecorpBlockEntityRenderLayers {
    public static void register(){
    }

    private static EntityModelLayer registerMain(String id){
        return new EntityModelLayer(LobeCorpUtil.id(id), "main");
    }
}
