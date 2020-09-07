package de.tk_industries.cdb.database.types.server;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class PermissionCollectionTest {


    @Test
    public void testRandomPermissionCollection(){
        PermissionCollection permissionCollection = new PermissionCollection();
        Random random = new Random();
        boolean temp;
        List<PermissionCollection.Permission> allTrueIndices = new ArrayList<>();

        for(PermissionCollection.Permission permission : PermissionCollection.getPermissionList()){
            temp = random.nextBoolean();
            permissionCollection.setPermission(permission,temp);
            if(temp) allTrueIndices.add(permission);
        }

        for(PermissionCollection.Permission permission : PermissionCollection.getPermissionList()){
            if(allTrueIndices.contains(permission))
                assertTrue(permissionCollection.getPermission(permission));
            else
                assertFalse(permissionCollection.getPermission(permission));
        }

    }

}