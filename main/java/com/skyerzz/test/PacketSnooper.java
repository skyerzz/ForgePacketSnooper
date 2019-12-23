package com.skyerzz.test;

import com.skyerzz.test.packets.MobSpawnHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.*;
import net.minecraft.stats.StatBase;
import net.minecraft.util.BlockPos;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by sky on 23-8-2019.
 * This snooper is a work in progress, more packets may be added on later times, and current packet readings may be expanded on.
 * Disclaimer: Not all packets may be recognized in the current state.
 */
public class PacketSnooper {
    //note wiki https://wiki.vg/index.php?title=Protocol&oldid=7368

    /**
     * Set a boolean to TRUE if you want to see those packets show up in the log
     */
    //s0_
    public static final boolean joinGame = false, spawnPosition=false, heldItemChange=false, chat=false, playerPosLook=false, timeUpdate=false, spawnMob=false, spawnObject=false, spawnPlayer=false;
    public static final boolean entityEquipment=false, animation=false, keepAlive=false, updateHealth=false, respawn=false, collectItem=false, useBed=false;

    //s1_ Entities
    public static final boolean relativeMove=false, entityTeleport=false, entityVelocity=false, entityAttach=false, entityLook=false, setExperience=false, destroyEntities=false;
    public static final boolean entityMetaData = false, entityEffect = false, entityHeadlook=false, entityLookMove=false, spawnExperienceOrb=false;

    //s2 Particles, Game state, Global EntitiesSpawn, windows, chat
    public static final boolean particles = false, changeGameState = false, setSlot=false, chunkData=false, entityProperties=false, blockAction=false, openWindow=false, closewindow=false;
    public static final boolean blockChange=false, soundEffect=false;

    //s3_
    public static final boolean confirmTransaction=false, statistics = false, playerAbilities = false, teams=false, displayScoreboard=false, windowItems=false, maps=false, signEditorOpen=false;
    public static final boolean scoreboardObjective = false, customPayload = false, playerListItem=false, updatescore=false, updateTileEntity=false, updateSign=false, entityStatus=false;

    //s4
    public static final boolean playerListHeaderFooter=false, title=false, camera=false;
    private PacketSnooper(){}

