package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import net.minecraft.network.play.server.S36PacketSignEditorOpen;
import net.minecraft.util.BlockPos;

public class S36PacketSignEditorOpenEvent extends PacketEvent {

    S36PacketSignEditorOpen packet;

    public S36PacketSignEditorOpenEvent(S36PacketSignEditorOpen o) {
        packet = o;
    }

    public BlockPos getSignLocation(){
        return packet.getSignPosition();
    }
}
