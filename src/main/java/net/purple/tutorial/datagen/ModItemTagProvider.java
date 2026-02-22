package net.purple.tutorial.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.purple.tutorial.item.ModItems;
import net.purple.tutorial.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.Six);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.Numberium_Sword);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.Numberium_Pickaxe);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.Numberium_Axe);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.Numberium_Shovel);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.Numberium_Hoe);
    }
}
