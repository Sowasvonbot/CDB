package de.tk_industries.cdb.database.types.server;

import de.tk_industries.cdb.database.types.User;
import de.tk_industries.cdb.database.types.UserServerData;
import de.tk_industries.cdb.database.types.server.channels.TextChannel;
import de.tk_industries.cdb.database.types.server.channels.VoiceChannel;

import java.util.List;
import java.util.Map;

/**
 * A representation of all the valuable data for a discord Server.
 * In Discord terminology it's called a guild.
 */
public class Server {

    private String serverName;
    private Long id;

    private List<User> users;
    private List<Role> roles;
    private List<TextChannel> textChannels;
    private List<VoiceChannel> voiceChannels;

}
