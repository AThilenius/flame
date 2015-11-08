package com.thilenius.flame.tpad;

import com.thilenius.flame.Flame;
import com.thilenius.flame.GlobalData;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Alec on 10/17/15.
 */
public class ItemTeleportPad extends Item {

    public ItemTeleportPad() {
        maxStackSize = 1;
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("teleportPad");
        GameRegistry.addRecipe(new ItemStack(this), new Object[]{
                "A  ",
                "AB ",
                "AC ",
                'A', Blocks.planks, 'B', GlobalData.WoodenSparkItem, 'C', GlobalData.SingularityCoreItem
        });
        this.setTextureName("flame:TeleportPad");
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int side,
                             float px, float py, float pz) {
        // No duplicate sparks
        if (Flame.Globals.EntityRegistry.contains(entityPlayer.getGameProfile().getName(),
                world.provider.dimensionId)) {
            return false;
        }
        // Offset from block face
        ForgeDirection forgeDirection = ForgeDirection.getOrientation(side);
        x += forgeDirection.offsetX;
        y += forgeDirection.offsetY;
        z += forgeDirection.offsetZ;
        if (world.isAirBlock(x, y, z)) {
            if (!entityPlayer.capabilities.isCreativeMode){
                itemStack.stackSize--;
            }
            world.setBlock(x, y, z, GlobalData.TeleportPadBlock);
            if (!world.isRemote) {
                TileEntityTeleportPad tileEntityTeleportPad = (TileEntityTeleportPad) world.getTileEntity(x, y, z);
                tileEntityTeleportPad.setPlayerName(entityPlayer.getGameProfile().getName());
            }
            return true;
        }
        return false;
    }

}