package com.skyerzz.packetsnooper;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

/**
 * This mod is purely for acedemic purposes of finding how packets are behaving. This is in no way a mod you should use on normal gameplay.
 */
@Mod(modid = TestMod.MODID, version = TestMod.VERSION)
public class TestMod
{
    public static final String MODID = "PacketSnooper";
    public static final String VERSION = "0.0.0";

    public static final boolean DisableOverride =false; //turns everything off if value is TRUE

    @EventHandler
    public void init(FMLInitializationEvent event){
        if(DisableOverride){
            return;
        }
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerConnect(FMLNetworkEvent.ClientConnectedToServerEvent event){
        System.out.println("Connected to server, inserting...");
        event.manager.channel().pipeline().addAfter("decoder", "snooper", new InboundReader());
    }



}
