package net.purple.tutorial.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.purple.tutorial.TutorialMod;
import net.purple.tutorial.block.ModBlocks;

public class ModItemGroups {


    public static final ItemGroup NUMBERS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "numbers"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.Six))
                    .displayName(Text.translatable("itemGroup.tutorial-mod.numbers"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.Six);
                        entries.add(ModItems.Seven);
                        entries.add(ModItems.Chisel);
                        entries.add(ModItems.Cauliflower);
                        entries.add(ModItems.Starlight_Ashes);
                    })
                    .build());


    public static final ItemGroup BLOCK_NUMBERS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "block_numbers"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.SevenSquare))
                    .displayName(Text.translatable("itemGroup.tutorial-mod.block_numbers"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.SixSquare);
                        entries.add(ModBlocks.SevenSquare);
                        entries.add(ModBlocks.NumberOre);
                    })
                    .build());

    public static final ItemGroup MAGIC_BLOCKS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "magic_blocks"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.MagicBlock))
                    .displayName(Text.translatable("itemGroup.tutorial-mod.magic_blocks"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModBlocks.MagicBlock);
                        entries.add(ModBlocks.MAGIC_BLOCK_DOOR);
                        entries.add(ModBlocks.MAGIC_BLOCK_BUTTON);
                        entries.add(ModBlocks.MAGIC_BLOCK_GATE);
                        entries.add(ModBlocks.MAGIC_BLOCK_SLAB);
                        entries.add(ModBlocks.MAGIC_BLOCK_FENCE);
                        entries.add(ModBlocks.MAGIC_BLOCK_WALL);
                        entries.add(ModBlocks.MAGIC_BLOCK_STAIRS);
                        entries.add(ModBlocks.MAGIC_BLOCK_PRESSURE_PLATE);
                        entries.add(ModBlocks.MAGIC_BLOCK_TRAP_DOOR);
                    })
                    .build());

    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering custom item groups for " + TutorialMod.MOD_ID);
    }
}
