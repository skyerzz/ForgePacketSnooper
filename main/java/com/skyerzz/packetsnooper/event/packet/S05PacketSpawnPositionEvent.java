package com.skyerzz.packetsnooper.event.packet;

import net.minecraft.network.play.server.S05PacketSpawnPosition;
import net.minecraft.util.BlockPos;

/**
 * Packet indicates the spawnpoint of a player.
 * This is also the point that a compass points to.
 */
public class S05PacketSpawnPositionEvent extends PacketEvent {

    S05PacketSpawnPosition packet;

    public S05PacketSpawnPositionEvent(S05PacketSpawnPosition o) {
        packet = o;
    }

    public BlockPos getBlockPos(){
        return packet.getSpawnPos();
    }
}
