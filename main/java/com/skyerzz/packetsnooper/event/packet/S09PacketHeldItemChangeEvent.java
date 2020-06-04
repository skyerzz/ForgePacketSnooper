package com.skyerzz.packetsnooper.event.packet;

import net.minecraft.network.play.server.S09PacketHeldItemChange;

public class S09PacketHeldItemChangeEvent extends PacketEvent {

    S09PacketHeldItemChange packet;

    public S09PacketHeldItemChangeEvent(S09PacketHeldItemChange o) {
        packet = o;
    }

    public int getHeldItemHotbarIndex(){
        return packet.getHeldItemHotbarIndex();
    }
}
