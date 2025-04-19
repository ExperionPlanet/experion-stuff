package io.github.experionplanet.experionstuff.initial;

import com.mojang.serialization.Codec;
import io.github.experionplanet.experionstuff.utils.EnchantmentUtils;
import net.minecraft.component.DataComponentType;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.dynamic.Codecs;

import java.util.function.UnaryOperator;

public class ModDataComponents {
    public static final DataComponentType<Integer> CURRENT_EXP = register("current_exp", build -> build.codec(Codecs.rangedInt(0, EnchantmentUtils.getExperienceForLevel(140))).packetCodec(PacketCodecs.VAR_INT));

    private static <T> DataComponentType<T> register(String name, UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, new Identifier(name), (builderOperator.apply(DataComponentType.builder())).build());
    }

    public static void init() {}
}
