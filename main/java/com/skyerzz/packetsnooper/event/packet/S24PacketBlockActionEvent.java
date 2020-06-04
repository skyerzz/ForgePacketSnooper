package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import net.minecraft.block.Block;
import net.minecraft.network.play.server.S24PacketBlockAction;
import net.minecraft.util.BlockPos;

public class S24PacketBlockActionEvent extends PacketEvent {

    S24PacketBlockAction packet;

    public S24PacketBlockActionEvent(S24PacketBlockAction o) {
        packet = o;
    }

    public BlockPos getLocation(){
        return packet.getBlockPosition();
    }

    public Block getBlock(){
        return packet.getBlockType();
    }

    public int getInstrumentType(){
        return packet.getData1();
    }

    public int getInstrumentPitch(){
        return packet.getData2();
    }

}
