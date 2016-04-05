package com.scorchforge.flame;

import com.scorchforge.flame.reference.Reference;
import com.scorchforge.flame.utility.LogHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.python.util.PythonInterpreter;

import java.io.InputStream;

@Mod(modid = Reference.MOD_ID, version = Reference.MOD_NAME)
public class Flame {

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LogHelper.info("Creating Flame Python Interpreter");
        InputStream main = Flame.class.getResourceAsStream("/python/main.py");
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile(main);
        LogHelper.info("Pre Initialization Complete!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        LogHelper.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        LogHelper.info("Post Initialization Complete!");
    }
}
