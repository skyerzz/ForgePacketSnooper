package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.S19PacketEntityHeadLook;

public class S19PacketEntityHeadLookEvent extends PacketEvent {

    S19PacketEntityHeadLook packet;

    public S19PacketEntityHeadLookEvent(S19PacketEntityHeadLook o) {
        packet = o;
    }

    //todo get entityID (reflection)

    public Entity getEntity(){
        return packet.getEntity(Minecraft.getMinecraft().thePlayer.getEntityWorld());
    }

    public byte getYaw(){
        return packet.getYaw();
    }

}
