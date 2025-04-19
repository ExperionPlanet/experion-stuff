package io.github.experionplanet.experionstuff.datagen;

import io.github.experionplanet.experionstuff.datagen.datagens.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModDataGenerator implements DataGeneratorEntrypoint {
    private static final Logger LOGGER = LoggerFactory.getLogger(ModDataGenerator.class);

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModelDataGen::new);
        pack.addProvider(ItemTagDataGen::new);
        pack.addProvider(TranslateDataGen::new);
        pack.addProvider(BlockTagDataGen::new);
        pack.addProvider(RecipeDataGen::new);

        LOGGER.info("Mod DataGenerator Initialize");
    }


}
