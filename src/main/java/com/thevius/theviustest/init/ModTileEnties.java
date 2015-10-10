package com.thevius.theviustest.init;

import com.thevius.theviustest.reference.Names;
import com.thevius.theviustest.tileentity.TileEntityCamoMine;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModTileEnties
{
    public static void init()
    {
        GameRegistry.registerTileEntity(TileEntityCamoMine.class, Names.TileEntities.CAMO_MINE);
    }
}
