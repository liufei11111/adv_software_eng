package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import managers.GameManager;
import managers.UserManager;
import model.forms.BuyStock;
import models.data.Game;
import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;
import model.forms.GameForm;
import model.forms.SellStock;
import models.data.GamePlayer;
import models.data.User;
import play.Logger;
import play.libs.Json;
import util.GameStateJSONFormatter;
import util.StocksFormatter;
import views.html.application_dashboard;
import views.html.game_playGame;
import views.html.game_playGame_cant_join;
import views.html.game_playGame_notFound;

public class GameController extends Controller {

    public static Result create() {
        //create a game
        GameManager gm = new GameManager();

        Form<GameForm> gameForm = Form.form(GameForm.class).bindFromRequest();
        if (gameForm.hasErrors()) { //form contains error
            return badRequest(application_dashboard.render(gm.getListOfAvailableGames(), gameForm));
        }
        //no error      
        Game newGame = gm.createFixedTimeChallengeGame(gameForm.get());
        if (newGame != null) {
            flash("game_created", "Game has beemn successfully created!");
            return redirect(routes.GameController.playGame(newGame.getId()));
        } else {
            gameForm.reject("Can not create game");
            return badRequest(application_dashboard.render(gm.getListOfAvailableGames(), gameForm));
        }

    }

    public static Result playGame(int gameId) {
        Game game = Game.find.byId(gameId + "");
        User currentUser = UserManager.getCurrentLoggedInUser();
        if (game == null) {
            return notFound(game_playGame_notFound.render());
        }

        if (!game.canJoinGame(currentUser)) {
            return badRequest(game_playGame_cant_join.render(game, false));
        }

        GamePlayer gamePlayer = game.getPlayerInGame(currentUser);
        if (gamePlayer == null) {
            Logger.info("joining game");
            gamePlayer = game.joinGame(currentUser);
            if (gamePlayer != null) {
                Logger.info("Successfully joined game.");
            } else {
                return badRequest(game_playGame_cant_join.render(game, true));
            }
        }

        ObjectNode gameState = GameStateJSONFormatter.getGameStateJson(gameId);
        //Logger.info("Game State: "+gameState);
        return ok(game_playGame.render(game, gameState, StocksFormatter.getStockList(game)));
    }

    public static Result stockList(Integer gameId) {
        response().setContentType("application/json");

        return ok(StocksFormatter.getStockList(Game.find.byId(gameId.toString())));
    }

    public static Result stockPrice(int gameId, String ticker) {
        GameCheck gc = new GameCheck(gameId, false);
        if (gc.hasErrors) {
            return gc.getResult();
        }
        response().setContentType("application/json");
        return ok(StocksFormatter.getPrices(gc.currentGame, ticker));
    }

    public static Result gameStatus(int gameId) {
        GameCheck gc = new GameCheck(gameId, false);
        if (gc.hasErrors) {
            return gc.getResult();
        }
        ObjectNode gameState = GameStateJSONFormatter.getGameStateJson(gameId);
        if (gameState == null) {
            return badRequest("{error: \"failed to load JSON...\"}");
        }

        response().setContentType("application/json");
//        testing things....
//        ObjectNode playerNode = Json.newObject();
//        playerNode.put("id", System.currentTimeMillis());
//        playerNode.put("firstName", "newPlayer"+System.currentTimeMillis());
//        playerNode.put("lastName", "newLastName");
//        playerNode.put("rank", 10);
//        ObjectNode pNode = Json.fromJson(gameState.get("players"), ObjectNode.class);
//        pNode.put(System.currentTimeMillis()+"", playerNode);
//        gameState.put("players", pNode);
//        gameState.put("gameStatus", "STARTED");
        return ok(gameState.toString());
    }

    public static Result leave(int gameId) {
        GameCheck gc = new GameCheck(gameId, false);
        if (gc.hasErrors) {
            return gc.getResult();
        }
        ObjectNode status = Json.newObject();
        status.put("success", gc.currentGame.leaveGame(UserManager.getCurrentLoggedInUser()));
        play.Logger.warn("Left Game: " + status);
        response().setContentType("application/json");
        return ok(GameStateJSONFormatter.getGameStateJson(gameId));
    }

    public static Result start(int gameId) {
        GameManager gm = new GameManager();
        response().setContentType("application/json");

        if (gm.startGame(gameId)) {
            return ok(GameStateJSONFormatter.getGameStateJson(gameId).toString());
        } else {
            return badRequest("{error: \"failed to start game...\"}");
        }
    }

    public static Result cancel(Integer gameId) {
        GameCheck gc = new GameCheck(gameId, true);
        if (gc.hasErrors) {
            return gc.getResult();
        }

        Game game = gc.currentGame;
        if (!game.cancelGame()) {
            return badRequest("{error: \"not cancellable...\"}");
        }
        response().setContentType("application/json");
        return ok(GameStateJSONFormatter.getGameStateJson(gameId).toString());
    }

    public static Result buyStock(Integer gameId) {
        GameCheck gc = new GameCheck(gameId, false);
        if (gc.hasErrors) {
            return gc.getResult();
        }
        GamePlayer me = gc.currentGame.getPlayerInGame(UserManager.getCurrentLoggedInUser());
        Form<BuyStock> buyStockForm = Form.form(BuyStock.class).bindFromRequest();
        response().setContentType("application/json");
        if (buyStockForm.hasGlobalErrors()) {
            return badRequest(buyStockForm.errorsAsJson());
        } else {
            if (me.buyStock(buyStockForm.get().ticker, buyStockForm.get().quantity, buyStockForm.get().price)) {
                return ok(GameStateJSONFormatter.getGameStateJson(gameId));
            } else {
                return badRequest("{error: \"could not make purchase\"}");
            }
        }
    }

    public static Result sellStock(int gameId) {
        GameCheck gc = new GameCheck(gameId, false);
        if (gc.hasErrors) {
            return gc.getResult();
        }
        GamePlayer me = gc.currentGame.getPlayerInGame(UserManager.getCurrentLoggedInUser());
        Form<SellStock> sellStockForm = Form.form(SellStock.class).bindFromRequest();
        response().setContentType("application/json");
        if(sellStockForm.hasErrors()){
            return badRequest(sellStockForm.errorsAsJson());
        }else{
            SellStock sellStock = sellStockForm.get();
            //play.Logger.info("Price: "+sellStock.price);
            if(me.sellStock(sellStock.ticker, sellStock.quantity, sellStock.price)){
                return ok(GameStateJSONFormatter.getGameStateJson(gameId));
            }else{
                return badRequest("{error: \"could not make sale!\"}");
            }
        }
        
    }

    public static class GameCheck {

        private Result result;
        private final Game currentGame;
        private boolean hasErrors = true;

        public GameCheck(Integer gameId, boolean checkOwnership) {
            currentGame = Game.find.byId(gameId.toString());
            if (currentGame == null) {
                result = notFound(game_playGame_notFound.render());
            } else if (!currentGame.playerInGame(UserManager.getCurrentLoggedInUser())) {
                response().setContentType("application/json");
                result = badRequest("{error: \"not in game...\"}");
            } else if (checkOwnership && !currentGame.getOwner().equals(UserManager.getCurrentLoggedInUser())) {
                response().setContentType("application/json");
                result = badRequest("{error: \"not game owner...\"}");
            } else {
                hasErrors = false;
            }
        }

        public Game getCurrentGame() {
            return currentGame;
        }

        public Result getResult() {
            return result;
        }

        public boolean isHasErrors() {
            return hasErrors;
        }

    }

}
