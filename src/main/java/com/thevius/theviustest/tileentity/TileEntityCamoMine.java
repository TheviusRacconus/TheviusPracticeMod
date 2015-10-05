package com.thevius.theviustest.tileentity;

import com.thevius.theviustest.handler.ConfigurationHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

import java.util.List;

public class TileEntityCamoMine extends TileEntity
{
    private int timer = ConfigurationHandler.camoMineTimer;

    public void updateEntity()
    {
        if(timer > 0) timer--;
        if(timer == 0 && !worldObj.isRemote)
        {
            List<Entity> entities = worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(xCoord - 1, yCoord - 1, zCoord - 1, xCoord  + 2, yCoord + 2, zCoord + 2));
            if(entities.size() > 0)
            {
                worldObj.createExplosion(null, xCoord + 0.5, yCoord + 0.5, zCoord + 0.5, ConfigurationHandler.camoMineRad, true);
            }
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        timer = tag.getInteger("timer");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        tag.setInteger("timer", timer);
    }
}
