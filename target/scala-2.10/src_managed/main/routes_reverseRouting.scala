// @SOURCE:/Users/feiliu/git/omniwin/conf/routes
// @HASH:ed7ce9bc8ac355e43b269c52501ed7d623f3c02a
// @DATE:Wed Oct 30 19:24:20 EDT 2013

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:46
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:15
// @LINE:14
// @LINE:10
// @LINE:9
package controllers {

// @LINE:46
class ReverseAssets {
    

// @LINE:46
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
class ReverseGameController {
    

// @LINE:28
def buyStock(gameId:Integer): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "game/" + implicitly[PathBindable[Integer]].unbind("gameId", gameId) + "/stock/buy")
}
                                                

// @LINE:26
def start(gameId:Integer): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "game/" + implicitly[PathBindable[Integer]].unbind("gameId", gameId) + "/start")
}
                                                

// @LINE:20
def create(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "game/create")
}
                                                

// @LINE:24
def gameStatus(gameId:Integer): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "game/" + implicitly[PathBindable[Integer]].unbind("gameId", gameId) + "/status")
}
                                                

// @LINE:25
def leave(gameId:Integer): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "game/" + implicitly[PathBindable[Integer]].unbind("gameId", gameId) + "/leave")
}
                                                

// @LINE:22
def stockList(gameId:Integer): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "game/" + implicitly[PathBindable[Integer]].unbind("gameId", gameId) + "/stock/list")
}
                                                

// @LINE:27
def cancel(gameId:Integer): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "game/" + implicitly[PathBindable[Integer]].unbind("gameId", gameId) + "/cancel")
}
                                                

// @LINE:23
def stockPrice(gameId:Integer, ticker:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "game/" + implicitly[PathBindable[Integer]].unbind("gameId", gameId) + "/stock/price/" + implicitly[PathBindable[String]].unbind("ticker", dynamicString(ticker)))
}
                                                

// @LINE:21
def playGame(gameId:Integer): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "game/" + implicitly[PathBindable[Integer]].unbind("gameId", gameId) + "/playGame")
}
                                                

// @LINE:29
def sellStock(gameId:Integer): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "game/" + implicitly[PathBindable[Integer]].unbind("gameId", gameId) + "/stock/sell")
}
                                                
    
}
                          

// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
class ReverseManagementController {
    

// @LINE:36
def stockList(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "management/stock")
}
                                                

// @LINE:39
def toggleStock(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "management/stock/toggle")
}
                                                

// @LINE:42
def generateMetrics(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "management/metrics")
}
                                                

// @LINE:37
def addStock(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "management/stock/add")
}
                                                

// @LINE:41
def playerToggle(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "management/player/toggle")
}
                                                

// @LINE:38
def deleteStock(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "management/stock/delete")
}
                                                

// @LINE:40
def player(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "management/player")
}
                                                

// @LINE:35
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "management")
}
                                                
    
}
                          

// @LINE:15
// @LINE:14
// @LINE:10
class ReverseLoginController {
    

// @LINE:15
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                

// @LINE:14
def register(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "register")
}
                                                

// @LINE:10
def login(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                                                
    
}
                          

// @LINE:17
// @LINE:9
class ReverseApplication {
    

// @LINE:17
def dashboard(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "dashboard")
}
                                                

// @LINE:9
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          
}
                  


