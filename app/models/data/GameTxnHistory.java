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
 * Game Txn History entity bean.
 */
@Entity
@Table(name = "GAME_TXN_HISTORY")
public class GameTxnHistory extends Model {

    private static final long serialVersionUID = 1L;

    @Id
    @Constraints.Required
    private Integer id;

    private String transactionType;

    private String stockTicker;

    private Integer volume;

    private Double amountPaid;

    private Timestamp virtualDate;

    private Timestamp realDate;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private GamePlayer player;

    @ManyToOne
    private Game game;

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
     * Return transaction type.
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * Set transaction type.
     */
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * Return stock ticker.
     */
    public String getStockTicker() {
        return stockTicker;
    }

    /**
     * Set stock ticker.
     */
    public void setStockTicker(String stockTicker) {
        this.stockTicker = stockTicker;
    }

    /**
     * Return volume.
     */
    public Integer getVolume() {
        return volume;
    }

    /**
     * Set volume.
     */
    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    /**
     * Return amount paid.
     */
    public Double getAmountPaid() {
        return amountPaid;
    }

    /**
     * Set amount paid.
     */
    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    /**
     * Return virtual date.
     */
    public Timestamp getVirtualDate() {
        return virtualDate;
    }

    /**
     * Set virtual date.
     */
    public void setVirtualDate(Timestamp virtualDate) {
        this.virtualDate = virtualDate;
    }

    /**
     * Return real date.
     */
    public Timestamp getRealDate() {
        return realDate;
    }

    /**
     * Set real date.
     */
    public void setRealDate(Timestamp realDate) {
        this.realDate = realDate;
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
     * Return game.
     */
    public Game getGame() {
        return game;
    }

    /**
     * Set game.
     */
    public void setGame(Game game) {
        this.game = game;
    }

}
