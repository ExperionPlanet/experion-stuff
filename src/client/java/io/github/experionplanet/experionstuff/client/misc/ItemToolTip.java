package io.github.experionplanet.experionstuff.client.misc;

import io.github.experionplanet.experionstuff.initial.ModDataComponents;
import io.github.experionplanet.experionstuff.initial.ModItems;
import io.github.experionplanet.experionstuff.items.ExperionOrbItem;
import io.github.experionplanet.experionstuff.utils.EnchantmentUtils;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class ItemToolTip {
    public static void register() {
        ItemTooltipCallback.EVENT.register((stack, tooltipContext, tooltipType, tooltip) -> {
            if (stack.isOf(ModItems.EXPERION_ORB)) {
                int currEXP = ExperionOrbItem.getEXP(stack, false);

                tooltip.add(Text.literal("EXP: " + currEXP + "/" + ExperionOrbItem.getEXP(stack, true)).formatted(Formatting.YELLOW));
                tooltip.add(Text.literal("LEVELS: " + EnchantmentUtils.getLevelForExperience(currEXP) + "/" + ExperionOrbItem.getMAXLEVELS(stack)).formatted(Formatting.GREEN));
            } else if (stack.isOf(ModItems.SOUL_ORB)) {
                if (stack.contains(ModDataComponents.SOUL_ID) && stack.contains(ModDataComponents.SOUL_UUID)) {
                    tooltip.add(Text.literal("Player: ").append(Text.literal(stack.get(ModDataComponents.SOUL_ID)).formatted(Formatting.GREEN)));
                    tooltip.add(Text.literal("Soul: ").append(Text.literal(stack.get(ModDataComponents.SOUL_UUID)).formatted(Formatting.GREEN)));
                } else {
                    tooltip.add(Text.literal("Your items will be safe lil bro").formatted(Formatting.ITALIC).formatted(Formatting.DARK_GREEN));
                    tooltip.add(Text.literal("? Shift + Right-Click").formatted(Formatting.GRAY).formatted(Formatting.ITALIC));
                    tooltip.add(Text.literal("if you missed out the previous one just in case").formatted(Formatting.GRAY).formatted(Formatting.ITALIC));
                }

            } else if (stack.isOf(ModItems.LUCY_THE_AXE)) {
                tooltip.add(Text.literal("All work and no play makes").formatted(Formatting.GRAY).formatted(Formatting.ITALIC));
                tooltip.add(Text.literal("me want to chop some trees.").formatted(Formatting.GRAY).formatted(Formatting.ITALIC));

                if (stack.contains(ModDataComponents.LUCY_YAPPING_MAX)) {
                    tooltip.add(Text.literal( stack.get(ModDataComponents.LUCY_YAPPING_COUNT) + "/" + stack.get(ModDataComponents.LUCY_YAPPING_MAX)));
                }
            }
        });
    }
}
