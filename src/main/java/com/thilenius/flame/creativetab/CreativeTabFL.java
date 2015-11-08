package com.thilenius.flame.creativetab;

import com.thilenius.flame.init.ModItems;
import com.thilenius.flame.lib.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by skyco on 11/8/2015.
 */
public class CreativeTabFL
{
    public static final CreativeTabs FL_TAB = new CreativeTabs(Reference.MOD_ID)
    {
        @Override
        public Item getTabIconItem() {
            return ModItems.woodenSpark;
        }

        @Override
        public String getTranslatedTabLabel() {
            return "Flame";
        }
    };
}
