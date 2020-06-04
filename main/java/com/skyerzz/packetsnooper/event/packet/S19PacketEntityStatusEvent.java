package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.network.play.server.S19PacketEntityStatus;

public class S19PacketEntityStatusEvent extends PacketEvent {


    S19PacketEntityStatus packet;

    public S19PacketEntityStatusEvent(S19PacketEntityStatus o) {
        packet = o;
    }

    //todo entityID using reflection

    public Entity getEntity(){
        return packet.getEntity(Minecraft.getMinecraft().thePlayer.getEntityWorld());
    }

    public OpCode getOpCode(){
        if(packet.getOpCode() == 10 && (getEntity() instanceof EntityTNTPrimed)){
            return OpCode.PLAY_TNT_IGNITE_SOUND;
        }
        return OpCode.getOpCodeById(packet.getOpCode());
    }


    /**
     * https://wiki.vg/index.php?title=Protocol&oldid=7368#Entity_Status
     */
    public enum OpCode{
        RESET_MINECART_TIMER(1), //also used for Rabbit Jump animation?
        LIVING_ENTITY_HURT(2),
        LIVING_ENTITY_DEAD(3),
        GOLEM_THROW_ARM(4),
        WOLF_OCELOT_HORSE_TAMING_HEARTS(6),
        WOLF_OCELOT_HORSE_TAMED_SMOKE(7),
        WOLF_SHAKE_WATER(8),
        EATING_ACCEPTED_BY_SERVER(9), //your eating was accepted
        SHEEP_EATING_GRASS(10), //for Sheep
        PLAY_TNT_IGNITE_SOUND(10), // for TNT
        IRON_GOLEM_HAND_ROSE(11),
        VILLAGER_MATING_HEARTS(12),
        SPAWN_PARTICLE_ANGRY_VILLAGER(13),
        SPAWN_HAPPY_VILLAGER_PARTICLE(14),
        WITCH_ANIMATION_MAGIC_PARTICLE(15),
        ZOMBIE_CONVERTING_VILLAGER_SOUND(16),
        FIREWORK_EXPLODE(17),
        ANIMAL_IN_LOVE_HEART_PARTICLE(18),
        RESET_SQUID_ROTATION(19),
        SPAWN_EXPLOSION_PARTICLE(20), //only works for some living entities
        PLAY_GUARDIAN_SOUND(21), //only works on guardians
        ENABLE_REDUCED_DEBUG(22),
        DISABLE_REDUCED_DEBUG(23);

        private int code;

        OpCode(int code){
            this.code = code;
        }

        public static OpCode getOpCodeById(int id){
            for(OpCode code: values()){
                if(code.code == id){
                    return code;
                }
            }
            return null;
        }
    }
}
