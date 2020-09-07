package de.tk_industries.cdb;

import de.tk_industries.cdb.database.types.server.PermissionCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {


    private static final Logger logger = LoggerFactory.getLogger("Main");

    public static void main(String[] args) {

        logger.info("Hello World");
        logger.info(PermissionCollection.getPermissionList().toString());

    }
}
