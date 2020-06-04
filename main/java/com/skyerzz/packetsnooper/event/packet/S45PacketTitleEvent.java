package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import net.minecraft.network.play.server.S45PacketTitle;
import net.minecraft.util.IChatComponent;

public class S45PacketTitleEvent extends PacketEvent {

    S45PacketTitle packet;

    public S45PacketTitleEvent(S45PacketTitle o) {
        packet = o;
    }

    public S45PacketTitle.Type getType(){
        return packet.getType();
    }

    public IChatComponent getChatComponent(){
        return packet.getMessage();
    }

    public int getFadeInTime(){
        return packet.getFadeInTime();
    }

    public int getDisplayTime(){
        return packet.getDisplayTime();
    }

    public int getFadeOutTime(){
        return packet.getFadeOutTime();
    }

}
