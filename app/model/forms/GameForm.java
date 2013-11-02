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
public class GameForm {
    
    
    @Constraints.Required(message = "Please enter the title of Game")
    public String gameTitle;

    @Constraints.Required(message = "Please enter max number of player")
    @Constraints.Min(value = 2, message = "At least two players")
    public Integer maxPlayers;

    @Constraints.Required(message = "Game length is required")
    public Integer gameLength; //game length in days
  
    @Constraints.Required(message = "Please enter open balance for the game")
    public Double openBalance;

    public String validate() {
        //check  1 <= maxPlayers <= 8
         if (maxPlayers < 2 || maxPlayers > 8) {
            return "Only support 1 to 8 players";
          }
        
         //if (gameLength % 7 != 0 || gameLength < 0){
         if (gameLength < 0){
            return "Invalid game length"; 
         }
      
         if (openBalance < 100){
           return "Open balance has to be bigger than $100";
         }
          
        return null;
    }

}
