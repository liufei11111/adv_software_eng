
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
object game_playGame_notFound extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/layout("Game was Not Found")/*1.30*/{_display_(Seq[Any](format.raw/*1.31*/("""

<h2>Game not Found</h2>

<div class="alert alert-error">
    The game you are looking for was not found. Please check the link you supplied.
</div>
""")))})),format.raw/*8.2*/("""
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Oct 28 15:04:06 EDT 2013
                    SOURCE: /Users/feiliu/git/omniwin/app/views/game_playGame_notFound.scala.html
                    HASH: fc944abb46871334562fe10a7024a6c38741e706
                    MATRIX: 881->1|917->29|955->30|1136->181
                    LINES: 29->1|29->1|29->1|36->8
                    -- GENERATED --
                */
            