package com.thevius.theviustest.creativetab;

import com.thevius.theviustest.init.ModItems;
import com.thevius.theviustest.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabThevius
{
    public static final CreativeTabs THEVIUS_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.thiefMask;
        }
    };
}
