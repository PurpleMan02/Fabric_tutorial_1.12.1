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
                    })
                    .build());


    public static final ItemGroup BLOCK_NUMBERS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "block_numbers"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.sevenSquare))
                    .displayName(Text.translatable("itemGroup.tutorial-mod.block_numbers"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.sixSquare);
                        entries.add(ModBlocks.sevenSquare);
                        entries.add(ModBlocks.numberOre);
                    })
                    .build());

    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering custom item groups for " + TutorialMod.MOD_ID);
    }
}
