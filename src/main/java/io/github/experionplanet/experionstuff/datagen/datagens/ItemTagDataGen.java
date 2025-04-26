package io.github.experionplanet.experionstuff.datagen.datagens;

import io.github.experionplanet.experionstuff.initial.ModBlocks;
import io.github.experionplanet.experionstuff.initial.ModItems;
import io.github.experionplanet.experionstuff.initial.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ItemTagDataGen extends FabricTagProvider<Item> {
    public ItemTagDataGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ITEM, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.ORB_ITEM_ENCHANTABLE).add(ModItems.EXPERION_ORB);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ModItems.RIVER_SUN_MUSIC_DISC)
                .add(ModItems.ROLLING_HAY_MUSIC_DISC)
                .add(ModItems.ENDLESS_VELOCITY_MUSIC_DISC)
                .setReplace(false);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ModItems.RIVER_SUN_MUSIC_DISC)
                .add(ModItems.ROLLING_HAY_MUSIC_DISC)
                .add(ModItems.ENDLESS_VELOCITY_MUSIC_DISC)
                .setReplace(false);
        getOrCreateTagBuilder(ItemTags.FLOWERS)
                .add(ModBlocks.PASSION_FLOWER.asItem())
                .add(ModBlocks.IRIS.asItem())
                .add(ModBlocks.BLEEDING_ALBA_HEART.asItem())
                .add(ModBlocks.BLEEDING_HEART.asItem())
                .add(ModBlocks.BLEEDING_CANDY_HEART.asItem())
                .add(ModBlocks.FLOWER_CLUSTER.asItem())
                .add(ModBlocks.ORANGE_WHEAT_CELOSIA.asItem())
                .add(ModBlocks.PINK_WHEAT_CELOSIA.asItem())
                .add(ModBlocks.YELLOW_WHEAT_CELOSIA.asItem())
                .add(ModBlocks.RED_BEE_BALM.asItem())
                .add(ModBlocks.PINK_BEE_BALM.asItem())
                .setReplace(false);



        getOrCreateTagBuilder(ItemTags.BOW_ENCHANTABLE).add(ModItems.PHANTOM_BOW);
        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE).add(ModItems.PHANTOM_BOW);

        getOrCreateTagBuilder(ModTags.PHANTOM_BOW).add(ModItems.PHANTOM_BOW).setReplace(false);
    }
}
