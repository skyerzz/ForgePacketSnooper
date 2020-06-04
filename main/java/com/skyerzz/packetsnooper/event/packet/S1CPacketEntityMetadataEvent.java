package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import com.skyerzz.packetsnooper.util.SkyHelper;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.S1CPacketEntityMetadata;

import java.util.List;

public class S1CPacketEntityMetadataEvent extends PacketEvent {

    S1CPacketEntityMetadata packet;

    public S1CPacketEntityMetadataEvent(S1CPacketEntityMetadata o) {
        packet = o;
    }

    public int getEntityId(){
        return packet.getEntityId();
    }

    public Entity getEntity(){
        return SkyHelper.getEntityById(getEntityId());
    }

    /**
     * https://wiki.vg/Entity_metadata#Entity_Metadata_Format
     * @return
     */
    public List<DataWatcher.WatchableObject> getWatchers(){
        return packet.func_149376_c();
    }
}
