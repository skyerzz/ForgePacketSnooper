package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import com.skyerzz.packetsnooper.util.SkyHelper;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.S13PacketDestroyEntities;

import java.util.ArrayList;
import java.util.List;

public class S13PacketDestroyEntitiesEvent extends PacketEvent {

    S13PacketDestroyEntities packet;

    public S13PacketDestroyEntitiesEvent(S13PacketDestroyEntities o) {
        packet = o;
    }

    public int[] getEntityIds(){
        return packet.getEntityIDs();
    }

    public List<Entity> getEntities(){
        ArrayList<Entity> list = new ArrayList();
        for(int id: getEntityIds()){
            list.add(SkyHelper.getEntityById(id));
        }
        return list;
    }
}
