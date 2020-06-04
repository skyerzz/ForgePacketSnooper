package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import com.skyerzz.packetsnooper.util.PotionEffect;
import com.skyerzz.packetsnooper.util.SkyHelper;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.S1DPacketEntityEffect;

public class S1DPacketEntityEffectEvent extends PacketEvent {

    S1DPacketEntityEffect packet;

    public S1DPacketEntityEffectEvent(S1DPacketEntityEffect o) {
        packet = o;
    }

    public int getEntityId(){
        return packet.getEntityId();
    }

    public Entity getEntity(){
        return SkyHelper.getEntityById(getEntityId());
    }

    public byte getEffectId(){
        return packet.getEffectId();
    }

    /**
     * Note: starts at 0. a level 1 effect has amplifier 0, a level 5 effect has amplifier 4.
     * @return
     */
    public byte getAmplifier(){
        return packet.getAmplifier();
    }

    public int getDuration(){
        return packet.getDuration();
    }

    public boolean doesHideParticles(){
        return packet.func_179707_f();
    }

    public PotionEffect getPotionEffect(){
        return PotionEffect.getById(getEffectId());
    }
}
