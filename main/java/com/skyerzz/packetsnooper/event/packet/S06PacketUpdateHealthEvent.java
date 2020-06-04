package com.skyerzz.packetsnooper.event.packet;

import net.minecraft.network.play.server.S06PacketUpdateHealth;

/**
 * Updates the health, food & saturation of the player it's sent to (us)
 */
public class S06PacketUpdateHealthEvent extends PacketEvent {


    S06PacketUpdateHealth packet;

    public S06PacketUpdateHealthEvent(S06PacketUpdateHealth o) {
        packet = o;
    }

    public float getHealth(){
        return packet.getHealth();
    }

    public int getFoodLevel(){
        return packet.getFoodLevel();
    }

    public float getSaturationLevel(){
        return packet.getSaturationLevel();
    }
}
