package com.aivech.lush.world.features;

import com.aivech.lush.Lush;
import com.aivech.lush.block.BlockReed;
import com.aivech.lush.world.features.config.ReedFeatureConfig;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.ArrayDeque;
import java.util.Random;

public class LushReedFeature extends Feature<ReedFeatureConfig> {

    public LushReedFeature() {
        super(ReedFeatureConfig::deserialize);
    }

    @Override
    public boolean generate(IWorld iWorld, ChunkGenerator<? extends ChunkGeneratorConfig> chunkGenerator, Random random, BlockPos blockPos, ReedFeatureConfig reedFeatureConfig) {
        Lush.Log.debug("Attempting to generate reed cluster @ " + blockPos.toString());
        //air above & in water
        if (iWorld.isAir(blockPos.up()) && iWorld.getBlockState(blockPos).getFluidState().getFluid().equals(Fluids.WATER)) {
            Lush.Log.debug("Water & clear space found @ " + blockPos.toString());
            ArrayDeque<BlockPos> placeNext = new ArrayDeque<>();
            placeNext.addLast(blockPos);
            int placed = 0;
            while (! placeNext.isEmpty() && placed <= reedFeatureConfig.size) {
                BlockPos pos = placeNext.pollFirst();
                if (reedFeatureConfig.plant.canPlaceAt(iWorld, pos)) {
                    placed++;
                    iWorld.setBlockState(pos, reedFeatureConfig.plant, 2);
                    iWorld.setBlockState(pos.up(), reedFeatureConfig.plant.with(BlockReed.POSITION, BlockReed.Position.MIDDLE).with(Properties.WATERLOGGED, false), 2);
                    if (random.nextInt(3) == 2) {
                        iWorld.setBlockState(pos.up(2), reedFeatureConfig.plant.with(BlockReed.POSITION, BlockReed.Position.TOP).with(Properties.WATERLOGGED, false), 2);
                    }
                    for (int i = 0; i < 4; i++) {
                        Direction dir = Direction.byId(i + 2);
                        BlockPos next = pos.offset(dir);
                        if (iWorld.isAir(next.up()) && iWorld.getBlockState(next).getFluidState().getFluid().equals(Fluids.WATER)) {
                            placeNext.addLast(next);
                        }
                    }
                }
            }
        }
        return true;
    }
}
