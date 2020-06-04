package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import net.minecraft.network.play.server.S3DPacketDisplayScoreboard;

public class S3DPacketDisplayScoreboardEvent extends PacketEvent {

    S3DPacketDisplayScoreboard packet;

    public S3DPacketDisplayScoreboardEvent(S3DPacketDisplayScoreboard o) {
        packet = o;
    }

    /**
     * 0: List, 1: Sidebar, 2: Below name
     * @return
     */
    public int getPosition(){
        return packet.func_149371_c();
    }

    public String getScoreName(){
        return packet.func_149370_d();
    }

}
