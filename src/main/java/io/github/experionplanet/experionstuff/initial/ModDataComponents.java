package io.github.experionplanet.experionstuff.initial;

import com.mojang.serialization.Codec;
import io.github.experionplanet.experionstuff.MaybeLib;
import io.github.experionplanet.experionstuff.utils.EnchantmentUtils;
import net.minecraft.component.ComponentType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.dynamic.Codecs;


import java.util.List;
import java.util.function.UnaryOperator;

public class ModDataComponents {

    public static final ComponentType<Integer> CURRENT_EXP = register("current_exp", build -> build.codec(Codecs.rangedInt(0, EnchantmentUtils.getExperienceForLevel(140))).packetCodec(PacketCodecs.VAR_INT));
    public static final ComponentType<String> SOUL_ID = register("soul_id", build -> build.codec(Codec.STRING));
    public static final ComponentType<String> SOUL_UUID = register("soul_uuid", build -> build.codec(Codec.STRING));
    public static final ComponentType<Integer> LUCY_YAPPING_COUNT = register("lucy_yapping_count", build -> build.codec(Codec.INT));
    public static final ComponentType<Integer> LUCY_YAPPING_MAX = register("lucy_yapping_max", build -> build.codec(Codec.INT));


    private static <T> ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, MaybeLib.newID(name),(builderOperator.apply(ComponentType.builder())).build());
    }

    public static void init() {}

}
