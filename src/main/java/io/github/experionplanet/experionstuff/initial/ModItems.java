package io.github.experionplanet.experionstuff.initial;

import io.github.experionplanet.experionstuff.MaybeLib;
import io.github.experionplanet.experionstuff.items.ExperionOrbItem;
import io.github.experionplanet.experionstuff.items.PhantomBowItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.util.Rarity;

public class ModItems {

    public static final Item EXPERION_ORB = MaybeLib.regItem(new ExperionOrbItem(new Item.Settings().maxCount(1)), "experion_orb");

    public static final Item ENDLESS_VELOCITY_MUSIC_DISC = MaybeLib.regItem(new MusicDiscItem(7, ModSoundEvents.ENDLESS_VELOCITY, new Item.Settings().maxCount(1).rarity(Rarity.RARE), 347), "endless_velocity_music_disc");
    public static final Item RIVER_SUN_MUSIC_DISC = MaybeLib.regItem(new MusicDiscItem(7, ModSoundEvents.RIVER_SUN, new Item.Settings().maxCount(1).rarity(Rarity.RARE), 192), "river_sun_music_disc");
    public static final Item ROLLING_HAY_MUSIC_DISC = MaybeLib.regItem(new MusicDiscItem(7, ModSoundEvents.ROLLING_HAY, new Item.Settings().maxCount(1).rarity(Rarity.RARE), 136), "rolling_hay_music_disc");

    public static final Item PHANTOM_BOW = MaybeLib.regItem(new PhantomBowItem(new Item.Settings().maxCount(1).maxDamage(690).rarity(Rarity.RARE)), "phantom_bow");

    public static final Item EXPI_ICON = MaybeLib.regItem(new Item(new Item.Settings().maxCount(1)), "expi_icon");

    public static void init() {}
}
