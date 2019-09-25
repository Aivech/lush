package com.aivech.lush.block;

import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.StringIdentifiable;

public class BlockReed extends BlockWaterPlant {
    public static final EnumProperty position = EnumProperty.of("position",Position.class);

    public BlockReed(String id) {
        super(id);
    }

    public enum Position implements StringIdentifiable {
        BOTTOM,MIDDLE,TOP;

        @Override
        public String asString() {
            return this.toString();
        }
    }
}
