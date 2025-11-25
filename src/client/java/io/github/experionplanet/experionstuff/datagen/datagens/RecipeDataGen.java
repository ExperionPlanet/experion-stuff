package io.github.experionplanet.experionstuff.datagen.datagens;

import io.github.experionplanet.experionstuff.initial.ModBlocks;
import io.github.experionplanet.experionstuff.initial.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class RecipeDataGen extends FabricRecipeProvider {
    public RecipeDataGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {

        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                createShaped(RecipeCategory.MISC, ModItems.EXPERION_ORB, 1)
                        .pattern(" # ")
                        .pattern("#OP")
                        .pattern(" P ")
                        .input('#', Items.EXPERIENCE_BOTTLE)
                        .input('O', Items.ENDER_PEARL)
                        .input('P', Items.EMERALD)
                        .criterion("criterion_experion_orb", conditionsFromItem(Items.EXPERIENCE_BOTTLE))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.COMBAT, ModItems.PHANTOM_BOW,1)
                        .pattern(" #S")
                        .pattern("* S")
                        .pattern(" #S")
                        .input('#', Items.PHANTOM_MEMBRANE)
                        .input('*', Items.EMERALD)
                        .input('S', Items.STRING)
                        .criterion("criterion_phantom_bow", conditionsFromItem(Items.PHANTOM_MEMBRANE))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.TOOLS, ModItems.LUCY_THE_AXE, 1)
                        .pattern("I##")
                        .pattern("#K ")
                        .pattern(" * ")
                        .input('I', Blocks.IRON_BLOCK.asItem())
                        .input('#', Blocks.REDSTONE_BLOCK.asItem())
                        .input('*', Items.STICK)
                        .input('K', Items.NETHERITE_AXE)
                        .criterion("criterion_lucy_axe", conditionsFromItem(Items.NETHERITE_AXE))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLEEDING_ALBA_HEART, Items.POPPY, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLEEDING_HEART, Items.POPPY, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLEEDING_CANDY_HEART, Items.POPPY, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.IRIS, Items.POPPY, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PASSION_FLOWER, Items.POPPY, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLOWER_CLUSTER, Items.POPPY, 4);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORANGE_WHEAT_CELOSIA, Items.POPPY, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_WHEAT_CELOSIA, Items.POPPY, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.YELLOW_WHEAT_CELOSIA, Items.POPPY, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_BEE_BALM, Items.POPPY, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_BEE_BALM, Items.POPPY, 1);

                offerStonecuttingRecipe(RecipeCategory.MISC, ModItems.ENDLESS_VELOCITY_MUSIC_DISC, Items.MUSIC_DISC_CAT, 1);
                offerStonecuttingRecipe(RecipeCategory.MISC, ModItems.RIVER_SUN_MUSIC_DISC, Items.MUSIC_DISC_CAT, 1);
                offerStonecuttingRecipe(RecipeCategory.MISC, ModItems.ROLLING_HAY_MUSIC_DISC, Items.MUSIC_DISC_CAT, 1);

                offerStonecuttingRecipe(RecipeCategory.MISC, ModItems.EXPI_ICON, ModItems.EXPERION_ORB, 1);
            }
        };
    }


    @Override
    public String getName() {
        return "";
    }
}
