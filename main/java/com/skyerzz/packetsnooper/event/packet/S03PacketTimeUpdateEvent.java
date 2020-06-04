package com.skyerzz.packetsnooper.event.packet;

import net.minecraft.network.play.server.S03PacketTimeUpdate;

public class S03PacketTimeUpdateEvent extends PacketEvent {

    S03PacketTimeUpdate packet;

    public S03PacketTimeUpdateEvent(S03PacketTimeUpdate o) {
        packet = o;
    }

    public long getWorldTime(){
        return packet.getWorldTime();
    }

    public long getTotalWorldTime(){
        return packet.getTotalWorldTime();
    }
}