    public static void decode(Object o){
        switch(o.getClass().getSimpleName().toLowerCase()){
            //s0_
            case "s00packetkeepalive": handleKeepAlive(o); return;
            case "s01packetjoingame": handleJoinGame(o); return;
            case "s02packetchat": handleChat(o); return;
            case "s03packettimeupdate": handleTimeUpdate(o); return;
            case "s04packetentityequipment": handleEntityEquipment(o); return;
            case "s05packetspawnposition": handleSpawnPosition(o); return;
            case "s06packetupdatehealth": handleUpdateHealth(o); return;
            case "s07packetrespawn": handleRespawn(o); return;
            case "s08packetplayerposlook": handlePlayerPosLook(o); return;
            case "s09packethelditemchange": handleHeldItemChange(o); return;
            case "s0apacketusebed": handleUseBed(o); return;
            case "s0bpacketanimation": handleAnimation(o); return;
            case "s0cpacketspawnplayer":  handleSpawnPlayer(o); return;
            case "s0dpacketcollectitem": handleCollectItem(o); return;
            case "s0epacketspawnobject": handleSpawnObject(o); return;
            case "s0fpacketspawnmob": handleSpawnMob(o); return;
            //s1_
            case "s11packetspawnexperienceorb": handleSpawnExperienceOrb(o); return;
            case "s12packetentityvelocity": handleEntityVelocity(o); return;
            case "s13packetdestroyentities": handleDestroyEntities(o); return;
            case "s15packetentityrelmove": handleRelativeMovePacket(o); return;
            case "s16packetentitylook": handleEntityLook(o); return;
            case "s18packetentityteleport": handleEntityTeleport(o); return;
            case "s17packetentitylookmove": handleEntityLookMove(o); return;
            case "s19packetentityheadlook": handleEntityHeadLook(o); return;
            case "s19packetentitystatus": handleEntityStatus(o); return;
            case "s1bpacketentityattach": handleEntityAttach(o); return;
            case "s1cpacketentitymetadata": handleEntityMetaData(o); return;
            case "s1dpacketentityeffect": handleEntityEffect(o); return;
            case "s1fpacketsetexperience": handleSetExperience(o); return;
            //
            case "s20packetentityproperties": handleEntityProperties(o); return;
            case "s21packetchunkdata": handleChunkData(o); return;
            case "s23packetblockchange": handleBlockChange(o); return;
            case "s24packetblockaction": handleBlockAction(o); return;
            case "s29packetsoundeffect": handleSoundEffect(o); return;
            case "s2apacketparticles": handleParticlesPacket(o); return;
            case "s2bpacketchangegamestate":  handleChangeGameState(o); return;
            case "s2dpacketopenwindow": handleOpenWindow(o); return;
            case "s2epacketclosewindow": handleClosewindow(o); return;
            case "s2fpacketsetslot": handleSetSlot(o); return;
            //s3_
            case "s30packetwindowitems": handleWindowItems(o); return;
            case "s32packetconfirmtransaction": handleConfirmTransaction(o); return;
            case "s33packetupdatesign": handleUpdateSign(o); return;
            case "s34packetmaps": handleMaps(o); return;
            case "s35packetupdatetileentity": handleUpdateTileEntity(o); return;
            case "s36packetsigneditoropen": handleSignEditorOpen(o); return;
            case "s37packetstatistics": handleStatistics(o); return;
            case "s38packetplayerlistitem": handlePlayerListItem(o); return;
            case "s39packetplayerabilities": handlePlayerAbilities(o); return;
            case "s3bpacketscoreboardobjective": handleScoreboardObjective(o); return;
            case "s3cpacketupdatescore": handleUpdateScore(o); return;
            case "s3dpacketdisplayscoreboard": handleDisplayScoreboard(o); return;
            case "s3epacketteams": handleTeams(o); return;
            case "s3fpacketcustompayload": handleCustomPayload(o); return;
            //s4_
            case "s43packetcamera": handleCamera(o); return;
            case "s45packettitle": handleTitle(o); return;
            case "s47packetplayerlistheaderfooter": handlePlayerListHeaderFooter(o); return;


            default: System.out.println("Unknown packet code: " + o.getClass().getSimpleName());
        }
    }

    private static void handleUseBed(Object o) {
        if(!useBed){
            return;
        }
        S0APacketUseBed pkt = (S0APacketUseBed) o;
        System.out.println("S0APacketUseBed: BedLocation: " + SkyHelper.positionToString(pkt.getBedPosition()));
    }

    //s0_
    public static void handleKeepAlive(Object o){
        if(!keepAlive){
            return;
        }
        S00PacketKeepAlive pkt = (S00PacketKeepAlive) o;
        System.out.println("S00PacketKeepAlive: Id: " + pkt.func_149134_c());
    }

    public static void handleJoinGame(Object o){
        if(!joinGame){
            return;
        }
        S01PacketJoinGame pkt = (S01PacketJoinGame) o;
        Entity e = SkyHelper.getEntityById(pkt.getEntityId());
        System.out.println("S01PacketJoinGame: EntityID: " + pkt.getEntityId() + " belonging to entity: " + e.getName() + " (" + e.toString() + ")\n"
                + "Dimension: " + pkt.getDimension() + " Difficulty: " + pkt.getDifficulty() + " gameType: " + pkt.getGameType() + " maxPlayers: " + pkt.getMaxPlayers() +
                " Hardcore: " + pkt.isHardcoreMode() + " worldType: " + pkt.getWorldType() + " isReducedBugInfo: " + pkt.isReducedDebugInfo());
    }

    public static void handleChat(Object o){
        if(!chat){
            return;
        }
        S02PacketChat pkt = (S02PacketChat) o;
        System.out.println("S02PacketChat: Type: " + pkt.getType() + " Message(Unformatted): " + pkt.getChatComponent().getUnformattedText());
    }

    public static void handleTimeUpdate(Object o){
        if(!timeUpdate){
            return;
        }
        S03PacketTimeUpdate pkt = (S03PacketTimeUpdate) o;
        System.out.println("S03PacketTimeUpdate: WorldTime: " + pkt.getWorldTime() + " TotalWorldTime: " + pkt.getTotalWorldTime());
    }

