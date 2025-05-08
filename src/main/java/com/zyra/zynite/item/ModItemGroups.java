package com.zyra.zynite.item;

import com.zyra.zynite.Zynite;
import com.zyra.zynite.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup ZYNITE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Zynite.MOD_ID, "zynite_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ZYNITE_INGOT))
                    .displayName(Text.translatable("itemgroup.zynite.zynite_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ZYNITE_INGOT);
                        entries.add(ModItems.RAW_ZYNITE_CHUNK);
                        entries.add(ModBlocks.DEEPSLATE_ZYNITE_ORE);
                        entries.add(ModBlocks.BLOCK_OF_ZYNITE);
                        entries.add(ModBlocks.RAW_ZYNITE_BLOCK);

                    }).build());


    public static void registerModItemGroups() {
        Zynite.LOGGER.info("Registering Mod Item Groups for " + Zynite.MOD_ID);
    }
}








