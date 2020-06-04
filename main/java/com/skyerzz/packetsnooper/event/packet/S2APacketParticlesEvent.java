package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import net.minecraft.network.play.server.S2APacketParticles;
import net.minecraft.util.EnumParticleTypes;

public class S2APacketParticlesEvent extends PacketEvent {

    S2APacketParticles packet;

    public S2APacketParticlesEvent(S2APacketParticles o) {
        packet = o;
    }

    public EnumParticleTypes getParticleType(){
        return packet.getParticleType();
    }

    public double getX(){
        return packet.getXCoordinate();
    }

    public double getY(){
        return packet.getYCoordinate();
    }

    public double getZ(){
        return packet.getZCoordinate();
    }

    public double getXOffset(){
        return packet.getXOffset();
    }

    public double getYOffset(){
        return packet.getYOffset();
    }

    public double getZOffset(){
        return packet.getZOffset();
    }

    public float getSpeed(){
        return packet.getParticleSpeed();
    }

    public float getCount(){
        return packet.getParticleCount();
    }

    public boolean longDistanceViewable(){
        return packet.isLongDistance();
    }

    /**
     * https://wiki.vg/index.php?title=Protocol&oldid=7368#Particle
     * @return
     */
    public int[] getArguments(){
        return packet.getParticleArgs();
    }
}
