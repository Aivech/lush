package com.aivech.lush.world.features.config;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.FeatureConfig;

public class ReedFeatureConfig implements FeatureConfig {
    public final int size;
    public final BlockState plant;

    public ReedFeatureConfig(int size, BlockState plant) {
        this.size = size;
        this.plant = plant;
    }

    @Override
    public <T> Dynamic<T> serialize(DynamicOps<T> dynamicOps) {
        return new Dynamic<>(dynamicOps,dynamicOps.createMap(ImmutableMap.of(
                dynamicOps.createString("size"),dynamicOps.createInt(this.size),
                dynamicOps.createString("plant"),BlockState.serialize(dynamicOps,this.plant).getValue()
        )));
    }

    public static ReedFeatureConfig deserialize(Dynamic<?> dynamic) {
        return new ReedFeatureConfig(
                dynamic.get("size").asInt(0),
                dynamic.get("plant").map(BlockState::deserialize).orElse(Blocks.AIR.getDefaultState())
        );
    }
}
