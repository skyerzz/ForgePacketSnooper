package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.util.SkyHelper;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.S0BPacketAnimation;

public class S0BPacketAnimationEvent extends PacketEvent {

    S0BPacketAnimation packet;

    public S0BPacketAnimationEvent(S0BPacketAnimation o) {
        packet = o;
    }

    public int getEntityId(){
        return packet.getEntityID();
    }

    public Entity getEntity(){
        return SkyHelper.getEntityById(getEntityId());
    }

    public AnimationType getAnimationType(){
        return AnimationType.getByInt(packet.getAnimationType());
    }

    public enum AnimationType{
        SWING_ARM(0),
        TAKE_DAMAGE(1),
        LEAVE_BED(2),
        EAT_FOOD(3),
        CRITICAL_EFFECT(4),
        MAGIC_CRITICAL_EFFECT(5);

        int type;

        AnimationType(int type){
            this.type = type;
        }

        public static AnimationType getByInt(int type){
            for(AnimationType an: values()){
                if(an.type == type){
                    return an;
                }
            }
            return null;
        }
    }


}
