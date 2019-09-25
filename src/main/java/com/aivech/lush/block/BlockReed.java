package com.aivech.lush.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityContext;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class BlockReed extends BlockWaterPlant {
    public static final EnumProperty POSITION = EnumProperty.of("position", Position.class);
    public static final VoxelShape SHAPE = Block.createCuboidShape(2, 0, 2, 14, 16, 14);

    public BlockReed(String id) {
        super(id);
        setDefaultState(getStateFactory().getDefaultState().with(POSITION, Position.BOTTOM));
    }

    @Override
    protected void appendProperties(StateFactory.Builder<Block, BlockState> stateFactory) {
        super.appendProperties(stateFactory);
        stateFactory.add(POSITION);
    }

    public enum Position implements StringIdentifiable {
        BOTTOM, MIDDLE, TOP;

        @Override
        public String asString() {
            return this.toString().toLowerCase();
        }
    }

    @Override
    public VoxelShape getOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, EntityContext entityContext_1) {
        return
    }
}
