package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import com.skyerzz.packetsnooper.util.SkyHelper;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.S20PacketEntityProperties;

import java.util.List;

public class S20PacketEntityPropertiesEvent extends PacketEvent {

    S20PacketEntityProperties packet;

    public S20PacketEntityPropertiesEvent(S20PacketEntityProperties o) {
        packet = o;
    }

    public int getEntityId(){
        return packet.getEntityId();
    }

    public Entity getEntity(){
        return SkyHelper.getEntityById(getEntityId());
    }

    //todo make this better
    public List<S20PacketEntityProperties.Snapshot> getAttributeModifiers(){
        return packet.func_149441_d();
    }
}
