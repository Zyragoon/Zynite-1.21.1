package com.zyra.zynite.block;

import com.zyra.zynite.Zynite;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;


public class ModBlocks {
    public static final Block RAW_ZYNITE_BLOCK = registerBlock("raw_zynite_block",
            new Block(AbstractBlock.Settings.create().strength(7,15).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DEEPSLATE_ZYNITE_ORE = registerBlock("deepslate_zynite_ore",
            new Block(AbstractBlock.Settings.create().strength(8,15).requiresTool().sounds(BlockSoundGroup.DEEPSLATE).emissiveLighting(ModBlocks::always).luminance(value -> 2)));
    public static final Block BLOCK_OF_ZYNITE = registerBlock("block_of_zynite",
            new Block(AbstractBlock.Settings.create().strength(9,20).requiresTool().sounds(BlockSoundGroup.METAL)));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Zynite.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(Zynite.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        Zynite.LOGGER.info("registering Mod Blocks for " + Zynite.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.RAW_ZYNITE_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.DEEPSLATE_ZYNITE_ORE);
            fabricItemGroupEntries.add(ModBlocks.BLOCK_OF_ZYNITE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.RAW_ZYNITE_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.DEEPSLATE_ZYNITE_ORE);
        });
    }
    private static boolean always(BlockState state, BlockView world, BlockPos pos){
        return true;
    }
}
