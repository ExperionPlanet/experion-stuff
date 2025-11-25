package io.github.experionplanet.experionstuff.mixin;

import io.github.experionplanet.experionstuff.ModInit;
import io.github.experionplanet.experionstuff.initial.ModItems;
import io.github.experionplanet.experionstuff.persistentData.SoulGraveStateLoader;
import io.github.experionplanet.experionstuff.persistentData.SoulGraveStatePending;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(LivingEntity.class)
public class LivingEntitySoulMixin {
    @Inject(method = "drop", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;dropInventory(Lnet/minecraft/server/world/ServerWorld;)V", shift = At.Shift.BEFORE))
    private void changeSoul(ServerWorld serverWorld, DamageSource damageSource, CallbackInfo ci) {
        if (((Object) this) instanceof ServerPlayerEntity plr) {
            try {
                PlayerInventory plrInventory = plr.getInventory();

                boolean fond = false;

                for (int i = 0; i < plr.getInventory().size(); i++) {
                    ItemStack s = plr.getInventory().getStack(i);
                    if (s.isOf(ModItems.SOUL_ORB)) {
                        fond = true;
                        break;
                    }
                }

                if (fond) {
                    ModInit.LOGGER.info("YAAAOOHHHHH");


                    List<ItemStack> collected = new ArrayList<>();
                    for (int i = 0; i < plr.getInventory().size(); i++) {
                        ItemStack s = plr.getInventory().getStack(i);

                        if (!s.isEmpty()) {
                            collected.add(s.copy());
                            ModInit.LOGGER.info(s.toString());
                        };
                    }

                    plrInventory.clear();


                    SoulGraveStateLoader soulState = SoulGraveStateLoader.get(serverWorld);
                    SoulGraveStatePending pendingState = SoulGraveStatePending.get(serverWorld);
                    String resID = soulState.addSoul(plr.getUuid(), collected);
                    pendingState.markPending(plr.getUuid(), resID);
                }
            }catch (Throwable a) {
                ModInit.LOGGER.info("Yeah no, Something went wrong with soul Grave");
                ModInit.LOGGER.info(a.toString());
            }



        }
    }

}
