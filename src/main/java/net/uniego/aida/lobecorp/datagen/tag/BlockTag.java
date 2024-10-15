package net.uniego.aida.lobecorp.datagen.tag;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.uniego.aida.lobecorp.init.BlockInit;
import net.uniego.aida.lobecorp.init.TagInit;

import java.util.concurrent.CompletableFuture;

public class BlockTag extends FabricTagProvider.BlockTagProvider{
    public BlockTag(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        //信号线
        getOrCreateTagBuilder(TagInit.SIGNAL_WIRE)
                .add(BlockInit.SIGNAL_WIRE);
    }
}
