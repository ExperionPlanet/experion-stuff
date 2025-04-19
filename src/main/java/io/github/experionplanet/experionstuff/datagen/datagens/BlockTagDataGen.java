package io.github.experionplanet.experionstuff.datagen.datagens;

import io.github.experionplanet.experionstuff.initial.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class BlockTagDataGen extends FabricTagProvider<Block> {
    public BlockTagDataGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.BLOCK, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.FLOWERS)
                .add(ModBlocks.BLEEDING_ALBA_HEART)
                .add(ModBlocks.BLEEDING_HEART)
                .add(ModBlocks.BLEEDING_CANDY_HEART)
                .add(ModBlocks.IRIS)
                .add(ModBlocks.PASSION_FLOWER)
                .setReplace(false);
    }
}