    public static void handleEntityEquipment(Object o){
        if(!entityEquipment){
            return;
        }
        S04PacketEntityEquipment pkt = (S04PacketEntityEquipment) o;
        Entity e = SkyHelper.getEntityById(pkt.getEntityID());
        System.out.println("S04PacketEntityEquipment: ID: " + pkt.getEntityID() + " Entity: " + e.getName() + " (" + e.toString() + ")\nequipmentSlot: " + pkt.getEquipmentSlot() + " ItemStack: " + pkt.getItemStack() );
    }

    public static void handleSpawnPosition(Object o){
        if(!spawnPosition){
            return;
        }
        S05PacketSpawnPosition pkt = (S05PacketSpawnPosition) o;
        BlockPos pos = pkt.getSpawnPos();
        System.out.println("S05PacketSpawnPosition: [x,y,z]: [" + pos.getX() + ", " + pos.getY() + ", " + pos.getZ() + "]");
    }

    public static void handleUpdateHealth(Object o){
        if(!updateHealth){
            return;
        }
        S06PacketUpdateHealth pkt = (S06PacketUpdateHealth) o;
        System.out.println("S06PacketUpdateHealth: Health: " + pkt.getHealth() + " foodlevel: " + pkt.getFoodLevel() + " saturationLevel: " + pkt.getSaturationLevel());
    }

    public static void handleRespawn(Object o){
        if(!respawn){
            return;
        }
        S07PacketRespawn pkt = (S07PacketRespawn) o;
        System.out.println("S07PacketRespawn: DimensionID: " + pkt.getDimensionID() + " Difficulty: " + pkt.getDifficulty() + " gameType: " + pkt.getGameType() + " worldType: " + pkt.getWorldType());
    }

    public static void handlePlayerPosLook(Object o){
        if(!playerPosLook){
            return;
        }
        //todo fix that set https://wiki.vg/index.php?title=Protocol&oldid=7368#Player_Position_And_Look
        S08PacketPlayerPosLook pkt = (S08PacketPlayerPosLook) o;
        System.out.println("S08PacketPlayerPosLook: [X,Y,Z]: [" + pkt.getX() + ", " + pkt.getY() + ", " + pkt.getZ() + "] Yaw,Pitch: " + pkt.getYaw() + ", " + pkt.getPitch() + " Flags: " + pkt.func_179834_f().toString());
    }

    public static void handleHeldItemChange(Object o){
        if(!heldItemChange){
            return;
        }
        S09PacketHeldItemChange pkt = (S09PacketHeldItemChange) o;
        System.out.println("S09PacketHeldItemChange: held index: " + pkt.getHeldItemHotbarIndex());
    }

    public static void handleAnimation(Object o){
        if(!animation){
            return;
        }
        S0BPacketAnimation pkt = (S0BPacketAnimation) o;
        Entity e = SkyHelper.getEntityById(pkt.getEntityID());
        System.out.println("S0CPacketSpawnPlayer: ID: " + pkt.getEntityID() + " Entity: " + e.getName() + " (" + e.toString() + ")\n type: " + pkt.getAnimationType());
    }

    public static void handleSpawnPlayer(Object o){
        if(!spawnPlayer){
            return;
        }
        S0CPacketSpawnPlayer pkt = (S0CPacketSpawnPlayer) o;
        System.out.println("S0CPacketSpawnPlayer: ID: " + pkt.getEntityID() + " UUID: " + pkt.getPlayer() + " [x,y,z]: [" +
                pkt.getX() + ", " + pkt.getY() + ", " + pkt.getZ() + "] Yaw,Pitch: " + pkt.getYaw() + ", " + pkt.getPitch()  + " CurrentItem: " + pkt.getCurrentItemID() +"\nWatchables:");
        for(DataWatcher.WatchableObject w : pkt.func_148944_c()){
            System.out.println("WatchableObject: {dataValueID: " +w.getDataValueId() + ", objettype: " + w.getObjectType() + ", obj: ");
        }
        System.out.println("--End of watchables--");
    }

    public static void handleCollectItem(Object o){
        if(!collectItem){
            return;
        }
        S0DPacketCollectItem pkt = (S0DPacketCollectItem) o;
        System.out.println("S0DPacketCollectItem: collectedId: " + pkt.getCollectedItemEntityID() + " by entity id: " + pkt.getEntityID() );
    }

