package com.thevius.theviustest.proxy;


import net.minecraft.entity.player.EntityPlayer;

public class ServerProxy extends CommonProxy
{
    @Override
    public void registerKeyBindings()
    {
        // NOOP
    }

    @Override
    public EntityPlayer getClientPlayer()
    {
        return null;
    }
}
