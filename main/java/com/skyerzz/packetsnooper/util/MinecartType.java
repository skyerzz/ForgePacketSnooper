package com.skyerzz.packetsnooper.util;


public enum MinecartType {
    EMPTY_MINECART(0),
    CHEST_MINECART(1),
    FURNACE_MINECART(2),
    TNT_MINECART(3),
    SPAWNER_MINECART(4),
    HOPPER_MINECART(5),
    COMMAND_BLOCK_MINECART(6);

    private int id;

    MinecartType(int id){
        this.id = id;
    }

    public static MinecartType getVehicleTypeByID(int id){
        for(MinecartType type: values()){
            if(type.id == id) {
                return type;
            }
        }
        return null;
    }
}
