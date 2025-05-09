package com.zyra.zynite.datagen;

import com.zyra.zynite.block.ModBlocks;
import com.zyra.zynite.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_ZYNITE_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOCK_OF_ZYNITE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_ZYNITE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ZYNITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_ZYNITE_CHUNK, Models.GENERATED);


        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ZYNITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ZYNITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ZYNITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ZYNITE_BOOTS));
    }
}
