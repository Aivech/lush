package com.aivech.lush.world;

import com.aivech.lush.world.features.LushFeatures;
import com.google.common.collect.HashMultimap;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.NopeDecoratorConfig;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class LushWorldGen {
    static final HashMultimap<Identifier,BiomeFeature> biomeMap = HashMultimap.create();
    static final HashMultimap<Biome.Category,BiomeFeature> biomeCategoryMap = HashMultimap.create();
    static final HashMultimap<Biome.Precipitation,BiomeFeature> biomeRainMap = HashMultimap.create();
    static final HashMultimap<Biome.TemperatureGroup,BiomeFeature> biomeTempMap = HashMultimap.create();

    public static void init() {
        Registry.BIOME.getIds().forEach(LushWorldGen::addGenForBiome);
        RegistryEntryAddedCallback.event(Registry.BIOME).register((i, id, biome) -> addGenForBiome(id));
    }

    private static void addGenForBiome(Identifier id) {
        Biome b = Registry.BIOME.get(id);
        b.addFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                Biome.configureFeature(
                        LushFeatures.TEST_FEATURE,
                        new DefaultFeatureConfig(),
                        Decorator.TOP_SOLID_HEIGHTMAP,
                        new NopeDecoratorConfig()
                ));
    }

    public static class BiomeFeature {
        private final GenerationStep.Feature genStep;
        private final ConfiguredFeature feature;

        public BiomeFeature(GenerationStep.Feature genStep, ConfiguredFeature feature) {
            this.genStep = genStep;
            this.feature = feature;
        }
    }
}
