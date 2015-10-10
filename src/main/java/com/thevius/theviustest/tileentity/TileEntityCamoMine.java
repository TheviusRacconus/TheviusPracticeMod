package com.thevius.theviustest.tileentity;

import com.thevius.theviustest.handler.ConfigurationHandler;
import com.thevius.theviustest.util.LogHelper;
import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.util.AxisAlignedBB;

import java.util.List;

public class TileEntityCamoMine extends TileEntityThevius
{
    private int timer = ConfigurationHandler.camoMineTimer;
    private ItemStack camoStack;

    @Override
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

    public void setCamouflage(ItemStack stack)
    {
        camoStack = stack;
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

    public ItemStack getCamouflage()
    {
        return camoStack;
    }

    public void writeToPacket(ByteBuf buf)
    {
        ByteBufUtils.writeItemStack(buf, camoStack);
        LogHelper.info("writing packet");
    }

    public void readFromPacket(ByteBuf buf)
    {
        ByteBufUtils.readItemStack(buf);
        LogHelper.info("reading packet");
    }

    @Override
    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        timer = tag.getInteger("timer");

        if(tag.hasKey("camoStack"))
        {
            camoStack = ItemStack.loadItemStackFromNBT(tag.getCompoundTag("camoStack"));
        }
        else
        {
            camoStack = null;
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        tag.setInteger("timer", timer);

        if(camoStack != null)
        {
            NBTTagCompound t = new NBTTagCompound();
            camoStack.writeToNBT(t);
            tag.setTag("camoStack", t);
        }
    }
}
