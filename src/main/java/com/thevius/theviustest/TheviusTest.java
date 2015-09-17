package com.thevius.theviustest;

import com.thevius.theviustest.proxy.IProxy;
import com.thevius.theviustest.reference.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class TheviusTest
{

    //Mod instance
    @Mod.Instance(Reference.MOD_ID)
    public static TheviusTest instance;

    //Proxies
    @SidedProxy(clientSide = "com.thevius.theviustest.proxy.ClientProxy", serverSide = "com.thevius.theviustest.proxy.ServerProxy")
    public static IProxy proxy;




   //Initalization phases
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {


    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {


    }


    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {


    }

}
