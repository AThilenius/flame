package com.thilenius.flame.init;

import com.thilenius.flame.item.ItemSingularityCore;
import com.thilenius.flame.item.ItemWoodenSpark;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * Created by skyco on 11/8/2015.
 */
public class Recipes
{
    public static void init()
    {
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.singCore), "RGR", "GGG", "RGR", 'G', "blockGlass", 'R', "dustRedstone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.woodenSpark), "PTP", "PCP", " S ", 'P', "plankWood", 'T', Blocks.redstone_torch, 'C', Blocks.chest, 'S', new ItemStack(ModItems.singCore)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.tpPad), "P  ", "PW ", "PS ", 'P', "plankWood", 'W', new ItemStack(ModItems.woodenSpark), 'S', new ItemStack(ModItems.singCore)));
    }
}
