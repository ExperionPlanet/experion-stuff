package io.github.experionplanet.experionstuff.items;

import com.google.common.collect.ImmutableList;
import io.github.experionplanet.experionstuff.entities.TemporaryHologramText;
import io.github.experionplanet.experionstuff.initial.ModEntities;
import io.github.experionplanet.experionstuff.initial.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.Brightness;
import net.minecraft.entity.decoration.DisplayEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import static io.github.experionplanet.experionstuff.initial.ModDataComponents.LUCY_YAPPING_COUNT;
import static io.github.experionplanet.experionstuff.initial.ModDataComponents.LUCY_YAPPING_MAX;

public class LucyTheAxeItem extends AxeItem {
    private static final ImmutableList<String> YAPPING_QUOTES = ImmutableList.of(
            "Woooooo!",
            "Yeah!",
            "Stupid tree!",
            "Nom nom nom!",
            "We did it!",
            "I feel ALIVE!",
            "HaHAHA!",
            "YEEEESS!",
            "This is what I live for!",
            "Woo-hoohoo!",
            "RAAAA!",
            "Die! Die!",
            "Chop! Chop!",
            "Destruction!",
            "CHOP!",
            "This is AWESOME!",
            "Death to all trees!",
            "Again! Let's chop another!",
            "Nice swing!",
            "Too easy!"
    );

    public LucyTheAxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    private static void resetYapping(ItemStack stack, Random rand) {
        stack.set(LUCY_YAPPING_COUNT, 0);
        stack.set(LUCY_YAPPING_MAX, rand.nextBetween(10, 50));
    }

    private static int getYappingCount(ItemStack stack) {
        if (stack.contains(LUCY_YAPPING_COUNT)) {
            return stack.get(LUCY_YAPPING_COUNT);
        }

        return 0;
    }

    private static int getMaxYappingCount(ItemStack stack) {
        if (stack.contains(LUCY_YAPPING_MAX)) {
            return stack.get(LUCY_YAPPING_MAX);
        }

        return 0;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        boolean res = super.postMine(stack, world, state, pos, miner);

        if (res && !world.isClient()) {
            int max = getMaxYappingCount(stack);
            int curr = getYappingCount(stack);

            if (max == 0 || curr >= max) { // Trigger Yapping
                resetYapping(stack, world.getRandom());
                max = getMaxYappingCount(stack);
                curr = getYappingCount(stack);

                TemporaryHologramText holo = new TemporaryHologramText(ModEntities.TEMPORARY_HOLOGRAM_TEXT, world);
                holo.setText(Text.literal(YAPPING_QUOTES.get(world.getRandom().nextBetween(0, YAPPING_QUOTES.size() - 1))));
                holo.setPos(pos.getX() + 0.5d, pos.getY() + 0.5d, pos.getZ() + 0.5d);
                holo.setBillboardMode(DisplayEntity.BillboardMode.CENTER);

                holo.setShadowRadius(0);
                holo.setBrightness(Brightness.FULL);

                world.spawnEntity(holo);

                world.playSound(null, pos, ModSoundEvents.LUCY_YAPPING, SoundCategory.PLAYERS);
            }

            stack.set(LUCY_YAPPING_COUNT, curr + 1);
        }

        return res;
    }

    @Override
    public boolean isItemBarVisible(ItemStack stack) {
        return stack.contains(LUCY_YAPPING_MAX);
    }

    @Override
    public int getItemBarColor(ItemStack stack) {
        return ColorHelper.getArgb(151, 51, 48);
    }

    @Override
    public int getItemBarStep(ItemStack stack) {

        int curr = 1;
        int max = 1;

        if (stack.contains(LUCY_YAPPING_MAX)) {
            curr = getYappingCount(stack);
            max = getMaxYappingCount(stack);
        }

        return MathHelper.clamp(Math.round(13.0F - (float)(max - curr) * 13.0F / (float) max), 0, 13);
    }
}
