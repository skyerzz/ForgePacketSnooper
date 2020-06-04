package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.util.SkyHelper;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.S0FPacketSpawnMob;

import java.util.List;

public class S0FPacketSpawnMobEvent extends PacketEvent {

    S0FPacketSpawnMob packet;
    
    public S0FPacketSpawnMobEvent(S0FPacketSpawnMob o) {
        packet = o;
    }

    public int getEntityId(){
        return packet.getEntityID();
    }

    public Entity getEntity(){
        return SkyHelper.getEntityById(getEntityId());
    }

    public int getX(){
        return packet.getX();
    }

    public int getY(){
        return packet.getY();
    }

    public int getZ(){
        return packet.getZ();
    }

    public int getVelocityX(){
        return packet.getVelocityX();
    }

    public int getVelocityY(){
        return packet.getVelocityY();
    }

    public int getVelocityZ(){
        return packet.getVelocityZ();
    }

    public byte getPitch(){
        return packet.getPitch();
    }

    public byte getYaw(){
        return packet.getYaw();
    }

    public int getEntityType(){
        return packet.getEntityType();
    }

    public byte headPitch(){
        return packet.getHeadPitch();
    }

    public List<DataWatcher.WatchableObject> getWatchers(){
        return packet.func_149027_c();
    }
}
