// @SOURCE:/Users/feiliu/git/omniwin/conf/routes
// @HASH:ed7ce9bc8ac355e43b269c52501ed7d623f3c02a
// @DATE:Wed Oct 30 19:24:20 EDT 2013


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:9
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:10
private[this] lazy val controllers_LoginController_login1 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:14
private[this] lazy val controllers_LoginController_register2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("register"))))
        

// @LINE:15
private[this] lazy val controllers_LoginController_logout3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        

// @LINE:17
private[this] lazy val controllers_Application_dashboard4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("dashboard"))))
        

// @LINE:20
private[this] lazy val controllers_GameController_create5 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("game/create"))))
        

// @LINE:21
private[this] lazy val controllers_GameController_playGame6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("game/"),DynamicPart("gameId", """[^/]+""",true),StaticPart("/playGame"))))
        

// @LINE:22
private[this] lazy val controllers_GameController_stockList7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("game/"),DynamicPart("gameId", """[^/]+""",true),StaticPart("/stock/list"))))
        

// @LINE:23
private[this] lazy val controllers_GameController_stockPrice8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("game/"),DynamicPart("gameId", """[^/]+""",true),StaticPart("/stock/price/"),DynamicPart("ticker", """[^/]+""",true))))
        

// @LINE:24
private[this] lazy val controllers_GameController_gameStatus9 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("game/"),DynamicPart("gameId", """[^/]+""",true),StaticPart("/status"))))
        

// @LINE:25
private[this] lazy val controllers_GameController_leave10 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("game/"),DynamicPart("gameId", """[^/]+""",true),StaticPart("/leave"))))
        

// @LINE:26
private[this] lazy val controllers_GameController_start11 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("game/"),DynamicPart("gameId", """[^/]+""",true),StaticPart("/start"))))
        

// @LINE:27
private[this] lazy val controllers_GameController_cancel12 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("game/"),DynamicPart("gameId", """[^/]+""",true),StaticPart("/cancel"))))
        

// @LINE:28
private[this] lazy val controllers_GameController_buyStock13 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("game/"),DynamicPart("gameId", """[^/]+""",true),StaticPart("/stock/buy"))))
        

// @LINE:29
private[this] lazy val controllers_GameController_sellStock14 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("game/"),DynamicPart("gameId", """[^/]+""",true),StaticPart("/stock/sell"))))
        

// @LINE:35
private[this] lazy val controllers_ManagementController_index15 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("management"))))
        

// @LINE:36
private[this] lazy val controllers_ManagementController_stockList16 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("management/stock"))))
        

// @LINE:37
private[this] lazy val controllers_ManagementController_addStock17 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("management/stock/add"))))
        

// @LINE:38
private[this] lazy val controllers_ManagementController_deleteStock18 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("management/stock/delete"))))
        

// @LINE:39
private[this] lazy val controllers_ManagementController_toggleStock19 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("management/stock/toggle"))))
        

// @LINE:40
private[this] lazy val controllers_ManagementController_player20 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("management/player"))))
        

// @LINE:41
private[this] lazy val controllers_ManagementController_playerToggle21 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("management/player/toggle"))))
        

// @LINE:42
private[this] lazy val controllers_ManagementController_generateMetrics22 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("management/metrics"))))
        

// @LINE:46
private[this] lazy val controllers_Assets_at23 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.LoginController.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """register""","""controllers.LoginController.register()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.LoginController.logout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """dashboard""","""controllers.Application.dashboard()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """game/create""","""controllers.GameController.create()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """game/$gameId<[^/]+>/playGame""","""controllers.GameController.playGame(gameId:Integer)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """game/$gameId<[^/]+>/stock/list""","""controllers.GameController.stockList(gameId:Integer)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """game/$gameId<[^/]+>/stock/price/$ticker<[^/]+>""","""controllers.GameController.stockPrice(gameId:Integer, ticker:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """game/$gameId<[^/]+>/status""","""controllers.GameController.gameStatus(gameId:Integer)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """game/$gameId<[^/]+>/leave""","""controllers.GameController.leave(gameId:Integer)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """game/$gameId<[^/]+>/start""","""controllers.GameController.start(gameId:Integer)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """game/$gameId<[^/]+>/cancel""","""controllers.GameController.cancel(gameId:Integer)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """game/$gameId<[^/]+>/stock/buy""","""controllers.GameController.buyStock(gameId:Integer)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """game/$gameId<[^/]+>/stock/sell""","""controllers.GameController.sellStock(gameId:Integer)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """management""","""controllers.ManagementController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """management/stock""","""controllers.ManagementController.stockList()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """management/stock/add""","""controllers.ManagementController.addStock()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """management/stock/delete""","""controllers.ManagementController.deleteStock()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """management/stock/toggle""","""controllers.ManagementController.toggleStock()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """management/player""","""controllers.ManagementController.player()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """management/player/toggle""","""controllers.ManagementController.playerToggle()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """management/metrics""","""controllers.ManagementController.generateMetrics()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:9
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """""", Routes.prefix + """"""))
   }
}
        

