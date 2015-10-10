package com.thevius.theviustest.world.gen;

import cpw.mods.fml.common.registry.GameRegistry;

public class WorldGenHandler
{
    public static void init()
    {
        GameRegistry.registerWorldGenerator(new WorldGeneratorColorful(), 0);
        GameRegistry.registerWorldGenerator(new WorldGeneratorTheviusOre(), 0);
        GameRegistry.registerWorldGenerator(new WorldGeneratorExploding(), 0);
    }
}
