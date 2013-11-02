import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import managers.GameManager;
import managers.UserManager;
import models.data.Admin;
import models.data.Player;
import models.data.Stock;
import play.Application;
import play.GlobalSettings;
import play.libs.F;
import play.libs.Yaml;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.SimpleResult;

import com.avaje.ebean.Ebean;

import controllers.LoginController;
import controllers.routes;
import constants.ApplicationConstants;


public class Global extends GlobalSettings {

	protected static ArrayList<String> ignorePaths = new ArrayList<String>();

	public Global() {
		super();
		if (ignorePaths.isEmpty()) {
			ignorePaths.add(routes.Application.index().toString());
			ignorePaths.add(routes.LoginController.login().toString());
			ignorePaths.add(routes.LoginController.register().toString());
			// ignorePaths.add();
		}
	}

	public void onStart(Application app) {
		InitialData.insert(app);
	}

	@Override
	public Action onRequest(Http.Request rqst, Method method) {
		// return super.onRequest(rqst, method); //To change body of generated
		// methods, choose Tools | Templates.
		return new ForceLoginAction();
	}

	static public class ForceLoginAction extends play.mvc.Action.Simple {

		public F.Promise<SimpleResult> call(Http.Context ctx) throws Throwable {
			String path = ctx.request().path();
			if (!UserManager.isLoggedIn() && !ignorePaths.contains(path)) {
				return F.Promise.pure((SimpleResult) LoginController
						.requireLogin());
			} else {
				return delegate.call(ctx);
			}
			// Logger.info("Forcing Login" + ctx.args);

		}
	}

	static class InitialData {

		public static void insert(Application app) {
			try {

				@SuppressWarnings("unchecked")
				Map<String, List<Object>> all = (Map<String, List<Object>>) Yaml
				.load("initial-data.yml");

				if (Ebean.find(Admin.class).findRowCount() == 0) {

					if (Admin.findAll().isEmpty()) // Insert Admin first
					{
						Ebean.save(all.get("admins"));
					}

				}

				if (Ebean.find(Player.class).findRowCount() == 0) {

					if (Player.findAll().isEmpty()) // Insert player first
					{
						Ebean.save(all.get("players"));
					}

				}

				if (Ebean.find(Stock.class).findRowCount() == 0) {

					GameManager gameManager = new GameManager();
					if (Stock.findAll().isEmpty()) // Insert player first
					{
						List<Object> stocks = all.get("stocks");
						for (Object stockObj : stocks) {
							Stock stock = (Stock) stockObj;
							gameManager.addStock(stock.getTicker(),
									stock.getCompanyName(),ApplicationConstants.TRUE);
						}

					}
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

		}

	}

}
