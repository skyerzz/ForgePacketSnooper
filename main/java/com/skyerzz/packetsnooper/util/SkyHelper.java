package com.skyerzz.packetsnooper.util;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;

import java.util.List;

/**
 * Created by sky on 23-8-2019.
 */
public class SkyHelper {

    public static Entity getEntityById(int id){
        if(id<0){
            return null;
        }
        return Minecraft.getMinecraft().thePlayer.getEntityWorld().getEntityByID(id);
    }

    public static String positionToString(BlockPos pos){
        return "[" + pos.getX() + ", " + pos.getY() + ", " + pos.getZ() + "]";
    }

    public static void printDataWatchers(List<DataWatcher.WatchableObject> watchers){
        for (DataWatcher.WatchableObject w : watchers) {
            int dataValueID = w.getDataValueId();
            int objType = w.getObjectType();
            Object obj = w.getObject();
            boolean isWatched = w.isWatched();
            System.out.println(
                    "WatchableObject: {dataValueID: " + dataValueID +
                            ", objecttype: " + objType +
                    ", isWatched: " + isWatched);
        }
    }

    public static String capitalizeString(String str){
        String[] split = str.split("_");
        StringBuilder toRet = new StringBuilder();
        for (String s : split) {
            toRet.append(capitalizeSingleString(s)).append(" ");
        }
        return toRet.toString().trim();
    }

    public static String capitalizeSingleString(String str){
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
