package io.github.experionplanet.experionstuff.datagen.datagens;

import io.github.experionplanet.experionstuff.initial.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class BlockLootDataGen extends FabricBlockLootTableProvider {
    public BlockLootDataGen(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.PASSION_FLOWER);
        addDrop(ModBlocks.IRIS);

        addDrop(ModBlocks.BLEEDING_ALBA_HEART);
        addDrop(ModBlocks.BLEEDING_HEART);
        addDrop(ModBlocks.BLEEDING_CANDY_HEART);

        addDrop(ModBlocks.ORANGE_WHEAT_CELOSIA);
        addDrop(ModBlocks.PINK_WHEAT_CELOSIA);
        addDrop(ModBlocks.YELLOW_WHEAT_CELOSIA);

        addDrop(ModBlocks.PINK_BEE_BALM);
        addDrop(ModBlocks.RED_BEE_BALM);

        addDrop(ModBlocks.FLOWER_CLUSTER, flowerbedDrops(ModBlocks.FLOWER_CLUSTER));

    }
}
