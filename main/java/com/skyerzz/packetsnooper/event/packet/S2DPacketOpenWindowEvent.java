package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import com.skyerzz.packetsnooper.util.SkyHelper;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.network.play.server.S2DPacketOpenWindow;
import net.minecraft.util.IChatComponent;

/**
 * Sent when client should open an inventory
 */
public class S2DPacketOpenWindowEvent extends PacketEvent {

    S2DPacketOpenWindow packet;

    public S2DPacketOpenWindowEvent(S2DPacketOpenWindow o) {
        packet = o;
    }

    public int getWindowId(){
        return packet.getWindowId();
    }

    public int getEntityHorseId(){
        return packet.getEntityId();
    }

    public EntityHorse getHorse(){
        if(getEntityHorseId()==0){
            return null;
        }
        return (EntityHorse) SkyHelper.getEntityById(getEntityHorseId());
    }

    public int getSlotCount(){
        return packet.getSlotCount();
    }

    public IChatComponent getWindowTitle(){
        return packet.getWindowTitle();
    }

    public String getInventoryType(){
        return packet.getGuiId();
    }
}
