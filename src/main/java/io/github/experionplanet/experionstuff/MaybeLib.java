package io.github.experionplanet.experionstuff;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class MaybeLib {
    public static Item regItem(Function<Item.Settings, Item> itemFactory, Item.Settings settings,String name) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, newID(name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static Block regBlock(Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, String name,boolean shouldRegisterItem) {
        // Create a registry key for the block
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, newID(name));
        // Create the block instance
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:moving_piston` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            // Items need to be registered with a different type of registry key, but the ID
            // can be the same.
            RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, newID(name));

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey).useBlockPrefixedTranslationKey());
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }



    public static Identifier newID(String id) {
        return Identifier.of(ModInit.ID, id);
    }
}
