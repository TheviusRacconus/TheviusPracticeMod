package com.thevius.theviustest.network;

import com.thevius.theviustest.reference.Reference;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class NetworkHandler
{
    private static SimpleNetworkWrapper INSTANCE;

    public static void init()
    {
        INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);

        INSTANCE.registerMessage(MessageExplode.class, MessageExplode.class, 0, Side.SERVER);
    }

    public static void sendToServer(IMessage message)
    {
        INSTANCE.sendToServer(message);
    }
}
