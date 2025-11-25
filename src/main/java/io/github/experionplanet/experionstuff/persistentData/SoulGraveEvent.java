package io.github.experionplanet.experionstuff.persistentData;

import io.github.experionplanet.experionstuff.ModInit;
import io.github.experionplanet.experionstuff.initial.ModItems;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static io.github.experionplanet.experionstuff.initial.ModDataComponents.SOUL_ID;
import static io.github.experionplanet.experionstuff.initial.ModDataComponents.SOUL_UUID;

public class SoulGraveEvent {
    public static void registerSoulGrave() {

        ServerPlayerEvents.AFTER_RESPAWN.register((oldPlr, newPlr, alive) -> {
            if (!alive) {
                UUID uuid = newPlr.getUuid();
                ServerWorld serverWorld = newPlr.getEntityWorld();
                SoulGraveStatePending pendingState = SoulGraveStatePending.get(serverWorld);

                if (pendingState.contains(uuid)) {
                    String soulID = pendingState.souls.get(uuid);

                    ItemStack soulOrb = new ItemStack(ModItems.SOUL_ORB);
                    soulOrb.set(SOUL_ID, soulID);
                    soulOrb.set(SOUL_UUID, uuid.toString());

                    pendingState.expirePending(uuid);

                    newPlr.getInventory().insertStack(soulOrb);
                }
            }
        });

    }
}
