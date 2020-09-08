package de.tk_industries.cdb.database.types.server;


import de.tk_industries.cdb.database.types.User;

import java.util.List;

/**
 * A role in a discord guild.
 */
public class Role {

    private List<User> members;
    private PermissionCollection myPermission;
}
