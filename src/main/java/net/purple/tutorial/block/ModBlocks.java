package net.purple.tutorial.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.purple.tutorial.TutorialMod;

public class ModBlocks {

    public static final Block sixSquare = registerBlock("six_square",
            new Block(AbstractBlock.Settings.create().strength(6f, 36f)
                    .requiresTool().sounds(BlockSoundGroup.DRIPSTONE_BLOCK)
                    .mapColor(MapColor.PALE_YELLOW)));

    public static final Block sevenSquare = registerBlock("seven_square",
            new Block(AbstractBlock.Settings.create().strength(7f, 49f)
                    .requiresTool().sounds(BlockSoundGroup.DRIPSTONE_BLOCK)
                    .mapColor(MapColor.PALE_YELLOW)));

    public static final Block numberOre = registerBlock("number_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()
                            .sounds(BlockSoundGroup.NETHER_GOLD_ORE)));

    public static Block registerBlock (String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }

    public static void registerBlockItem (String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering mod blocks for " + TutorialMod.MOD_ID);
    }
}
