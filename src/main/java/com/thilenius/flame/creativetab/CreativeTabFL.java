package com.thilenius.flame.creativetab;

import com.thilenius.flame.init.ModItems;
import com.thilenius.flame.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

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
