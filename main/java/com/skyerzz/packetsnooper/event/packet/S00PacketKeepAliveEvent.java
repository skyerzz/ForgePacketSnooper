package com.skyerzz.packetsnooper.event.packet;

import net.minecraft.network.play.server.S00PacketKeepAlive;

public class S00PacketKeepAliveEvent extends PacketEvent {

    S00PacketKeepAlive packet;

    public S00PacketKeepAliveEvent(S00PacketKeepAlive o) {
        this.packet = o;
    }

    public int getId(){
        return packet.func_149134_c();
    }

}
