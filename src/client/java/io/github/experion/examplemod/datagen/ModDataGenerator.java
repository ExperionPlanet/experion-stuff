package io.github.experion.examplemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModDataGenerator implements DataGeneratorEntrypoint {
    private static final Logger LOGGER = LoggerFactory.getLogger(ModDataGenerator.class);

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        LOGGER.info("Mod DataGenerator Initialize");
    }
}
