package com.skyerzz.packetsnooper.event.packet;

import net.minecraft.network.play.server.S07PacketRespawn;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;

/**
 * Sent to change the dimension they are in
 */
public class S07PacketRespawnEvent extends PacketEvent {

    S07PacketRespawn packet;

    public S07PacketRespawnEvent(S07PacketRespawn o) {
        packet = o;
    }

    public int getDimensionID(){
        return packet.getDimensionID();
    }

    public EnumDifficulty getDifficulty(){
        return packet.getDifficulty();
    }

    public WorldSettings.GameType getGameType(){
        return packet.getGameType();
    }

    public WorldType getWorldType(){
        return packet.getWorldType();
    }
}
