package net.purple.tutorial;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.purple.tutorial.Component.ModDataComponents;
import net.purple.tutorial.block.ModBlocks;
import net.purple.tutorial.item.ModItemGroups;
import net.purple.tutorial.item.ModItems;
import net.purple.tutorial.util.hammerUsageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorial-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.RegisterModItems();
        ModBlocks.registerModBlocks();
        ModItemGroups.registerItemGroups();
        ModDataComponents.registerDataComponentType();


        FuelRegistry.INSTANCE.add(ModItems.Starlight_Ashes, 600);

        PlayerBlockBreakEvents.BEFORE.register(new hammerUsageEvent());
	}
}