package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.S3FPacketCustomPayload;

public class S3FPacketCustomPayloadEvent extends PacketEvent {

    S3FPacketCustomPayload packet;

    public S3FPacketCustomPayloadEvent(S3FPacketCustomPayload o) {
        packet = o;
    }

    public String getChannel(){
        return packet.getChannelName();
    }

    public PacketBuffer getData(){
        return packet.getBufferData();
    }
}
