package net.uniego.aida.lobecorp.init;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.uniego.aida.lobecorp.item.LobeCorpItem;
import net.uniego.aida.lobecorp.item.ego.suit.EGOSuit;
import net.uniego.aida.lobecorp.item.ego.suit.model.WolfArmorModel;
import net.uniego.aida.lobecorp.item.ego.weapon.EGOWeapon;
import net.uniego.aida.lobecorp.item.ego.weapon.model.StickModel;
import net.uniego.aida.lobecorp.renderer.EGOWeaponRenderer;

import java.util.HashMap;
import java.util.Map;

//初始化模型
@Environment(EnvType.CLIENT)
public class ModelInit {
    private static final Map<LobeCorpItem, BipedEntityModel<AbstractClientPlayerEntity>> lobecorpItemModels = new HashMap<>();

    //注册EGO武器模型
    public static void registerEGOWeaponModels() {
        registerEGOWeaponModel(EGOWeapon.CODE_RIOT_STICK, new StickModel(), "code_riot_stick");
    }

    //注册脑叶公司物品模型
    public static void registerLobeCorpItemModels() {
        lobecorpItemModels.put(EGOSuit.CODE_SUIT, new WolfArmorModel(WolfArmorModel.getTexturedModelData().createModel()));
    }

    //注册EGO武器模型
    public static void registerEGOWeaponModel(EGOWeapon egoWeapon, EntityModel<Entity> entityModel, String id) {
        BuiltinItemRendererRegistry.INSTANCE.register(egoWeapon, new EGOWeaponRenderer(entityModel, id));
    }

    //获取脑叶公司物品模型
    public static BipedEntityModel<AbstractClientPlayerEntity> getLobeCorpItemModel(LobeCorpItem loeCorpItem) {
        return lobecorpItemModels.get(loeCorpItem);
    }

    public static void register() {
        registerEGOWeaponModels();
        registerLobeCorpItemModels();
    }
}
