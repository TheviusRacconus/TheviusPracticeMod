package com.thevius.theviustest.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockColorful extends BlockThevius
{
    public BlockColorful()
    {
        super();
        this.setBlockName("colorfulBlock");
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ)
    {
        return false;
    }
}
