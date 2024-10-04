package net.uniego.aida.lobecorp.datagen.model;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.uniego.aida.lobecorp.item.LobeCorpItem;
import net.uniego.aida.lobecorp.item.badge.badges.*;
import net.uniego.aida.lobecorp.item.ego.gift.EGOGift;
import net.uniego.aida.lobecorp.item.ego.suit.EGOSuit;

//物品模型文件生成器
public class ItemModel extends FabricModelProvider {
    public ItemModel(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //脑叶公司
        itemModelGenerator.register(LobeCorpItem.LOBECORP_LOGO, Models.GENERATED);
        itemModelGenerator.register(LobeCorpItem.BLUE_LEAF, Models.GENERATED);
        itemModelGenerator.register(EGOSuit.CODE_SUIT, Models.GENERATED);
        itemModelGenerator.register(EGOSuit.STANDARD_SUIT, Models.GENERATED);
        itemModelGenerator.register(ControlBadge.CONTROL_BADGE, Models.GENERATED);
        itemModelGenerator.register(InformationBadge.INFORMATION_BADGE, Models.GENERATED);
        itemModelGenerator.register(SecurityBadge.SECURITY_BADGE, Models.GENERATED);
        itemModelGenerator.register(TrainingBadge.TRAINING_BADGE, Models.GENERATED);
        itemModelGenerator.register(CentralCommandBadge.CENTRAL_COMMAND_BADGE, Models.GENERATED);
        itemModelGenerator.register(WelfareBadge.WELFARE_BADGE, Models.GENERATED);
        itemModelGenerator.register(DisciplinaryBadge.DISCIPLINARY_BADGE, Models.GENERATED);
        itemModelGenerator.register(RecordBadge.RECORD_BADGE, Models.GENERATED);
        itemModelGenerator.register(ExtractionBadge.EXTRACTION_BADGE, Models.GENERATED);
        itemModelGenerator.register(ArchitectureBadge.ARCHITECTURE_BADGE, Models.GENERATED);
        //EGO武器
        //EGO护甲
        itemModelGenerator.register(EGOSuit.FLESH_BOUND_SUIT, Models.GENERATED);
        //EGO饰品
        itemModelGenerator.register(EGOGift.STANDARD_TRAINING_EGO_GIFT, Models.GENERATED);
    }
}
