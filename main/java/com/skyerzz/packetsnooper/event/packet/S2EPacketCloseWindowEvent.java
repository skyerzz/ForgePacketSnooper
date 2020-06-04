package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import net.minecraft.network.play.server.S2EPacketCloseWindow;

public class S2EPacketCloseWindowEvent extends PacketEvent {

    S2EPacketCloseWindow packet;

    public S2EPacketCloseWindowEvent(S2EPacketCloseWindow o) {
        packet = o;
    }

    public int getWindowId(){
        return -1; //todo reflection
    }


}
