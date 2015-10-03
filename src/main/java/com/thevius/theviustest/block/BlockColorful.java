package com.thevius.theviustest.block;

import com.thevius.theviustest.init.ModBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockColorful extends BlockThevius
{
    public BlockColorful()
    {
        super();
        this.setBlockName("colorfulBlock");
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ)
    {
        if(world.isAirBlock(x, y + 1, z))
        {
            world.setBlock(x, y + 1, z, ModBlocks.colorfulBlock);
        }
        return false;
    }
}
