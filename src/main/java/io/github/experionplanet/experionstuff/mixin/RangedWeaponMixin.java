package io.github.experionplanet.experionstuff.mixin;

import io.github.experionplanet.experionstuff.ModInit;
import io.github.experionplanet.experionstuff.initial.ModSoundEvents;
import io.github.experionplanet.experionstuff.initial.ModTags;
import io.github.experionplanet.experionstuff.utils.interfaces.PhantomArrowGetter;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RangedWeaponItem.class)
public class RangedWeaponMixin {

    @Inject(at = @At("TAIL"), method = "createArrowEntity", cancellable = true)
    private void createArrowEntityInject(World world, LivingEntity shooter, ItemStack weaponStack, ItemStack projectileStack, boolean critical, CallbackInfoReturnable<PersistentProjectileEntity> info) {
        PersistentProjectileEntity projectile = info.getReturnValue();

        if (weaponStack.isIn(ModTags.PHANTOM_BOW)) {
            ((PhantomArrowGetter) projectile).setPhantomize(true);
            projectile.setSound(ModSoundEvents.PHANTOM_BOW_IMPACT);
        }

    }


}
