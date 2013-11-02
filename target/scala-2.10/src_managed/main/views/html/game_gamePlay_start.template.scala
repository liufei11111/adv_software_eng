
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object game_gamePlay_start extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<div class="gameScreen hide" id="startScreen" ng-controller="StartCtrl">
    <div class="gameName">"""),format.raw/*2.27*/("""{"""),format.raw/*2.28*/("""{"""),format.raw/*2.29*/("""appName"""),format.raw/*2.36*/("""}"""),format.raw/*2.37*/("""}"""),format.raw/*2.38*/("""</div>
    <div class="gameTitle">
        """),format.raw/*4.9*/("""{"""),format.raw/*4.10*/("""{"""),format.raw/*4.11*/("""gameState.title"""),format.raw/*4.26*/("""}"""),format.raw/*4.27*/("""}"""),format.raw/*4.28*/("""
    </div>
    <div class="row-fluid">
        <div class="span8">
            <div class="gameDetails row-fluid">
                <div class="openingBalance span6">
                    <span>Opening Balance</span> $"""),format.raw/*10.51*/("""{"""),format.raw/*10.52*/("""{"""),format.raw/*10.53*/("""format(gameState.myAccount.openingBalance)"""),format.raw/*10.95*/("""}"""),format.raw/*10.96*/("""}"""),format.raw/*10.97*/("""
                </div>

                <div class="playersCount span6">
                    <span>Players</span> """),format.raw/*14.42*/("""{"""),format.raw/*14.43*/("""{"""),format.raw/*14.44*/("""count(gameState.players)"""),format.raw/*14.68*/("""}"""),format.raw/*14.69*/("""}"""),format.raw/*14.70*/("""/"""),format.raw/*14.71*/("""{"""),format.raw/*14.72*/("""{"""),format.raw/*14.73*/("""gameState.maxPlayers"""),format.raw/*14.93*/("""}"""),format.raw/*14.94*/("""}"""),format.raw/*14.95*/("""
                </div>
                <div class="clearfix"></div>
                <div class="gameOwner">
                    <span>Created by: </span> """),format.raw/*18.47*/("""{"""),format.raw/*18.48*/("""{"""),format.raw/*18.49*/("""gameState.owner.firstName"""),format.raw/*18.74*/("""}"""),format.raw/*18.75*/("""}"""),format.raw/*18.76*/(""" """),format.raw/*18.77*/("""{"""),format.raw/*18.78*/("""{"""),format.raw/*18.79*/("""gameState.owner.lastName"""),format.raw/*18.103*/("""}"""),format.raw/*18.104*/("""}"""),format.raw/*18.105*/("""
                </div>
            </div>
        </div>
        <div class="span4 gamePlayers">
            <div class="gameHeading" style="margin-right: -15px; margin-left: 0;">
                Current Players
            </div>
            <div class="arrow arrow-left" style="margin-left: 20px;"></div>
            <div class="clearfix"></div>
            <ol>
                <li ng-repeat="player in gameState.players|orderBy:'rank'">
                    """),format.raw/*30.21*/("""{"""),format.raw/*30.22*/("""{"""),format.raw/*30.23*/("""player.firstName"""),format.raw/*30.39*/("""}"""),format.raw/*30.40*/("""}"""),format.raw/*30.41*/(""" """),format.raw/*30.42*/("""{"""),format.raw/*30.43*/("""{"""),format.raw/*30.44*/("""player.lastName"""),format.raw/*30.59*/("""}"""),format.raw/*30.60*/("""}"""),format.raw/*30.61*/("""
                </li>
            </ol>
        </div>

    </div>
    <div class="clearfix"></div>
    <div ng-if="iAmOwner()" style="text-align: center;">
        <div class="btn-group" >
            <a class="btn btn-large btn-success" href="#" ng-click="start()" onclick="return false;">Start Game</a>
            <a onclick="return false;" class="btn btn-large btn-warning" href="#" ng-click="cancel()">Cancel Game</a>
        </div>
    </div>

    <div ng-if="!iAmOwner()" style="text-align: center;">
        <div>
            <a class="btn btn-large btn-warning" href="#" ng-click="leave()" onclick="return false;">Leave Game</a>
        </div>
    </div>


</div>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Oct 30 19:24:24 EDT 2013
                    SOURCE: /Users/feiliu/git/omniwin/app/views/game_gamePlay_start.scala.html
                    HASH: 50e1345c2e006e3e65076b9dec21adaba839e54a
                    MATRIX: 869->0|995->99|1023->100|1051->101|1085->108|1113->109|1141->110|1210->153|1238->154|1266->155|1308->170|1336->171|1364->172|1609->389|1638->390|1667->391|1737->433|1766->434|1795->435|1938->550|1967->551|1996->552|2048->576|2077->577|2106->578|2135->579|2164->580|2193->581|2241->601|2270->602|2299->603|2482->758|2511->759|2540->760|2593->785|2622->786|2651->787|2680->788|2709->789|2738->790|2791->814|2821->815|2851->816|3341->1278|3370->1279|3399->1280|3443->1296|3472->1297|3501->1298|3530->1299|3559->1300|3588->1301|3631->1316|3660->1317|3689->1318
                    LINES: 29->1|30->2|30->2|30->2|30->2|30->2|30->2|32->4|32->4|32->4|32->4|32->4|32->4|38->10|38->10|38->10|38->10|38->10|38->10|42->14|42->14|42->14|42->14|42->14|42->14|42->14|42->14|42->14|42->14|42->14|42->14|46->18|46->18|46->18|46->18|46->18|46->18|46->18|46->18|46->18|46->18|46->18|46->18|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30
                    -- GENERATED --
                */
            