    public static void handleSpawnObject(Object o) {
        if (!spawnObject) {
            return;
        }
        //vehicles like minecarts and boats
        S0EPacketSpawnObject pkt = (S0EPacketSpawnObject) o;
        Entity e = SkyHelper.getEntityById(pkt.getEntityID());
        System.out.println("S0EPacketSpawnObject: ID: " + pkt.getEntityID() + " Entity: " + e.getName() + " (" + e.toString() + ")\n" + "Type: " + pkt.getType() + " [x,y,z]: [" +
                pkt.getX() + ", " + pkt.getY() + ", " + pkt.getZ() + "] Yaw,Pitch: " + pkt.getYaw() + ", " + pkt.getPitch() + " Vel[x,y,z]: [" + pkt.getSpeedX() + ", " + pkt.getSpeedY() +
                ", " + pkt.getSpeedZ() + "] Type Functionality: " + pkt.func_149009_m());
    }

    public static void handleSpawnMob(Object o){
        if(!spawnMob){
            return;
        }
        S0FPacketSpawnMob pkt = (S0FPacketSpawnMob) o;
        System.out.println(new MobSpawnHandler(pkt).toString());
    }

    //s1_
    public static void handleSpawnExperienceOrb(Object o){
        if(!spawnExperienceOrb){
            return;
        }
        S11PacketSpawnExperienceOrb pkt = (S11PacketSpawnExperienceOrb) o;
        System.out.println("S11PacketSpawnExperienceOrb: entityId: " + pkt.getEntityID() + " Pos[x,y,z]: [" + pkt.getX() + ", " + pkt.getY() + ", " + pkt.getZ() + "] xpValue: " + pkt.getXPValue());
    }

    public static void handleEntityVelocity(Object o){
        if(!entityVelocity){
            return;
        }
        S12PacketEntityVelocity pkt = (S12PacketEntityVelocity) o;
        Entity e = SkyHelper.getEntityById(pkt.getEntityID());
        System.out.println("S12PacketEntityVelocity: ID: " + pkt.getEntityID() + " Entity: " + e.getName() + " (" + e.toString() + ") Motion[x,y,z]: [" + pkt.getMotionX() + ", " + pkt.getMotionY() + ", " + pkt.getMotionZ() + "]" );
     }

    public static void handleDestroyEntities(Object o){
        if(!destroyEntities){
            return;
        }
        //todo get proper entities here too
        S13PacketDestroyEntities pkt = (S13PacketDestroyEntities) o;
        System.out.println("S13PacketDestroyEntities: IdList: " + Arrays.asList(pkt.getEntityIDs()));
    }

    public static void handleRelativeMovePacket(Object o){
        if(!relativeMove){
            return;
        }
        S14PacketEntity.S15PacketEntityRelMove pkt = (S14PacketEntity.S15PacketEntityRelMove) o;
        //s15PacketEntityRelMove updates the x,y,z position and the onGround status
        System.out.println("S15PacketEntityRelMove Updated " + pkt.getEntity(Minecraft.getMinecraft().thePlayer.getEntityWorld()).getCustomNameTag() + " to X,Y,Z: [" + pkt.func_149062_c() + ", " + pkt.func_149061_d() + ", " + pkt.func_149064_e() + "] OnGround:"+pkt.getOnGround());
    }

    public static void handleEntityLook(Object o){
        if(!entityLook){
            return;
        }
        S14PacketEntity.S16PacketEntityLook pkt = (S14PacketEntity.S16PacketEntityLook) o;
        System.out.println("S16PacketEntityLook: new Yaw,Pitch: " + pkt.func_149066_f() + ", " + pkt.func_149063_g()  + " field_149069_g??: " + pkt.func_149060_h() + " onGround: " + pkt.getOnGround());
    }

