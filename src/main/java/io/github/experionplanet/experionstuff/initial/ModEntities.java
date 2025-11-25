package io.github.experionplanet.experionstuff.initial;

import io.github.experionplanet.experionstuff.MaybeLib;
import io.github.experionplanet.experionstuff.entities.TemporaryHologramText;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<TemporaryHologramText> TEMPORARY_HOLOGRAM_TEXT = Registry.register(
            Registries.ENTITY_TYPE,
            MaybeLib.newID("temporary_hologram_text"),
            EntityType.Builder.create(TemporaryHologramText::new, SpawnGroup.MISC).dimensions(0.75f, 0.75f).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, MaybeLib.newID("temporary_hologram_text")))
    );

    public static void init() {}
}
