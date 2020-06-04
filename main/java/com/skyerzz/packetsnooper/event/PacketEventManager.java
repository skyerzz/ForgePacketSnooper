package com.skyerzz.packetsnooper.event;

import com.skyerzz.packetsnooper.PacketEventHandler;
import com.skyerzz.packetsnooper.event.packet.PacketEvent;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class PacketEventManager {

    private static List<PacketListener> registered = new ArrayList<>();

    public static void register(PacketListener listener) {
        System.out.println("registering packetlistener" + listener.getClass().getSimpleName());
        if (!registered.contains(listener)) {
            registered.add(listener);
        }
    }

    public static void unregister(PacketListener listener) {
        System.out.println("unregistering packetlistener" + listener.getClass().getSimpleName());
        if (registered.contains(listener)) {
            registered.remove(listener);
        }
    }

    public static void callEvent(final PacketEvent event) {
        new Thread() {
            public void run() {
                call(event);
            }
        }.start();
    }

    private static void call(final PacketEvent event) {
        for (PacketListener listener : registered) {
            Method[] methods = listener.getClass().getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(PacketEventHandler.class)) {
                    if(event.getClass().equals(method.getParameterTypes()[0])) {
                        try {
                            method.invoke(listener, event);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
