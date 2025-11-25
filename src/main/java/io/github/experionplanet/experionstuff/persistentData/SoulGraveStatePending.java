package io.github.experionplanet.experionstuff.persistentData;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Uuids;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateType;

import java.util.*;

public class SoulGraveStatePending extends PersistentState {
    public static final Codec<SoulGraveStatePending> CODEC = RecordCodecBuilder.create(inst ->
            inst.group(
                    Codec.unboundedMap(
                            Uuids.CODEC,
                            Codec.STRING
                    ).fieldOf("souls").forGetter(s -> s.souls)
            ).apply(inst, SoulGraveStatePending::new)
    );

    public SoulGraveStatePending(Map<UUID, String> stored) {
        this.souls = new HashMap<>();
        for (Map.Entry<UUID, String> s : stored.entrySet()) {
            souls.put(s.getKey(), s.getValue());
        }
    }

    public SoulGraveStatePending() {
        this(new HashMap<>());
    }

    public Map<UUID, String> souls;

    public static final PersistentStateType<SoulGraveStatePending> TYPE = new PersistentStateType<>("souls_pending", SoulGraveStatePending::new, CODEC, null);

    public static SoulGraveStatePending get(ServerWorld world) {
        return world.getPersistentStateManager().getOrCreate(TYPE);
    }

    public void markPending(UUID uuid, String id) {
        souls.put(uuid, id);
        markDirty();
    }

    public boolean contains(UUID uuid) {
        return souls.containsKey(uuid);
    }

    public void expirePending(UUID uuid) {
        souls.remove(uuid);
        markDirty();
    }
}
