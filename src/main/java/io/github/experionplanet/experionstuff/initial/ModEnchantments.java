package io.github.experionplanet.experionstuff.initial;

import io.github.experionplanet.experionstuff.MaybeLib;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.ItemTags;

public class ModEnchantments {
    public static final RegistryKey<Enchantment> ORB_CAPACITY = of("orb_capacity");
    public static void init() {}

    private static RegistryKey<Enchantment> of(String path) {
        return RegistryKey.of(RegistryKeys.ENCHANTMENT, MaybeLib.newID(path));
    }

    public static int getEnchantLevel(ItemStack stack, RegistryKey<Enchantment> enchantment){
        for (RegistryEntry<Enchantment> enchantments : stack.getEnchantments().getEnchantments()){
            if (enchantments.toString().contains(enchantment.getValue().toString())){
                return stack.getEnchantments().getLevel(enchantments);
            }
        }
        return 0;
    }

}
