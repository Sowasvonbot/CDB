package de.tk_industries.cdb.database.file_system.file_based;

import de.tk_industries.cdb.database.file_system.Connector;
import de.tk_industries.cdb.database.types.User;
import de.tk_industries.cdb.database.types.server.Role;
import de.tk_industries.cdb.database.types.server.Server;
import de.tk_industries.cdb.database.types.server.channels.TextChannel;
import de.tk_industries.cdb.database.types.server.channels.VoiceChannel;

public class FileConnector implements Connector{


    @Override
    public User getUser() {
        return null;
    }

    @Override
    public Server getServer() {
        return null;
    }

    @Override
    public TextChannel getTextChannel() {
        return null;
    }

    @Override
    public VoiceChannel getVoiceChannel() {
        return null;
    }

    @Override
    public Role getRole() {
        return null;
    }

    @Override
    public boolean initConnection() {
        return false;
    }
}
