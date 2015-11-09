package com.thilenius.flame.init;

import com.thilenius.flame.block.BlockTileEntityFL;
import com.thilenius.flame.block.BlockTeleportPad;
import com.thilenius.flame.block.BlockWoodenSpark;
import com.thilenius.flame.reference.Names;
import com.thilenius.flame.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockTileEntityFL woodSpark = new BlockWoodenSpark();
    public static final BlockTileEntityFL tpPad = new BlockTeleportPad();

    public static void init()
    {
        GameRegistry.registerBlock(woodSpark, Names.Blocks.WOOD_SPARK);
        GameRegistry.registerBlock(tpPad, Names.Blocks.PAD);
    }
}
