package de.tk_industries.cdb.database.file_system;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.Set;

public class AccessPoint {







    private Set<Class<? extends Connector>> findSubclassesOfConnector(){
        Reflections reflections = new Reflections("de.tk_industries.cdb.database.file_system.sql", new SubTypesScanner(false));
        return reflections.getSubTypesOf(Connector.class);

    }
}
