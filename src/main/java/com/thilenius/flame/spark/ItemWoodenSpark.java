package com.thilenius.flame.spark;

import com.thilenius.flame.GlobalData;
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
public class ItemWoodenSpark extends Item {

    public ItemWoodenSpark() {
        maxStackSize = 1;
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("woodenSpark");
        GameRegistry.addRecipe(new ItemStack(this), new Object[]{
                "ABA",
                "ACA",
                " D ",
                'A', Blocks.planks, 'B', Blocks.redstone_torch, 'C', Blocks.chest, 'D', GlobalData.SingularityCoreItem
        });
        this.setTextureName("flame:WoodenSpark");
    }
}
