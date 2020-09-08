package de.tk_industries.cdb;

import de.tk_industries.cdb.database.types.User;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Bot {

    private static Bot instance;
    private JDA myJDA;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private Bot(){
        String token = receiveToken();
        try {
            myJDA = JDABuilder.createDefault(token).build().awaitReady();
        } catch (LoginException | InterruptedException e) {
            logger.error("The given token {} was invalid",token);
            System.exit(1);
        }
    }

    private String receiveToken(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("token"));
            return reader.readLine();
        } catch (IOException e){
            return "file not found";
        }
    }


    public User getUserByID(long userID)  {
        net.dv8tion.jda.api.entities.User tempUser = myJDA.retrieveUserById(userID).complete();
        if (tempUser == null) throw new NullPointerException("User with ID: " + userID + " does not exist");
        return new User(tempUser.getAsTag(),tempUser.getIdLong(),null,null);
    }






    /**
     * classic Singleton Function
     * @return The instance, where all JDA Functions will run through
     */
    public static Bot getInstance() {
        if(instance == null) instance = new Bot();
        return instance;
    }
}
