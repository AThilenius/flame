package com.thilenius.flame.reference;

import com.thilenius.flame.utilities.ResourceLocationHelper;
import net.minecraft.util.ResourceLocation;

public class Models
{
    public final static String MODEL_LOCATION = "models/";

    public final static ResourceLocation PAD = ResourceLocationHelper.getResourceLocation(MODEL_LOCATION + "teleportpad.obj");
    public final static ResourceLocation WOOD_SPARK = ResourceLocationHelper.getResourceLocation(MODEL_LOCATION + "spark.obj");
    public final static ResourceLocation SPARK_ROTOR = ResourceLocationHelper.getResourceLocation(MODEL_LOCATION + "sparkrotor.obj");
}
