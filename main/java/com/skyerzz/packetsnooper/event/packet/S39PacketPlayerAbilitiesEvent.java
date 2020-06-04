package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import net.minecraft.network.play.server.S39PacketPlayerAbilities;

public class S39PacketPlayerAbilitiesEvent extends PacketEvent {

    S39PacketPlayerAbilities packet;

    public S39PacketPlayerAbilitiesEvent(S39PacketPlayerAbilities o) {
        packet = o;
    }

    public boolean isInvulnerable(){
        return packet.isInvulnerable();
    }

    public boolean isFlying(){
        return packet.isFlying();
    }

    public boolean isAllowedFlying(){
        return packet.isAllowFlying();
    }

    public boolean isCreativeMode(){
        return packet.isCreativeMode();
    }

    public float getWalkSpeed(){
        return packet.getWalkSpeed();
    }

    public float getFlySpeed(){
        return packet.getFlySpeed();
    }
}
