package com.aivech.lush.world.features;

import com.aivech.lush.world.features.config.ReedFeatureConfig;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class ReedFeature extends Feature<ReedFeatureConfig> {

    public ReedFeature() {
        super(ReedFeatureConfig::deserialize);
    }

    @Override
    public boolean generate(IWorld iWorld, ChunkGenerator<? extends ChunkGeneratorConfig> chunkGenerator, Random random, BlockPos blockPos, ReedFeatureConfig reedFeatureConfig) {





        return true;
    }
}
