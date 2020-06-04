package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.util.SkyHelper;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.S11PacketSpawnExperienceOrb;

public class S11PacketSpawnExperienceOrbEvent extends PacketEvent {

    S11PacketSpawnExperienceOrb packet;

    public S11PacketSpawnExperienceOrbEvent(S11PacketSpawnExperienceOrb o) {
        packet = o;
    }

    public int getEntityId(){
        return packet.getEntityID();
    }

    public Entity getEntity(){
        return SkyHelper.getEntityById(getEntityId());
    }

    public int getX(){
        return packet.getX();
    }

    public int getY(){
        return packet.getY();
    }

    public int getZ(){
        return packet.getZ();
    }

    public int getExpValue(){
        return packet.getXPValue();
    }

}
