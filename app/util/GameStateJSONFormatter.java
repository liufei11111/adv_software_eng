/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import beans.GameState;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import managers.GameManager;
import models.data.GamePlayer;
import models.data.PortfolioStock;
import models.data.StockPrice;
import play.libs.Json;

/**
 *
 * @author intelWorX
 */
public class GameStateJSONFormatter {

    private GameState gameState;

    public GameStateJSONFormatter(GameState gameState) {
        this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public ObjectNode getJSON() {
        ObjectNode gmState = Json.newObject();
        gmState.put("id", gameState.getGame().getId());
        gmState.put("title", gameState.getGame().getGameTitle());
        gmState.put("gameLength", gameState.getGame().getGameLength());
        gmState.put("owner", getOwnerPlayer());
        gmState.put("players", getPlayers());
        gmState.put("gameStatus", gameState.getGame().getGameStatus());
        gmState.put("currentGameDay", gameState.getCurrentDay());
        gmState.put("numberOfDays", gameState.getNumOfDays());
        if (gameState.getCurrentPlayer() != null) {
            gmState.put("currentPlayer", getPlayerNode(gameState.getCurrentPlayer(), 0));
            gmState.put("myAccount", getMyAccount());
            gmState.put("myPortfolio", getPortfolio());
            gmState.put("netWorth", gameState.getCurrentPlayer().getNetWorth());

        }
        gmState.put("maxPlayers", gameState.getGame().getMaxPlayers());

        return gmState;
    }

    public ArrayNode getPortfolio() {
        ArrayNode stocks = Json.newObject().arrayNode();
        GameManager gm = new GameManager();
        for (PortfolioStock portfoilioStock : gameState.getCurrentPlayer().getPortfolios()) {
            ObjectNode stockNode = Json.newObject();
            stockNode.put("id", portfoilioStock.getId());
            String ticker = portfoilioStock.getStock().getTicker();
            stockNode.put("ticker", ticker);
            stockNode.put("company", portfoilioStock.getStock().getCompanyName());
            stockNode.put("quantity", portfoilioStock.getQuantity());
            StockPrice currentStockPrice = null;
            try {
                currentStockPrice = gm.getStockPrice(ticker, gameState.getGame().getVirtualCurrentDate());
            } catch (IOException ex) {
                play.Logger.warn("error occured while retrieving price", ex);
            }
            stockNode.put("currentPrice", currentStockPrice != null ? currentStockPrice.getStockPrice() : 0);
            //stockNode.put("purchasePrice", purchasePrice);
            stocks.add(stockNode);
        }
        return stocks;
    }

    public ObjectNode getMyAccount() {
        ObjectNode myAccount = Json.newObject();
        myAccount.put("openingBalance", gameState.getGame().getOpenBalance());
        myAccount.put("currentBalance", gameState.getCurrentPlayer().getCurrentBalance());
        //myAccount.put("currentBalance", gameState.getCurrentPlayer().getCurrentBalance());
        return myAccount;
    }

    public ObjectNode getPlayers() {
        List<GamePlayer> gamePlayers = gameState.getPlayers();
        Collections.sort(gamePlayers, new Comparator<GamePlayer>() {

            public int compare(GamePlayer o1, GamePlayer o2) {
                return o2.compareTo(o1);
            }
        });

        ObjectNode playersList = Json.newObject();
        int currentRank = 0;
        double lastNetWorth = Double.MAX_VALUE;

        for (GamePlayer player : gamePlayers) {
            double myNetWorth = player.getNetWorth();
            int myRank;
            myRank = myNetWorth == lastNetWorth ? currentRank : playersList.size() + 1;
            currentRank = myRank;
            lastNetWorth = myNetWorth;
            playersList.put(player.getId().toString(), getPlayerNode(player, myRank));
        }

        return playersList;
    }

    public ObjectNode getOwnerPlayer() {
        //ObjectNode ownerPlayerNode
        return getPlayerNode(gameState.getGameOwner(), 0);
    }

    public ObjectNode getPlayerNode(GamePlayer player, int rank) {
        ObjectNode playerNode = Json.newObject();
        playerNode.put("id", player.getId());
        playerNode.put("firstName", player.getUser().getFirstName());
        playerNode.put("lastName", player.getUser().getLastName());
        playerNode.put("rank", rank);
        return playerNode;
    }

    public static ObjectNode getGameStateJson(Integer gameId) {
        try {
            GameState gs = (new GameManager()).getGameState(gameId);
            if (gs == null) {
                return null;
            }
            GameStateJSONFormatter gsj = new GameStateJSONFormatter(gs);
            return gsj.getJSON();
        } catch (Exception ex) {
            play.Logger.error("error occured while retrieveing game state", ex);
            return null;
        }
    }
}
