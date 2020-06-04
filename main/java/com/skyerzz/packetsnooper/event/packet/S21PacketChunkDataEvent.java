package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import net.minecraft.network.play.server.S21PacketChunkData;

public class S21PacketChunkDataEvent extends PacketEvent {

    S21PacketChunkData packet;

    public S21PacketChunkDataEvent(S21PacketChunkData o) {
        packet = o;
    }

    public int getChunkX(){
        return packet.getChunkX();
    }

    public int getChunkZ(){
        return packet.getChunkZ();
    }

    public boolean groundUpContinuous(){
        return packet.func_149274_i();
    }

    public byte[] getData(){
        return packet.func_149272_d();
    }

    public int getDataSize(){
        return packet.getExtractedSize();
    }

}
