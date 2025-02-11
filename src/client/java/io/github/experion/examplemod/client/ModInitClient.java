package io.github.experion.examplemod.client;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModInitClient implements ClientModInitializer {
  public static final Logger LOGGER = LoggerFactory.getLogger(ModInitClient.class);

  @Override
  public void onInitializeClient() {
    LOGGER.info("Hello, World! (Client initialize)");
  }
}
