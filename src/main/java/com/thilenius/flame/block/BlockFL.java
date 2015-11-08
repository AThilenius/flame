package com.thilenius.flame.block;

import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;
import com.thilenius.flame.creativetab.CreativeTabFL;
import com.thilenius.flame.lib.Reference;
import com.thilenius.flame.spark.TileEntityWoodenSpark;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by skyco on 11/8/2015.
 */
public class BlockFL extends BlockContainer
{
    public BlockFL(Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTabFL.FL_TAB);
    }

    public BlockFL()
    {
        this(Material.iron);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int p_149915_2_) { return null; }
}
