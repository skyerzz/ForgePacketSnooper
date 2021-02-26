package com.skyerzz.packetsnooper;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sky on 23-8-2019.
 */
public class InboundReader implements ChannelInboundHandler {


    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext c) {
        System.out.println("connected with packetReader - INBOUND");
        System.out.println(c.getClass());
        System.out.println(c.toString());
        c.fireChannelActive();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, final Object msg) throws Exception {
        printIfRequired(msg);
        //System.out.println("Reading channel - INBOUND: " + msg.getClass().getSimpleName());
        new Thread(new Runnable() {
            @Override
            public void run() {
                PacketSnooper.decode(msg);
            }
        }).start();
        ctx.fireChannelRead(msg);
    }

    private List<String> ignoreList = Arrays.asList(
            "S00PacketKeepAlive",
            "S03PacketTimeUpdate",
            "S18PacketEntityTeleport",
            "S21PacketChunkData",
            "S32PacketConfirmTransaction",
            "S3BPacketScoreboardObjective"
    );

    private void printIfRequired(Object msg) {
        switch (msg.getClass().getSimpleName()) {
            case "S00PacketKeepAlive":
            case "S03PacketTimeUpdate":
            case "S18PacketEntityTeleport":
            case "S21PacketChunkData":
            case "S23PacketBlockChange":
            case "S32PacketConfirmTransaction":
            case "S3BPacketScoreboardObjective":
            case "S35PacketUpdateTileEntity":
                return;
        }
        //System.out.println("INBOUND: " + msg.getClass().getSimpleName());
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

    }
}
