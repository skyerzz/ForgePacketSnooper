package com.skyerzz.packetsnooper.event.packet;

import com.skyerzz.packetsnooper.event.packet.PacketEvent;
import net.minecraft.network.play.server.S2BPacketChangeGameState;

public class S2BPacketChangeGameStateEvent extends PacketEvent {

    S2BPacketChangeGameState packet;

    public S2BPacketChangeGameStateEvent(S2BPacketChangeGameState o) {
        packet = o;
    }

    public GameState getState(){
        return GameState.getStateById(packet.getGameState());
    }

    public float getValue(){
        return packet.func_149137_d();
    }

    public enum GameState{
        INVALID_BED(0),
        END_RAINING(1),
        BEGIN_RAINING(2),
        CHANGE_GAME_MODE(3), //0: Survival, 1: creative, 2: adventure, 3: spectator
        ENTER_CREDITS(4),
        DEMO_MESSAGE(5), // 0: show welcome to demo screen, 101: tell movement controls, 102: tell jump control, 103: tell inventory control
        ARROW_HITTING_PLAYER(6),
        FADE_VALUE(7), //arg: current darkness value. 1 = Dark, 0 = Bright
        FADE_TIME(8), //arg: time in ticks for the sky to fade
        PLAY_MOB_APPEARANCE(10); //effect and sound played

        private int id;

        GameState(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public static GameState getStateById(int id){
            for(GameState state: values()){
                if(state.id == id){
                    return state;
                }
            }
            return null;
        }
    }
}
