package com.scorchforge.flame;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.python.util.PythonInterpreter;
import java.io.InputStream;

@Mod(modid = FlameLoader.MODID, version = FlameLoader.VERSION)
public class FlameLoader {
    public static final String MODID = "flame";
    public static final String VERSION = "0.1.0";

    public static FlameLoader Instance = null;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        FlameLoader.Instance = this;
        InputStream mainStream = getClass().getResourceAsStream("/python/main.py");
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile(mainStream);
    }
}
