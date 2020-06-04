package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.S2FPacketSetSlot;

public class S2FPacketSetSlotEvent extends PacketEvent {

    S2FPacketSetSlot packet;

    public S2FPacketSetSlotEvent(S2FPacketSetSlot o) {
        packet = o;
    }

    public int getWindowId(){
        return packet.func_149175_c();
    }

    public int getSlot(){
        return packet.func_149173_d();
    }

    public ItemStack getItemStack(){
        return packet.func_149174_e();
    }
}
