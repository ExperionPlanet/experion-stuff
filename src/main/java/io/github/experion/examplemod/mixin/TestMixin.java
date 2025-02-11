package io.github.experion.examplemod.mixin;


import io.github.experion.examplemod.ModInit;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class TestMixin {
  @Inject(at = @At("HEAD"), method = "runServer")
  private void runServer(CallbackInfo info) {
    ModInit.LOGGER.info("TestMixin Initialized!");
  }
}
