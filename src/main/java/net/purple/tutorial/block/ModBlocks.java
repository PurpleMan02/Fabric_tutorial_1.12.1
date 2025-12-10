package net.purple.tutorial.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.purple.tutorial.TutorialMod;
import net.purple.tutorial.block.custom.MagicBlock;

public class ModBlocks {

    public static final Block SixSquare = registerBlock("six_square",
            new Block(AbstractBlock.Settings.create().strength(6f, 36f)
                    .requiresTool().sounds(BlockSoundGroup.DRIPSTONE_BLOCK)
                    .mapColor(MapColor.PALE_YELLOW)));

    public static final Block SevenSquare = registerBlock("seven_square",
            new Block(AbstractBlock.Settings.create().strength(7f, 49f)
                    .requiresTool().sounds(BlockSoundGroup.DRIPSTONE_BLOCK)
                    .mapColor(MapColor.PALE_YELLOW)));

    public static final Block NumberOre = registerBlock("number_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()
                            .sounds(BlockSoundGroup.NETHER_GOLD_ORE)));

    public static final Block MagicBlock = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create().strength(3f, 1f)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

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
