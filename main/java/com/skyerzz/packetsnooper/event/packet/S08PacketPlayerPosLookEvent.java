package com.skyerzz.packetsnooper.event.packet;

import net.minecraft.network.play.server.S08PacketPlayerPosLook;

import java.util.Set;

public class S08PacketPlayerPosLookEvent extends PacketEvent {

    S08PacketPlayerPosLook packet;

    public S08PacketPlayerPosLookEvent(S08PacketPlayerPosLook o) {
        packet = o;
    }

    public double getX(){
        return packet.getX();
    }

    public double getY(){
        return packet.getY();
    }

    public double getZ(){
        return packet.getZ();
    }

    public float getYaw(){
        return packet.getYaw();
    }

    public float getPitch(){
        return packet.getPitch();
    }

    /**
     * If a flag is set, it means that the value is relative and not absolute.
     * @return
     */
    public Set<S08PacketPlayerPosLook.EnumFlags> getEnumFlags(){
        return packet.func_179834_f();
    }

    public boolean isXReltive(){
        return getEnumFlags().contains(S08PacketPlayerPosLook.EnumFlags.X);
    }

    public boolean isYReltive(){
        return getEnumFlags().contains(S08PacketPlayerPosLook.EnumFlags.Y);
    }

    public boolean isZReltive(){
        return getEnumFlags().contains(S08PacketPlayerPosLook.EnumFlags.Z);
    }

    public boolean isXRotReltive(){
        return getEnumFlags().contains(S08PacketPlayerPosLook.EnumFlags.X_ROT);
    }

    public boolean isYRotReltive(){
        return getEnumFlags().contains(S08PacketPlayerPosLook.EnumFlags.Y_ROT);
    }


}
