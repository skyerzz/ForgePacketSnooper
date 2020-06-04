package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import net.minecraft.network.play.server.S38PacketPlayerListItem;

import java.util.List;

public class S38PacketPlayerListItemEvent extends PacketEvent {

    S38PacketPlayerListItem packet;

    public S38PacketPlayerListItemEvent(S38PacketPlayerListItem o) {
        super();
    }

    public S38PacketPlayerListItem.Action getAction(){
        return packet.func_179768_b();
    }

    //todo https://wiki.vg/index.php?title=Protocol&oldid=7368#Player_List_Item
    public List<S38PacketPlayerListItem.AddPlayerData> getPlayerData(){
        return packet.func_179767_a();
    }
}
