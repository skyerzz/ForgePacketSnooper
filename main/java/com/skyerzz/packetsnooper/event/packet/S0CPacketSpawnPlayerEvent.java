package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.util.SkyHelper;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.S0CPacketSpawnPlayer;

import java.util.List;
import java.util.UUID;

/**
 * Received when a player comes into visible range.
 * Not to be confused with when a player joins!
 */
public class S0CPacketSpawnPlayerEvent extends PacketEvent {

    S0CPacketSpawnPlayer packet;

    public S0CPacketSpawnPlayerEvent(S0CPacketSpawnPlayer o) {
        packet = o;
    }

    public int getPlayerId(){
        return packet.getEntityID();
    }

    public Entity getPlayer(){
        return SkyHelper.getEntityById(getPlayerId());
    }

    public UUID getPlayerUUID(){
        return packet.getPlayer();
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

    public int getYaw(){
        return packet.getYaw();
    }

    public int getPitch(){
        return packet.getPitch();
    }

    public int getHeldItemSlot(){
        return packet.getCurrentItemID();
    }

    public List<DataWatcher.WatchableObject> getWatchers(){
        return packet.func_148944_c();
    }
}
