package io.github.experionplanet.experionstuff.initial;

import io.github.experionplanet.experionstuff.MaybeLib;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.BlockSoundGroup;

public class ModBlocks {

    public static final Block IRIS = MaybeLib.regBlock(new FlowerBlock(StatusEffects.DOLPHINS_GRACE, 1f, AbstractBlock.Settings.create().sounds(BlockSoundGroup.BAMBOO_SAPLING).breakInstantly()), "iris", true);
    public static final Block PASSION_FLOWER = MaybeLib.regBlock(new FlowerBlock(StatusEffects.BLINDNESS, 2f, AbstractBlock.Settings.create().sounds(BlockSoundGroup.BAMBOO_SAPLING).breakInstantly()), "passion_flower", true);


    public static final Block BLEEDING_HEART = MaybeLib.regBlock(new FlowerBlock(StatusEffects.REGENERATION, 1f, AbstractBlock.Settings.create().sounds(BlockSoundGroup.BAMBOO_SAPLING).breakInstantly()), "bleeding_heart", true);
    public static final Block BLEEDING_ALBA_HEART = MaybeLib.regBlock(new FlowerBlock(StatusEffects.NIGHT_VISION, 3f, AbstractBlock.Settings.create().sounds(BlockSoundGroup.BAMBOO_SAPLING).breakInstantly()), "bleeding_alba_heart", true);
    public static final Block BLEEDING_CANDY_HEART = MaybeLib.regBlock(new FlowerBlock(StatusEffects.REGENERATION, 2f, AbstractBlock.Settings.create().sounds(BlockSoundGroup.BAMBOO_SAPLING).breakInstantly()), "bleeding_candy_heart", true);


    public static void init() {}
}