// @LINE:46
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:15
// @LINE:14
// @LINE:10
// @LINE:9
package controllers.javascript {

// @LINE:46
class ReverseAssets {
    

// @LINE:46
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
class ReverseGameController {
    

// @LINE:28
def buyStock : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.GameController.buyStock",
   """
      function(gameId) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "game/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("gameId", gameId) + "/stock/buy"})
      }
   """
)
                        

// @LINE:26
def start : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.GameController.start",
   """
      function(gameId) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "game/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("gameId", gameId) + "/start"})
      }
   """
)
                        

// @LINE:20
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.GameController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "game/create"})
      }
   """
)
                        

// @LINE:24
def gameStatus : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.GameController.gameStatus",
   """
      function(gameId) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "game/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("gameId", gameId) + "/status"})
      }
   """
)
                        

// @LINE:25
def leave : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.GameController.leave",
   """
      function(gameId) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "game/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("gameId", gameId) + "/leave"})
      }
   """
)
                        

// @LINE:22
def stockList : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.GameController.stockList",
   """
      function(gameId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "game/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("gameId", gameId) + "/stock/list"})
      }
   """
)
                        

// @LINE:27
def cancel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.GameController.cancel",
   """
      function(gameId) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "game/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("gameId", gameId) + "/cancel"})
      }
   """
)
                        

// @LINE:23
def stockPrice : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.GameController.stockPrice",
   """
      function(gameId,ticker) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "game/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("gameId", gameId) + "/stock/price/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("ticker", encodeURIComponent(ticker))})
      }
   """
)
                        

// @LINE:21
def playGame : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.GameController.playGame",
   """
      function(gameId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "game/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("gameId", gameId) + "/playGame"})
      }
   """
)
                        

// @LINE:29
def sellStock : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.GameController.sellStock",
   """
      function(gameId) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "game/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("gameId", gameId) + "/stock/sell"})
      }
   """
)
                        
    
}
              

// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
class ReverseManagementController {
    

// @LINE:36
def stockList : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ManagementController.stockList",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "management/stock"})
      }
   """
)
                        

// @LINE:39
def toggleStock : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ManagementController.toggleStock",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "management/stock/toggle"})
      }
   """
)
                        

// @LINE:42
def generateMetrics : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ManagementController.generateMetrics",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "management/metrics"})
      }
   """
)
                        

// @LINE:37
def addStock : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ManagementController.addStock",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "management/stock/add"})
      }
   """
)
                        

// @LINE:41
def playerToggle : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ManagementController.playerToggle",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "management/player/toggle"})
      }
   """
)
                        

// @LINE:38
def deleteStock : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ManagementController.deleteStock",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "management/stock/delete"})
      }
   """
)
                        

// @LINE:40
def player : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ManagementController.player",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "management/player"})
      }
   """
)
                        

// @LINE:35
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ManagementController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "management"})
      }
   """
)
                        
    
}
              

// @LINE:15
// @LINE:14
// @LINE:10
class ReverseLoginController {
    

// @LINE:15
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.LoginController.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:14
def register : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.LoginController.register",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "register"})
      }
   """
)
                        

// @LINE:10
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.LoginController.login",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        
    
}
              