    public static void handleEntityLookMove(Object o){
        if(!entityLookMove){
            return;
        }
        S14PacketEntity.S17PacketEntityLookMove pkt = (S14PacketEntity.S17PacketEntityLookMove) o;
        Entity e = pkt.getEntity(Minecraft.getMinecraft().thePlayer.getEntityWorld());
        System.out.println("S17PacketEntityLookMove: ID: " + e.getEntityId() + " Entity: " + e.getName() + " (" + e.toString() + ")\n" +
                            " new[x,y,z] " + pkt.func_149062_c() +  ", " + pkt.func_149061_d() + ", " + pkt.func_149064_e() + "] " +
                            "new Yaw,Pitch: " + pkt.func_149066_f() + ", " + pkt.func_149063_g() + " onGround: " + pkt.getOnGround()  + " field_149069_g??: " + pkt.func_149060_h() );
    }

    public static void handleEntityTeleport(Object o){
        if(!entityTeleport){
            return;
        }
        S18PacketEntityTeleport pkt = (S18PacketEntityTeleport) o;
        Entity e = SkyHelper.getEntityById(pkt.getEntityId());
        System.out.println("S18PacketEntityTeleport: Entity " + pkt.getEntityId() + "\nName: " + e.getName() + " teleported to [" + pkt.getX() + ", " + pkt.getY() + ", " + pkt.getZ() + "] " +
                            "With Yaw,Pitch: " + pkt.getYaw() + "," + pkt.getPitch() + "\nOnground: " + pkt.getOnGround());
    }

    public static void handleEntityHeadLook(Object o){
        if(!entityHeadlook){
            return;
        }
        S19PacketEntityHeadLook pkt = (S19PacketEntityHeadLook) o;
        Entity e = pkt.getEntity(Minecraft.getMinecraft().thePlayer.getEntityWorld());
        System.out.println("S19PacketEntityHeadLook: ID: " + e.getEntityId() + " Entity: " + e.getName() + " (" + e.toString() + ") YawUpdate:" + pkt.getYaw() );
    }

    public static void handleEntityStatus(Object o){
        if(!entityStatus){
            return;
        }
        S19PacketEntityStatus pkt = (S19PacketEntityStatus) o;
        System.out.println("S19PacketEntityStatus: entityID: " + pkt.getEntity(Minecraft.getMinecraft().thePlayer.getEntityWorld()) + " logicOpCode: " + pkt.getOpCode());
    }

    public static void handleEntityAttach(Object o){
        if(!entityAttach){
            return;
        }
        S1BPacketEntityAttach pkt = (S1BPacketEntityAttach) o;
        Entity e = SkyHelper.getEntityById(pkt.getEntityId());
        Entity veh = SkyHelper.getEntityById(pkt.getVehicleEntityId());
        System.out.println("S1BPacketEntityAttach: ID: " + e.getEntityId() + " Entity: " + e.getName() + " (" + e.toString() + ") Leash:" + pkt.getLeash() + " VehicleID: " + pkt.getVehicleEntityId() + " Vehicle: " + veh.getName() + "(" + veh.toString() + ")");
    }

    public static void handleEntityMetaData(Object o){
        if(!entityMetaData){
            return;
        }
        S1CPacketEntityMetadata pkt = (S1CPacketEntityMetadata) o;
        Entity e = SkyHelper.getEntityById(pkt.getEntityId());
        System.out.println("S1CPacketEntityMetadata: Metadata for entity ID" + pkt.getEntityId() + "\nName: " + e.getName());
        for(DataWatcher.WatchableObject w : pkt.func_149376_c()){
            System.out.println("WatchableObject: {dataValueID: " +w.getDataValueId() + ", objettype: " + w.getObjectType() + ", obj: ");
        }
        System.out.println("--End of watchables--");
    }

    public static void handleEntityEffect(Object o){
        if(!entityEffect){
            return;
        }
        S1DPacketEntityEffect pkt = (S1DPacketEntityEffect) o;
        Entity e = SkyHelper.getEntityById(pkt.getEntityId());
        System.out.println("S1DPacketEntityEffect: EntityID: " + pkt.getEntityId() + " Entity: " + e.getName() + "("+ e.toString() + ") EffectID: " + pkt.getEffectId() + " amplifier: " + pkt.getAmplifier() +
                            " duration: " + pkt.getDuration() + " hideParticles: " + pkt.func_179707_f());
    }

    public static void handleSetExperience(Object o){
        if(!setExperience){
            return;
        }
        S1FPacketSetExperience pkt = (S1FPacketSetExperience) o;
        System.out.println("S1FPacketSetExperience: Bar: " + pkt.func_149397_c() + " level: " + pkt.getLevel() + " totalEXP: " + pkt.getTotalExperience());
    }

