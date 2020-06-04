package com.skyerzz.packetsnooper.event.packet;

import net.minecraft.network.play.server.S02PacketChat;
import net.minecraft.util.IChatComponent;

public class S02PacketChatEvent extends PacketEvent {

    S02PacketChat packet;

    public S02PacketChatEvent(S02PacketChat o) {
        this.packet = o;
    }

    public byte getType(){
        return packet.getType();
    }

    public boolean isChat(){
        return packet.isChat();
    }

    public IChatComponent getChatComponent(){
        return packet.getChatComponent();
    }

    public String getUnformattedText(){
        return getChatComponent().getUnformattedText();
    }

    public String getFormattedText(){
        return getChatComponent().getFormattedText();
    }

}
