package com.aivech.lush.block;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ViewableWorld;

public class BlockWaterPlant extends BlockBase implements Waterloggable {

    public BlockWaterPlant(String id) {
        super(FabricBlockSettings.of(Material.UNDERWATER_PLANT).noCollision().build(), id);
        this.setDefaultState(this.getStateFactory().getDefaultState().with(Properties.WATERLOGGED, true));
    }

    @Override
    public boolean canPlaceAt(BlockState thisBlock, ViewableWorld world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        Block under = world.getBlockState(pos.down()).getBlock();
        return state.getFluidState().getFluid() == Fluids.WATER && world.getBlockState(pos.up()).isAir() &&
                (under == Blocks.DIRT || under == Blocks.CLAY || under == Blocks.SAND);
    }

    @Override
    protected void appendProperties(StateFactory.Builder<Block, BlockState> stateFactory) {
        stateFactory.add(Properties.WATERLOGGED);
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }
}