    //s2_
    public static void handleEntityProperties(Object o){
        if(!entityProperties){
            return;
        }
        S20PacketEntityProperties pkt = (S20PacketEntityProperties) o;
        Entity e = SkyHelper.getEntityById(pkt.getEntityId());
        System.out.println("S0FPacketSpawnMob: ID: " + pkt.getEntityId() + " Entity: " + e.getName() + " (" + e.toString() + ") Snapshots:");
        for(S20PacketEntityProperties.Snapshot s: pkt.func_149441_d()){
            System.out.println("Snap[ " + s.func_151409_a() + " - " + s.func_151410_b() + " AttributeModifiers: " + Arrays.toString(s.func_151408_c().toArray()));
        }
        System.out.println("--End of snapshots--");
    }

    public static void handleChunkData(Object o){
        if(!chunkData){
            return;
        }
        S21PacketChunkData pkt = (S21PacketChunkData) o;
        System.out.println("S21PacketChunkData: chunk X,Z: " + pkt.getChunkX() + ", " + pkt.getChunkZ() + " ExtractedData.data: " + Arrays.toString(pkt.func_149272_d()) + " GroundUpContinious: " + pkt.func_149274_i());
    }

    public static void handleBlockChange(Object o){
        if(!blockChange){
            return;
        }
        //todo better thing for blockstate later
        S23PacketBlockChange pkt = (S23PacketBlockChange) o;
        System.out.println("S23PacketBlockChange: Pos:" + SkyHelper.positionToString(pkt.getBlockPosition()) + " state: " + pkt.getBlockState().toString());
    }

    public static void handleBlockAction(Object o){
        if(!blockAction){
            return;
        }
        S24PacketBlockAction pkt = (S24PacketBlockAction) o;
        System.out.println("S24PacketBlockAction: Pos[x,y,z]: " + SkyHelper.positionToString(pkt.getBlockPosition()) + " instrument: " + pkt.getData1() + " Pitch: " + pkt.getData2() + " blockType: " + pkt.getBlockType());
    }

    public static void handleSoundEffect(Object o){
        if(!soundEffect){
            return;
        }
        S29PacketSoundEffect pkt = (S29PacketSoundEffect) o;
        System.out.println("S29PacketSoundEffect: Sound: " + pkt.getSoundName() + " Pos[x,y,z]: [" + pkt.getX() + ", " + pkt.getY() + ", " + pkt.getZ() + "] Volume: " + pkt.getVolume() + " Pitch: " + pkt.getPitch());
    }

    public static void handleParticlesPacket(Object o){
        if(!particles){
            return;
        }
        S2APacketParticles pkt = (S2APacketParticles) o;
        System.out.println("S2APacketParticles: Spawned particle " + pkt.getParticleType().name() + " at [" + pkt.getXCoordinate() + ", " + pkt.getYCoordinate() + ", " + pkt.getZCoordinate() + "] \noffset " +
                "[" + pkt.getXOffset() + ", " + pkt.getYOffset() + ", " + pkt.getZOffset() + "] \nspeed: " + pkt.getParticleSpeed() + "\ncount: " + pkt.getParticleCount()+ "\nisLongDistance: " + pkt.isLongDistance() +
                "\nArgs: " + Arrays.toString(pkt.getParticleArgs()));
    }

    public static void handleChangeGameState(Object o){
        if(!changeGameState){
            return;
        }
        //todo https://wiki.vg/index.php?title=Protocol&oldid=7368#Change_Game_State
        S2BPacketChangeGameState pkt = (S2BPacketChangeGameState) o;
        System.out.println("S2BPacketChangeGameState: state: " + pkt.getGameState() + " Value: " + pkt.func_149137_d());

    }

    public static void handleOpenWindow(Object o){
        if(!openWindow){
            return;
        }
        S2DPacketOpenWindow pkt = (S2DPacketOpenWindow) o;
        System.out.println("S2DPacketOpenWindow: id:" + pkt.getWindowId() + " Type(GuiId): " + pkt.getGuiId() + " title: " + pkt.getWindowTitle().getUnformattedText() + " slotcount: " + pkt.getSlotCount() + " entityID: " + pkt.getEntityId());
    }

