package com.zyra.zynite.datagen;

import com.zyra.zynite.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.RAW_ZYNITE_BLOCK)
                .add(ModBlocks.DEEPSLATE_ZYNITE_ORE)
                .add(ModBlocks.BLOCK_OF_ZYNITE);


        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.BLOCK_OF_ZYNITE)
                .add(ModBlocks.DEEPSLATE_ZYNITE_ORE)
                .add(ModBlocks.RAW_ZYNITE_BLOCK);
    }
}
