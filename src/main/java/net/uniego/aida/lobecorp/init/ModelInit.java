package net.uniego.aida.lobecorp.init;

import net.uniego.aida.lobecorp.item.LobeCorpItem;
import net.uniego.aida.lobecorp.item.LobeCorpItemModel;
import net.uniego.aida.lobecorp.item.badge.BadgeModel;
import net.uniego.aida.lobecorp.item.badge.badges.*;
import net.uniego.aida.lobecorp.item.ego.gift.EGOGift;
import net.uniego.aida.lobecorp.item.ego.gift.gifts.BearPawsGift;
import net.uniego.aida.lobecorp.item.ego.gift.gifts.JustitiaGift;
import net.uniego.aida.lobecorp.item.ego.gift.gifts.PenitenceGift;
import net.uniego.aida.lobecorp.item.ego.gift.models.BlessGiftModel;
import net.uniego.aida.lobecorp.item.ego.gift.models.JustitiaGiftModel;
import net.uniego.aida.lobecorp.item.ego.gift.models.PenitenceGiftModel;
import net.uniego.aida.lobecorp.item.ego.gift.models.StandardTrainingEGOGiftModel;
import net.uniego.aida.lobecorp.item.ego.suit.EGOSuit;
import net.uniego.aida.lobecorp.item.ego.suit.models.JustitiaSuitModel;
import net.uniego.aida.lobecorp.item.ego.suit.models.StandardTrainingEGOSuitModel;
import net.uniego.aida.lobecorp.item.ego.suit.models.SuitModel;
import net.uniego.aida.lobecorp.item.ego.suit.suits.PenitenceSuit;

import java.util.HashMap;
import java.util.Map;

//初始化模型
public class ModelInit {
    private static final Map<LobeCorpItem, LobeCorpItemModel> lobecorpItemModels = new HashMap<>();

    //注册脑叶公司物品模型
    public static void registerLobeCorpItemModels() {
        //EGO护甲
        lobecorpItemModels.put(EGOSuit.CODE_SUIT, new LobeCorpItemModel(SuitModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(EGOSuit.STANDARD_SUIT, new LobeCorpItemModel(SuitModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(EGOSuit.STANDARD_TRAINING_EGO_SUIT, new LobeCorpItemModel(StandardTrainingEGOSuitModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(PenitenceSuit.PENITENCE_SUIT, new LobeCorpItemModel(StandardTrainingEGOSuitModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(EGOSuit.HORN_SUIT, new LobeCorpItemModel(StandardTrainingEGOSuitModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(EGOSuit.BEAR_PAWS_SUIT, new LobeCorpItemModel(StandardTrainingEGOSuitModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(EGOSuit.JUSTITIA_SUIT, new LobeCorpItemModel(JustitiaSuitModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(EGOSuit.FLESH_BOUND_SUIT, new LobeCorpItemModel(SuitModel.getTexturedModelData().createModel()));
        //EGO饰品
        lobecorpItemModels.put(EGOGift.STANDARD_TRAINING_EGO_GIFT, new LobeCorpItemModel(StandardTrainingEGOGiftModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(PenitenceGift.PENITENCE_GIFT, new LobeCorpItemModel(PenitenceGiftModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(EGOGift.HORN_GIFT, new LobeCorpItemModel(StandardTrainingEGOGiftModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(BearPawsGift.BEAR_PAWS_GIFT, new LobeCorpItemModel(StandardTrainingEGOGiftModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(JustitiaGift.JUSTITIA_GIFT, new LobeCorpItemModel(JustitiaGiftModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(EGOGift.BLESS_GIFT, new LobeCorpItemModel(BlessGiftModel.getTexturedModelData().createModel()));
        //部门袖标
        lobecorpItemModels.put(ControlBadge.CONTROL_BADGE, new LobeCorpItemModel(BadgeModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(InformationBadge.INFORMATION_BADGE, new LobeCorpItemModel(BadgeModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(SecurityBadge.SECURITY_BADGE, new LobeCorpItemModel(BadgeModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(TrainingBadge.TRAINING_BADGE, new LobeCorpItemModel(BadgeModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(CentralCommandBadge.CENTRAL_COMMAND_BADGE, new LobeCorpItemModel(BadgeModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(WelfareBadge.WELFARE_BADGE, new LobeCorpItemModel(BadgeModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(DisciplinaryBadge.DISCIPLINARY_BADGE, new LobeCorpItemModel(BadgeModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(RecordBadge.RECORD_BADGE, new LobeCorpItemModel(BadgeModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(ExtractionBadge.EXTRACTION_BADGE, new LobeCorpItemModel(BadgeModel.getTexturedModelData().createModel()));
        lobecorpItemModels.put(ArchitectureBadge.ARCHITECTURE_BADGE, new LobeCorpItemModel(BadgeModel.getTexturedModelData().createModel()));
    }

    //获取脑叶公司物品模型
    public static LobeCorpItemModel getLobeCorpItemModel(LobeCorpItem loecorpItem) {
        return lobecorpItemModels.get(loecorpItem);
    }

    public static void register() {
        registerLobeCorpItemModels();
    }
}
