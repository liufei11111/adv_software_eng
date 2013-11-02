package managers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.forms.GameForm;
import models.data.FixedTimeChallengeGame;
import models.data.Game;
import models.data.GamePlayer;
import models.data.Player;
import models.data.Stock;
import models.data.StockPrice;
import util.TimeKeeper;
import models.data.User;

import org.joda.time.DateTime;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import util.GameUtil;
import beans.GameState;
import constants.ApplicationConstants;
import enums.GameStatusEnum;

public class GameManager {

    private final String YAHOO_URL = "http://ichart.yahoo.com/table.csv?s=";

    private final String[] header = new String[]{"Date", "Open", "High",
        "Low", "Close", null, null};
    private List<Game> GameList;
    // no processing required for ignored columns
    private final CellProcessor[] processors = new CellProcessor[]{
        new ParseDate("yyyy-MM-dd"), new ParseDouble(), new ParseDouble(), new ParseDouble(),
        new ParseDouble(), null, null};

    /**
     * Sets up the bean reader
     *
     * @param ticker
     * @return
     * @throws IOException
     *
     * @throws Exception
     */
    private ICsvBeanReader setup(String ticker, DateTime startDt, DateTime endDt) throws IOException {
        ICsvBeanReader beanReader = null;

        URL yahoo;
        StringBuffer urlStr = new StringBuffer(YAHOO_URL + ticker);
        /*if (startDt!=null && endDt !=null){
         //http://ichart.yahoo.com/table.csv?s=GOOG&a=0&b=1&c=2000&d=0&e=31&f=2010&g=w
         int startDtNumOfMonth = startDt.getMonthOfYear()-1;
         int startDtNumOfDay = startDt.getDayOfMonth();
         int startDtYear = startDt.getYear();

         int endDtNumOfMonth = endDt.getMonthOfYear()-1;
         int endDtNumOfDay = endDt.getDayOfMonth();
         int endDtYear = endDt.getYear();
         //url construction
         urlStr.append("&a=").append(startDtNumOfMonth);
         urlStr.append("&b=").append(startDtNumOfDay);
         urlStr.append("&c=").append(startDtYear);
         urlStr.append("&d=").append(endDtNumOfMonth);
         urlStr.append("&e=").append(endDtNumOfDay);
         urlStr.append("&f=").append(endDtYear);
         urlStr.append("&g=d&ignore=.csv");
         }*/
        yahoo = new URL(urlStr.toString());

        BufferedReader in = new BufferedReader(new InputStreamReader(
                yahoo.openStream()));

        beanReader = new CsvBeanReader(in, CsvPreference.STANDARD_PREFERENCE);
        beanReader.getHeader(true);

        return beanReader;

    }

    /**
     * Returns a list of games that is in the database
     *
     * @return
     */
    public List<Game> getListOfGames() {
        return Game.find.all();
    }

    /**
     * This creates a fixed time challenge game. The goal of this game to
     * achieve the highest winnings by the end of the game
     *
     * @param gameForm
     * @return
     */
    public Game createFixedTimeChallengeGame(GameForm gameForm) {
        FixedTimeChallengeGame game = new FixedTimeChallengeGame();
        User user = UserManager.getCurrentLoggedInUser();
        // if user is not in the session, then cannot create game
        if (user == null) {
            return null;
        }

        // creating game
        game.setGameLength(gameForm.gameLength);
        game.setGameStatus(GameStatusEnum.CREATED.getValue());
        game.setGameTitle(gameForm.gameTitle);
        game.setAddedOn(GameUtil.getCurrentTimeStamp());
        game.setMaxPlayers(gameForm.maxPlayers);
        game.setOwner((Player) user);
        game.setOpenBalance(gameForm.openBalance);
        //adding game player to list        
        game.save();
        game.joinGame(user);
        return game;
    }

    /**
     * This creates a Lump sum game. The goal of this game is to achieve the
     * target winnings of the game. This is currently not supported
     *
     * @param gameTitle
     * @param winningAmount
     * @return
     */
//	public boolean createLumpSumGame(GameForm gameForm) {
//		LumpSumGame game = new LumpSumGame();
//		UserManager userManager = new UserManager();
//		User user = userManager.getCurrentLoggedInUser();
//		// if user is not in the session, then cannot create game
//		if (user == null)
//			return false;
//
//		// creating game
////		game.setWinningAmount(gameForm.);
//		game.setGameStatus(GameStatusEnum.WAITING.getValue());
//		game.setGameTitle(gameForm.gameTitle);
//		game.setAddedOn(GameUtil.getCurrentTimeStamp());
//		game.save();
//		return true;
//	}
    /**
     * This returns the List of available games
     *
     * @return
     */
    public List<Game> getListOfAvailableGames() {
        return Game.find.where().eq("gameStatus", GameStatusEnum.CREATED.getValue()).findList();
    }

