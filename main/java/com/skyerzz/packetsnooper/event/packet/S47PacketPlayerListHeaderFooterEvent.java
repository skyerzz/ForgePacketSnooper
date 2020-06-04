package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import net.minecraft.network.play.server.S47PacketPlayerListHeaderFooter;
import net.minecraft.util.IChatComponent;

public class S47PacketPlayerListHeaderFooterEvent extends PacketEvent {

    S47PacketPlayerListHeaderFooter packet;

    public S47PacketPlayerListHeaderFooterEvent(S47PacketPlayerListHeaderFooter o) {
        super();
    }

    public IChatComponent getHeader(){
        return packet.getHeader();
    }

    public IChatComponent getFooter(){
        return packet.getFooter();
    }
}
