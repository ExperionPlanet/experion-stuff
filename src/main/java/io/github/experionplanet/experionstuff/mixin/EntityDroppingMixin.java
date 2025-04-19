package io.github.experionplanet.experionstuff.mixin;

import io.github.experionplanet.experionstuff.initial.ModItems;
import io.github.experionplanet.experionstuff.initial.ModSoundEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobEntity.class)
public class EntityDroppingMixin {
    Entity entity = (Entity) (Object) this;

    @Inject(at = @At("HEAD"), method = "dropEquipment")
    private void drops(DamageSource source, int lootingMultiplier, boolean allowDrops, CallbackInfo cit) {
        Entity attacker = source.getAttacker();
        Entity mySource = source.getSource();

        if ((Object) this instanceof PhantomEntity) {
            if (attacker instanceof PlayerEntity && mySource instanceof ArrowEntity) {
                World world = attacker.getWorld();
                world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ModSoundEvents.PHANTOM_BOW_DROP, SoundCategory.NEUTRAL);
                entity.dropItem(ModItems.PHANTOM_BOW);
            }
        }

    }

}
