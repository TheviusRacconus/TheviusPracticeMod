package com.thevius.theviustest.handler;


import com.thevius.theviustest.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler
{
    public static Configuration configuration;
    public static int camoMineTimer = 60;
    public static float camoMineRad = 3.0F;
    public static float explodeKeyRad = 3.0F;
    public static float explodeBigKeyRad = 30.0F;

    public static void init(File configFile)
    {
        if (configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }
    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            //resync configs
            loadConfiguration();

        }
    }

    private static void loadConfiguration()
    {
        camoMineTimer = configuration.getInt("Camo Mine Timer", Configuration.CATEGORY_GENERAL, 60, 10, 20000, "The timer for the Camo Mine (in ticks)");
        camoMineRad = configuration.getFloat("Camo Mine Radius", Configuration.CATEGORY_GENERAL, 3.0F, 0.0F, 30.0F, "The explosion radius for the Camo Mine");
        explodeKeyRad = configuration.getFloat("Explode Key Radius", Configuration.CATEGORY_GENERAL, 3.0F, 0.0F, 30.0F, "The explosion radius for the Explosion key");
        explodeBigKeyRad = configuration.getFloat("Big Explode Radius", Configuration.CATEGORY_GENERAL, 30.0F, 30.0F, 100.0F, "The explosion radius for the Camo Mine");


        if(configuration.hasChanged())
        {
            configuration.save();
        }
    }
}
