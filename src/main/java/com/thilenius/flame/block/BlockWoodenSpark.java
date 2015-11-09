package com.thilenius.flame.block;

import com.thilenius.flame.Flame;
import com.thilenius.flame.reference.Names;
import com.thilenius.flame.tileentity.TileEntityWoodenSpark;
import com.thilenius.flame.tileentity.TileEntityTeleportPad;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

public class BlockWoodenSpark extends BlockTileEntityFL {

    public BlockWoodenSpark() {
        super();
        this.setBlockName(Names.Blocks.WOOD_SPARK);
        this.setBlockTextureName(Names.Blocks.WOOD_SPARK);
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
    public int quantityDropped(int meta, int fortune, Random random) {
        return 0;
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int metadata)
    {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity instanceof TileEntityWoodenSpark) {
            TileEntityWoodenSpark tileEntityWoodenSpark = (TileEntityWoodenSpark) tileEntity;
            // Breaking can be suppressed by code animating spark movement
            if (tileEntityWoodenSpark.isSuppressingDrop()) {
                super.breakBlock(world, x, y, z, block, metadata);
                return;
            }
            TileEntityTeleportPad tileEntityTeleportPad = tileEntityWoodenSpark.getTeleportPad();
            if (!world.isRemote) {
                for (int i = 0; i < tileEntityTeleportPad.getSizeInventory(); i++) {
                    ItemStack item = tileEntityTeleportPad.getStackInSlot(i);
                    if (item != null && item.stackSize > 0) {
                        EntityItem entityItem = new EntityItem(world, x, y, z,
                                new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));
                        if (item.hasTagCompound()) {
                            entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
                        }
                        world.spawnEntityInWorld(entityItem);
                        item.stackSize = 0;
                    }
                }
            }
            // Also break the teleport pad
            world.setBlockToAir(tileEntityTeleportPad.xCoord,
                    tileEntityTeleportPad.yCoord,
                    tileEntityTeleportPad.zCoord);
        }
    }

    // =================================================================================================================
    // ====  TileEntity Support  =======================================================================================
    // =================================================================================================================
    @Override
    public TileEntity createNewTileEntity(World world, int p_149915_2_) {
        return new TileEntityWoodenSpark();
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