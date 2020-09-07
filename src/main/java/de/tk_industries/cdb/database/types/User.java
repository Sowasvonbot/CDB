package de.tk_industries.cdb.database.types;

import de.tk_industries.cdb.database.types.connections.Connection;
import de.tk_industries.cdb.database.types.server.Server;

import java.util.List;

/**
 * A representation of all the valuable data for a discord user.
 */
public class User {

    private String tag;
    private Long id;
    private List<Server> servers;

    //optional atm, may be null
    private List<Connection> connections;
}
