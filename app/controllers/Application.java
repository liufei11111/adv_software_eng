package controllers;

import model.forms.LoginForm;
import model.forms.RegisterForm;
import model.forms.GameForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.application_index;
import views.html.application_dashboard;
import managers.GameManager;

public class Application extends Controller {

    public static Result index() {
        return ok(application_index.render(Form.form(LoginForm.class), Form.form(RegisterForm.class), null));
    }

    public static Result dashboard() {
        GameManager gm = new GameManager();
        return ok(application_dashboard.render(gm.getListOfAvailableGames(),Form.form(GameForm.class)));
    }
}