    /**
     * Returns the game state of a given game
     *
     * @param id
     * @return
     * @throws java.lang.Exception
     */
    public GameState getGameState(Integer id) throws Exception {

        GameState gameState = new GameState();
        FixedTimeChallengeGame game = (FixedTimeChallengeGame) FixedTimeChallengeGame.find
                .where().eq("id", id).findUnique();

        //save new virtual current date if no gotten
        if (game.getVirtualStartDate() != null) {
            game.setVirtualCurrentDate(TimeKeeper.convert(game));
            game.save();
        }
        User player = UserManager.getCurrentLoggedInUser();

        // set the game state
        List<GamePlayer> gamePlayers = game.getPlayers();

        gameState.setPlayers(gamePlayers);
        gameState.setNumOfDays(game.getGameLength());
        gameState.setCurrentDay(game.getVirtualCurrentDate() == null ? 0 : GameUtil.getCurrentDay(game));
        if (gameState.getCurrentDay() > gameState.getNumOfDays()) {
            game.setGameStatus(enums.GameStatusEnum.END.toString());
            game.save();
        }
        gameState.setGame(game);
        GamePlayer currentGamePlayer = game.getPlayerInGame(player);
        gameState.setCurrentPlayer(currentGamePlayer);
        if (currentGamePlayer != null) {
            gameState.setMyPortfolio(currentGamePlayer.getPortfolios());
        }
        gameState.setGameOwner(game.getPlayerInGame(game.getOwner()));
        return gameState;
    }

    /**
     * Returns a list of stocks that is in the system
     *
     * @return
     */
    public List<Stock> getStockList() {
        return Stock.find.all();
    }

    /**
     * Adds a stock to the system
     *
     * @param ticker
     * @param companyName
     * @throws IOException
     */
    public boolean addStock(String ticker, String companyName, int isEnabled) throws IOException {
        if (stockExistInSystem(ticker)) {
            return false;
        }

        if (stockExist(ticker)) {
            Stock stock = new Stock();
            stock.setAddedOn(new Timestamp(new Date().getTime()));
            stock.setCompanyName(companyName);
            stock.setIsEnabled(isEnabled);
            stock.setLastUpdated(GameUtil.getCurrentTimeStamp());
            stock.setTicker(ticker);

            ICsvBeanReader beanReader = setup(ticker, null, null);
            if (beanReader == null) {
                play.Logger.warn("bean reader null");
            }

            List<StockPrice> stockPrices = parseCSV(beanReader);
            //List<StockPrice> stockPrices = new ArrayList<StockPrice>();

            /**
             * StockPrice temp = null;
             *
             *
             * do { if ((temp = beanReader.read(StockPrice.class, header,
             * processors)) != null) { stockPrices.add(temp); } } while (temp !=
             * null);
             *
             */
            stock.setPrices(stockPrices);
            stock.save();
            return true;
        }
        return false;
    }

    /**
     * Delete a stock from the system
     *
     * @param ticker
     * @param companyName
     * @throws IOException
     */
    public boolean deleteStock(String ticker, String companyName) throws IOException {

        if (stockExist(ticker)) {

            Stock stock = Stock.find.where().eq("ticker", ticker).findUnique();

            if (stock != null) {
                int stock_id = Stock.find.where().eq("ticker", ticker).findUnique().getId();
                Stock.find.ref(Integer.toString(stock_id)).delete();
                return true;
                /*temp.setIsEnabled(0);
                 play.Logger.warn("Stock set? "+Stock.find.where().eq("ticker", ticker).findUnique().getIsEnabled());
                 Stock.find.where().eq("ticker", ticker).findUnique().setLastUpdated(GameUtil.getCurrentTimeStamp());
                 */ }
        }

        return false;
    }

