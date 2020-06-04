package com.skyerzz.packetsnooper.event.packet;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.server.S0APacketUseBed;
import net.minecraft.util.BlockPos;

public class S0APacketUseBedEvent extends PacketEvent {

    S0APacketUseBed packet;

    public S0APacketUseBedEvent(S0APacketUseBed o) {
        packet = o;
    }

    public EntityPlayer getPlayer(){
        return packet.getPlayer(Minecraft.getMinecraft().thePlayer.getEntityWorld());
    }

    public BlockPos getBedPosition(){
        return packet.getBedPosition();
    }


}
