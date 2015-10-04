package com.thevius.theviustest;

import com.thevius.theviustest.client.handler.KeyInputEventHandler;
import com.thevius.theviustest.handler.ConfigurationHandler;
import com.thevius.theviustest.init.ModBlocks;
import com.thevius.theviustest.init.ModItems;
import com.thevius.theviustest.init.Recipes;
import com.thevius.theviustest.network.NetworkHandler;
import com.thevius.theviustest.proxy.IProxy;
import com.thevius.theviustest.reference.Reference;
import com.thevius.theviustest.util.LogHelper;
import com.thevius.theviustest.world.gen.WorldGenHandler;
import com.thevius.theviustest.world.gen.WorldGeneratorColorful;
import com.thevius.theviustest.world.gen.WorldGeneratorTheviusOre;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class TheviusTest
{

    public static Item thiefMask;


    //Mod instance
    @Mod.Instance(Reference.MOD_ID)
    public static TheviusTest instance;

    //Proxies
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;




   //Initalization phases
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        //config
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        //KeyBindings
        proxy.registerKeyBindings();

        //Blocks/Items
        ModItems.init();
        ModBlocks.init();

        //worldgen
        WorldGenHandler.init();

        //networking
        NetworkHandler.init();

        LogHelper.info("Pre Initialization Complete");

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());

        Recipes.init();
        LogHelper.info("Initialization Complete");
    }


    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

        LogHelper.info("Post Initialization Complete");

    }

}
