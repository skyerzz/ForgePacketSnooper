package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import com.skyerzz.packetsnooper.util.SkyHelper;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.S43PacketCamera;

/**
 * Sent when your camera position is attached to an entity (mostly spectating?)
 */
public class S43PacketCameraEvent extends PacketEvent {

    S43PacketCamera packet;

    public S43PacketCameraEvent(S43PacketCamera o) {
        packet = o;
    }

    public int getEntityId(){
        return packet.entityId;
    }

    public Entity getEntity(){
        return SkyHelper.getEntityById(packet.entityId);
    }


}