    public static void handleClosewindow(Object o){
        if(!closewindow){
            return;
        }
        S2EPacketCloseWindow pkt = (S2EPacketCloseWindow) o;
        System.out.println("S2EPacketCloseWindow: id: <refraction needed, private field inaccessible>");
    }

    public static void handleSetSlot(Object o){
        if(!setSlot){
            return;
        }
        S2FPacketSetSlot pkt = (S2FPacketSetSlot) o;
        System.out.println("S2FPacketSetSlot: WindowID: " + pkt.func_149175_c() + " slot: " + pkt.func_149173_d() + " ItemStack: " + pkt.func_149174_e());
    }

    //s3_
    public static void handleWindowItems(Object o){
        if(!windowItems){
            return;
        }
        //todo itemstacks
        S30PacketWindowItems pkt = (S30PacketWindowItems) o;
        System.out.println("S30PacketWindowItems: windowID: " + pkt.func_148911_c() + " ItemStacks: " + Arrays.toString(pkt.getItemStacks()));
    }

    public static void handleConfirmTransaction(Object o){
        if(!confirmTransaction){
            return;
        }
        S32PacketConfirmTransaction pkt = (S32PacketConfirmTransaction) o;
        System.out.println("S32PacketConfirmTransaction: WindowID: " + pkt.getWindowId() + " Action Number: " + pkt.getActionNumber() + " Accepted: "+ pkt.func_148888_e());
    }

    public static void handleUpdateSign(Object o){
        if(!updateSign){
            return;
        }
        //todo probably do lines so they work? untested.
        S33PacketUpdateSign pkt = (S33PacketUpdateSign) o;
        BlockPos pos = pkt.getPos();
        System.out.println("S33PacketUpdateSign: blockPos[X,Y,Z]: [" + pos.getX() + ", " + pos.getY() + ", " + pos.getZ() + "] Lines: " + Arrays.toString(pkt.getLines()));
    }

    public static void handleMaps(Object o){
        if(!maps){
            return;
        }
        S34PacketMaps pkt = (S34PacketMaps) o;
        System.out.println("S34PacketMaps: id: " + pkt.getMapId() + " <Other info inaccessible without refraction> ");
    }

    public static void handleUpdateTileEntity(Object o){
        if(!updateTileEntity){
            return;
        }
        S35PacketUpdateTileEntity pkt = (S35PacketUpdateTileEntity) o;
        BlockPos pos = pkt.getPos();
        System.out.println("S35PacketUpdateTileEntity: blockPos[X,Y,Z]: [" + pos.getX() + ", " + pos.getY() + ", " + pos.getZ() + "] Metadata(Entity Type): " + pkt.getTileEntityType() + " NBTTagCompound: " + pkt.getNbtCompound().toString());
    }

    public static void handleSignEditorOpen(Object o){
        if(!signEditorOpen){
            return;
        }
        S36PacketSignEditorOpen pkt = (S36PacketSignEditorOpen) o;
        System.out.println("S36PacketSignEditorOpen: Pos:" + SkyHelper.positionToString(pkt.getSignPosition()));
    }

    public static void handleStatistics(Object o){
        if(!statistics){
            return;
        }
        S37PacketStatistics pkt = (S37PacketStatistics) o;
        Map<StatBase, Integer> map = pkt.func_148974_c();
        System.out.println("S37PacketStatistics: EntrySets:");
        for(Map.Entry<StatBase, Integer> e: map.entrySet()){
            System.out.print("{" +e.getKey() + ": " + e.getValue() + "} ");
        }
        System.out.println("--End of EntrySets--");
    }

    public static void handlePlayerListItem(Object o){
        if(!playerListItem){
            return;
        }
        //todo https://wiki.vg/index.php?title=Protocol&oldid=7368#Player_List_Item
        //PlayerListItem = tab list
        S38PacketPlayerListItem pkt = (S38PacketPlayerListItem) o;
        System.out.println("PS38PacketPlayerListItem: Action: " + pkt.func_179768_b().name() + " Players affected: " + Arrays.toString(pkt.func_179767_a().toArray()));
    }

