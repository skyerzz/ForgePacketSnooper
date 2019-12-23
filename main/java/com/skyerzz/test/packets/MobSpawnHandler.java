package com.skyerzz.test.packets;

import net.minecraft.entity.DataWatcher;
import net.minecraft.network.play.server.S0FPacketSpawnMob;

/**
 * Created by sky on 23-8-2019.
 */
public class MobSpawnHandler {

    S0FPacketSpawnMob pkt;

    public MobSpawnHandler(S0FPacketSpawnMob pkt){
        this.pkt=pkt;
        switch(pkt.getEntityType()){
            case 58: handleEnderman(); break; //examples of how to find the mob type, and do something with the packet
            case 92: handleCow(); break;
        }
    }

    public void handleArmorStand(){}
    public void handleArrow(){}
    public void handleBat(){}
    public void handleBlaze(){}
    public void handleBoat(){}
    public void handleCaveSpider(){}
    public void handleChicken(){}
    public void handleCow(){}
    public void handleEnderman(){}

    @Override
    public String toString() {
        String watchables="";
        for(DataWatcher.WatchableObject w : pkt.func_149027_c()){
            watchables += "\nWatchableObject: {dataValueID: " +w.getDataValueId() + ", objettype: " + w.getObjectType() + ", obj: " + w.getObject().getClass().getSimpleName();
        }
        return ("S0FPacketSpawnMob: ID: " + pkt.getEntityID() + "Type: " + pkt.getEntityType() + " [x,y,z]: [" +
                pkt.getX() + ", " + pkt.getY() + ", " + pkt.getZ() + "] Yaw,Pitch: " + pkt.getYaw() + ", " + pkt.getPitch() + " Vel[x,y,z]: [" + pkt.getVelocityX() + ", " + pkt.getVelocityY() +
                ", " + pkt.getVelocityZ() + "] HeadPitch: " + pkt.getHeadPitch() + "\nWatchables:" + watchables + "\n--end of watchables--");
    }
}
