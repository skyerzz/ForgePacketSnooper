package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.util.SkyHelper;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.S0EPacketSpawnObject;

/**
 * Mostly used to spawn vehicles (Minecarts, boats)
 */
public class S0EPacketSpawnObjectEvent extends PacketEvent {

    S0EPacketSpawnObject packet;

    public S0EPacketSpawnObjectEvent(S0EPacketSpawnObject o) {
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

    public int getSpeedX(){
        return packet.getSpeedX();
    }

    public int getSpeedY(){
        return packet.getSpeedY();
    }

    public int getSpeedZ(){
        return packet.getSpeedZ();
    }

    public int getPitch(){
        return packet.getPitch();
    }

    public int getYaw(){
        return packet.getYaw();
    }

    /**
     * https://wiki.vg/Entity_metadata#Objects
     * @return
     */
    public int getType(){
        return packet.getType();
    }

    /**
     * https://wiki.vg/Object_Data
     * @return
     */
    public int getTypeFunctionality(){
        return packet.func_149009_m();
    }



    @Override
    public String toString() {
        Entity e = getEntity();
        return "S0EPacketSpawnObject: ID: " + getEntityId() + " Entity: " + e.getName() + " (" + e.toString() + ")\n" + "Type: " + getType() + " [x,y,z]: [" +
                getX() + ", " + getY() + ", " + getZ() + "] Yaw,Pitch: " + getYaw() + ", " + getPitch() + " Vel[x,y,z]: [" + getSpeedX() + ", " + getSpeedY() +
                ", " + getSpeedZ() + "] Type Functionality: " + getTypeFunctionality();
    }
}
