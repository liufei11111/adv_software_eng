package controllers;

import model.forms.LoginForm;
import model.forms.RegisterForm;
import models.data.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.application_index;
import constants.ApplicationConstants;
import managers.UserManager;

public class LoginController extends Controller {

    protected static String NEXT_URL = "nextUrl";

    public static class Login {

        public String email;
        public String password;

        public String validate() {
            if (User.authenticate(email, password) == null) {
                return "Invalid user or password";
            }
            return null;
        }
    }

    /**
     * Login page.
     */
    public static Result login() {
        Form<LoginForm> loginForm = Form.form(LoginForm.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            return badRequest(application_index.render(loginForm, Form.form(RegisterForm.class), "login"));
        } else {
            session(ApplicationConstants.USER, loginForm.get().email);
            //if is admin... redirect to admin admin dashboard
            if (UserManager.getCurrentLoggedInUser().isAdmin()) {
                //redirect to admin
                return redirect(routes.ManagementController.index());
            } else {
                return redirect(retrieveNextUrl());
            }
        }
    }

    public static Result register() {
        Form<RegisterForm> registerForm = Form.form(RegisterForm.class).bindFromRequest();
        if (registerForm.hasErrors()) {
            return badRequest(application_index.render(Form.form(LoginForm.class), registerForm, "register"));
        } else {
            session(ApplicationConstants.USER, registerForm.get().email);
            return redirect(retrieveNextUrl());
        }

    }

    protected static String retrieveNextUrl() {
        String nextUrl = session(NEXT_URL);
        if (nextUrl == null) {
            nextUrl = routes.Application.dashboard().toString();
        }
        return nextUrl;
    }

    public static Result registerSave() {
        return TODO;
    }

    /**
     * Logout and clean the session.
     *
     * @return
     */
    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect(routes.Application.index());
    }

    public static Result requireLogin() {
        String currentUrl = request().path();
        if (currentUrl == null) {
            currentUrl = routes.Application.dashboard().toString();
        }
        session(NEXT_URL, currentUrl);
        return redirect(routes.Application.index() + "#login");
    }
}
