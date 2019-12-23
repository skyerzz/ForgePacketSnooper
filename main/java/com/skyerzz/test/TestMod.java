package com.skyerzz.test;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Mod(modid = TestMod.MODID, version = TestMod.VERSION)
/**
 * This mod is purely for acedemic purposes of finding how packets are behaving. This is in no way a mod you should use on normal gameplay.
 */
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

}
