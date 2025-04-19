package io.github.experionplanet.experionstuff.initial;

import io.github.experionplanet.experionstuff.MaybeLib;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ModTags {
    public static final TagKey<Item> ORB_ITEM_ENCHANTABLE = itemKey("enchantable/orb_item");
    public static final TagKey<Item> PHANTOM_BOW = itemKey("exclusive/phantom_bow");

    public static TagKey<Item> itemKey(String str) {
        return TagKey.of(RegistryKeys.ITEM, MaybeLib.newID(str));
    }
}
