package de.tk_industries.cdb.database.types.server;

import java.util.*;

/**
 * Represents all possible permission in a discord server/guild.
 * Purpose is to use it in combination with a text channel, discord user, server role etc.
 */
public class PermissionCollection {


    private Map<Permission,Boolean> myPermissions;

    /**
     * Returns an "empty" permission collection.
     * Empty means, all permissions are in the map, but set to false
     */
    public PermissionCollection(){
            myPermissions = new HashMap<>();

            //Fill the permission map
            for(Permission permission : Permission.values()) myPermissions.put(permission,false);


    }

    /**
     * Constructs a permission collection from a permission long, when the calcLong is invalid, some not predictable will happen.
     * Use the {@link #toLong() toLong} or {@link #permissionCollectionToLong(PermissionCollection) permissionCollectionToLong} method
     * for getting a calcLong.
     * @param calcLong from the methods mentioned above calculated long
     */
    public PermissionCollection(long calcLong){
        this();
        long temp;
        for (int i = Permission.values().length-1; i >= 0 ; i--) {
            temp = Math.round(Math.pow(2,i));
            if (temp <= calcLong) {
                calcLong = calcLong - temp;
                this.setPermission(Permission.values()[i], true);
            }
            //No need to set to false with else block, cause all are false per default.
        }
    }

    /**
     * Set the boolean of a given permission
     * @param permission enum of the permission
     * @return true if successful, false otherwise
     */
    public boolean setPermission(Permission permission, Boolean value){
        return myPermissions.replace(permission, value) != null;
    }

    /**
     * Get the boolean of a given permission
     * @param permission enum of the permission
     * @return the value of the given permission
     */
    public boolean getPermission(Permission permission){
        return  myPermissions.get(permission);
    }


    /**
     * Represents this Permission Collection as Long
     * @return long, one number, which can be recalculated to a {@link PermissionCollection PermissionCollection}
     */
    public long toLong(){
        return PermissionCollection.permissionCollectionToLong(this);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof PermissionCollection)) return false;

        for(Permission permission : Permission.values()){
            if(this.getPermission(permission)!=((PermissionCollection) obj).getPermission(permission)) return false;
        }
        return true;
    }

    /**
     * Returns a list of all possible Permissions in the discord universe
     * @return the List with all permissions as enums
     */
    public static List<Permission> getPermissionList(){
        return Arrays.asList(Permission.values());
    }


    /**
     * Represents a given Permission Collection as Long
     * @param permissionCollection the Permission Collection to represent
     * @return long, one number, which can be recalculated to a {@link PermissionCollection PermissionCollection}
     */
    public static long permissionCollectionToLong(PermissionCollection permissionCollection){
        long result = 0;
        for(int i = 0; i < Permission.values().length; i++){
            result = result + (permissionCollection.getPermission(Permission.values()[i]) ? 1:0) * Math.round(Math.pow(2,i));
        }
        return result;
    }


    /**
     * All possible Permissions.
     */
    protected enum Permission{
        CREATE_INSTANT_INVITE, KICK_MEMBERS, BAN_MEMBERS, ADMINISTRATOR, MANAGE_CHANNELS, MANAGE_GUILD, ADD_REACTIONS,
        VIEW_AUDIT_LOG, PRIORITY_SPEAKER, STREAM, VIEW_CHANNEL, SEND_MESSAGES, SEND_TTS_MESSAGES, MANAGE_MESSAGES,
        EMBED_LINKS, ATTACH_FILES, READ_MESSAGE_HISTORY, MENTION_EVERYONE, USE_EXTERNAL_EMOJIS, VIEW_GUILD_INSIGHTS,
        CONNECT, SPEAK, MUTE_MEMBERS, DEAFEN_MEMBERS, MOVE_MEMBERS, USE_VAD, CHANGE_NICKNAME, MANAGE_NICKNAMES,MANAGE_ROLES,
        MANAGE_WEBHOOKS, MANAGE_EMOJIS
    }
}
