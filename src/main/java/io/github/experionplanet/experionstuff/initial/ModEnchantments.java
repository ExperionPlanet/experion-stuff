package io.github.experionplanet.experionstuff.initial;

import io.github.experionplanet.experionstuff.MaybeLib;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.ItemTags;

public class ModEnchantments {
    public static final Enchantment ORB_CAPACITY = regEnchant(new Enchantment(Enchantment.properties(ModTags.ORB_ITEM_ENCHANTABLE, 5, 3, Enchantment.leveledCost(23, 9), Enchantment.constantCost(50), 5, EquipmentSlot.MAINHAND)), "orb_capacity");
    //public static final Enchantment ORB_SHARING = regEnchant(new Enchantment(Enchantment.properties(ModTags.ORB_ITEM_ENCHANTABLE, 2, 1, Enchantment.constantCost(1), Enchantment.constantCost(41), 4, EquipmentSlot.MAINHAND)),"orb_sharing");

    public static void init() {}

    public static Enchantment regEnchant(Enchantment v, String id) {
        return Registry.register(Registries.ENCHANTMENT, MaybeLib.newID(id), v);
    }
}
