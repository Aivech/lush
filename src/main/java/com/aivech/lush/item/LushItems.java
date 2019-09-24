package com.aivech.lush.item;

import com.aivech.lush.Lush;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public enum LushItems {
    TEST_ITEM(new ItemBase(new Item.Settings().group(Lush.ITEM_GROUP),"test_item"));

    private final ItemBase item;
    private final String id;

    LushItems(ItemBase item) {
        this.id = item.id;
        this.item = item;
    }

    public ItemBase getItem() {
        return this.item;
    }

    public static void init() {
        for (LushItems item : LushItems.values()) {
            Registry.register(Registry.ITEM, new Identifier(Lush.MODID,item.id),item.item);
        }
    }
}
