/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.forms;

import models.data.Player;
import models.data.User;
import play.data.validation.Constraints;
import constants.ApplicationConstants;

/**
 *
 * @author intelWorX
 */
public class RegisterForm {

    @Constraints.Required(message = "Please entern your first name")
    public String firstName;

    @Constraints.Required(message = "Please entern your last name")
    public String lastName;

    @Constraints.Required(message = "E-mail is required")
    @Constraints.Email(message = "Invalid e-mail supplied")
    public String email;
    @Constraints.Required(message = "Please specify a password")
    @Constraints.MinLength(6)
    public String password;

    public String password2;

    public int isEnabled;

    public String validate() {
        if (!password.equals(password2)) {
            return ApplicationConstants.PASSWORD_MISMATCH;
        }

        User user = User.findByEmail(email);
        if (user != null) {
            return ApplicationConstants.USER_ALREADY_REGISTERED;
        }

        //do registration
        user = new Player();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setIsEnabled(ApplicationConstants.TRUE);
        user.save();

        return null;
    }

}
