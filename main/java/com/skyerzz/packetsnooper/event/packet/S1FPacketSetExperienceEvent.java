package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import net.minecraft.network.play.server.S1FPacketSetExperience;

/**
 * Sent to set YOUR level/exp.
 */
public class S1FPacketSetExperienceEvent extends PacketEvent {

    S1FPacketSetExperience packet;

    public S1FPacketSetExperienceEvent(S1FPacketSetExperience o) {
        packet = o;
    }

    /**
     * Is between 0 & 1. 0 for empty, 1 for full.
     * @return
     */
    public float getExperienceBarFill(){
        return packet.func_149397_c();
    }

    public int getLevel(){
        return packet.getLevel();
    }

    public int getTotalExp(){
        return packet.getTotalExperience();
    }
}
