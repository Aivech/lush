package com.aivech.lush.block;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Material;

public class BlockLandPlant extends BlockBase {
    BlockLandPlant(String id) {
        super(FabricBlockSettings.of(Material.REPLACEABLE_PLANT).breakInstantly().build(),id);
    }

}
