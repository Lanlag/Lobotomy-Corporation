package net.uniego.aida.lobecorp.datagen.model;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.uniego.aida.lobecorp.item.LobeCorpItem;
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
    }
}