// @LINE:17
// @LINE:9
class ReverseApplication {
    

// @LINE:17
def dashboard : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.dashboard",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dashboard"})
      }
   """
)
                        

// @LINE:9
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:46
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:15
// @LINE:14
// @LINE:10
// @LINE:9
package controllers.ref {


// @LINE:46
class ReverseAssets {
    

// @LINE:46
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /public path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
class ReverseGameController {
    

// @LINE:28
def buyStock(gameId:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.GameController.buyStock(gameId), HandlerDef(this, "controllers.GameController", "buyStock", Seq(classOf[Integer]), "POST", """""", _prefix + """game/$gameId<[^/]+>/stock/buy""")
)
                      

// @LINE:26
def start(gameId:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.GameController.start(gameId), HandlerDef(this, "controllers.GameController", "start", Seq(classOf[Integer]), "POST", """""", _prefix + """game/$gameId<[^/]+>/start""")
)
                      

// @LINE:20
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.GameController.create(), HandlerDef(this, "controllers.GameController", "create", Seq(), "POST", """game controller""", _prefix + """game/create""")
)
                      

// @LINE:24
def gameStatus(gameId:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.GameController.gameStatus(gameId), HandlerDef(this, "controllers.GameController", "gameStatus", Seq(classOf[Integer]), "POST", """""", _prefix + """game/$gameId<[^/]+>/status""")
)
                      

// @LINE:25
def leave(gameId:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.GameController.leave(gameId), HandlerDef(this, "controllers.GameController", "leave", Seq(classOf[Integer]), "POST", """""", _prefix + """game/$gameId<[^/]+>/leave""")
)
                      

// @LINE:22
def stockList(gameId:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.GameController.stockList(gameId), HandlerDef(this, "controllers.GameController", "stockList", Seq(classOf[Integer]), "GET", """""", _prefix + """game/$gameId<[^/]+>/stock/list""")
)
                      

// @LINE:27
def cancel(gameId:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.GameController.cancel(gameId), HandlerDef(this, "controllers.GameController", "cancel", Seq(classOf[Integer]), "POST", """""", _prefix + """game/$gameId<[^/]+>/cancel""")
)
                      

// @LINE:23
def stockPrice(gameId:Integer, ticker:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.GameController.stockPrice(gameId, ticker), HandlerDef(this, "controllers.GameController", "stockPrice", Seq(classOf[Integer], classOf[String]), "GET", """""", _prefix + """game/$gameId<[^/]+>/stock/price/$ticker<[^/]+>""")
)
                      

// @LINE:21
def playGame(gameId:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.GameController.playGame(gameId), HandlerDef(this, "controllers.GameController", "playGame", Seq(classOf[Integer]), "GET", """""", _prefix + """game/$gameId<[^/]+>/playGame""")
)
                      

// @LINE:29
def sellStock(gameId:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.GameController.sellStock(gameId), HandlerDef(this, "controllers.GameController", "sellStock", Seq(classOf[Integer]), "POST", """""", _prefix + """game/$gameId<[^/]+>/stock/sell""")
)
                      
    
}
                          

// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
class ReverseManagementController {
    

// @LINE:36
def stockList(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ManagementController.stockList(), HandlerDef(this, "controllers.ManagementController", "stockList", Seq(), "GET", """""", _prefix + """management/stock""")
)
                      

// @LINE:39
def toggleStock(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ManagementController.toggleStock(), HandlerDef(this, "controllers.ManagementController", "toggleStock", Seq(), "POST", """""", _prefix + """management/stock/toggle""")
)
                      

// @LINE:42
def generateMetrics(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ManagementController.generateMetrics(), HandlerDef(this, "controllers.ManagementController", "generateMetrics", Seq(), "POST", """""", _prefix + """management/metrics""")
)
                      

// @LINE:37
def addStock(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ManagementController.addStock(), HandlerDef(this, "controllers.ManagementController", "addStock", Seq(), "POST", """""", _prefix + """management/stock/add""")
)
                      

// @LINE:41
def playerToggle(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ManagementController.playerToggle(), HandlerDef(this, "controllers.ManagementController", "playerToggle", Seq(), "POST", """""", _prefix + """management/player/toggle""")
)
                      

// @LINE:38
def deleteStock(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ManagementController.deleteStock(), HandlerDef(this, "controllers.ManagementController", "deleteStock", Seq(), "POST", """""", _prefix + """management/stock/delete""")
)
                      

// @LINE:40
def player(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ManagementController.player(), HandlerDef(this, "controllers.ManagementController", "player", Seq(), "POST", """""", _prefix + """management/player""")
)
                      

// @LINE:35
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ManagementController.index(), HandlerDef(this, "controllers.ManagementController", "index", Seq(), "GET", """admin related function...""", _prefix + """management""")
)
                      
    
}
                          

// @LINE:15
// @LINE:14
// @LINE:10
class ReverseLoginController {
    

// @LINE:15
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.LoginController.logout(), HandlerDef(this, "controllers.LoginController", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:14
def register(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.LoginController.register(), HandlerDef(this, "controllers.LoginController", "register", Seq(), "POST", """ Authentication
POST    /login                         controllers.LoginController.authenticate()
GET 	/register			controllers.LoginController.register()""", _prefix + """register""")
)
                      

// @LINE:10
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.LoginController.login(), HandlerDef(this, "controllers.LoginController", "login", Seq(), "POST", """""", _prefix + """login""")
)
                      
    
}
                          

// @LINE:17
// @LINE:9
class ReverseApplication {
    

// @LINE:17
def dashboard(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.dashboard(), HandlerDef(this, "controllers.Application", "dashboard", Seq(), "GET", """""", _prefix + """dashboard""")
)
                      

// @LINE:9
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """""", _prefix + """""")
)
                      
    
}
                          
}
        
    