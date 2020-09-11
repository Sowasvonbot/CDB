package de.tk_industries.cdb.database.file_system;

import de.tk_industries.cdb.database.types.*;
import de.tk_industries.cdb.database.types.server.Role;
import de.tk_industries.cdb.database.types.server.Server;
import de.tk_industries.cdb.database.types.server.channels.TextChannel;
import de.tk_industries.cdb.database.types.server.channels.VoiceChannel;

public interface Connector {


    User getUser();

    Server getServer();

    TextChannel getTextChannel();

    VoiceChannel getVoiceChannel();

    Role getRole();

    boolean initConnection();

}
