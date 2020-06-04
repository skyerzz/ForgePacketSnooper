package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import net.minecraft.network.play.server.S34PacketMaps;

public class S34PacketMapsEvent extends PacketEvent {

    S34PacketMaps packet;

    public S34PacketMapsEvent(S34PacketMaps o) {
        packet = o;
    }

    public int getMapId(){
        return packet.getMapId();
    }

    //todo reflection
}
