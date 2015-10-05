package com.thevius.theviustest.block;

import com.thevius.theviustest.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockExploding extends BlockThevius
{
    public BlockExploding()
    {
        super();
        this.setBlockName(Names.Blocks.EXPLODING_BLOCK);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        if(!world.isRemote)
        {
            world.createExplosion(player, x, y, z, 3.0F, true);
        }
        return true;
    }
}
