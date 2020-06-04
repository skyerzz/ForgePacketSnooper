package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import com.skyerzz.packetsnooper.util.SkyHelper;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.S18PacketEntityTeleport;

public class S18PacketEntityTeleportEvent extends PacketEvent {

    S18PacketEntityTeleport packet;

    public S18PacketEntityTeleportEvent(S18PacketEntityTeleport o) {
        packet = o;
    }

    public int getEntityId(){
        return packet.getEntityId();
    }

    public Entity getEntity(){
        return SkyHelper.getEntityById(packet.getEntityId());
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

    public byte getYaw(){
        return packet.getYaw();
    }

    public byte getPitch(){
        return packet.getPitch();
    }

    public boolean isOnGround(){
        return packet.getOnGround();
    }

    @Override
    public String toString() {
        Entity e = getEntity();
        return "S18PacketEntityTeleport: Entity " + getEntityId() + "\nName: " + e.getName() + " teleported to [" + getX() + ", " + getY() + ", " + getZ() + "] " +
                "With Yaw,Pitch: " + getYaw() + "," + getPitch() + "\nOnground: " + isOnGround();

    }
}
