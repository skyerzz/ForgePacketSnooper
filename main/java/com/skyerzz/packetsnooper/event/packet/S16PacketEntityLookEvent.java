package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.S14PacketEntityEvent;
import net.minecraft.network.play.server.S14PacketEntity;

public class S16PacketEntityLookEvent extends S14PacketEntityEvent {

    public S16PacketEntityLookEvent(S14PacketEntity.S16PacketEntityLook o) {
        super(o);
    }
}
