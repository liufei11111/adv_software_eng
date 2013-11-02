/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.forms;

import models.data.User;
import play.data.validation.Constraints.*;

/**
 *
 * @author intelWorX
 */
public class LoginForm {

    @Required(message = "E-mail is required")
    @Email(message = "Invalid e-mail supplied")
    public String email;
    @Required(message = "Please specify a password")
    public String password;

    public String validate() {
        if (User.authenticate(email, password) == null) {
            return "Invalid user or password";
        }
        //handle the login process
        return null;
    }
}
