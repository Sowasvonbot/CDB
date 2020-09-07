package de.tk_industries.cdb.database.types;

import de.tk_industries.cdb.database.types.connections.Connection;

import java.util.List;
import java.util.Map;

/**
 * A representation of all the valuable data for a discord user.
 */
public class User {

    private String tag;
    private Long id;
    private Map<Server, Permission> servers;

    //optional atm, may be null
    private List<Connection> connections;
}
