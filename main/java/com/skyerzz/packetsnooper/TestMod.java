package com.skyerzz.packetsnooper;

import com.skyerzz.packetsnooper.command.ListItemsInHand;
import com.skyerzz.sbs.SBS;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

/**
 * This mod is purely for academic purposes of finding how packets are behaving. This is in no way a mod you should use on normal gameplay.
 */
@Mod(modid = TestMod.MODID, version = TestMod.VERSION)
public class TestMod {
    public static final String MODID = "packetsnooper";
    public static final String VERSION = "0.0.1";

    public static final boolean DisableOverride = false; //turns everything off if value is TRUE

    @EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("Init?");
        if (DisableOverride) {
            return;
        }
        System.out.println("INIT!");
        MinecraftForge.EVENT_BUS.register(this);
        ClientCommandHandler.instance.registerCommand(new ListItemsInHand());
        //MinecraftForge.EVENT_BUS.register(new SBS());

    }

    @SubscribeEvent
    public void onServerConnect(FMLNetworkEvent.ClientConnectedToServerEvent event) {
        System.out.println("Connected to server, inserting...");
        event.manager.channel().pipeline().addAfter("decoder", "snooper", new InboundReader());
        event.manager.channel().pipeline().addAfter("encoder", "outsnooper", new PacketOutputReader());
        event.manager.channel().pipeline().forEach((line) -> {
            System.out.println(line.getKey()  + "::" + line.getValue());
        });
    }


}
