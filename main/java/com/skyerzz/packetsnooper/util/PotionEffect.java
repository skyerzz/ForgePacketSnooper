package com.skyerzz.packetsnooper.util;

public enum PotionEffect {
    SPEED(1),
    SLOWNESS(2),
    HASTE(3),
    MINING_FATIGUE(4),
    STRENGTH(5),
    INSTANT_HEALTH(6),
    INSTANT_DAMAGE(7),
    JUMP_BOOST(8),
    NAUSEA(9),
    REGENERATION(10),
    RESISTANCE(11),
    FIRE_RESISTANCE(12),
    WATER_BREATHING(13),
    INVISIBILITY(14),
    BLINDNESS(15),
    NIGHT_VISION(16),
    HUNGER(17),
    WEAKNESS(18),
    POISON(19),
    WITHER(20),
    HEALTH_BOOST(21),
    ABSORPTION(22),
    SATURATION(23),
    GLOWING(24),
    LEVITATION(25),
    LUCK(26),
    BAD_LUCK(27),
    SLOW_FALLING(28),
    CONDUIT_POWER(29),
    DOLPHIN_GRACE(30),
    BAD_OMEN(31),
    HERO_OF_THE_VILLAGE(32);

    private int id;
    private String displayName;

    PotionEffect(int id){
        this.id = id;
        this.displayName = SkyHelper.capitalizeSingleString(name());
    }

    public int getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static PotionEffect getById(int id){
        for(PotionEffect eff: values()){
            if(eff.id==id){
                return eff;
            }
        }
        return null;
    }
}
