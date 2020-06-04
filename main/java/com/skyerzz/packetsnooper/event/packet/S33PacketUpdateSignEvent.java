package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import net.minecraft.network.play.server.S33PacketUpdateSign;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IChatComponent;

public class S33PacketUpdateSignEvent extends PacketEvent {

    S33PacketUpdateSign packet;

    public S33PacketUpdateSignEvent(S33PacketUpdateSign o) {
        packet = o;
    }

    public BlockPos getBlockPos(){
        return packet.getPos();
    }

    public IChatComponent[] getLines(){
        return packet.getLines();
    }
}
