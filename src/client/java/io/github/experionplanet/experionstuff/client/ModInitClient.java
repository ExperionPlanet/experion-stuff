package io.github.experionplanet.experionstuff.client;

import io.github.experionplanet.experionstuff.client.particles.PhantomDustParticle;
import io.github.experionplanet.experionstuff.client.particles.PhantomSplashParticle;
import io.github.experionplanet.experionstuff.initial.ModBlocks;
import io.github.experionplanet.experionstuff.initial.ModItems;
import io.github.experionplanet.experionstuff.initial.ModParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModInitClient implements ClientModInitializer {
  public static final Logger LOGGER = LoggerFactory.getLogger(ModInitClient.class);

  @Override
  public void onInitializeClient() {
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLEEDING_ALBA_HEART, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLEEDING_HEART, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLEEDING_CANDY_HEART, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.IRIS, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PASSION_FLOWER, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FLOWER_CLUSTER, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_BEE_BALM, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_BEE_BALM, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.YELLOW_WHEAT_CELOSIA, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORANGE_WHEAT_CELOSIA, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_WHEAT_CELOSIA, RenderLayer.getCutout());


    ModelPredicateProviderRegistry.register(ModItems.PHANTOM_BOW, new Identifier("pull"), (stack, world, entity, seed) -> {
      if (entity == null) {
        return 0.0F;
      } else {
        return entity.getActiveItem() != stack ? 0.0F : (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0F;
      }
    });

    ModelPredicateProviderRegistry.register(ModItems.PHANTOM_BOW, new Identifier("pulling"), (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F);

    regParti(ModParticles.PHANTOM_SPLASH, PhantomSplashParticle.Factory::new);
    regParti(ModParticles.PHANTOM_DUST, PhantomDustParticle.Factory::new);

  }

  private static <T extends ParticleEffect> void regParti(ParticleType<T> var1, ParticleFactoryRegistry.PendingParticleFactory<T> var2) {
    ParticleFactoryRegistry.getInstance().register(var1,var2);
  }

}
