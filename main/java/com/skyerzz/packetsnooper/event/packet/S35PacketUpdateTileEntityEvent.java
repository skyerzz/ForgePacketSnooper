package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.util.BlockPos;

public class S35PacketUpdateTileEntityEvent extends PacketEvent {

    S35PacketUpdateTileEntity packet;

    public S35PacketUpdateTileEntityEvent(S35PacketUpdateTileEntity o) {
        packet = o;
    }

    public BlockPos getBlockPos(){
        return packet.getPos();
    }

    public UpdateTileEntityType getTileEntityType(){
        return UpdateTileEntityType.getTileEntityTypeById(packet.getTileEntityType());
    }


    public enum UpdateTileEntityType{
        SET_SPAWNER_POTENTIALS(1),
        SET_COMMAND_BLOCK_TEXT(2),
        SET_BEACON_DETAILS(3),
        SET_ROTATION_SKIN_MOB_HEAD(4),
        SET_FLOWER_TYPE_IN_POT(5),
        SET_BANNER_DETAILS(6);

        private int id;

        UpdateTileEntityType(int id) {
            this.id = id;
        }

        public static UpdateTileEntityType getTileEntityTypeById(int id){
            for(UpdateTileEntityType type: values()){
                if(type.id == id){
                    return type;
                }
            }
            return null;
        }
    }
}
