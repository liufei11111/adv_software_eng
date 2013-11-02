/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.forms;
import play.data.validation.Constraints.*;
/**
 *
 * @author intelWorX
 */
public class BuyStock {
    @Required(message = "no ticker supplied")
    public String ticker;
    @Required(message = "quantity was not supplied")
    @Min(value = 1)
    public int quantity;
    @Required(message = "Request error!")
    public double price;
    
}
