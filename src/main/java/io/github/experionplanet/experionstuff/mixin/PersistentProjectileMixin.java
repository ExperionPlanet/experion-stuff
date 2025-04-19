package io.github.experionplanet.experionstuff.mixin;

import io.github.experionplanet.experionstuff.ModInit;
import io.github.experionplanet.experionstuff.initial.ModParticles;
import io.github.experionplanet.experionstuff.utils.interfaces.PhantomArrowGetter;
import net.minecraft.entity.Entity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PersistentProjectileEntity.class)
public class PersistentProjectileMixin implements PhantomArrowGetter {

    private static final TrackedData<Boolean> PHANTOMIZED = DataTracker.registerData(PersistentProjectileEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    Entity entity = (Entity) (Object) this;
    DataTracker dataTracker = ((EntityAccessorMixin) entity).getDataTracker();

    @Inject(at = @At("TAIL"), method = "initDataTracker")
    private void initDataTrackerModified(DataTracker.Builder builder, CallbackInfo cit) {
        builder.add(PHANTOMIZED, false);
    }
    /*
    @Inject(at = @At("TAIL"), method = "onBlockHit")
    private void onBlockHitted(BlockHitResult blockHitResult, CallbackInfo ci) {
        Vec3d pos = blockHitResult.getPos();
        World world = entity.getEntityWorld();

        if (!world.isClient()) {
            ServerWorld serverWorld = (ServerWorld) world;
            serverWorld.spawnParticles(ModParticles.PHANTOM_SPLASH, pos.getX(), pos.getY(), pos.getZ(), 1, 0,0,0,0);
        }
    }*/

    @Override
    public boolean isPhantomized() {
        return this.dataTracker.get(PHANTOMIZED);
    }

    @Override
    public void setPhantomize(boolean a) {
        this.dataTracker.set(PHANTOMIZED, a);
    }

}
