package com.thilenius.flame.entity;

import com.thilenius.flame.tileentity.TileEntityFL;

import java.lang.reflect.Method;

public class FlameActionTarget {

    public TileEntityFL TileEntity;
    public FlameActionPath ActionPath;
    public Method TargetMethod;
    public String EntityUUID;
    public String Username;

    public FlameActionTarget(TileEntityFL tileEntity, FlameActionPath actionPath, Method targetMethod,
                             String entityUUID, String username) {
        TileEntity = tileEntity;
        ActionPath = actionPath;
        TargetMethod = targetMethod;
        EntityUUID = entityUUID;
        Username = username;
    }

    @Override
    public String toString() {
        return "Entity UUID [ " + EntityUUID + " ], Username [ " + Username + " ], Action Method Name [ " +
                TargetMethod.getName() + " ]";
    }

}
