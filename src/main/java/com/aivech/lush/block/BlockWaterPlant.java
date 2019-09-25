package com.aivech.lush.block;

import net.minecraft.block.*;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.ViewableWorld;

public class BlockWaterPlant extends BlockBase implements FluidFillable {

    public BlockWaterPlant(String id) {
        super(Block.Settings.copy(Blocks.KELP), id);
        //super(FabricBlockSettings.of(Material.UNDERWATER_PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.WET_GRASS).build(), id);
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

    @Override
    public boolean isTranslucent(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
        return true;
    }

    @Override
    public boolean isSimpleFullBlock(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
        return super.isSimpleFullBlock(blockState_1, blockView_1, blockPos_1);
    }

    @Override
    public FluidState getFluidState(BlockState blockState_1) {
        return Fluids.WATER.getStill(false);
    }

    @Override
    public boolean canFillWithFluid(BlockView var1, BlockPos var2, BlockState var3, Fluid var4) {
        return false;
    }

    @Override
    public boolean tryFillWithFluid(IWorld var1, BlockPos var2, BlockState var3, FluidState var4) {
        return false;
    }
}