package com.thevius.theviustest.init;

import com.thevius.theviustest.block.*;
import com.thevius.theviustest.reference.Names;
import com.thevius.theviustest.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockThevius colorfulBlock = new BlockColorful();
    public static final BlockThevius theviusOre = new BlockTheviusOre();
    public static final BlockThevius explodingBlock = new BlockExploding();
    public static final BlockTheviusTileEntity camoMine = new BlockCamoMine();

    public static void init()
    {
        GameRegistry.registerBlock(colorfulBlock, Names.Blocks.COLORFUL_BLOCK);
        GameRegistry.registerBlock(theviusOre, Names.Blocks.THEVIUS_ORE);
        GameRegistry.registerBlock(explodingBlock, Names.Blocks.EXPLODING_BLOCK);
        GameRegistry.registerBlock(camoMine, Names.Blocks.CAMO_MINE);
    }
}
