package com.thilenius.flame.entity;

import com.thilenius.flame.tileentity.TileEntityFL;
import net.minecraft.world.WorldServer;

import java.util.HashMap;

// Hacked to register entities 1:1 to usernames for now
public class FlameEntityRegistry {

    // In the format USERNAME-DIMENSION_ID
    private HashMap<String, TileEntityFL> m_entitiesByUsername = new HashMap<String, TileEntityFL>();

    public void register (TileEntityFL entity) {
        if (entity.getWorldObj() instanceof WorldServer) {
            String key = entity.getPlayerUsername() + "-" + entity.getWorldObj().provider.dimensionId;
            if (!m_entitiesByUsername.containsKey(key)) {
                m_entitiesByUsername.put(key, entity);
                System.out.println("Registering entity with UUID: " + entity.getUuid() + ", key of: " + key);
            } else {
                System.out.println("Ignoring duplicated registry for entity with UUID: " + entity.getUuid() +
                        ", key of: " + key);
            }
        }
    }

    public void unregister (TileEntityFL entity) {
        if (entity.getWorldObj() instanceof WorldServer) {
            String key = entity.getPlayerUsername() + "-" + entity.getWorldObj().provider.dimensionId;
            if (m_entitiesByUsername.containsKey(key)) {
                m_entitiesByUsername.remove(key);
                System.out.println("Unregistering: " + entity.toString());
            } else {
                System.out.println("Can't unregister: " + entity.toString() + ". It was never registered.");
            }
        }
    }

    public boolean contains (String username, int dimension) {
        String key = username + "-" + dimension;
        return m_entitiesByUsername.containsKey(key);
    }

    public FlameActionTarget getTargetByUsernameAndDimension(String username, int dimension, String actionName) {
        String key = username + "-" + dimension;
        TileEntityFL tileEntity = m_entitiesByUsername.get(key);
        if (tileEntity == null) {
            return null;
        }
        return tileEntity.getActionTargetByName(actionName);
    }
}
