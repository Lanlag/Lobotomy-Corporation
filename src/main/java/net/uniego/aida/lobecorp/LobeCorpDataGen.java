package net.uniego.aida.lobecorp;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.uniego.aida.lobecorp.datagen.lang.EnUsLang;
import net.uniego.aida.lobecorp.datagen.lang.ZhCnLang;
import net.uniego.aida.lobecorp.datagen.model.ItemModel;
import net.uniego.aida.lobecorp.datagen.tag.BlockTag;
import net.uniego.aida.lobecorp.datagen.tag.ItemTag;

public class LobeCorpDataGen implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        //生成语言文件
        pack.addProvider(ZhCnLang::new);
        pack.addProvider(EnUsLang::new);
        //生成物品标签文件
        pack.addProvider(ItemTag::new);
        //生成方块标签文件
        pack.addProvider(BlockTag::new);
        //生成物品模型文件
        pack.addProvider(ItemModel::new);
    }
}
