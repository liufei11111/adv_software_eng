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
public class UserForm {

    @Required(message = "E-mail is required")
    @Email(message = "Invalid e-mail supplied")
    public String email;

    public String validate() {
        User user = User.findByEmail(email);
        if (user == null) {
            //no such user
            return "user not found";
        }
        //handle the toggle user isEnabled process
        play.Logger.warn(""+user.getIsEnabled());
        
        
        if (user.getIsEnabled() == 1){
             play.Logger.warn("disable");
            user.setIsEnabled(0); 
        }
        else{
           user.setIsEnabled(1); 
        }
        user.save();
      
        return null;
    }
}
