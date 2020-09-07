package de.tk_industries.cdb.database.types;

import java.util.List;

/**
 * A representation of all the valuable data for a discord Server.
 * In Discord terminology it's called a guild.
 */
public class Server {

    private String serverName;
    private Long id;
    private List<User> users;

}
