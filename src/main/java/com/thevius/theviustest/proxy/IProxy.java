package com.thevius.theviustest.proxy;

import net.minecraft.entity.player.EntityPlayer;

public interface IProxy
{
    public abstract void registerKeyBindings();

    public abstract EntityPlayer getClientPlayer();
}
