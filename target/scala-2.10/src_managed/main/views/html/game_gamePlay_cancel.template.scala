
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
object game_gamePlay_cancel extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<div class="gameScreen hide" id="cancelScreen">
    <div class="gameName">
        """),format.raw/*3.9*/("""{"""),format.raw/*3.10*/("""{"""),format.raw/*3.11*/("""appName"""),format.raw/*3.18*/("""}"""),format.raw/*3.19*/("""}"""),format.raw/*3.20*/("""
    </div>
    <div class="gameTitle">
        """),format.raw/*6.9*/("""{"""),format.raw/*6.10*/("""{"""),format.raw/*6.11*/("""gameState.title"""),format.raw/*6.26*/("""}"""),format.raw/*6.27*/("""}"""),format.raw/*6.28*/("""
    </div>
    <div class="gameMessage alert alert-warning">
        Sorry, game has been canceled!
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
                    SOURCE: /Users/feiliu/git/omniwin/app/views/game_gamePlay_cancel.scala.html
                    HASH: 3f4c2dbe719191dc2b2f2c620f18b4f0ae06d4aa
                    MATRIX: 870->0|979->83|1007->84|1035->85|1069->92|1097->93|1125->94|1199->142|1227->143|1255->144|1297->159|1325->160|1353->161
                    LINES: 29->1|31->3|31->3|31->3|31->3|31->3|31->3|34->6|34->6|34->6|34->6|34->6|34->6
                    -- GENERATED --
                */
            