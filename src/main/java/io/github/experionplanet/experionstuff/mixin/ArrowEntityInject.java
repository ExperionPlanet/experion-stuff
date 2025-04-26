package io.github.experionplanet.experionstuff.mixin;

import io.github.experionplanet.experionstuff.ModInit;
import io.github.experionplanet.experionstuff.utils.interfaces.PhantomArrowGetter;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ArrowEntity.class)
public class ArrowEntityInject {


    Entity entity = (Entity) (Object) this;
    DataTracker dataTracker = ((EntityAccessorMixin) entity).getDataTracker();

    @Inject(at = @At("TAIL"), method = "onHit")
    private void OnHitted(LivingEntity entity, CallbackInfo ci) {
        World world = entity.getWorld();

        if (!world.isClient()) {
            ModInit.LOGGER.info("ITS SERVER");
        }
    }


}
