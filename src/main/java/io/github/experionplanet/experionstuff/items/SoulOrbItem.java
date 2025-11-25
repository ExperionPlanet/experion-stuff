package io.github.experionplanet.experionstuff.items;

import io.github.experionplanet.experionstuff.initial.ModDataComponents;
import io.github.experionplanet.experionstuff.initial.ModItems;
import io.github.experionplanet.experionstuff.persistentData.SoulGraveStateLoader;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import static io.github.experionplanet.experionstuff.initial.ModDataComponents.SOUL_ID;
import static io.github.experionplanet.experionstuff.initial.ModDataComponents.SOUL_UUID;

public class SoulOrbItem extends Item {
    public SoulOrbItem(Settings settings) {
        super(settings);
    }


    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {
            ItemStack stack = user.getStackInHand(Hand.MAIN_HAND);

            if (stack.isOf(ModItems.SOUL_ORB)) {
                ServerWorld serverWorld = (ServerWorld) world;
                if (stack.contains(SOUL_ID) && stack.contains(SOUL_UUID)) {


                    SoulGraveStateLoader soulState = SoulGraveStateLoader.get(serverWorld);
                    UUID uuid = UUID.fromString(stack.get(SOUL_UUID));
                    String id = stack.get(SOUL_ID);
                    List<ItemStack> coll = soulState.getSoul(uuid,id);

                    stack.decrement(1);

                    if (coll != null) {
                        for (int i = 0; i < coll.size(); i++) {
                            user.getInventory().insertStack(coll.get(i).copy());
                        }
                    } else {
                        user.sendMessage(Text.literal("Oops something went wrong with " + uuid.toString() + " : " + id), false);
                    }

                    soulState.removeSoul(uuid, id);
                }else {
                    if (user.isSneaking()) {
                        SoulGraveStateLoader soulState = SoulGraveStateLoader.get(serverWorld);

                        UUID uuid = user.getUuid();

                        if (soulState.souls.get(uuid).size() > 0) {
                            Random rand = new Random();
                            String[] array = soulState.souls.get(uuid).keySet().toArray(new String[0]);
                            String randomKey = array[rand.nextInt(array.length)];

                            stack.set(SOUL_ID, randomKey);
                            stack.set(SOUL_UUID, uuid.toString());

                            user.sendMessage(Text.literal("Previous soul loaded!").formatted(Formatting.GREEN), false);
                        } else {
                            user.sendMessage(Text.literal("No previous soul left...").formatted(Formatting.RED), false);
                        }
                    }
                }
            }

        }
        return super.use(world, user, hand);
    }


    @Override
    public Text getName(ItemStack stack) {
        if (stack.contains(SOUL_ID) && stack.contains(SOUL_UUID)) {
            return Text.literal("YOUR ITEMS (Right click)").formatted(Formatting.ITALIC).formatted(Formatting.AQUA).formatted(Formatting.BOLD);
        }
        return super.getName(stack);
    }
}
