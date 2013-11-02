
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
object game_gamePlay_leave extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<div class="gameScreen hide" id="leaveScreen">
    <div class="gameName">"""),_display_(Seq[Any](/*2.28*/play/*2.32*/.Play.application().configuration().getString("application.name"))),format.raw/*2.97*/("""</div>
    <div class="gameTitle">
        """),format.raw/*4.9*/("""{"""),format.raw/*4.10*/("""{"""),format.raw/*4.11*/("""gameState.title"""),format.raw/*4.26*/("""}"""),format.raw/*4.27*/("""}"""),format.raw/*4.28*/("""
    </div>
    <div class="gameMessage alert alert-warning">
        You have successfully left the game!
    </div>
</div>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Oct 30 19:24:23 EDT 2013
                    SOURCE: /Users/feiliu/git/omniwin/app/views/game_gamePlay_leave.scala.html
                    HASH: 213a9ed8d2344f62af2be9e1cd865ce75da74bf6
                    MATRIX: 869->0|978->74|990->78|1076->143|1145->186|1173->187|1201->188|1243->203|1271->204|1299->205
                    LINES: 29->1|30->2|30->2|30->2|32->4|32->4|32->4|32->4|32->4|32->4
                    -- GENERATED --
                */
            