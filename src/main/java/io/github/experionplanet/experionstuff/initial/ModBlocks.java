package io.github.experionplanet.experionstuff.initial;

import io.github.experionplanet.experionstuff.MaybeLib;
import io.github.experionplanet.experionstuff.blocks.FirePitBlock;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.BlockSoundGroup;

public class ModBlocks {

    public static final Block IRIS = registerPlant(StatusEffects.DOLPHINS_GRACE, 20, "iris");
    public static final Block PASSION_FLOWER = registerPlant(StatusEffects.BLINDNESS, 40, "passion_flower");
    public static final Block BLEEDING_HEART = registerPlant(StatusEffects.REGENERATION, 20, "bleeding_heart");
    public static final Block BLEEDING_ALBA_HEART = registerPlant(StatusEffects.NIGHT_VISION, 60,  "bleeding_alba_heart");
    public static final Block BLEEDING_CANDY_HEART = registerPlant(StatusEffects.REGENERATION, 40,  "bleeding_candy_heart");

    public static final Block FLOWER_CLUSTER = MaybeLib.regBlock(FlowerbedBlock::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.BAMBOO_SAPLING).breakInstantly().noCollision(),"flower_cluster", true);

    public static final Block ORANGE_WHEAT_CELOSIA = registerPlant(StatusEffects.FIRE_RESISTANCE, 60, "orange_wheat_celosia");
    public static final Block PINK_WHEAT_CELOSIA = registerPlant(StatusEffects.REGENERATION, 60, "pink_wheat_celosia");
    public static final Block YELLOW_WHEAT_CELOSIA = registerPlant(StatusEffects.GLOWING, 60, "yellow_wheat_celosia");

    public static final Block PINK_BEE_BALM = registerPlant(StatusEffects.REGENERATION, 60, "pink_bee_balm");
    public static final Block RED_BEE_BALM = registerPlant(StatusEffects.INSTANT_HEALTH, 60, "red_bee_balm");

    public static final Block BASALT_FIRE_PIT = MaybeLib.regBlock(FirePitBlock::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.BASALT),"basalt_fire_pit", true);

    private static Block registerPlant(RegistryEntry<StatusEffect> stewEffect, int effectInLengthSeconds, String name) {
        return MaybeLib.regBlock((s) -> new FlowerBlock(stewEffect, effectInLengthSeconds, s), AbstractBlock.Settings.create().sounds(BlockSoundGroup.BAMBOO_SAPLING).breakInstantly().noCollision(), name, true);
    }

    public static void init() {}
}
