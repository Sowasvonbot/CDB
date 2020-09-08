package de.tk_industries.cdb.database.types.server.channels;

import de.tk_industries.cdb.database.types.server.PermissionCollection;
import de.tk_industries.cdb.database.types.server.Role;

import java.util.List;
import java.util.Map;

/**
 * Represents a channel in discord guild with all roles, which are able to see it, and the permission of them.
 */
public abstract class Channel {

    private long id;
    private String name;

    //Stores the role-specific permissions for this channel
    private Map<Role, PermissionCollection> visibleRoles;
}

