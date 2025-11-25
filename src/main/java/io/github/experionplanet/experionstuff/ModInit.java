package io.github.experionplanet.experionstuff;

import com.google.common.collect.ImmutableList;
import io.github.experionplanet.experionstuff.initial.*;
import io.github.experionplanet.experionstuff.items.SoulOrbItem;
import io.github.experionplanet.experionstuff.persistentData.SoulGraveEvent;
import io.github.experionplanet.experionstuff.persistentData.SoulGraveStateLoader;
import io.github.experionplanet.experionstuff.persistentData.SoulGraveStatePending;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.player.PlayerPickItemEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static io.github.experionplanet.experionstuff.initial.ModDataComponents.SOUL_ID;

public class ModInit implements ModInitializer {
  public static final String ID = "experion_stuff";
  public static final Logger LOGGER = LoggerFactory.getLogger(ModInit.class);

  @Override
  public void onInitialize() {
    ModInit.LOGGER.info("Experion Stuff Initialized");
    ModItems.init();
    ModBlocks.init();
    ModItemGroup.boot();
    ModDataComponents.init();
    ModEnchantments.init();
    ModSoundEvents.init();
    ModEntities.init();
    ModParticles.boot();


    SoulGraveEvent.registerSoulGrave();


  }

  private void predicate() {

  }


}
