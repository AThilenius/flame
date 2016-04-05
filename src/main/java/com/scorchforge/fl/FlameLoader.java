package com.scorchforge.fl;

import com.scorchforge.fl.reference.Reference;
import com.scorchforge.fl.utility.LogHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.python.util.PythonInterpreter;

import java.io.InputStream;

@Mod(modid = Reference.MOD_ID, version = Reference.VERSION)
public class FlameLoader {

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LogHelper.info("Creating FlameLoader Python Interpreter");
        InputStream main = FlameLoader.class.getResourceAsStream("/python/main.py");
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile(main);
        LogHelper.info("Pre Initialization Complete!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // Recipe initialization if we decide to do it during construction (but that makes things complicated)
        LogHelper.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        LogHelper.info("Post Initialization Complete!");
    }
}
