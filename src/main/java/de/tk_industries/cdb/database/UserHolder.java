package de.tk_industries.cdb.database;

import de.tk_industries.cdb.Bot;
import de.tk_industries.cdb.database.types.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class UserHolder {

    private static UserHolder instance;

    private List<User> allUser;
    private final Logger logger = LoggerFactory.getLogger(getClass());




    private UserHolder(){
        allUser = new ArrayList<>();
    }

    public User getUserByID(long userID){
        for (User user: allUser) {
            if(user.getId() == userID) return user;
        }
        try{
            User user = Bot.getInstance().getUserByID(userID);
            if(user == null) throw new NullPointerException();
            allUser.add(user);
            return user;
        } catch (NullPointerException exception){
            logger.info("User with id {} does not exist",userID);
            return null;
        }
    }

    public long getUserCount(){
        return allUser.size();
    }


    public static UserHolder getInstance() {
        if (instance == null) instance = new UserHolder();
        return instance;
    }

}
