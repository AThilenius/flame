package com.scorchforge.flame;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.python.util.PythonInterpreter;

import java.io.InputStream;

@Mod(modid = Flame.MODID, version = Flame.VERSION)
public class Flame {
    public static final String MODID = "flame";
    public static final String VERSION = "0.1.0";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        InputStream main = getClass().getResourceAsStream("/python/main.py");
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("print 'Hello, world!'");
    }
}
