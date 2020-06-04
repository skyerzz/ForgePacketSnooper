package com.skyerzz.packetsnooper.event.packet;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.S14PacketEntity;

/**
 * Movement is relative. Byte range -128 : 127 , block range -4:4
 */
public class S14PacketEntityEvent extends PacketEvent {

    S14PacketEntity packet;

    public S14PacketEntityEvent(S14PacketEntity o) {
        packet = o;
    }

    //todo reflection get entityID

    public Entity getEntity(){
        return packet.getEntity(Minecraft.getMinecraft().thePlayer.getEntityWorld());
    }

    public byte getX(){
        return packet.func_149062_c();
    }

    public byte getY(){
        return packet.func_149061_d();
    }

    public byte getZ(){
        return packet.func_149064_e();
    }

    public byte getYaw(){
        return packet.func_149066_f();
    }

    public byte getPitch(){
        return packet.func_149063_g();
    }

    public boolean isOnGround(){
        return packet.getOnGround();
    }

    /**
     * Unsure if this one is correct.
     * @return
     */
    public boolean didRotate(){
        return packet.func_149060_h();
    }



}
