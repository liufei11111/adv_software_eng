/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.forms;

import play.data.validation.Constraints;

/**
 *
 * @author intelWorX
 */
public class StockForm {
    
    @Constraints.Required(message = "Company Name is required")
    public String companyName;
  
    @Constraints.Required(message = "Ticker is required")
    public String ticker;


    @Constraints.Required(message = "Please specify wether the ticker is enabled")
    public Integer isEnabled = 0;
    
  
  
    public String validate() {
        //check  1 <= maxPlayers <= 8
        if (isEnabled != 0 && isEnabled != 1) {
            return "invalid isEnabled value";
          }

          
         if (companyName == null){
            return "invalid companyName"; 
         }
      
         if (ticker == null){
           //need to check if ticker is valid here
           return "invlaid ticker";
         }
        
        return null;
    }

}
