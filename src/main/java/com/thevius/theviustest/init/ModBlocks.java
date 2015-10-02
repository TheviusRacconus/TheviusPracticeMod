package com.thevius.theviustest.init;

import com.thevius.theviustest.block.BlockColorful;
import com.thevius.theviustest.block.BlockThevius;
import com.thevius.theviustest.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockThevius colorfulBlock = new BlockColorful();

    public static void init()
    {
        GameRegistry.registerBlock(colorfulBlock, "colorfulBlock");
    }
}
