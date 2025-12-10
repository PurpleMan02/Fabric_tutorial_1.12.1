package net.purple.tutorial;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.purple.tutorial.block.ModBlocks;
import net.purple.tutorial.item.ModItemGroups;
import net.purple.tutorial.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorial-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.RegisterModItems();
        ModBlocks.registerModBlocks();
        ModItemGroups.registerItemGroups();


        FuelRegistry.INSTANCE.add(ModItems.Starlight_Ashes, 600);
	}
}