package io.github.experionplanet.experionstuff.datagen.datagens;

import io.github.experionplanet.experionstuff.initial.ModBlocks;
import io.github.experionplanet.experionstuff.initial.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class RecipeDataGen extends FabricRecipeProvider {
    public RecipeDataGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EXPERION_ORB, 1)
                .pattern(" # ")
                .pattern("#OP")
                .pattern(" P ")
                .input('#', Items.EXPERIENCE_BOTTLE)
                .input('O', Items.ENDER_PEARL)
                .input('P', Items.EMERALD)
                .criterion("criterion_experion_orb", conditionsFromItem(Items.EXPERIENCE_BOTTLE))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PHANTOM_BOW,1)
                .pattern(" #S")
                .pattern("* S")
                .pattern(" #S")
                .input('#', Items.PHANTOM_MEMBRANE)
                .input('*', Items.EMERALD)
                .input('S', Items.STRING)
                .criterion("criterion_phantom_bow", conditionsFromItem(Items.PHANTOM_MEMBRANE))
                .offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLEEDING_ALBA_HEART, Items.POPPY, 1);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLEEDING_HEART, Items.POPPY, 1);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLEEDING_CANDY_HEART, Items.POPPY, 1);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.IRIS, Items.POPPY, 1);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PASSION_FLOWER, Items.POPPY, 1);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.MISC, ModItems.EXPI_ICON, ModItems.EXPERION_ORB, 1);
    }
}
