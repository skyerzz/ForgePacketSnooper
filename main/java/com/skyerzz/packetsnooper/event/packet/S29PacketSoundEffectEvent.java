package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import net.minecraft.network.play.server.S29PacketSoundEffect;

public class S29PacketSoundEffectEvent extends PacketEvent {


    S29PacketSoundEffect packet;

    public S29PacketSoundEffectEvent(S29PacketSoundEffect o) {
        packet = o;
    }

    public String getSoundName(){
        return packet.getSoundName();
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

    public float getVolume(){
        return packet.getVolume();
    }

    public float getPitch(){
        return packet.getPitch();
    }

}
