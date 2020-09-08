package de.tk_industries.cdb.database;

import de.tk_industries.cdb.database.types.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserHolderTest {

    UserHolder userHolder;


    @Before
    public void setUp() throws Exception {
        userHolder = UserHolder.getInstance();

    }

    @Test
    public void singleNameTest(){
        User user = userHolder.getUserByID(673950824287830047L);
        user = userHolder.getUserByID(296297160884879370L);

        assertEquals("Sowasvonbaf#8906",user.getTag());

        user = userHolder.getUserByID(673950824287830047L);

        assertEquals(2,userHolder.getUserCount());
        assertEquals("TobisTollerTestBot#0174",user.getTag());
    }

    @After
    public void tearDown() throws Exception {
    }
}