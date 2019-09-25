package com.aivech.lush.block;

import com.aivech.lush.Lush;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public enum LushBlocks {
    ANTHURIUM(new BlockAnthrium(),true),
    REED(new BlockWaterloggable(FabricBlockSettings.of(Material.UNDERWATER_PLANT).build(),"cattail"),true);

    public final BlockBase block;
    private final boolean registerItemBlock;

    LushBlocks(BlockBase b, boolean registerItemBlock) {
        this.block = b;
        this.registerItemBlock = registerItemBlock;
    }

    public static void init() {
        for(LushBlocks enumEntry : LushBlocks.values()) {
            Registry.register(Registry.BLOCK, new Identifier(Lush.MODID,enumEntry.block.id), enumEntry.block);
            if (enumEntry.registerItemBlock) {
                Registry.register(Registry.ITEM, new Identifier(Lush.MODID,enumEntry.block.id),new BlockItem(enumEntry.block, new Item.Settings().group(Lush.ITEM_GROUP)));
            }
        }
    }
}
