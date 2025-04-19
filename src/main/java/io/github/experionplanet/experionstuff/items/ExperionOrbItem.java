package io.github.experionplanet.experionstuff.items;

import io.github.experionplanet.experionstuff.initial.ModDataComponents;
import io.github.experionplanet.experionstuff.initial.ModEnchantments;
import io.github.experionplanet.experionstuff.initial.ModSoundEvents;
import io.github.experionplanet.experionstuff.utils.EnchantmentUtils;
import net.minecraft.client.item.TooltipType;
import net.minecraft.component.DataComponentType;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.List;

public class ExperionOrbItem extends Item {
    public ExperionOrbItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient()) {
            boolean succ = false;

            if (user.isSneaking()) {
                int withdrawEXP = getEXP(stack,false);

                if (withdrawEXP > 0) {
                    stack.set(ModDataComponents.CURRENT_EXP, 0);

                    world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSoundEvents.EXPERION_ORB_OUT, SoundCategory.PLAYERS);

                    if (EnchantmentHelper.getLevel(ModEnchantments.ORB_SHARING, stack) > 0) {
                        Vec3d pos = user.getPos();
                        while( withdrawEXP > 0) {
                            int i = ExperienceOrbEntity.roundToOrbSize(withdrawEXP);
                            withdrawEXP -= i;

                            Random rand = world.getRandom();

                            double angle = rand.nextDouble() * 2 * Math.PI;
                            double speed = rand.nextDouble() * 0.5 + 0.3;
                            double ySpeed = rand.nextDouble() * 0.3 + 0.1;

                            double offsetX = Math.cos(angle) * speed;
                            double offsetZ = Math.sin(angle) * speed;

                            ExperienceOrbEntity orb = new ExperienceOrbEntity(world, pos.getX(), pos.getY(), pos.getZ(), i);
                            orb.setVelocity(offsetX, ySpeed, offsetZ);
                            world.spawnEntity(orb);
                        }
                    } else {
                        EnchantmentUtils.addPlayerXP(user, withdrawEXP);
                    }

                }else {
                    user.sendMessage(Text.literal("Empty").formatted(Formatting.RED), true);
                }

            } else {
                int storeEXP = EnchantmentUtils.getPlayerXP(user);
                if (storeEXP > 0) {
                    int totalStore = totalAddings(stack, storeEXP);

                    if (totalStore > 0) {
                        EnchantmentUtils.addPlayerXP(user,-totalStore);
                        stack.set(ModDataComponents.CURRENT_EXP, getEXP(stack, false) + totalStore);

                        world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSoundEvents.EXPERION_ORB_IN, SoundCategory.PLAYERS);

                        succ = true;
                    }else {
                        user.sendMessage(Text.literal("It's maxed out!").formatted(Formatting.RED), true);
                    }
                }else {
                    user.sendMessage(Text.literal("No EXP left").formatted(Formatting.RED), true);
                }
            }

            if (succ) {
                return TypedActionResult.success(stack, true);
            }
        }

        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        int currEXP = getEXP(stack, false);

        tooltip.add(Text.literal("EXP: " + currEXP + "/" + getEXP(stack, true)).formatted(Formatting.YELLOW));
        tooltip.add(Text.literal("LEVELS: " + EnchantmentUtils.getLevelForExperience(currEXP) + "/" + getMAXLEVELS(stack)).formatted(Formatting.GREEN));

        super.appendTooltip(stack, context, tooltip, type);
    }

    private static int getEXP(ItemStack stack, boolean maxMode) {
        DataComponentType<Integer> y = ModDataComponents.CURRENT_EXP;
        int res = 0;
        int maxLevels = getMAXLEVELS(stack);
        if (stack.get(y) != null && !maxMode) {
            res = stack.get(y);
        } else if (maxMode) {
            return EnchantmentUtils.getExperienceForLevel(maxLevels);
        }
        return res;
    }

    private static int getMAXLEVELS(ItemStack stack) {
        return 30 * MathHelper.clamp(EnchantmentHelper.getLevel(ModEnchantments.ORB_CAPACITY, stack), 1, 3);
    }

    private static int totalAddings(ItemStack stack, int amount) {
        int curr = getEXP(stack, false);
        int max = getEXP(stack, true);
        if (curr >= max) {
            return 0;
        } else if (curr + amount <= max) {
            return amount;
        }else {
            return max - curr;
        }
    }

    @Override
    public int getItemBarStep(ItemStack stack) {
        int curr = getEXP(stack, false);
        int max = getEXP(stack, true);

        return MathHelper.clamp(Math.round(13.0F - (float)(max - curr) * 13.0F / (float) max), 0, 13);
    }

    @Override
    public boolean isItemBarVisible(ItemStack stack) {
        return true;
    }

    @Override
    public int getItemBarColor(ItemStack stack) {
        return MathHelper.hsvToRgb(3f, 1f, 1f);
    }
}
