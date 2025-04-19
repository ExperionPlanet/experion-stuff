package io.github.experionplanet.experionstuff;

import io.github.experionplanet.experionstuff.initial.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModInit implements ModInitializer {
  public static final String ID = "experion_stuff";
  public static final Logger LOGGER = LoggerFactory.getLogger(ModInit.class);

  @Override
  public void onInitialize() {
    ModInit.LOGGER.info("Hello, World! (Common initialize)");
    ModItems.init();
    ModBlocks.init();
    ModItemGroup.boot();
    ModDataComponents.init();
    ModEnchantments.init();
    ModSoundEvents.init();
    ModParticles.boot();
  }

  private void predicate() {

  }
}
