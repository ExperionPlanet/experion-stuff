package io.github.experionplanet.experionstuff.initial;

import io.github.experionplanet.experionstuff.MaybeLib;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModParticles {

    public static final SimpleParticleType PHANTOM_SPLASH = FabricParticleTypes.simple();

    public static void boot() {
        Registry.register(Registries.PARTICLE_TYPE, MaybeLib.newID("phantom_splash"), PHANTOM_SPLASH);
    }

}
