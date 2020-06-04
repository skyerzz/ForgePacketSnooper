package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.util.SkyHelper;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.S0DPacketCollectItem;

public class S0DPacketCollectItemEvent extends PacketEvent {

    S0DPacketCollectItem packet;

    public S0DPacketCollectItemEvent(S0DPacketCollectItem o) {
        packet = o;
    }

    public int getEntityId(){
        return packet.getEntityID();
    }

    public Entity getEntity(){
        return SkyHelper.getEntityById(getEntityId());
    }

    public int getCollectedItemEntityId(){
        return packet.getCollectedItemEntityID();
    }

    public Entity getEntityItem(){
        return SkyHelper.getEntityById(getCollectedItemEntityId());
    }
}
