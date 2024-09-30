package net.uniego.aida.lobecorp.init;

import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.registry.Registries;
import net.uniego.aida.lobecorp.item.LobeCorpItem;
import net.uniego.aida.lobecorp.item.LobeCorpItemModel;
import net.uniego.aida.lobecorp.item.badge.BadgeModel;
import net.uniego.aida.lobecorp.item.badge.badges.*;
import net.uniego.aida.lobecorp.item.ego.suit.EGOSuit;
import net.uniego.aida.lobecorp.item.ego.suit.models.SuitModel;
import net.uniego.aida.lobecorp.item.ego.weapon.EGOWeapon;
import net.uniego.aida.lobecorp.item.ego.weapon.models.StickModel;
import net.uniego.aida.lobecorp.renderer.EGOWeaponRenderer;

import java.util.HashMap;
import java.util.Map;

//初始化模型
public class ModelInit {
    private static final Map<LobeCorpItem, LobeCorpItemModel> lobecorpItemModels = new HashMap<>();

    //注册EGO武器模型
    public static void registerEGOWeaponModels() {
        registerEGOWeaponModel(EGOWeapon.CODE_RIOT_STICK, new StickModel());
        registerEGOWeaponModel(EGOWeapon.RED_RIOT_STICK, new StickModel());
        registerEGOWeaponModel(EGOWeapon.WHITE_RIOT_STICK, new StickModel());
        registerEGOWeaponModel(EGOWeapon.BLACK_RIOT_STICK, new StickModel());
        registerEGOWeaponModel(EGOWeapon.PALE_RIOT_STICK, new StickModel());
    }

    //注册脑叶公司物品模型
    public static void registerLobeCorpItemModels() {
        lobecorpItemModels.put(EGOSuit.CODE_SUIT, new SuitModel(SuitModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(EGOSuit.STANDARD_SUIT, new SuitModel(SuitModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(ControlBadge.CONTROL_BADGE, new BadgeModel(BadgeModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(InformationBadge.INFORMATION_BADGE, new BadgeModel(BadgeModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(SecurityBadge.SECURITY_BADGE, new BadgeModel(BadgeModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(TrainingBadge.TRAINING_BADGE, new BadgeModel(BadgeModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(CentralCommandBadge.CENTRAL_COMMAND_BADGE, new BadgeModel(BadgeModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(WelfareBadge.WELFARE_BADGE, new BadgeModel(BadgeModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(DisciplinaryBadge.DISCIPLINARY_BADGE, new BadgeModel(BadgeModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(RecordBadge.RECORD_BADGE, new BadgeModel(BadgeModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(ExtractionBadge.EXTRACTION_BADGE, new BadgeModel(BadgeModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(ArchitectureBadge.ARCHITECTURE_BADGE, new BadgeModel(BadgeModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(EGOSuit.FLESH_BOUND_SUIT, new SuitModel(SuitModel.getTexturedModelData().createModel()));
    }

    //注册EGO武器模型
    public static void registerEGOWeaponModel(EGOWeapon egoWeapon, EntityModel<Entity> entityModel) {
        BuiltinItemRendererRegistry.INSTANCE.register(egoWeapon,
                new EGOWeaponRenderer(entityModel, Registries.ITEM.getId(egoWeapon).getPath()));
    }

    //获取脑叶公司物品模型
    public static LobeCorpItemModel getLobeCorpItemModel(LobeCorpItem loecorpItem) {
        return lobecorpItemModels.get(loecorpItem);
    }

    public static void register() {
        registerEGOWeaponModels();
        registerLobeCorpItemModels();
    }
}
