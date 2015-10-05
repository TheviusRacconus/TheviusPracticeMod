package com.thevius.theviustest.client.handler;

import com.thevius.theviustest.client.settings.Keybindings;
import com.thevius.theviustest.handler.ConfigurationHandler;
import com.thevius.theviustest.network.MessageExplode;
import com.thevius.theviustest.network.NetworkHandler;
import com.thevius.theviustest.reference.Key;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeyInputEventHandler
{
    private static Key getPressedKeybinding()
    {
        if(Keybindings.charge.isPressed())
        {
            return Key.CHARGE;
        }
        else if(Keybindings.release.isPressed())
        {
            return Key.RELEASE;
        }
        else if(Keybindings.explode.isPressed())
        {
            return Key.EXPLODE;
        }
        else if(Keybindings.explodeBig.isPressed())
        {
            return Key.EXPLODE_BIG;
        }
        return null;
    }

    @SubscribeEvent
    public void handleKeyInputEvent(InputEvent.KeyInputEvent event)
    {
        Key key = getPressedKeybinding();
        if(key != null)
        {
            switch(key)
            {
                case EXPLODE:
                    NetworkHandler.sendToServer(new MessageExplode(ConfigurationHandler.explodeKeyRad));
                    break;
                case EXPLODE_BIG:
                    NetworkHandler.sendToServer(new MessageExplode(ConfigurationHandler.explodeBigKeyRad));
            }
        }
    }
}
