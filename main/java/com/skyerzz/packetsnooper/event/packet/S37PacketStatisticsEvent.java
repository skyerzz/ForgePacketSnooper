package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import net.minecraft.network.play.server.S37PacketStatistics;
import net.minecraft.stats.StatBase;

import java.util.Map;

public class S37PacketStatisticsEvent extends PacketEvent {


    S37PacketStatistics packet;

    public S37PacketStatisticsEvent(S37PacketStatistics o) {
        packet = o;
    }

    public Map<StatBase, Integer> getStatisticMap(){
        return packet.func_148974_c();
    }
}
