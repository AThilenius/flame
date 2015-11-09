package com.thilenius.flame.client.gui;

import com.thilenius.flame.inventory.ContainerWoodenSpark;
import com.thilenius.flame.client.gui.GuiWoodenSpark;
import com.thilenius.flame.tileentity.TileEntityWoodenSpark;
import com.thilenius.flame.tileentity.TileEntityTeleportPad;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
    //returns an instance of the Container you made earlier
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world,
                                      int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if(tileEntity instanceof TileEntityWoodenSpark) {
            TileEntityWoodenSpark tileEntityWoodenSpark = (TileEntityWoodenSpark) tileEntity;
            TileEntityTeleportPad tileEntityTeleportPad = tileEntityWoodenSpark.getTeleportPad();
            return new ContainerWoodenSpark(player.inventory, tileEntityTeleportPad);
        } else if (tileEntity instanceof TileEntityTeleportPad) {
            // NA
        }
        return null;
    }

    //returns an instance of the Gui you made earlier
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world,
                                      int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if(tileEntity instanceof TileEntityWoodenSpark) {
            TileEntityWoodenSpark tileEntityWoodenSpark = (TileEntityWoodenSpark) tileEntity;
            TileEntityTeleportPad tileEntityTeleportPad = tileEntityWoodenSpark.getTeleportPad();
            return new GuiWoodenSpark(player.inventory, tileEntityTeleportPad);
        } else if (tileEntity instanceof TileEntityTeleportPad) {
            TileEntityTeleportPad tileEntityTeleportPad = (TileEntityTeleportPad) tileEntity;
            // Only show GUI if spark is on the pad
            if (!tileEntityTeleportPad.getPadLocation().equals(tileEntityTeleportPad.getSparkLocation())) {
                return null;
            }
            return new GuiWoodenSpark(player.inventory, tileEntityTeleportPad);
        }
        return null;

    }
}