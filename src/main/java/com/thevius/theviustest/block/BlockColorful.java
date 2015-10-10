package com.thevius.theviustest.block;

import com.thevius.theviustest.reference.Names;
import com.thevius.theviustest.reference.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import javax.lang.model.element.Name;
import java.util.Random;

public class BlockColorful extends BlockThevius
{
    public BlockColorful()
    {
        super();
        this.setBlockName(Names.Blocks.COLORFUL_BLOCK);
        this.setTickRandomly(true);
    }

    public void updateTick(World world, int x, int y, int z, Random random)
    {
        if(random.nextInt(10) == 0) world.playSoundEffect(x, y, z, Reference.RESOURCE_PREFIX + "flagFlap", 1.0F, random.nextFloat() + 0.5F);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
       /* if(world.isAirBlock(x, y + 1, z))
        {
            world.setBlock(x, y + 1, z, ModBlocks.colorfulBlock);
        }*/
        world.playSoundEffect(x, y, z, Reference.RESOURCE_PREFIX + "flagFlap", 1.0F, player.getRNG().nextFloat() + 0.75F);
        return true;
    }
}
