package io.github.experionplanet.experionstuff.datagen.datagens;

import io.github.experionplanet.experionstuff.initial.ModBlocks;
import io.github.experionplanet.experionstuff.initial.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModelDataGen extends FabricModelProvider {
    public ModelDataGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator gen) {
        gen.registerTintableCross(ModBlocks.BLEEDING_HEART, BlockStateModelGenerator.TintType.NOT_TINTED);
        gen.registerTintableCross(ModBlocks.BLEEDING_ALBA_HEART, BlockStateModelGenerator.TintType.NOT_TINTED);
        gen.registerTintableCross(ModBlocks.BLEEDING_CANDY_HEART, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ENDLESS_VELOCITY_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.RIVER_SUN_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROLLING_HAY_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.IRIS.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.PASSION_FLOWER.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModItems.EXPI_ICON, Models.GENERATED);
    }
}
