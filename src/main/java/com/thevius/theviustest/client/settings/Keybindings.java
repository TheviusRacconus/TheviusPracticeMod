package com.thevius.theviustest.client.settings;

import com.thevius.theviustest.reference.Names;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public class Keybindings
{
    public static KeyBinding charge = new KeyBinding(Names.Keys.CHARGE, Keyboard.KEY_C, Names.Keys.CATEGORY);
    public static KeyBinding release = new KeyBinding(Names.Keys.RELEASE, Keyboard.KEY_R, Names.Keys.CATEGORY);
    public static KeyBinding explode = new KeyBinding(Names.Keys.EXPLODE, Keyboard.KEY_Z, Names.Keys.CATEGORY);
    public static KeyBinding explodeBig = new KeyBinding(Names.Keys.EXPLODE_BIG, Keyboard.KEY_G, Names.Keys.CATEGORY);
}
