package com.thilenius.flame.init;

import com.thilenius.flame.item.ItemFL;
import com.thilenius.flame.item.ItemSingularityCore;
import com.thilenius.flame.item.ItemTeleportPad;
import com.thilenius.flame.item.ItemWoodenSpark;
import com.thilenius.flame.lib.Names;
import com.thilenius.flame.lib.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by skyco on 11/8/2015.
 */

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final ItemFL woodenSpark = new ItemWoodenSpark();
    public static final ItemFL singCore = new ItemSingularityCore();
    public static final ItemFL tpPad = new ItemTeleportPad();

    public static void init()
    {
        GameRegistry.registerItem(woodenSpark, Names.Items.WOOD_SPARK);
        GameRegistry.registerItem(singCore, Names.Items.CORE);
        GameRegistry.registerItem(tpPad, Names.Items.PAD);
    }
}
