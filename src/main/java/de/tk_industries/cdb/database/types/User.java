package de.tk_industries.cdb.database.types;

import de.tk_industries.cdb.database.types.connections.Connection;
import de.tk_industries.cdb.database.types.server.Server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
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


    public User(String tag, Long id, Collection<Server> servers, Collection<Connection> connections) {
        this.tag = tag;
        this.id = id;
        this.servers = new ArrayList<>();
        this.connections = new LinkedList<>();

        if(servers != null) this.servers.addAll(servers);
        if(connections != null) this.connections.addAll(connections);
    }

    public String getTag() {
        return tag;
    }

    public long getId() {
        return id;
    }
}