// @LINE:10
case controllers_LoginController_login1(params) => {
   call { 
        invokeHandler(controllers.LoginController.login(), HandlerDef(this, "controllers.LoginController", "login", Nil,"POST", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:14
case controllers_LoginController_register2(params) => {
   call { 
        invokeHandler(controllers.LoginController.register(), HandlerDef(this, "controllers.LoginController", "register", Nil,"POST", """ Authentication
POST    /login                         controllers.LoginController.authenticate()
GET 	/register			controllers.LoginController.register()""", Routes.prefix + """register"""))
   }
}
        

// @LINE:15
case controllers_LoginController_logout3(params) => {
   call { 
        invokeHandler(controllers.LoginController.logout(), HandlerDef(this, "controllers.LoginController", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
   }
}
        

// @LINE:17
case controllers_Application_dashboard4(params) => {
   call { 
        invokeHandler(controllers.Application.dashboard(), HandlerDef(this, "controllers.Application", "dashboard", Nil,"GET", """""", Routes.prefix + """dashboard"""))
   }
}
        

// @LINE:20
case controllers_GameController_create5(params) => {
   call { 
        invokeHandler(controllers.GameController.create(), HandlerDef(this, "controllers.GameController", "create", Nil,"POST", """game controller""", Routes.prefix + """game/create"""))
   }
}
        

// @LINE:21
case controllers_GameController_playGame6(params) => {
   call(params.fromPath[Integer]("gameId", None)) { (gameId) =>
        invokeHandler(controllers.GameController.playGame(gameId), HandlerDef(this, "controllers.GameController", "playGame", Seq(classOf[Integer]),"GET", """""", Routes.prefix + """game/$gameId<[^/]+>/playGame"""))
   }
}
        

// @LINE:22
case controllers_GameController_stockList7(params) => {
   call(params.fromPath[Integer]("gameId", None)) { (gameId) =>
        invokeHandler(controllers.GameController.stockList(gameId), HandlerDef(this, "controllers.GameController", "stockList", Seq(classOf[Integer]),"GET", """""", Routes.prefix + """game/$gameId<[^/]+>/stock/list"""))
   }
}
        

// @LINE:23
case controllers_GameController_stockPrice8(params) => {
   call(params.fromPath[Integer]("gameId", None), params.fromPath[String]("ticker", None)) { (gameId, ticker) =>
        invokeHandler(controllers.GameController.stockPrice(gameId, ticker), HandlerDef(this, "controllers.GameController", "stockPrice", Seq(classOf[Integer], classOf[String]),"GET", """""", Routes.prefix + """game/$gameId<[^/]+>/stock/price/$ticker<[^/]+>"""))
   }
}
        

// @LINE:24
case controllers_GameController_gameStatus9(params) => {
   call(params.fromPath[Integer]("gameId", None)) { (gameId) =>
        invokeHandler(controllers.GameController.gameStatus(gameId), HandlerDef(this, "controllers.GameController", "gameStatus", Seq(classOf[Integer]),"POST", """""", Routes.prefix + """game/$gameId<[^/]+>/status"""))
   }
}
        

// @LINE:25
case controllers_GameController_leave10(params) => {
   call(params.fromPath[Integer]("gameId", None)) { (gameId) =>
        invokeHandler(controllers.GameController.leave(gameId), HandlerDef(this, "controllers.GameController", "leave", Seq(classOf[Integer]),"POST", """""", Routes.prefix + """game/$gameId<[^/]+>/leave"""))
   }
}
        

// @LINE:26
case controllers_GameController_start11(params) => {
   call(params.fromPath[Integer]("gameId", None)) { (gameId) =>
        invokeHandler(controllers.GameController.start(gameId), HandlerDef(this, "controllers.GameController", "start", Seq(classOf[Integer]),"POST", """""", Routes.prefix + """game/$gameId<[^/]+>/start"""))
   }
}
        

// @LINE:27
case controllers_GameController_cancel12(params) => {
   call(params.fromPath[Integer]("gameId", None)) { (gameId) =>
        invokeHandler(controllers.GameController.cancel(gameId), HandlerDef(this, "controllers.GameController", "cancel", Seq(classOf[Integer]),"POST", """""", Routes.prefix + """game/$gameId<[^/]+>/cancel"""))
   }
}
        

// @LINE:28
case controllers_GameController_buyStock13(params) => {
   call(params.fromPath[Integer]("gameId", None)) { (gameId) =>
        invokeHandler(controllers.GameController.buyStock(gameId), HandlerDef(this, "controllers.GameController", "buyStock", Seq(classOf[Integer]),"POST", """""", Routes.prefix + """game/$gameId<[^/]+>/stock/buy"""))
   }
}
        

// @LINE:29
case controllers_GameController_sellStock14(params) => {
   call(params.fromPath[Integer]("gameId", None)) { (gameId) =>
        invokeHandler(controllers.GameController.sellStock(gameId), HandlerDef(this, "controllers.GameController", "sellStock", Seq(classOf[Integer]),"POST", """""", Routes.prefix + """game/$gameId<[^/]+>/stock/sell"""))
   }
}
        

// @LINE:35
case controllers_ManagementController_index15(params) => {
   call { 
        invokeHandler(controllers.ManagementController.index(), HandlerDef(this, "controllers.ManagementController", "index", Nil,"GET", """admin related function...""", Routes.prefix + """management"""))
   }
}
        

// @LINE:36
case controllers_ManagementController_stockList16(params) => {
   call { 
        invokeHandler(controllers.ManagementController.stockList(), HandlerDef(this, "controllers.ManagementController", "stockList", Nil,"GET", """""", Routes.prefix + """management/stock"""))
   }
}
        

// @LINE:37
case controllers_ManagementController_addStock17(params) => {
   call { 
        invokeHandler(controllers.ManagementController.addStock(), HandlerDef(this, "controllers.ManagementController", "addStock", Nil,"POST", """""", Routes.prefix + """management/stock/add"""))
   }
}
        

// @LINE:38
case controllers_ManagementController_deleteStock18(params) => {
   call { 
        invokeHandler(controllers.ManagementController.deleteStock(), HandlerDef(this, "controllers.ManagementController", "deleteStock", Nil,"POST", """""", Routes.prefix + """management/stock/delete"""))
   }
}
        

// @LINE:39
case controllers_ManagementController_toggleStock19(params) => {
   call { 
        invokeHandler(controllers.ManagementController.toggleStock(), HandlerDef(this, "controllers.ManagementController", "toggleStock", Nil,"POST", """""", Routes.prefix + """management/stock/toggle"""))
   }
}
        

// @LINE:40
case controllers_ManagementController_player20(params) => {
   call { 
        invokeHandler(controllers.ManagementController.player(), HandlerDef(this, "controllers.ManagementController", "player", Nil,"POST", """""", Routes.prefix + """management/player"""))
   }
}
        

// @LINE:41
case controllers_ManagementController_playerToggle21(params) => {
   call { 
        invokeHandler(controllers.ManagementController.playerToggle(), HandlerDef(this, "controllers.ManagementController", "playerToggle", Nil,"POST", """""", Routes.prefix + """management/player/toggle"""))
   }
}
        

// @LINE:42
case controllers_ManagementController_generateMetrics22(params) => {
   call { 
        invokeHandler(controllers.ManagementController.generateMetrics(), HandlerDef(this, "controllers.ManagementController", "generateMetrics", Nil,"POST", """""", Routes.prefix + """management/metrics"""))
   }
}
        

// @LINE:46
case controllers_Assets_at23(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /public path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     