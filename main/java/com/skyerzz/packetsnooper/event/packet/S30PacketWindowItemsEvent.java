package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.S30PacketWindowItems;

public class S30PacketWindowItemsEvent extends PacketEvent {

    S30PacketWindowItems packet;

    public S30PacketWindowItemsEvent(S30PacketWindowItems o) {
        packet = o;
    }

    public int getWindowId(){
        return packet.func_148911_c();
    }

    public ItemStack[] getItemStacks(){
        return packet.getItemStacks();
    }

}
