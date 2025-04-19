package io.github.experionplanet.experionstuff;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class MaybeLib {
    public static Item regItem(Item v, String id) {
        return Registry.register(Registries.ITEM, newID(id), v);
    }

    public static Block regBlock(Block v, String id, boolean item) {
        if (item) {
            Registry.register(Registries.ITEM, newID(id), new BlockItem(v, new Item.Settings()));
        }

        return Registry.register(Registries.BLOCK, newID(id), v);
    }

    public static Enchantment regEnchant(Enchantment v, String id) {
        return Registry.register(Registries.ENCHANTMENT, newID(id), v);
    }

    public static Identifier newID(String id) {
        return Identifier.of(ModInit.ID, id);
    }
}
