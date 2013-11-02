/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.avaje.ebean.ExpressionList;
import com.fasterxml.jackson.databind.node.*;
import constants.ApplicationConstants;
import java.sql.Timestamp;
import java.util.List;
import managers.GameManager;
import models.data.Game;
import models.data.Stock;
import models.data.StockPrice;
import org.joda.time.DateTime;
import play.libs.Json;

/**
 *
 * @author intelWorX
 */
public class StocksFormatter {

    public static ArrayNode getStockList(Game currentGame) {
        ArrayNode stockListJson = Json.newObject().arrayNode();
        List<Stock> stockList = Stock.find.filter().eq("isEnabled", 1).filter((new GameManager()).getStockList());
        GameManager gm = new GameManager();
        for (Stock stk : stockList) {
            ObjectNode stock = Json.newObject();
            stock.put("id", stk.getId());
            stock.put("ticker", stk.getTicker());
            stock.put("company", stk.getCompanyName());
            if(currentGame != null && currentGame.getVirtualCurrentDate() != null){
                stock.put("price", gm.getStockPriceAmount(stk.getTicker(), currentGame.getVirtualCurrentDate()));
            }else{
                stock.put("price", 0);
            }
            
            stockListJson.add(stock);
        }

        return stockListJson;
    }

    public static ArrayNode getPrices(Game game, String ticker) {
        ArrayNode stockPricesJson = Json.newObject().arrayNode();
        Stock stock = Stock.find
                .where()
                .eq("ticker", ticker)
                .findUnique();
        if (stock != null) {
            DateTime dt = new DateTime(game.getVirtualCurrentDate());
            if(game.getVirtualCurrentDate() == null){
                play.Logger.warn("dt is null"+dt.getMillis());
            }
            dt = dt.minusDays(ApplicationConstants.STOCK_HISTORY_DAYS);
            //play.Logger.warn("Elsp : "+elsp.order());
            List<StockPrice> prices = StockPrice.find
                    .where()
                    .ge("date", new Timestamp(dt.getMillis()))
                    .lt("date", game.getVirtualCurrentDate())
                    .eq("stock", stock).findList();
            long day = 0;
            for(StockPrice stockPrice : prices){
                ArrayNode stp = Json.newObject().arrayNode();
                stp.add(day+=TimeKeeper.aDayInMS);
                stp.add(stockPrice.getOpen());
                stp.add(stockPrice.getHigh());
                stp.add(stockPrice.getLow());
                stp.add(stockPrice.getClose());
                stockPricesJson.add(stp);
            }
        }
        return stockPricesJson;
    }
}
