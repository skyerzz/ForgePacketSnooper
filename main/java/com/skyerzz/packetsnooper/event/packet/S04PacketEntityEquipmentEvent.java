package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.util.SkyHelper;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.S04PacketEntityEquipment;

public class S04PacketEntityEquipmentEvent extends PacketEvent {

    S04PacketEntityEquipment packet;

    public S04PacketEntityEquipmentEvent(S04PacketEntityEquipment o) {
        this.packet = o;
    }

    public int getEntityId(){
        return packet.getEntityID();
    }

    public Entity getEntity(){
        return SkyHelper.getEntityById(getEntityId());
    }

    public int getEquipmentSlot(){
        return packet.getEquipmentSlot();
    }

    public ItemStack getItemStack(){
        return packet.getItemStack();
    }

}
