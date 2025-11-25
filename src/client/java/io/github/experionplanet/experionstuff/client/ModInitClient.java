package io.github.experionplanet.experionstuff.client;

import io.github.experionplanet.experionstuff.client.misc.ItemToolTip;
import io.github.experionplanet.experionstuff.client.misc.TemporaryHologramTextRenderer;
import io.github.experionplanet.experionstuff.initial.ModBlocks;
import io.github.experionplanet.experionstuff.initial.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.entity.DisplayEntityRenderer;
import net.minecraft.client.render.entity.EmptyEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactories;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModInitClient implements ClientModInitializer {
  public static final Logger LOGGER = LoggerFactory.getLogger(ModInitClient.class);

  @Override
  public void onInitializeClient() {
    BlockRenderLayerMap.putBlock(ModBlocks.BLEEDING_ALBA_HEART, BlockRenderLayer.CUTOUT);
    BlockRenderLayerMap.putBlock(ModBlocks.BLEEDING_HEART, BlockRenderLayer.CUTOUT);
    BlockRenderLayerMap.putBlock(ModBlocks.BLEEDING_CANDY_HEART, BlockRenderLayer.CUTOUT);
    BlockRenderLayerMap.putBlock(ModBlocks.IRIS, BlockRenderLayer.CUTOUT);
    BlockRenderLayerMap.putBlock(ModBlocks.PASSION_FLOWER, BlockRenderLayer.CUTOUT);
    BlockRenderLayerMap.putBlock(ModBlocks.FLOWER_CLUSTER, BlockRenderLayer.CUTOUT);
    BlockRenderLayerMap.putBlock(ModBlocks.RED_BEE_BALM, BlockRenderLayer.CUTOUT);
    BlockRenderLayerMap.putBlock(ModBlocks.PINK_BEE_BALM, BlockRenderLayer.CUTOUT);
    BlockRenderLayerMap.putBlock(ModBlocks.YELLOW_WHEAT_CELOSIA, BlockRenderLayer.CUTOUT);
    BlockRenderLayerMap.putBlock(ModBlocks.ORANGE_WHEAT_CELOSIA, BlockRenderLayer.CUTOUT);
    BlockRenderLayerMap.putBlock(ModBlocks.PINK_WHEAT_CELOSIA, BlockRenderLayer.CUTOUT);

    ItemToolTip.register();

    EntityRendererFactories.register(ModEntities.TEMPORARY_HOLOGRAM_TEXT, TemporaryHologramTextRenderer::new);


  }

  private static <T extends ParticleEffect> void regParti(ParticleType<T> var1, ParticleFactoryRegistry.PendingParticleFactory<T> var2) {
    ParticleFactoryRegistry.getInstance().register(var1,var2);
  }

}
