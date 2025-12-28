package net.purple.tutorial.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.purple.tutorial.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.NumberOre)
                .add(ModBlocks.SixSquare)
                .add(ModBlocks.SevenSquare);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.NumberOre)
                .add(ModBlocks.SixSquare)
                .add(ModBlocks.SevenSquare);

        //the type of tags matters - to make it connect to wooden fences need to change
        //the type of fences to "wooden fences" and so forth
        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.MAGIC_BLOCK_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.MAGIC_BLOCK_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.MAGIC_BLOCK_WALL);



    }
}
