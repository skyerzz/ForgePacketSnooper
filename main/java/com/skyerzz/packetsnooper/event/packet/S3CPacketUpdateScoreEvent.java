package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import net.minecraft.network.play.server.S3CPacketUpdateScore;

public class S3CPacketUpdateScoreEvent extends PacketEvent {


    S3CPacketUpdateScore packet;

    public S3CPacketUpdateScoreEvent(S3CPacketUpdateScore o) {
        packet = o;
    }

    public String getPlayerName(){
        return packet.getPlayerName();
    }

    public String getObjectiveName(){
        return packet.getObjectiveName();
    }

    public int getValue(){
        return packet.getScoreValue();
    }

    public S3CPacketUpdateScore.Action getAction(){
        return packet.getScoreAction();
    }
}
