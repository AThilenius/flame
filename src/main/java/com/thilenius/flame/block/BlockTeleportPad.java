package com.thilenius.flame.block;

import com.thilenius.flame.Flame;
import com.thilenius.flame.GlobalData;
import com.thilenius.flame.init.ModItems;
import com.thilenius.flame.reference.Names;
import com.thilenius.flame.tileentity.TileEntityWoodenSpark;
import com.thilenius.flame.tileentity.TileEntityTeleportPad;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

public class BlockTeleportPad extends BlockTileEntityFL {

    public BlockTeleportPad() {
        super();
        this.setBlockName(Names.Blocks.PAD);
        this.setBlockTextureName(Names.Blocks.PAD);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z,
                                    EntityPlayer player, int metadata, float what, float these, float are) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity == null || player.isSneaking()) {
            return false;
        }
        player.openGui(Flame.instance, 0, world, x, y, z);
        return true;
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);
    }

    @Override
    public int quantityDropped(int meta, int fortune, Random random) {
        return 0;
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int noIdeaWhatThisIs)
    {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity instanceof TileEntityTeleportPad) {
            TileEntityTeleportPad tileEntityTeleportPad = (TileEntityTeleportPad) tileEntity;
            tileEntityTeleportPad.unregisterActionPaths();
            if (!world.isRemote) {
                world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(ModItems.tpPad, 1)));
            }
            // Also break the spark
            TileEntity tileEntity2 = world.getTileEntity(
                    tileEntityTeleportPad.getSparkLocation().X,
                    tileEntityTeleportPad.getSparkLocation().Y,
                    tileEntityTeleportPad.getSparkLocation().Z);
            if (tileEntity2 != null && tileEntity2 instanceof TileEntityWoodenSpark) {
                TileEntityWoodenSpark tileEntityWoodenSpark = (TileEntityWoodenSpark) tileEntity2;
                world.setBlockToAir(tileEntityWoodenSpark.xCoord,
                        tileEntityWoodenSpark.yCoord,
                        tileEntityWoodenSpark.zCoord);
            }
        }
    }

    // =================================================================================================================
    // ====  TileEntity Support  =======================================================================================
    // =================================================================================================================
    @Override
    public TileEntity createNewTileEntity(World world, int p_149915_2_) {
        return new TileEntityTeleportPad();
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
}