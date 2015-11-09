package com.thilenius.flame;

import com.thilenius.flame.client.gui.GuiHandler;
import com.thilenius.flame.commands.BlazeCommandHandler;
import com.thilenius.flame.commands.HomeCommandHandler;
import com.thilenius.flame.init.ModBlocks;
import com.thilenius.flame.init.ModItems;
import com.thilenius.flame.init.ModTileEntity;
import com.thilenius.flame.init.Recipes;
import com.thilenius.flame.proxy.CommonProxy;
import com.thilenius.flame.reference.Reference;
import com.thilenius.flame.rest.RestServer;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ServerTickEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.block.Block;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;

import java.util.HashSet;

// Note: Program Arguments: -username=athilenius

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class Flame
{

    @Instance(value = Reference.MOD_ID)
    public static Flame instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static GlobalData Globals = new GlobalData();

    private static HashSet<Entity> m_protectedEntities = new HashSet<Entity>();
    private static boolean m_hasStartTickBeenSent;

    // HACK FOR TINY CONTAINER
    public static Block blockTiny;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        // Register Events
        MinecraftForge.EVENT_BUS.register(this);
        FMLCommonHandler.instance().bus().register(this);

        ModItems.init();
        ModBlocks.init();

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        // Register Rendered
        ModTileEntity.init();
        proxy.registerRenderers();
        Recipes.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    }

    @EventHandler
    public void serverStart(FMLServerStartingEvent event)
    {
        MinecraftServer server = MinecraftServer.getServer();
        ICommandManager command = server.getCommandManager();
        ServerCommandManager manager = (ServerCommandManager) command;
        manager.registerCommand(new HomeCommandHandler());
        manager.registerCommand(new BlazeCommandHandler());
    }

    @SubscribeEvent
    public void onServerTick(ServerTickEvent event)
    {
        if (!m_hasStartTickBeenSent)
        {
            m_hasStartTickBeenSent = true;
            Flame.Globals.RestServer = new RestServer();
        }
        Flame.Globals.RestServer.onGameTick();
    }
}
