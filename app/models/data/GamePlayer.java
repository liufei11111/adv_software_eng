package models.data;

import com.avaje.ebean.Ebean;
import java.io.IOException;
import util.TimeKeeper;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import managers.GameManager;
import play.db.ebean.Model;

/**
 * Game Player entity bean.
 */
@Entity
@Table(name = "game_player")
public class GamePlayer extends Model implements Comparable<GamePlayer> {

    @Id
    Integer id;

    Double currentBalance;

    Timestamp joinedAt;

    @ManyToOne
    @JoinColumn(name = "game_id")
    Game game;

    @ManyToOne
    Player user;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "player_id")
    List<GameTxnHistory> histories;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "player_id")
    List<PortfolioStock> portfolios;

    /**
     * buy stock.
     *
     * @param ticker
     * @param quantity
     * @param quotedPrice
     * @return -1 if not possible quantity if successful(check >0 to see if
     * successful)
     *
     */
    public boolean buyStock(String ticker, int quantity, double quotedPrice) {
        //find stock
        Stock stock = Stock.find.where().eq("ticker", ticker).findUnique();
        //return false if not found
        if (stock == null) {
            return false;
        }

        Timestamp currentGameDate = TimeKeeper.round_to_day(game.getVirtualCurrentDate());
        StockPrice currentStockPrice;
        try {
            //get current stock price
            currentStockPrice = (new GameManager()).getStockPrice(ticker, currentGameDate);
            if (currentStockPrice == null) {
                return false;
            }
        } catch (IOException ex) {
            play.Logger.warn("could not retrieve stock Price\n", ex);
            return false;
        }

        //check to see that quoted price tallies with allowable
        double unitPrice = currentStockPrice.isValidQuotedPrice(quotedPrice) ? quotedPrice
                : currentStockPrice.getStockPrice();

        //cost
        double cost = unitPrice * quantity;

        //broke Ass
        if (currentBalance < cost) {
            return false;
        }

        PortfolioStock toAdd = findPortfolio(ticker);

        if (toAdd == null) {
            toAdd = new PortfolioStock();
            toAdd.setGameId(game.getId());
            toAdd.setPlayer(this);
            toAdd.setQuantity(quantity);
            toAdd.setRealAddedOn(new Timestamp(System.currentTimeMillis()));
            toAdd.setVirtualAddedOn(game.getVirtualCurrentDate());
            toAdd.setStock(stock);
            toAdd.setUserId(user.getId());
            portfolios.add(toAdd);
        } else {
            toAdd.setQuantity(toAdd.getQuantity() + quantity);
        }

        // history
        GameTxnHistory newEntry = new GameTxnHistory();
        newEntry.setAmountPaid(cost);
        newEntry.setGame(game);
        newEntry.setPlayer(this);
        newEntry.setRealDate(new Timestamp(System.currentTimeMillis()));
        newEntry.setVirtualDate(game.getVirtualCurrentDate());
        newEntry.setStockTicker(ticker);
        newEntry.setVolume(quantity);
        newEntry.setTransactionType("buy");
        histories.add(newEntry);
        setCurrentBalance(currentBalance - cost);
        save();
        Ebean.save(portfolios);
        Ebean.save(histories);
        return true;

    }

    /**
     * sell stock.
     *
     * @param ticker
     * @param quantity
     * @param quotedPrice
     * @return -1 if not possible quantity if successful(check >0 to see if
     * successful)
     *
     */
    public boolean sellStock(String ticker, int quantity, double quotedPrice) {
        Stock stock = Stock.find.where().eq("ticker", ticker).findUnique();
        if (stock == null) {
            return false;
        }

        PortfolioStock toSellFrom = findPortfolio(ticker);
        if (toSellFrom == null) {
            return false;
        }

        if (quantity > toSellFrom.getQuantity()) {
            return false;
        }

        StockPrice currentStockPrice;
        try {
            currentStockPrice = (new GameManager()).getStockPrice(ticker, game.getVirtualCurrentDate());
            if (currentStockPrice == null) {
                return false;
            }
        } catch (IOException ex) {
            play.Logger.warn("Could not sell stock... ", ex);
            return false;
        }

        double unitPrice = currentStockPrice.isValidQuotedPrice(quotedPrice) ? quotedPrice : currentStockPrice.getStockPrice();

        double cost = quantity * unitPrice;
        toSellFrom.setQuantity(toSellFrom.getQuantity() - quantity);
        //if quantity is now less than 1
        if (toSellFrom.getQuantity() < 1) {
            portfolios.remove(toSellFrom);
            toSellFrom.delete();
        }
        //update account
        currentBalance += cost;
        GameTxnHistory newEntry = new GameTxnHistory();
        // time
        // history
        newEntry.setAmountPaid(cost);
        newEntry.setGame(game);
        newEntry.setPlayer(this);
        newEntry.setRealDate(util.GameUtil.getCurrentTimeStamp());
        newEntry.setVirtualDate(game.getVirtualCurrentDate());
        newEntry.setStockTicker(ticker);
        newEntry.setVolume(quantity);
        newEntry.setTransactionType("sell");
        histories.add(newEntry);

        save();
        Ebean.save(histories);
        Ebean.save(portfolios);
        return true;
    }

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
     * Return current balance.
     */
    public Double getCurrentBalance() {
        return currentBalance;
    }

    /**
     * Set current balance.
     */
    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }

    /**
     * Return joined at.
     */
    public Timestamp getJoinedAt() {
        return joinedAt;
    }

    /**
     * Set joined at.
     */
    public void setJoinedAt(Timestamp joinedAt) {
        this.joinedAt = joinedAt;
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

    /**
     * Return user.
     */
    public Player getUser() {
        return user;
    }

    /**
     * Set user.
     */
    public void setUser(Player user) {
        this.user = user;
    }

    /**
     * Return historys.
     */
    public List<GameTxnHistory> getHistorys() {
        return histories;
    }

    /**
     * Set historys.
     */
    public void setHistorys(List<GameTxnHistory> histories) {
        this.histories = histories;
    }

    /**
     * Return portfolios.
     */
    public List<PortfolioStock> getPortfolios() {
        return portfolios;
    }

    /**
     * Set portfolios.
     */
    public void setPortfolios(List<PortfolioStock> portfolios) {
        this.portfolios = portfolios;
    }

    /**
     * Computes player's net worth in a game.
     *
     * @return
     */
    public double getNetWorth() {
        double totalPortfolio = 0;
        // calculates portfolio value
        Timestamp referenceDate = game.isEnded() ? TimeKeeper.getLastTradingDay(game)
                : game.getVirtualCurrentDate();
        GameManager gm = new GameManager();
        for (PortfolioStock portfolioStock : portfolios) {
            int quantity = portfolioStock.getQuantity();

            StockPrice stockPrice;
            double stockPriceAmount = 0;
            try {
                stockPrice = gm.getStockPrice(portfolioStock.getStock().getTicker(), referenceDate);
                stockPriceAmount = game.isEnded()
                        ? stockPrice.getClose()
                        : stockPrice.getStockPrice();
            } catch (IOException ex) {
                play.Logger.warn("Could not get stock price: ", ex);
            }

            totalPortfolio += (stockPriceAmount * quantity);
        }

        return totalPortfolio + getCurrentBalance();
    }

    public int compareTo(GamePlayer o) {
        if (getNetWorth() > o.getNetWorth()) {
            return 1;
        } else if (getNetWorth() < o.getNetWorth()) {
            return -1;
        } else {
            // enforce transitivity!, just compare with their IDs
            return id.compareTo(o.id);
        }
    }

    public PortfolioStock findPortfolio(String ticker) {
        for (PortfolioStock portfolioStock : portfolios) {
            if (portfolioStock.getStock().getTicker().equalsIgnoreCase(ticker)) {
                return portfolioStock;
            }
        }
        return null;
    }

}
