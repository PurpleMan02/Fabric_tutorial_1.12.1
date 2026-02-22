package net.purple.tutorial.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.purple.tutorial.TutorialMod;
import net.purple.tutorial.block.ModBlocks;
import net.purple.tutorial.item.ModItems;
import net.purple.tutorial.util.ModTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> SEVEN_SMELTABLES = List.of(ModItems.Six, ModItems.Seven);

        offerSmelting(exporter, SEVEN_SMELTABLES, RecipeCategory.MISC, ModItems.Seven,
                100f, 100, "seven");
        offerBlasting(exporter, SEVEN_SMELTABLES, RecipeCategory.MISC, ModItems.Seven,
                100f, 100, "seven");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.Six, RecipeCategory.MISC,
                ModBlocks.SixSquare);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.Seven, RecipeCategory.MISC,
                ModBlocks.SevenSquare);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.Chisel)
                .pattern("III")
                .pattern(" S ")
                .pattern("   ")
                .input('I', Items.IRON_NUGGET)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                .offerTo(exporter);
        //in case of two different recipes using the same item, add the ", Identifier.of(TutorialMod.MOD_ID, "name" "
        //to the (exporter) line to create two differently named recipes for the data generation

        offerShapelessRecipe(exporter, ModItems.Six, ModBlocks.SixSquare, "misc", 9);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.Numberium_Sword)
                .pattern(" N ")
                .pattern(" N ")
                .pattern(" S ")
                .input('N', ModItems.Numberium)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.Numberium), conditionsFromItem(ModItems.Numberium))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.Numberium_Pickaxe)
                .pattern("NNN")
                .pattern(" S ")
                .pattern(" S ")
                .input('N', ModItems.Numberium)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.Numberium), conditionsFromItem(ModItems.Numberium))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.Numberium_Axe)
                .pattern("NN ")
                .pattern("NS ")
                .pattern(" S ")
                .input('N', ModItems.Numberium)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.Numberium), conditionsFromItem(ModItems.Numberium))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.Numberium_Shovel)
                .pattern(" N ")
                .pattern(" S ")
                .pattern(" S ")
                .input('N', ModItems.Numberium)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.Numberium), conditionsFromItem(ModItems.Numberium))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.Numberium_Hoe)
                .pattern(" NN")
                .pattern(" S ")
                .pattern(" S ")
                .input('N', ModItems.Numberium)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.Numberium), conditionsFromItem(ModItems.Numberium))
                .offerTo(exporter);



    }
}
