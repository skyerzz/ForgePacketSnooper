package com.skyerzz.test;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;

/**
 * Created by sky on 23-8-2019.
 */
public class SkyHelper {

    public static Entity getEntityById(int id){
        return Minecraft.getMinecraft().thePlayer.getEntityWorld().getEntityByID(id);
    }

    public static String positionToString(BlockPos pos){
        return "[" + pos.getX() + ", " + pos.getY() + ", " + pos.getZ() + "]";
    }
}
