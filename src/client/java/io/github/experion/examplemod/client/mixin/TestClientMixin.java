package io.github.experion.examplemod.client.mixin;

import io.github.experion.examplemod.client.ModInitClient;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class TestClientMixin {
  @Inject(at = @At("HEAD"), method = "run")
  private void run(CallbackInfo info) {
    ModInitClient.LOGGER.info("TestClient Mixin Initialize!");
  }
}
