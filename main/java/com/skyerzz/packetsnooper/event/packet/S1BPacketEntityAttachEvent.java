package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import com.skyerzz.packetsnooper.util.SkyHelper;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.S1BPacketEntityAttach;

public class S1BPacketEntityAttachEvent extends PacketEvent {

    S1BPacketEntityAttach packet;

    public S1BPacketEntityAttachEvent(S1BPacketEntityAttach o) {
        packet = o;
    }

    /**
     * Theoretical boolean? 1 = leash, 0 = dont leash?
     * @return
     */
    public int getLeash(){
        return packet.getLeash();
    }

    public int getEntityId(){
        return packet.getEntityId();
    }

    /**
     * This is the entity that is ATTACHED TO the leash
     * @return
     */
    public Entity getEntity(){
        return SkyHelper.getEntityById(getEntityId());
    }

    public int getVehicleId(){
        return packet.getVehicleEntityId();
    }

    public boolean isUnleashPacket(){
        return getVehicleId()==-1;
    }

    public Entity getVehicle(){
        return SkyHelper.getEntityById(getVehicleId());
    }


}
