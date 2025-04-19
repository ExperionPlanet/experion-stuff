package io.github.experionplanet.experionstuff.client.mixin;

import io.github.experionplanet.experionstuff.MaybeLib;
import io.github.experionplanet.experionstuff.utils.interfaces.PhantomArrowGetter;
import net.minecraft.client.render.entity.ArrowEntityRenderer;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ArrowEntityRenderer.class)
public class ArrowEntityRendererMixin {
    private static final Identifier PHANTOM_TEXTURE = MaybeLib.newID("textures/entity/phantom_arrow.png");

    @Inject(at = @At("HEAD"), method = "getTexture", cancellable = true)
    private void getTexture(ArrowEntity arrowEntity, CallbackInfoReturnable<Identifier> cit) {
        if (((PhantomArrowGetter) arrowEntity).isPhantomized()) {
            cit.setReturnValue(PHANTOM_TEXTURE);
        }

    }

}
