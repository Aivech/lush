package com.aivech.lush.world.features;

import com.aivech.lush.Lush;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public enum LushFeatures {
    REED_FEATURE(new LushReedFeature(), "reed_feature"),
    TEST_FEATURE(new TestFeature(DefaultFeatureConfig::deserialize), "test_feature");

    public final String id;
    public final Feature feature;

    LushFeatures(Feature feature, String id) {
        this.feature = feature;
        this.id = Lush.MODID + ":" + id;
    }

    public static void init() {
        for (LushFeatures feature : LushFeatures.values()) {
            Registry.register(Registry.FEATURE, feature.id, (Feature<FeatureConfig>)feature.feature);
        }
    }
}
