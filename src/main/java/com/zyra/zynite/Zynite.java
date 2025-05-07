package com.zyra.zynite;

import com.zyra.zynite.block.ModBlocks;
import com.zyra.zynite.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Zynite implements ModInitializer {
	public static final String MOD_ID = "zynite";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}