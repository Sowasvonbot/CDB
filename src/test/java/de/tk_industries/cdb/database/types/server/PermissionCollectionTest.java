package de.tk_industries.cdb.database.types.server;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class PermissionCollectionTest {

    List<PermissionCollection.Permission> allTrueIndices;
    PermissionCollection permissionCollection;


    @Before
    public void setupCollection(){
        permissionCollection = new PermissionCollection();
        allTrueIndices = new ArrayList<>();
        Random random = new Random();
        boolean temp;


        for(PermissionCollection.Permission permission : PermissionCollection.getPermissionList()){
            temp = random.nextBoolean();
            permissionCollection.setPermission(permission,temp);
            if(temp) allTrueIndices.add(permission);
        }
    }

    @Test
    public void testRandomPermissionCollection(){


        for(PermissionCollection.Permission permission : PermissionCollection.getPermissionList()){
            if(allTrueIndices.contains(permission))
                assertTrue(permissionCollection.getPermission(permission));
            else
                assertFalse(permissionCollection.getPermission(permission));
        }

    }

    @Test
    public void testToIntAndBack(){
        long test = permissionCollection.toLong();
        PermissionCollection newPermissionCollection = new PermissionCollection(test);
        assertEquals(permissionCollection,newPermissionCollection);

    }


}