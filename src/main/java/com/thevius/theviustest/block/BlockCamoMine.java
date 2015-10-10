package com.thevius.theviustest.block;

import com.thevius.theviustest.reference.Names;
import com.thevius.theviustest.reference.Reference;
import com.thevius.theviustest.tileentity.TileEntityCamoMine;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
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

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        if(!world.isRemote)
        {
            TileEntityCamoMine te = (TileEntityCamoMine)world.getTileEntity(x, y, z);
            te.setCamouflage(player.getCurrentEquippedItem());
        }
        return true;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
    {
        TileEntityCamoMine te = (TileEntityCamoMine) world.getTileEntity(x, y, z);
        ItemStack stack = te.getCamouflage();
        if(stack != null && stack.getItem() instanceof ItemBlock)
        {
            Block block = ((ItemBlock)stack.getItem()).field_150939_a;
            return block.getIcon(side, stack.getItemDamage());
        }
        else
        {
            return super.getIcon(world, x, y, z, side);
        }
    }
}
