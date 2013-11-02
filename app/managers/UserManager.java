package managers;

import java.util.List;

import models.data.User;
import play.mvc.Controller;
import constants.ApplicationConstants;

public class UserManager {

    public static User getCurrentLoggedInUser() {
        String email = Controller.session(ApplicationConstants.USER);
        return User.findByEmail(email);
    }

    public static boolean isLoggedIn(){
        return Controller.session(ApplicationConstants.USER) != null;
    }
  
    /**
     * Returns a list of Users that is in the system
     *
     * @return
     */
    public static List<User> getUserList() {
        return User.find.all();
    }
}
