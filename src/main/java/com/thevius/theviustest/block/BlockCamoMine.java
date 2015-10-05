package com.thevius.theviustest.block;

import com.thevius.theviustest.reference.Names;
import com.thevius.theviustest.tileentity.TileEntityCamoMine;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCamoMine extends BlockTheviusTileEntity
{
    public BlockCamoMine()
    {
        super();
        this.setBlockName(Names.Blocks.CAMO_MINE);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata)
    {
        return new TileEntityCamoMine();
    }
}
