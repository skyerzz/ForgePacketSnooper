package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.util.SkyHelper;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.S01PacketJoinGame;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;

public class S01PacketJoinGameEvent extends PacketEvent {

    S01PacketJoinGame packet;

    public S01PacketJoinGameEvent(S01PacketJoinGame o) {
        this.packet = o;
    }

    public int getEntityId(){
        return packet.getEntityId();
    }

    public Entity getEntity(){
        return SkyHelper.getEntityById(getEntityId());
    }

    public int getDimension(){
        return packet.getDimension();
    }

    public EnumDifficulty getDifficulty(){
        return packet.getDifficulty();
    }

    public WorldSettings.GameType getGameType(){
        return packet.getGameType();
    }

    public int getMaxPlayers(){
        return packet.getMaxPlayers();
    }

    public boolean isHardcoreMode(){
        return packet.isHardcoreMode();
    }

    public WorldType getWorldType(){
        return packet.getWorldType();
    }

    public boolean isReducedDebugInfo(){
        return packet.isReducedDebugInfo();
    }
}
