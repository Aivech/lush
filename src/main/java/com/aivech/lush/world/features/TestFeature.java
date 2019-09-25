package com.aivech.lush.world.features;

import com.aivech.lush.block.LushBlocks;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;
import java.util.function.Function;

public class TestFeature extends Feature<DefaultFeatureConfig> {

    public TestFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> function_1) {
        super(function_1);
    }

    @Override
    public boolean generate(IWorld iWorld, ChunkGenerator<? extends ChunkGeneratorConfig> chunkGenerator, Random rand, BlockPos blockPos, DefaultFeatureConfig defaultFeatureConfig) {
        for(int i = 0; i < 36; i++) {
            BlockPos pos = blockPos.add(rand.nextInt(8)-rand.nextInt(8), rand.nextInt(4)-rand.nextInt(4),rand.nextInt(8)-rand.nextInt(8));
            if (iWorld.isAir(pos)) {
                iWorld.setBlockState(pos, LushBlocks.ANTHURIUM.block.getDefaultState(),2);
            }
        }
        return true;
    }
}
