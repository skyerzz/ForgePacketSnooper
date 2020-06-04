package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.S14PacketEntityEvent;
import net.minecraft.network.play.server.S14PacketEntity;

public class S17PacketEntityLookMoveEvent extends S14PacketEntityEvent {

    public S17PacketEntityLookMoveEvent(S14PacketEntity.S17PacketEntityLookMove o) {
        super(o);
    }
}
