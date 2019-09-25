package com.aivech.lush.block;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.Waterloggable;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.Properties;

public class BlockWaterPlant extends BlockBase implements Waterloggable {

    public BlockWaterPlant(String id) {
        super(FabricBlockSettings.of(Material.UNDERWATER_PLANT).build(), id);
        this.setDefaultState(this.getStateFactory().getDefaultState().with(Properties.WATERLOGGED, true));
    }

    @Override
    protected void appendProperties(StateFactory.Builder<Block, BlockState> stateFactory) {
        stateFactory.add(Properties.WATERLOGGED);
    }
}