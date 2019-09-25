package com.aivech.lush.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.FluidState;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ViewableWorld;

public class BlockReed extends BlockWaterPlant {
    public static final EnumProperty POSITION = EnumProperty.of("position", Position.class);

    public BlockReed(String id) {
        super(id);
        setDefaultState(getStateFactory().getDefaultState().with(POSITION, Position.BOTTOM));
    }

    @Override
    protected void appendProperties(StateFactory.Builder<Block, BlockState> stateFactory) {
        super.appendProperties(stateFactory);
        stateFactory.add(POSITION);
    }

    @Override
    public boolean canPlaceAt(BlockState state, ViewableWorld world, BlockPos pos) {
        FluidState fluidState = state.getFluidState();
        Block under = world.getBlockState(pos.down()).getBlock();

        return fluidState.getFluid().matches(FluidTags.WATER) && fluidState.isStill() && world.getBlockState(pos.up()).isAir() &&
                (under.equals(Blocks.DIRT) || under.equals(Blocks.CLAY) || under.equals(Blocks.SAND));
    }

    public enum Position implements StringIdentifiable {
        BOTTOM,MIDDLE,TOP;

        @Override
        public String asString() {
            return this.toString().toLowerCase();
        }
    }
}
