package io.github.experionplanet.experionstuff.utils;

import io.github.experionplanet.experionstuff.MaybeLib;
import io.github.experionplanet.experionstuff.initial.ModSoundEvents;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModJukeboxSongs {
    public static final RegistryKey<JukeboxSong> ENDLESS_VELOCITY = of("endless_velocity");
    public static final RegistryKey<JukeboxSong> ROLLING_HAY = of("rolling_hay");
    public static final RegistryKey<JukeboxSong> RIVER_SUN = of("river_sun");

    private static RegistryKey<JukeboxSong> of(String id) {
        return RegistryKey.of(RegistryKeys.JUKEBOX_SONG, MaybeLib.newID(id));
    }

    private static void register(Registerable<JukeboxSong> registry, RegistryKey<JukeboxSong> key, RegistryEntry.Reference<SoundEvent> soundEvent, int lengthInSeconds, int comparatorOutput) {
        registry.register(key, new JukeboxSong(soundEvent, Text.translatable(Util.createTranslationKey("jukebox_song", key.getValue())), (float)lengthInSeconds, comparatorOutput));
    }

    public static void bootsrap(Registerable<JukeboxSong> registry) {
        register(registry, ENDLESS_VELOCITY, ModSoundEvents.ENDLESS_VELOCITY, 347, 7);
        register(registry, ROLLING_HAY, ModSoundEvents.ROLLING_HAY, 192, 7);
        register(registry, RIVER_SUN, ModSoundEvents.RIVER_SUN, 136, 7);
    }
}
