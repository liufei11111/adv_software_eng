
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
object game_playGame_cant_join extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[models.data.Game,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(game: models.data.Game, isJoinError: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.48*/("""
"""),_display_(Seq[Any](/*2.2*/layout("Game Error")/*2.22*/{_display_(Seq[Any](format.raw/*2.23*/("""
<h2>Game Error</h2>

"""),_display_(Seq[Any](/*5.2*/if(isJoinError)/*5.17*/{_display_(Seq[Any](format.raw/*5.18*/("""
<div class="alert alert-warning">
    It seems this game has already reached its maximum number of players!
</div>
""")))}/*9.2*/else/*9.6*/{_display_(Seq[Any](format.raw/*9.7*/("""
<div class="alert alert-warning">
    You can no longer join this game because <strong>it has already """),_display_(Seq[Any](/*11.70*/if(game.isStarted())/*11.90*/{_display_(Seq[Any](format.raw/*11.91*/("""started""")))}/*11.99*/else/*11.103*/{_display_(Seq[Any](format.raw/*11.104*/("""ended""")))})),format.raw/*11.110*/("""!</strong>
</div>
""")))})),format.raw/*13.2*/("""
""")))})))}
    }
    
    def render(game:models.data.Game,isJoinError:Boolean): play.api.templates.HtmlFormat.Appendable = apply(game,isJoinError)
    
    def f:((models.data.Game,Boolean) => play.api.templates.HtmlFormat.Appendable) = (game,isJoinError) => apply(game,isJoinError)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Oct 28 15:04:06 EDT 2013
                    SOURCE: /Users/feiliu/git/omniwin/app/views/game_playGame_cant_join.scala.html
                    HASH: 0804064fe057348b9033a7202f8049d376188604
                    MATRIX: 810->1|950->47|986->49|1014->69|1052->70|1109->93|1132->108|1170->109|1304->226|1315->230|1352->231|1492->335|1521->355|1560->356|1587->364|1601->368|1641->369|1680->375|1730->394
                    LINES: 26->1|29->1|30->2|30->2|30->2|33->5|33->5|33->5|37->9|37->9|37->9|39->11|39->11|39->11|39->11|39->11|39->11|39->11|41->13
                    -- GENERATED --
                */
            