package com.aivech.lush.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Waterloggable;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;

public class BlockWaterloggable extends BlockBase implements Waterloggable {

    public BlockWaterloggable(Settings settings, String id) {
        super(settings, id);
        this.setDefaultState(this.getStateFactory().getDefaultState().with(Properties.WATERLOGGED,false));
    }
}
