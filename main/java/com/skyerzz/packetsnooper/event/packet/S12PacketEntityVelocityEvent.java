package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import com.skyerzz.packetsnooper.util.SkyHelper;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.S12PacketEntityVelocity;

public class S12PacketEntityVelocityEvent extends PacketEvent {

    S12PacketEntityVelocity packet;

    public S12PacketEntityVelocityEvent(S12PacketEntityVelocity o) {
        packet = o;
    }

    public int getEntityId(){
        return packet.getEntityID();
    }

    public Entity getEntity(){
        return SkyHelper.getEntityById(getEntityId());
    }

    public int getMotionX(){
        return packet.getMotionX();
    }

    public int getMotionY(){
        return packet.getMotionY();
    }

    public int getMotionZ(){
        return packet.getMotionZ();
    }

}
