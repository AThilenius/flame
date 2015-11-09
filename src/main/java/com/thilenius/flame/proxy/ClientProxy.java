package com.thilenius.flame.proxy;

import com.thilenius.flame.Flame;
import com.thilenius.flame.client.renderer.tileentity.RendererFL;
import com.thilenius.flame.tileentity.TileEntityTeleportPad;
import com.thilenius.flame.tileentity.TileEntityWoodenSpark;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy
{
    @Override
    public void registerRenderers()
    {
        Flame.Globals.IsClient = true;
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTeleportPad.class, new RendererFL());
        // Can use the dual-purpose teleport pad renderer for this
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWoodenSpark.class, new RendererFL());
    }
}
