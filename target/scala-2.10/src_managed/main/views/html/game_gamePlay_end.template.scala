
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
object game_gamePlay_end extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<div class="gameScreen hide" id="endScreen">
    <div>
        <div class="gameTitle" style="margin-top: 10px;">
            """),format.raw/*4.13*/("""{"""),format.raw/*4.14*/("""{"""),format.raw/*4.15*/("""gameState.title"""),format.raw/*4.30*/("""}"""),format.raw/*4.31*/("""}"""),format.raw/*4.32*/("""
        </div>
    </div>
    <div class="gameMessage alert alert-info">
        Game Over
    </div>

    <div class="gameOverMessage">
        <div>
            <div class="gameHeading" style="margin-right: -15px;">
                Leader Board
            </div>
            <div class="arrow arrow-left"></div>
            <div class="clearfix"></div>
        </div>
        <div class="row-fluid" ng-init="playersList=playersArray();">
            <div class="span6 gamePlayer" ng-repeat="player in playersList |orderBy:'rank'">
                <div ng-if="player.id==gameState.currentPlayer.id"  class="isMe">
                    <span class="label label-info">"""),format.raw/*22.52*/("""{"""),format.raw/*22.53*/("""{"""),format.raw/*22.54*/("""pos(player.rank)"""),format.raw/*22.70*/("""}"""),format.raw/*22.71*/("""}"""),format.raw/*22.72*/("""</span> """),format.raw/*22.80*/("""{"""),format.raw/*22.81*/("""{"""),format.raw/*22.82*/("""player.firstName"""),format.raw/*22.98*/("""}"""),format.raw/*22.99*/("""}"""),format.raw/*22.100*/(""" """),format.raw/*22.101*/("""{"""),format.raw/*22.102*/("""{"""),format.raw/*22.103*/("""player.lastName"""),format.raw/*22.118*/("""}"""),format.raw/*22.119*/("""}"""),format.raw/*22.120*/("""
                </div>

                <div ng-if="player.id!=gameState.currentPlayer.id">
                    <span class="label label-info">"""),format.raw/*26.52*/("""{"""),format.raw/*26.53*/("""{"""),format.raw/*26.54*/("""pos(player.rank)"""),format.raw/*26.70*/("""}"""),format.raw/*26.71*/("""}"""),format.raw/*26.72*/("""</span> """),format.raw/*26.80*/("""{"""),format.raw/*26.81*/("""{"""),format.raw/*26.82*/("""player.firstName"""),format.raw/*26.98*/("""}"""),format.raw/*26.99*/("""}"""),format.raw/*26.100*/(""" """),format.raw/*26.101*/("""{"""),format.raw/*26.102*/("""{"""),format.raw/*26.103*/("""player.lastName"""),format.raw/*26.118*/("""}"""),format.raw/*26.119*/("""}"""),format.raw/*26.120*/("""
                </div>
            </div>
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
                    DATE: Thu Oct 31 16:44:07 EDT 2013
                    SOURCE: /Users/feiliu/git/omniwin/app/views/game_gamePlay_end.scala.html
                    HASH: b4887efcdc4e089fafa6a0c9f0d54e6c38b2614a
                    MATRIX: 867->0|1019->125|1047->126|1075->127|1117->142|1145->143|1173->144|1869->812|1898->813|1927->814|1971->830|2000->831|2029->832|2065->840|2094->841|2123->842|2167->858|2196->859|2226->860|2256->861|2286->862|2316->863|2360->878|2390->879|2420->880|2592->1024|2621->1025|2650->1026|2694->1042|2723->1043|2752->1044|2788->1052|2817->1053|2846->1054|2890->1070|2919->1071|2949->1072|2979->1073|3009->1074|3039->1075|3083->1090|3113->1091|3143->1092
                    LINES: 29->1|32->4|32->4|32->4|32->4|32->4|32->4|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26
                    -- GENERATED --
                */
            