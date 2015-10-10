package com.thevius.theviustest.init;

import com.thevius.theviustest.item.ItemThevius;
import com.thevius.theviustest.item.ItemThiefMask;
import com.thevius.theviustest.reference.Names;
import com.thevius.theviustest.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final ItemThevius thiefMask = new ItemThiefMask();

    public static void init()
    {
        GameRegistry.registerItem(thiefMask, Names.Items.THIEF_MASK);
    }
}
