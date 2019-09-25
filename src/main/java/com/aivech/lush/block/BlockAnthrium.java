package com.aivech.lush.block;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.Direction;

public class BlockAnthrium extends BlockBase {
    public static final EnumProperty STATE = EnumProperty.of("direction", Direction.class);

    BlockAnthrium() {
        super(FabricBlockSettings.of(Material.REPLACEABLE_PLANT).build(),"anthrium");
    }

}
