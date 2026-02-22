package net.purple.tutorial.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.purple.tutorial.block.ModBlocks;
import net.purple.tutorial.item.ModItems;

import java.util.concurrent.CompletableFuture;

//VERY IMPORTANT!!! To see how other loot tables are built, press 'double shift'
//and search "BlockLootTableGenerator"

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        RegistryWrapper.Impl<Enchantment> enchantmentRegistry = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

        addDrop(ModBlocks.SixSquare);
        addDrop(ModBlocks.SevenSquare);

        addDrop(ModBlocks.MagicBlock);
        addDrop(ModBlocks.MAGIC_BLOCK_GATE);
        addDrop(ModBlocks.MAGIC_BLOCK_BUTTON);
        addDrop(ModBlocks.MAGIC_BLOCK_STAIRS);
        addDrop(ModBlocks.MAGIC_BLOCK_PRESSURE_PLATE);
        addDrop(ModBlocks.MAGIC_BLOCK_TRAP_DOOR);
        addDrop(ModBlocks.MAGIC_BLOCK_FENCE);
        addDrop(ModBlocks.MAGIC_BLOCK_WALL);

        addDrop(ModBlocks.MAGIC_BLOCK_DOOR, doorDrops(ModBlocks.MAGIC_BLOCK_DOOR));
        addDrop(ModBlocks.MAGIC_BLOCK_SLAB, slabDrops(ModBlocks.MAGIC_BLOCK_SLAB));


        addDrop(ModBlocks.NumberOre, block -> LootTable.builder()
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(applyExplosionDecay(block,
                                ItemEntry.builder(ModItems.Numberium)
                                        .apply(ApplyBonusLootFunction.oreDrops(enchantmentRegistry.getOrThrow(Enchantments.FORTUNE)))
                        ))));
    }
}
