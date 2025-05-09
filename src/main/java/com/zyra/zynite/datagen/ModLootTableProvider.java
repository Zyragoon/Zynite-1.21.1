package com.zyra.zynite.datagen;

import com.zyra.zynite.block.ModBlocks;
import com.zyra.zynite.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
        public void generate() {
        addDrop(ModBlocks.RAW_ZYNITE_BLOCK);
        addDrop(ModBlocks.BLOCK_OF_ZYNITE);


        addDrop(ModBlocks.DEEPSLATE_ZYNITE_ORE, oreDrops(ModBlocks.DEEPSLATE_ZYNITE_ORE, ModItems.RAW_ZYNITE_CHUNK));
        }
    }
