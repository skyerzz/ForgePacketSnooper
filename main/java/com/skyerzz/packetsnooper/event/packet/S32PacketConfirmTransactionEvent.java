package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import net.minecraft.network.play.server.S32PacketConfirmTransaction;

public class S32PacketConfirmTransactionEvent extends PacketEvent {

    S32PacketConfirmTransaction packet;

    public S32PacketConfirmTransactionEvent(S32PacketConfirmTransaction o) {
        packet = o;
    }

    public int getWindowId(){
        return packet.getWindowId();
    }

    public short getActionNumber(){
        return packet.getActionNumber();
    }

    public boolean isAccepted(){
        return packet.func_148888_e();
    }
}
