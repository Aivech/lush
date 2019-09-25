package com.aivech.lush.block;

import com.aivech.lush.item.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ViewableWorld;

public class BlockReed extends BlockWaterPlant {
    public static final EnumProperty position = EnumProperty.of("position",Position.class);

    public final ItemBase placer;

    public BlockReed(String id, ItemBase placer) {
        super(id);

        this.placer = placer;
    }

    @Override
    public Item asItem() {
        return placer;
    }

    @Override
    public boolean canPlaceAt(BlockState state, ViewableWorld world, BlockPos pos) {
        FluidState fluidState = state.getFluidState();
        Block under = world.getBlockState(pos.down()).getBlock();

        return fluidState.getFluid().matches(FluidTags.WATER) && fluidState.isStill() &&
                (under.equals(Blocks.DIRT) || under.equals(Blocks.CLAY) || under.equals(Blocks.SAND));
    }

    public enum Position implements StringIdentifiable {
        BOTTOM,MIDDLE,TOP;

        @Override
        public String asString() {
            return this.toString();
        }
    }
}
