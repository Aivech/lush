package com.aivech.lush;

import com.aivech.lush.block.LushBlocks;
import com.aivech.lush.item.LushItems;
import com.aivech.lush.world.LushWorldGen;
import com.aivech.lush.world.features.LushFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class Lush implements ModInitializer {
    public static final String MODID = "lush";
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID,"item_group"),() -> new ItemStack(LushItems.TEST_ITEM.getItem()));
    private static Logger log;
    @Override
    public void onInitialize() {
        log = LogManager.getLogger(MODID);

        Configurator.setLevel(MODID, Level.DEBUG);

        Log.info("Green thumb.");

        LushItems.init();
        LushBlocks.init();
        LushFeatures.init();

        LushWorldGen.init();

    }

    public static class Log {
        public static void debug(String s) {
            log.debug("[Lush] "+s);
        }
        public static void info(String s) {
            log.info("[Lush] "+s);
        }
        public static void error(String s) { log.error("[Lush] "+s);}
        public static void fatal(String s) { log.fatal("[Lush] "+s); }
    }
}
