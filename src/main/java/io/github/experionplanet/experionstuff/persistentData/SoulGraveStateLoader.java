package io.github.experionplanet.experionstuff.persistentData;

import com.mojang.datafixers.DataFixer;
import com.mojang.datafixers.types.Type;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.experionplanet.experionstuff.ModInit;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Uuids;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateType;


import java.nio.file.Path;
import java.util.*;

public class SoulGraveStateLoader extends PersistentState {
    public static final Codec<SoulGraveStateLoader> CODEC = RecordCodecBuilder.create(inst ->
            inst.group(
                    Codec.unboundedMap(
                            Uuids.CODEC,
                            Codec.unboundedMap(
                                    Codec.STRING,
                                    ItemStack.CODEC.listOf()
                            )
                    ).fieldOf("souls").forGetter(s -> s.souls)
            ).apply(inst, SoulGraveStateLoader::new)
    );

    public SoulGraveStateLoader(Map<UUID, Map<String, List<ItemStack>>> stored) {
        this.souls = new HashMap<>();


        for (var entry : stored.entrySet()) {
            UUID uuid = entry.getKey();
            ModInit.LOGGER.info("Load " + uuid.toString());
            Map<String, List<ItemStack>> innerMap = entry.getValue();

            Map<String, List<ItemStack>> mutableInner = new HashMap<>();
            for (var innerEntry : innerMap.entrySet()) {
                ModInit.LOGGER.info("SubLoad " + innerEntry.getKey());
                mutableInner.put(
                        innerEntry.getKey(),
                        new ArrayList<>(innerEntry.getValue())
                );
            }

            this.souls.put(uuid, mutableInner);
        }

        ModInit.LOGGER.info("Size Loaded " + this.souls.size());
    }

    public SoulGraveStateLoader() {
        this.souls = new HashMap<>();
    }

    public Map<UUID, Map<String, List<ItemStack>>> souls;

    public static final PersistentStateType<SoulGraveStateLoader> TYPE = new PersistentStateType<>("souls_data", SoulGraveStateLoader::new, CODEC, null);

    public static SoulGraveStateLoader get(ServerWorld world) {
        return world.getPersistentStateManager().getOrCreate(TYPE);
    }

    public String addSoul(UUID uuid, List<ItemStack> collected) {

        String id = UUID.randomUUID().toString();

        if (!souls.containsKey(uuid)) {
            souls.put(uuid, new HashMap<>());
        }

        souls.get(uuid).put(id, collected);

        markDirty();

        return id;
    }

    public List<ItemStack> getSoul(UUID uuid, String soulID) {
        if (!souls.containsKey(uuid)) {
            souls.put(uuid, new HashMap<>());
            markDirty();
        }

        if (souls.get(uuid).containsKey(soulID)) {
            return souls.get(uuid).get(soulID);
        }

        return null;

    }

    public void removeSoul(UUID uuid, String soulID) {
        if (!souls.containsKey(uuid)) {
            souls.put(uuid, new HashMap<>());
        }

        souls.get(uuid).remove(soulID);

        markDirty();
    }

}
