package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import net.minecraft.block.state.IBlockState;
import net.minecraft.network.play.server.S23PacketBlockChange;
import net.minecraft.util.BlockPos;

public class S23PacketBlockChangeEvent extends PacketEvent {

    S23PacketBlockChange packet;

    public S23PacketBlockChangeEvent(S23PacketBlockChange o) {
        packet = o;
    }

    public BlockPos getLocation(){
        return packet.getBlockPosition();
    }

    public IBlockState getBlockState(){
        return packet.getBlockState();
    }
}
