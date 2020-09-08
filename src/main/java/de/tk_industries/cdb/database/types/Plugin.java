package de.tk_industries.cdb.database.types;

import de.tk_industries.cdb.database.types.server.Server;

import java.net.URL;
import java.util.Map;

public class Plugin {


    private String name;
    private Map<Server, PluginData> servers;






    public class PluginData{

        private String configuration;
        private boolean active;

        private URL iconURL;


    }

}








