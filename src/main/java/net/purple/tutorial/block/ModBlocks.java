package net.purple.tutorial.block;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.purple.tutorial.TutorialMod;
import net.purple.tutorial.block.custom.MagicBlock;
import net.purple.tutorial.block.custom.PinkGarnetLampBlock;

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

    public static final Block PINK_GARNET_LAMP = registerBlock("pink_garnet_lamp",
            new PinkGarnetLampBlock(AbstractBlock.Settings.create()
                    .strength(1f).luminance(state -> state.get(PinkGarnetLampBlock.CLICKED) ? 15 : 0)));

    public static final Block MAGIC_BLOCK_STAIRS = registerBlock("magic_block_stairs",
            new StairsBlock(ModBlocks.MagicBlock.getDefaultState(),
                    AbstractBlock.Settings.create().strength(3f, 1f)));

    public static final Block MAGIC_BLOCK_SLAB = registerBlock("magic_block_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(3f, 1f)));

    public static final Block MAGIC_BLOCK_BUTTON = registerBlock("magic_block_button",
            new ButtonBlock(BlockSetType.IRON, 2,
                    AbstractBlock.Settings.create().strength(3f, 1f)));

    public static final Block MAGIC_BLOCK_PRESSURE_PLATE = registerBlock("magic_block_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON,
                    AbstractBlock.Settings.create().strength(3f, 1f)));

    public static final Block MAGIC_BLOCK_FENCE = registerBlock("magic_block_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(3f, 1f).noCollision()));

    public static final Block MAGIC_BLOCK_GATE = registerBlock("magic_block_gate",
            new FenceGateBlock(WoodType.ACACIA,
                    AbstractBlock.Settings.create().strength(3f, 1f)));

        public static final Block MAGIC_BLOCK_WALL = registerBlock("magic_block_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(3f, 1f)));

    public static final Block MAGIC_BLOCK_DOOR = registerBlock("magic_block_door",
            new DoorBlock(BlockSetType.WARPED,
                    AbstractBlock.Settings.create().strength(3f, 1f).nonOpaque()));

    public static final Block MAGIC_BLOCK_TRAP_DOOR = registerBlock("magic_block_trap_door",
            new TrapdoorBlock(BlockSetType.WARPED,
                    AbstractBlock.Settings.create().strength(3f, 1f).nonOpaque()));

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