    public static void handlePlayerAbilities(Object o){
        if(!playerAbilities){
            return;
        }
        S39PacketPlayerAbilities pkt = (S39PacketPlayerAbilities) o;
        System.out.println("S39PacketPlayerAbilities: invulnerable: " + pkt.isInvulnerable() + " Flying: " + pkt.isFlying() + " allowFlying: " + pkt.isAllowFlying() + " creative: " + pkt.isCreativeMode() +
                            " flyspeed: " + pkt.getFlySpeed() + " walkspeed: " + pkt.getWalkSpeed());
    }

    public static void handleScoreboardObjective(Object o){
        if(!scoreboardObjective){
            return;
        }
        S3BPacketScoreboardObjective pkt = (S3BPacketScoreboardObjective) o;
        System.out.println("S3BPacketScoreboardObjective: Name: " + pkt.func_149339_c() + "\nValue (Opt): " + pkt.func_149337_d() + "\nMode: " + pkt.func_149338_e() + "\nType (Opt): " + pkt.func_179817_d());
    }

    public static void handleUpdateScore(Object o){
        if(!updatescore){
            return;
        }
        S3CPacketUpdateScore pkt = (S3CPacketUpdateScore) o;
        System.out.println("S3CPacketUpdateScore: PlayerName: " + pkt.getPlayerName() + " ObjectiveName: " + pkt.getObjectiveName() + " Value: " + pkt.getScoreValue() + " Action: " + pkt.getScoreAction().name());
    }

    public static void handleDisplayScoreboard(Object o){
        if(!displayScoreboard){
            return;
        }
        S3DPacketDisplayScoreboard pkt = (S3DPacketDisplayScoreboard) o;
        System.out.println("S3DPacketDisplayScoreboard: Position: " + pkt.func_149371_c() + " TestLine: " + pkt.func_149370_d());
    }

    public static void handleTeams(Object o){
        if(!teams){
            return;
        }
        //todo https://wiki.vg/index.php?title=Protocol&oldid=7368#Teams make it better
        S3EPacketTeams pkt = (S3EPacketTeams) o;
        int mode = pkt.func_149307_h();
        System.out.println("S3EPacketTeams: Team name: " + pkt.func_149312_c() + " Mode: " + mode + " Team Display Name(Opt) " + pkt.func_149306_d() + " Prefix(Opt): " + pkt.func_149311_e() +
                            " Suffix(Opt): " + pkt.func_149309_f() + " Friendly Fire Bitmask)Opt): " + pkt.func_149308_i() + " Name Tag Visible: " + pkt.func_179814_i() +
                            "Color(Opt): " + pkt.func_179813_h() + " Player Count(Opt): " + pkt.func_149310_g().size() + " Players: {" + Arrays.toString(pkt.func_149310_g().toArray()) + "}" );

    }

    public static void handleCustomPayload(Object o){
        if(!customPayload){
            return;
        }
        S3FPacketCustomPayload pkt = (S3FPacketCustomPayload) o;
        System.out.println("S3FPacketCustomPayload: Channel: " + pkt.getChannelName() + "\nData: " + Arrays.toString(pkt.getBufferData().readByteArray()));
    }

    //s4
    public static void handleCamera(Object o){
        if(!camera){
            return;
        }
        S43PacketCamera pkt = (S43PacketCamera) o;
        System.out.println("S43PacketCamera: id: " + pkt.entityId);
    }

    public static void handleTitle(Object o){
        if(!title){
            return;
        }
        S45PacketTitle pkt = (S45PacketTitle) o;
        System.out.println("S45PackerTitle: Type: " + pkt.getType() + " Message(Unformatted): " + pkt.getMessage().getUnformattedText() + " FadeIn: " + pkt.getFadeInTime() + " display: " + pkt.getDisplayTime() + " FadeOut: " + pkt.getFadeOutTime());
    }

    public static void handlePlayerListHeaderFooter(Object o){
        if(!playerListHeaderFooter){
            return;
        }
        S47PacketPlayerListHeaderFooter pkt = (S47PacketPlayerListHeaderFooter) o;
        System.out.println("S47PacketPlayerListHeaderFooter: [Unformatted text]: Header: " + pkt.getHeader().getUnformattedText() + "\nFooter: " + pkt.getFooter().getUnformattedText());
    }
}