    /**
     * flip a stock from its current enable status
     *
     * @param ticker
     * @return
     * @throws IOException return 2 if failure, 1 if stock is enabled and 0 if
     * stock is disabled after the method call
     */
    public int flip_enable(String ticker) throws IOException {
        int final_state = 2;
        if (stockExist(ticker)) {
            Stock stock = Stock.find.where().eq("ticker", ticker).findUnique();
            if (stock != null) {
                int stock_id = Stock.find.where().eq("ticker", ticker).findUnique().getId();
                Integer currentStatus = stock.getIsEnabled();
                if (currentStatus == 1) {
                    stock.setIsEnabled(0);
                    final_state = 0;
                } else {
                    stock.setIsEnabled(1);
                }
                stock.save();
            }
        }
        return final_state;
    }

    /**
     * This checks if a stock exist on yahoo api
     *
     * @param ticker
     * @return
     */
    public boolean stockExist(String ticker) {
        try {
            Object obj = setup(ticker, null, null);
            return obj != null;
        } catch (IOException ioe) {
            play.Logger.error("Could not check for stock existence", ioe);
            return false;
        }
    }

    /**
     * This checks if a stock already exists in database
     *
     * @param ticker
     * @return
     */
    public boolean stockExistInSystem(String ticker) {
        Stock stock = Stock.find.where().eq("ticker", ticker).findUnique();
        return stock != null;
    }

    public List<StockPrice> parseCSV(ICsvBeanReader beanReader) throws IOException {

        List<StockPrice> stockPrices = new ArrayList<StockPrice>();
        StockPrice temp;
        while ((temp = beanReader.read(StockPrice.class, header, processors)) != null) {
            stockPrices.add(temp);
        }

        return stockPrices;
    }

    /**
     * This starts the game
     *
     * @param gameId
     * @return
     */
    public boolean startGame(int gameId) {
        Game game = Game.findById(gameId);

        if (game == null) {
            return false;
        } else if (!game.getOwner().equals(UserManager.getCurrentLoggedInUser())) {
            play.Logger.warn("attemt to start game not owned.");
            return false;
        } else {
            DateTime dt = new DateTime();
            //game length is in days
            int randStartDaysAgo = (int) (Math.random() * ApplicationConstants.MAX_DAYS_BACK)
                    + game.getGameLength()
                    + ApplicationConstants.DAYS_PADDING_FROM_REALITY;

            dt = dt.minusDays(randStartDaysAgo);
            Timestamp temp = new Timestamp(dt.getMillis());// the start of game is one year ago
            while (!TimeKeeper.isTradingDay(temp)) {
                temp = new Timestamp(temp.getTime() + TimeKeeper.aDayInMS);
                play.Logger.info("Skipping... " + temp);
            }

            game.setVirtualStartDate(temp);
            game.setRealStartTime(new Timestamp(System.currentTimeMillis()));
            game.setGameStatus(GameStatusEnum.STARTED.getValue());
            game.save();
            return true;
        }

    }

    /**
     * Gets stock price
     *
     * @param ticker
     * @param virtualDate
     * @return
     * @throws java.io.IOException
     */
    public StockPrice getStockPrice(String ticker, Timestamp virtualDate) throws IOException {
        virtualDate = util.TimeKeeper.round_to_day(virtualDate);

        Stock stock = Stock.find.where().eq("ticker", ticker).findUnique();
        List<StockPrice> stockPrices = StockPrice.find.filter().eq("Date", virtualDate).filter(stock.getPrices());
        //parse file to get updated info
        //if (false) {
        if (stockPrices == null || stockPrices.isEmpty()) {
            //just do a week at a time for performance reasons, hence 7 meaning 7 days
            DateTime fromDt = new DateTime(virtualDate.getTime());
            DateTime toDt = fromDt.plusDays(7);

            ICsvBeanReader beanReader = setup(ticker, fromDt, toDt);
            List<StockPrice> newStockPrices = parseCSV(beanReader);
            stock.getPrices().addAll(newStockPrices);
            stock.update();
            stockPrices = StockPrice.find.filter().eq("Date", virtualDate).filter(stock.getPrices());
        }

        return stockPrices.isEmpty() ? null : stockPrices.get(0);
    }

    public double getStockPriceAmount(String ticker, Timestamp virtualDate) {
        StockPrice stockPrice;
        try {
            stockPrice = getStockPrice(ticker, virtualDate);
            return stockPrice == null ? 0 : stockPrice.getStockPrice();
        } catch (IOException ex) {
            play.Logger.error("Could not retrieve stock price", ex);
        }

        return 0;
    }
}
