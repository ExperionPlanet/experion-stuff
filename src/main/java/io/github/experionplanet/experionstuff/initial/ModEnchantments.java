package io.github.experionplanet.experionstuff.initial;

import io.github.experionplanet.experionstuff.MaybeLib;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.tag.ItemTags;

public class ModEnchantments {
    public static final Enchantment ORB_CAPACITY = MaybeLib.regEnchant(new Enchantment(Enchantment.properties(ModTags.ORB_ITEM_ENCHANTABLE, 5, 3, Enchantment.leveledCost(5, 3), Enchantment.constantCost(50), 2, EquipmentSlot.MAINHAND)), "orb_capacity");
    public static final Enchantment ORB_SHARING = MaybeLib.regEnchant(new Enchantment(Enchantment.properties(ModTags.ORB_ITEM_ENCHANTABLE, 2, 1, Enchantment.constantCost(1), Enchantment.constantCost(41), 4, EquipmentSlot.MAINHAND)),"orb_sharing");

    public static void init() {}
}
