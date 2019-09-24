package com.aivech.lush.world.features;

import com.aivech.lush.Lush;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

public class LushFeatures {
    public static final TestFeature TEST_FEATURE = Registry.register(Registry.FEATURE,new Identifier(Lush.MODID,"test_feature"),new TestFeature(DefaultFeatureConfig::deserialize));
}
