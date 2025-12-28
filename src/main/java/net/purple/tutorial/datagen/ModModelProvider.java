package net.purple.tutorial.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.purple.tutorial.block.ModBlocks;
import net.purple.tutorial.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NumberOre);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SixSquare);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SevenSquare);

        BlockStateModelGenerator.BlockTexturePool magicBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MagicBlock);

        magicBlockPool.stairs(ModBlocks.MAGIC_BLOCK_STAIRS);
        magicBlockPool.wall(ModBlocks.MAGIC_BLOCK_WALL);
        magicBlockPool.fence(ModBlocks.MAGIC_BLOCK_FENCE);
        magicBlockPool.fenceGate(ModBlocks.MAGIC_BLOCK_GATE);
        magicBlockPool.slab(ModBlocks.MAGIC_BLOCK_SLAB);
        magicBlockPool.button(ModBlocks.MAGIC_BLOCK_BUTTON);
        magicBlockPool.pressurePlate(ModBlocks.MAGIC_BLOCK_PRESSURE_PLATE);

        blockStateModelGenerator.registerDoor(ModBlocks.MAGIC_BLOCK_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.MAGIC_BLOCK_TRAP_DOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.Six, Models.GENERATED);
        itemModelGenerator.register(ModItems.Seven, Models.GENERATED);
        itemModelGenerator.register(ModItems.Cauliflower, Models.GENERATED);
        itemModelGenerator.register(ModItems.Starlight_Ashes, Models.GENERATED);
        itemModelGenerator.register(ModItems.Chisel, Models.GENERATED);
    }
}
