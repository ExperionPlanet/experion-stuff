package io.github.experionplanet.experionstuff.initial;

import io.github.experionplanet.experionstuff.MaybeLib;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSoundEvents {

    public static final SoundEvent EXPERION_ORB_IN = register("experion_orb_in");
    public static final SoundEvent EXPERION_ORB_OUT = register("experion_orb_out");

    public static final SoundEvent ENDLESS_VELOCITY = register("endless_velocity");
    public static final SoundEvent ROLLING_HAY = register("rolling_hay");
    public static final SoundEvent RIVER_SUN = register("river_sun");

    public static final SoundEvent PHANTOM_BOW_SHOOT = register("phantom_bow_shoot");
    public static final SoundEvent PHANTOM_BOW_IMPACT = register("phantom_bow_impact");
    public static final SoundEvent PHANTOM_BOW_DROP = register("phantom_bow_drop");

    public static void init() {}

    public static SoundEvent register(String id) {
        return Registry.register(Registries.SOUND_EVENT, MaybeLib.newID(id), SoundEvent.of(MaybeLib.newID(id)));
    }
}
