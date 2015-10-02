package com.thevius.theviustest.client.handler;

import com.thevius.theviustest.client.gui.settings.Keybindings;
import com.thevius.theviustest.reference.Key;
import com.thevius.theviustest.util.LogHelper;
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

        return Key.UNKNOWN;
    }

    @SubscribeEvent
    public void handleKeyInputEvent(InputEvent.KeyInputEvent event)
    {
        LogHelper.info(getPressedKeybinding());
    }
}
