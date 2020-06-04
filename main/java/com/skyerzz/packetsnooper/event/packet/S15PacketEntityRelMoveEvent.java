package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.S14PacketEntityEvent;
import net.minecraft.network.play.server.S14PacketEntity;

public class S15PacketEntityRelMoveEvent extends S14PacketEntityEvent {

    public S15PacketEntityRelMoveEvent(S14PacketEntity.S15PacketEntityRelMove o) {
        super(o);
    }


}
