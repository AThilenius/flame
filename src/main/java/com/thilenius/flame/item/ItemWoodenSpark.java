package com.thilenius.flame.item;

import com.thilenius.flame.GlobalData;
import com.thilenius.flame.lib.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Alec on 10/17/15.
 */
public class ItemWoodenSpark extends ItemFL {

    public ItemWoodenSpark() {
        maxStackSize = 1;
        this.setUnlocalizedName(Names.Items.WOOD_SPARK);
    }
}
