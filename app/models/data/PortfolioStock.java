package models.data;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.data.validation.Constraints;
import play.db.ebean.Model;

/**
 * Game Player Portfolio entity bean.
 */
@Entity
@Table(name="PORTFOLIO_STOCK")
public class PortfolioStock extends Model  {

	private static final long serialVersionUID = 1L;
	
	@Id
    @Constraints.Required
    private Integer id;

    private Integer userId;

    private Integer gameId;

    private Integer quantity;

    private Timestamp virtualAddedOn;

    private Timestamp realAddedOn;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private GamePlayer player;

    @ManyToOne
    private Stock stock;



    /**
     * Return id.
     */    
    public Integer getId() {
  	    return id;
    }

    /**
     * Set id.
     */    
    public void setId(Integer id) {
  	    this.id = id;
    }

    /**
     * Return user id.
     */    
    public Integer getUserId() {
  	    return userId;
    }

    /**
     * Set user id.
     */    
    public void setUserId(Integer userId) {
  	    this.userId = userId;
    }

    /**
     * Return game id.
     */    
    public Integer getGameId() {
  	    return gameId;
    }

    /**
     * Set game id.
     */    
    public void setGameId(Integer gameId) {
  	    this.gameId = gameId;
    }

    /**
     * Return quantity.
     */    
    public Integer getQuantity() {
  	    return quantity;
    }

    /**
     * Set quantity.
     */    
    public void setQuantity(Integer quantity) {
  	    this.quantity = quantity;
    }

    /**
     * Return virtual added on.
     */    
    public Timestamp getVirtualAddedOn() {
  	    return virtualAddedOn;
    }

    /**
     * Set virtual added on.
     */    
    public void setVirtualAddedOn(Timestamp virtualAddedOn) {
  	    this.virtualAddedOn = virtualAddedOn;
    }

    /**
     * Return real added on.
     */    
    public Timestamp getRealAddedOn() {
  	    return realAddedOn;
    }

    /**
     * Set real added on.
     */    
    public void setRealAddedOn(Timestamp realAddedOn) {
  	    this.realAddedOn = realAddedOn;
    }

    /**
     * Return player.
     */    
    public GamePlayer getPlayer() {
  	    return player;
    }

    /**
     * Set player.
     */    
    public void setPlayer(GamePlayer player) {
  	    this.player = player;
    }

    /**
     * Return stock.
     */    
    public Stock getStock() {
  	    return stock;
    }

    /**
     * Set stock.
     */    
    public void setStock(Stock stock) {
  	    this.stock = stock;
    }

    public double getPurchasePrice(){
        
        return 0;
    }

}
