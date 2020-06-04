package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import net.minecraft.network.play.server.S3EPacketTeams;

import java.util.Collection;

public class S3EPacketTeamsEvent extends PacketEvent {

    S3EPacketTeams packet;

    public S3EPacketTeamsEvent(S3EPacketTeams o) {
        packet = o;
    }

    //todo https://wiki.vg/index.php?title=Protocol&oldid=7368#Teams make it better

    public String getTeamName(){
        return packet.func_149312_c();
    }

    /**
     * 0 = team create
     * 1 = team removed
     * 2 = team information update
     * 3 = new players added
     * 4 = players removed
     * @return
     */
    public int getMode(){
        return packet.func_149307_h();
    }

    //Below only if getMode() == 0 || 2

    public String getTeamDisplayName(){
        return packet.func_149306_d();
    }

    public String getTeamPrefix(){
        return packet.func_149311_e();
    }

    public String getTeamSuffix(){
        return packet.func_149309_f();
    }

    /**
     * 0 = off
     * 1 = on
     * 3 = see friendly invisibles
     * @return
     */
    public int getFriendlyFireSetting(){
        return packet.func_149308_i();
    }

    /**
     * always, hideForOtherTeams, hideForOwnTeam, never
     * @return
     */
    public String getNameTagVisibility(){
        return packet.func_179814_i();
    }

    public int getTeamColor(){
        return packet.func_179813_h();
    }

    //Below only if getMode() == 0 || 3 || 4

    public int getPlayerCount(){
        return packet.func_149310_g().size();
    }

    //todo see if this is UUID or name
    public Collection<String> getPlayers(){
        return packet.func_149310_g();
    }
}
