package io.github.experionplanet.experionstuff.initial;

import io.github.experionplanet.experionstuff.MaybeLib;
import io.github.experionplanet.experionstuff.items.ExperionOrbItem;
import io.github.experionplanet.experionstuff.items.LucyTheAxeItem;
import io.github.experionplanet.experionstuff.items.PhantomBowItem;
import io.github.experionplanet.experionstuff.items.SoulOrbItem;
import io.github.experionplanet.experionstuff.utils.ModJukeboxSongs;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Rarity;

public class ModItems {

    public static final Item EXPERION_ORB = MaybeLib.regItem(ExperionOrbItem::new, new Item.Settings().maxCount(1).enchantable(20), "experion_orb");

    public static final Item ENDLESS_VELOCITY_MUSIC_DISC = MaybeLib.regItem(Item::new, new Item.Settings().maxCount(1).rarity(Rarity.RARE).jukeboxPlayable(ModJukeboxSongs.ENDLESS_VELOCITY), "endless_velocity_music_disc");
    public static final Item RIVER_SUN_MUSIC_DISC = MaybeLib.regItem(Item::new, new Item.Settings().maxCount(1).rarity(Rarity.RARE).jukeboxPlayable(ModJukeboxSongs.RIVER_SUN), "river_sun_music_disc");
    public static final Item ROLLING_HAY_MUSIC_DISC = MaybeLib.regItem(Item::new, new Item.Settings().maxCount(1).rarity(Rarity.RARE).jukeboxPlayable(ModJukeboxSongs.ROLLING_HAY), "rolling_hay_music_disc");

    public static final Item PHANTOM_BOW = MaybeLib.regItem(PhantomBowItem::new, new Item.Settings().maxCount(1).maxDamage(690).rarity(Rarity.RARE), "phantom_bow");

    public static final Item SOUL_ORB = MaybeLib.regItem(SoulOrbItem::new, new Item.Settings().maxCount(1), "soul_orb");
    public static final Item LUCY_THE_AXE = MaybeLib.regItem((s) -> new LucyTheAxeItem(ToolMaterial.NETHERITE, 5.0F, -3.0F, s), new Item.Settings().maxCount(1).enchantable(10), "lucy_the_axe");

    public static final Item EXPI_ICON = MaybeLib.regItem(Item::new, new Item.Settings().maxCount(1), "expi_icon");

    public static void init() {}
}
