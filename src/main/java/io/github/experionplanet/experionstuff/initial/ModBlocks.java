package io.github.experionplanet.experionstuff.initial;

import io.github.experionplanet.experionstuff.MaybeLib;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.FlowerbedBlock;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.BlockSoundGroup;

public class ModBlocks {

    public static final Block IRIS = MaybeLib.regBlock(new FlowerBlock(StatusEffects.DOLPHINS_GRACE, 1f, AbstractBlock.Settings.create().sounds(BlockSoundGroup.BAMBOO_SAPLING).breakInstantly().noCollision()), "iris", true);
    public static final Block PASSION_FLOWER = MaybeLib.regBlock(new FlowerBlock(StatusEffects.BLINDNESS, 2f, AbstractBlock.Settings.create().sounds(BlockSoundGroup.BAMBOO_SAPLING).breakInstantly().noCollision()), "passion_flower", true);
    public static final Block BLEEDING_HEART = MaybeLib.regBlock(new FlowerBlock(StatusEffects.REGENERATION, 1f, AbstractBlock.Settings.create().sounds(BlockSoundGroup.BAMBOO_SAPLING).breakInstantly().noCollision()), "bleeding_heart", true);
    public static final Block BLEEDING_ALBA_HEART = MaybeLib.regBlock(new FlowerBlock(StatusEffects.NIGHT_VISION, 3f, AbstractBlock.Settings.create().sounds(BlockSoundGroup.BAMBOO_SAPLING).breakInstantly().noCollision()), "bleeding_alba_heart", true);
    public static final Block BLEEDING_CANDY_HEART = MaybeLib.regBlock(new FlowerBlock(StatusEffects.REGENERATION, 2f, AbstractBlock.Settings.create().sounds(BlockSoundGroup.BAMBOO_SAPLING).breakInstantly().noCollision()), "bleeding_candy_heart", true);

    public static final Block FLOWER_CLUSTER = MaybeLib.regBlock(new FlowerbedBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.BAMBOO_SAPLING).breakInstantly().noCollision()), "flower_cluster", true);

    public static final Block ORANGE_WHEAT_CELOSIA = MaybeLib.regBlock(new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 3f, AbstractBlock.Settings.create().sounds(BlockSoundGroup.BAMBOO_SAPLING).breakInstantly().noCollision()), "orange_wheat_celosia", true);
    public static final Block PINK_WHEAT_CELOSIA = MaybeLib.regBlock(new FlowerBlock(StatusEffects.REGENERATION, 3f, AbstractBlock.Settings.create().sounds(BlockSoundGroup.BAMBOO_SAPLING).breakInstantly().noCollision()), "pink_wheat_celosia", true);
    public static final Block YELLOW_WHEAT_CELOSIA = MaybeLib.regBlock(new FlowerBlock(StatusEffects.GLOWING, 3f, AbstractBlock.Settings.create().sounds(BlockSoundGroup.BAMBOO_SAPLING).breakInstantly().noCollision()), "yellow_wheat_celosia", true);

    public static final Block PINK_BEE_BALM = MaybeLib.regBlock(new FlowerBlock(StatusEffects.REGENERATION, 3f, AbstractBlock.Settings.create().sounds(BlockSoundGroup.BAMBOO_SAPLING).breakInstantly().noCollision()), "pink_bee_balm", true);
    public static final Block RED_BEE_BALM = MaybeLib.regBlock(new FlowerBlock(StatusEffects.INSTANT_HEALTH, 3f, AbstractBlock.Settings.create().sounds(BlockSoundGroup.BAMBOO_SAPLING).breakInstantly().noCollision()), "red_bee_balm", true);

    public static void init() {}
}
