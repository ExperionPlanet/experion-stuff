package io.github.experionplanet.experionstuff.datagen.datagens;

import io.github.experionplanet.experionstuff.initial.ModEnchantments;
import io.github.experionplanet.experionstuff.initial.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class EnchantmentDataGen extends FabricDynamicRegistryProvider {
    public EnchantmentDataGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
    //regEnchant(new Enchantment(Enchantment.properties(ModTags.ORB_ITEM_ENCHANTABLE, 5, 3, Enchantment.leveledCost(23, 9), Enchantment.constantCost(50), 5, EquipmentSlot.MAINHAND)), "orb_capacity");
    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup, Entries entries) {
        register(entries, ModEnchantments.ORB_CAPACITY, Enchantment.builder(Enchantment.definition(wrapperLookup.getOrThrow(RegistryKeys.ITEM).getOrThrow(ModTags.ORB_ITEM_ENCHANTABLE), 5, 3, Enchantment.constantCost(25), Enchantment.constantCost(50), 5, AttributeModifierSlot.MAINHAND)));
    }

    private void register(Entries entries, RegistryKey<Enchantment> key, Enchantment.Builder builder, ResourceCondition... resourceConditions) {
        entries.add(key, builder.build(key.getValue()), resourceConditions);
    }

    @Override
    public String getName() {
        return "EnchantmentDataGen";
    }
}
