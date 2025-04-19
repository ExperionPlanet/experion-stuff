package io.github.experionplanet.experionstuff.initial;

import io.github.experionplanet.experionstuff.MaybeLib;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;

public class ModItemGroup {
    public static final RegistryKey<ItemGroup> EXPERION_ITEM_GROUP_KEY = RegistryKey.of(RegistryKeys.ITEM_GROUP, MaybeLib.newID("experion_item_group"));
    public static final ItemGroup EXPERION_ITEM_GROUP = FabricItemGroup.builder()
            .displayName(Text.literal("Experion Stuffs"))
            .icon(() -> new ItemStack(Items.EXPERIENCE_BOTTLE))
            .build();

    public static void boot() {
        Registry.register(Registries.ITEM_GROUP, EXPERION_ITEM_GROUP_KEY, EXPERION_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(EXPERION_ITEM_GROUP_KEY).register(
                v -> {
                    v.add(ModItems.EXPERION_ORB);
                    v.add(ModItems.PHANTOM_BOW);

                    v.add(ModBlocks.BLEEDING_HEART);
                    v.add(ModBlocks.BLEEDING_ALBA_HEART);
                    v.add(ModBlocks.BLEEDING_CANDY_HEART);
                    v.add(ModBlocks.IRIS);
                    v.add(ModBlocks.PASSION_FLOWER);

                    v.add(ModItems.ENDLESS_VELOCITY_MUSIC_DISC);
                    v.add(ModItems.RIVER_SUN_MUSIC_DISC);
                    v.add(ModItems.ROLLING_HAY_MUSIC_DISC);


                }
        );
    }
}
