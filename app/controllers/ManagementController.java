package controllers;

import managers.GameManager;
import managers.UserManager;
import model.forms.StockForm;
import model.forms.UserForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.management;
import models.data.User;

public class ManagementController extends Controller {

    public static Result index() {
        GameManager gm = new GameManager();
        User user = UserManager.getCurrentLoggedInUser();
        if (user != null && user.isAdmin()) {
            return ok(management.render(gm.getStockList(), "", "stockTab"));
        } else {
            return ok("You don't have acess to Admin DashBoard!");
        }

    }

    public static Result stockList() {
        return TODO;
    }

    public static Result addStock() {
        User user = UserManager.getCurrentLoggedInUser();
        if (user != null && user.isAdmin()) {

            boolean success = true;
            GameManager gm = new GameManager();

            Form<StockForm> stockForm = Form.form(StockForm.class).bindFromRequest();
            if (stockForm.hasErrors()) {
                success = false;
            } else {
                try {
                    success = gm.addStock(stockForm.get().ticker, stockForm.get().companyName, stockForm.get().isEnabled);
                } catch (Exception e) {
                    success = false; //can not add into database
                }
            }
            if (success) {
                return ok(management.render(gm.getStockList(), "stock successfully added", "stockTab"));//return message indicating success
            } else {
                return ok(management.render(gm.getStockList(), "Failed adding stock", "stockTab")); //not success in general
            }

        } else {
            return ok("You don't have acess to Admin DashBoard!");
        }
    }

    public static Result deleteStock() {
        User user = UserManager.getCurrentLoggedInUser();
        if (user != null && user.isAdmin()) {

            boolean success = true;
            GameManager gm = new GameManager();
            Form<StockForm> stockForm = Form.form(StockForm.class).bindFromRequest();
            if (stockForm.hasErrors()) {
                success = false;
            } else {
                try {
                    success = gm.deleteStock(stockForm.get().ticker, stockForm.get().companyName);
                } catch (Exception e) {
                    success = false; //can not add into database
                }
            }
            if (success) {
                return ok(management.render(gm.getStockList(), "stock successfully deleted", "stockTab")); //return message indicating success
            } else {
                return ok(management.render(gm.getStockList(), "Failed deleting stock", "stockTab"));//not success in general
            }

        } else {
            return ok("You don't have acess to Admin DashBoard!");
        }
    }

    public static Result toggleStock() {
        User user = UserManager.getCurrentLoggedInUser();
        if (user != null && user.isAdmin()) {

            boolean success = true;
            GameManager gm = new GameManager();
            int rs = 1;
            Form<StockForm> stockForm = Form.form(StockForm.class).bindFromRequest();
            if (stockForm.hasErrors()) {
                success = false;
            } else {
                try {
                    rs = gm.flip_enable(stockForm.get().ticker);
                    if (rs == 2) {
                        success = false;
                    }
                } catch (Exception e) {
                    success = false; //can not add into database
                }
            }
            if (success) {
                return ok(management.render(gm.getStockList(), "stock successfully " + (rs == 1 ? "enabled" : "disabled"), "stockTab")); //return message indicating success
            } else {
                return ok(management.render(gm.getStockList(), "Failed enable/disable stock", "stockTab"));//not success in general
            }

        } else {
            return ok("You don't have acess to Admin DashBoard!");
        }
    }

    public static Result player() {
        return TODO;
    }

    public static Result playerToggle() {
        User user = UserManager.getCurrentLoggedInUser();
        if (user != null && user.isAdmin()) {
            GameManager gm = new GameManager();
            Form<UserForm> userForm = Form.form(UserForm.class).bindFromRequest();
            if (userForm.hasErrors()) {
                return ok(management.render(gm.getStockList(), "Failed enable/disable User", "userTab"));
            } else {
                return ok(management.render(gm.getStockList(), "User successfully " + (User.findByEmail(userForm.get().email).getIsEnabled() == 1 ? "enabled" : "disabled"), "userTab"));
            }
        } else {
            return ok("You don't have acess to Admin DashBoard!");
        }
    }

    public static Result generateMetrics() {
        return TODO;
    }

}
