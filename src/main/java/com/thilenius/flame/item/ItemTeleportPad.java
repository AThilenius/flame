package com.thilenius.flame.item;

import com.thilenius.flame.Flame;
import com.thilenius.flame.GlobalData;
import com.thilenius.flame.init.ModBlocks;
import com.thilenius.flame.reference.Names;
import com.thilenius.flame.tileentity.TileEntityTeleportPad;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemTeleportPad extends ItemFL {

    public ItemTeleportPad() {
        maxStackSize = 1;
        this.setUnlocalizedName(Names.Items.PAD);
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
            world.setBlock(x, y, z, ModBlocks.tpPad);
            if (!world.isRemote) {
                TileEntityTeleportPad tileEntityTeleportPad = (TileEntityTeleportPad) world.getTileEntity(x, y, z);
                tileEntityTeleportPad.setPlayerName(entityPlayer.getGameProfile().getName());
            }
            return true;
        }
        return false;
    }

}
