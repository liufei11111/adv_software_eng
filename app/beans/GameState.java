package beans;

import java.util.Date;
import java.util.List;

import models.data.Game;
import models.data.GamePlayer;
import models.data.PortfolioStock;

public class GameState {

    private int currentDay;
    private int numOfDays;
    private Game game;
    // list sorted by net worth
    private List<GamePlayer> players;
    private List<PortfolioStock> myPortfolio;
    private GamePlayer currentPlayer;
    private GamePlayer gameOwner;

    public int getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(int currentDay) {
        this.currentDay = currentDay;
    }

    public int getNumOfDays() {
        return numOfDays;
    }

    public void setNumOfDays(int numOfDays) {
        this.numOfDays = numOfDays;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public List<GamePlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<GamePlayer> players) {
        this.players = players;
    }

    public GamePlayer getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(GamePlayer currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public List<PortfolioStock> getMyPortfolio() {
        return myPortfolio;
    }

    public void setMyPortfolio(List<PortfolioStock> myPortfolio) {
        this.myPortfolio = myPortfolio;
    }

    public void setGameOwner(GamePlayer gameOwner) {
        this.gameOwner = gameOwner;
    }

    public GamePlayer getGameOwner() {
        return gameOwner;
    }
    
    
}
