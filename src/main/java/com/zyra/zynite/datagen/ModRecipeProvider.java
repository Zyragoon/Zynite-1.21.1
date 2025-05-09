package com.zyra.zynite.datagen;

import com.zyra.zynite.block.ModBlocks;
import com.zyra.zynite.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> ZYNITE_INGOT_SMELTABLES = List.of(ModItems.RAW_ZYNITE_CHUNK, ModBlocks.DEEPSLATE_ZYNITE_ORE);

        offerBlasting(exporter,ZYNITE_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.ZYNITE_INGOT, 1.5f,300, "zynite");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_ZYNITE_BLOCK)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.RAW_ZYNITE_CHUNK)
                .criterion(hasItem(ModItems.RAW_ZYNITE_CHUNK), conditionsFromItem(ModItems.RAW_ZYNITE_CHUNK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLOCK_OF_ZYNITE)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.ZYNITE_INGOT)
                .criterion(hasItem(ModItems.ZYNITE_INGOT), conditionsFromItem(ModItems.ZYNITE_INGOT))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ZYNITE_INGOT, 9)
                .input(ModBlocks.BLOCK_OF_ZYNITE)
                .criterion(hasItem(ModBlocks.BLOCK_OF_ZYNITE), conditionsFromItem(ModBlocks.BLOCK_OF_ZYNITE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_ZYNITE_CHUNK, 9)
                .input(ModBlocks.RAW_ZYNITE_BLOCK)
                .criterion(hasItem(ModBlocks.RAW_ZYNITE_BLOCK), conditionsFromItem(ModBlocks.RAW_ZYNITE_BLOCK))
                .offerTo(exporter);
    }
}
