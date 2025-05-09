package com.zyra.zynite.item;

import com.zyra.zynite.Zynite;
import com.zyra.zynite.custom.ModArmorMaterials;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ZYNITE_INGOT = registerItem("zynite_ingot", new Item(new Item.Settings()));
    public static final Item RAW_ZYNITE_CHUNK = registerItem("raw_zynite_chunk", new Item(new Item.Settings()));
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(Zynite.MOD_ID, name), item);
    }
    public static final Item ZYNITE_HELMET = registerItem("zynite_helmet",
        new ArmorItem(ModArmorMaterials.ZYNITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(37))));
    public static final Item ZYNITE_CHESTPLATE = registerItem("zynite_chestplate",
            new ArmorItem(ModArmorMaterials.ZYNITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(37))));
    public static final Item ZYNITE_LEGGINGS = registerItem("zynite_leggings",
            new ArmorItem(ModArmorMaterials.ZYNITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(37))));
    public static final Item ZYNITE_BOOTS = registerItem("zynite_boots",
            new ArmorItem(ModArmorMaterials.ZYNITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(37))));




    public static void registerModItems() {
        Zynite.LOGGER.info("Registering Mod Items for " + Zynite.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ZYNITE_INGOT);
            fabricItemGroupEntries.add(RAW_ZYNITE_CHUNK);
        });
    }


}
