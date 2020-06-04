package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import net.minecraft.network.play.server.S3BPacketScoreboardObjective;
import net.minecraft.scoreboard.IScoreObjectiveCriteria;

public class S3BPacketScoreboardObjectiveEvent extends PacketEvent {

    S3BPacketScoreboardObjective packet;

    public S3BPacketScoreboardObjectiveEvent(S3BPacketScoreboardObjective o) {
        packet = o;
    }

    public String getObjectiveName(){
        return packet.func_149339_c();
    }

    public String getObjectiveValue(){
        return packet.func_149337_d();
    }

    public ScoreboardObjectiveMode getMode(){
        return ScoreboardObjectiveMode.getModeById(packet.func_149338_e());
    }

    public IScoreObjectiveCriteria.EnumRenderType getType(){
        return packet.func_179817_d();
    }

    public enum ScoreboardObjectiveMode{
        CREATE(0),
        REMOVE(1),
        UPDATE(2);

        private int id;

        ScoreboardObjectiveMode(int id) {
            this.id = id;
        }

        public static ScoreboardObjectiveMode getModeById(int id){
            for(ScoreboardObjectiveMode mode: values()){
                if(mode.id == id){
                    return mode;
                }
            }
            return null;
        }
    }
}
