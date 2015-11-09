package com.thilenius.flame.init;

import com.thilenius.flame.reference.Names;
import com.thilenius.flame.tileentity.TileEntityTeleportPad;
import com.thilenius.flame.tileentity.TileEntityWoodenSpark;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModTileEntity {
    public static void init(){
        GameRegistry.registerTileEntity(TileEntityTeleportPad.class, Names.TileEntities.PAD);
        GameRegistry.registerTileEntity(TileEntityWoodenSpark.class, Names.TileEntities.WOOD_SPARK);
    }
}
