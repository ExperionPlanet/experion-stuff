package io.github.experionplanet.experionstuff.datagen.datagens;

import io.github.experionplanet.experionstuff.MaybeLib;
import io.github.experionplanet.experionstuff.initial.ModBlocks;
import io.github.experionplanet.experionstuff.initial.ModEnchantments;
import io.github.experionplanet.experionstuff.initial.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class TranslateDataGen extends FabricLanguageProvider {
    public TranslateDataGen(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translator) {
        translator.add(ModItems.EXPERION_ORB, "Experion Orb");
        translator.add(ModEnchantments.ORB_CAPACITY, "Orb Capacity");
        translator.add(ModItems.EXPI_ICON, "Expi Icon");

        translator.add(ModBlocks.BLEEDING_HEART, "Bleeding Heart");
        translator.add(ModBlocks.BLEEDING_ALBA_HEART, "Bleeding Alba Heart");
        translator.add(ModBlocks.BLEEDING_CANDY_HEART, "Bleeding Candy Heart");

        translator.add(ModBlocks.IRIS, "Iris");
        translator.add(ModBlocks.PASSION_FLOWER, "Passion Flower");

        translator.add(ModItems.PHANTOM_BOW, "Phantom Bow");

        translator.add(ModItems.ENDLESS_VELOCITY_MUSIC_DISC, "Music Disc");
        translator.add("item.experion_stuff.endless_velocity_music_disc.desc", "C418 - Endless Velocity");

        translator.add(ModItems.RIVER_SUN_MUSIC_DISC, "Music Disc");
        translator.add("item.experion_stuff.river_sun_music_disc.desc", "C418 - River Sun");

        translator.add(ModItems.ROLLING_HAY_MUSIC_DISC, "Music Disc");
        translator.add("item.experion_stuff.rolling_hay_music_disc.desc", "C418 - Rolling Hay");
    }
}
