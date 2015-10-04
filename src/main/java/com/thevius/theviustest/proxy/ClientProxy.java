package com.thevius.theviustest.proxy;

import com.thevius.theviustest.client.settings.Keybindings;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy
{
    @Override
    public void registerKeyBindings()
    {
        ClientRegistry.registerKeyBinding(Keybindings.charge);
        ClientRegistry.registerKeyBinding(Keybindings.release);
        ClientRegistry.registerKeyBinding(Keybindings.explode);
        ClientRegistry.registerKeyBinding(Keybindings.explodeBig);
    }
}
