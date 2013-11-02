
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
object game_playGame extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[models.data.Game,com.fasterxml.jackson.databind.node.ObjectNode,com.fasterxml.jackson.databind.node.ArrayNode,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(game : models.data.Game, gameState : com.fasterxml.jackson.databind.node.ObjectNode, stockList : com.fasterxml.jackson.databind.node.ArrayNode):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.146*/("""
"""),_display_(Seq[Any](/*2.2*/layout("Game Play ("+game.getGameTitle() +")")/*2.48*/{_display_(Seq[Any](format.raw/*2.49*/("""
<script>
    var gameState = """),_display_(Seq[Any](/*4.22*/Html(gameState.toString()))),format.raw/*4.48*/(""";
    var gameId = """),_display_(Seq[Any](/*5.19*/game/*5.23*/.getId())),format.raw/*5.31*/(""";
    var availableStocks = """),_display_(Seq[Any](/*6.28*/Html(stockList.toString()))),format.raw/*6.54*/(""";
    var appName = '"""),_display_(Seq[Any](/*7.21*/play/*7.25*/.Play.application().configuration().getString("application.name"))),format.raw/*7.90*/("""';
    var gameRoutes = """),format.raw/*8.22*/("""{"""),format.raw/*8.23*/("""
        refresh: '"""),_display_(Seq[Any](/*9.20*/routes/*9.26*/.GameController.gameStatus(game.getId()))),format.raw/*9.66*/("""'
        , leave: '"""),_display_(Seq[Any](/*10.20*/routes/*10.26*/.GameController.leave(game.getId()))),format.raw/*10.61*/("""'
        , start: '"""),_display_(Seq[Any](/*11.20*/routes/*11.26*/.GameController.start(game.getId()))),format.raw/*11.61*/("""'
        , cancel: '"""),_display_(Seq[Any](/*12.21*/routes/*12.27*/.GameController.cancel(game.getId()))),format.raw/*12.63*/("""'
        , priceList: '"""),_display_(Seq[Any](/*13.24*/routes/*13.30*/.GameController.stockPrice(game.getId(), "_TICKER_"))),format.raw/*13.82*/("""'
        , stockList: '"""),_display_(Seq[Any](/*14.24*/routes/*14.30*/.GameController.stockList(game.getId()))),format.raw/*14.69*/("""'
        , buyStock: '"""),_display_(Seq[Any](/*15.23*/routes/*15.29*/.GameController.buyStock(game.getId()))),format.raw/*15.67*/("""'
        , sellStock: '"""),_display_(Seq[Any](/*16.24*/routes/*16.30*/.GameController.sellStock(game.getId()))),format.raw/*16.69*/("""'
    """),format.raw/*17.5*/("""}"""),format.raw/*17.6*/(""";
</script>
<link href='"""),_display_(Seq[Any](/*19.14*/routes/*19.20*/.Assets.at("plugins/loading/jquery.loadmask.css"))),format.raw/*19.69*/("""' rel="stylesheet">
<link href='"""),_display_(Seq[Any](/*20.14*/routes/*20.20*/.Assets.at("plugins/jquery.toast/jquery.toast.css"))),format.raw/*20.71*/("""' rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Fondamento' rel='stylesheet' type='text/css'>
<script src='"""),_display_(Seq[Any](/*22.15*/routes/*22.21*/.Assets.at("plugins/jquery.toast/jquery.toast.js"))),format.raw/*22.71*/("""'></script>
<script src='"""),_display_(Seq[Any](/*23.15*/routes/*23.21*/.Assets.at("plugins/loading/jquery.loadmask.min.js"))),format.raw/*23.73*/("""'></script>
<script src='"""),_display_(Seq[Any](/*24.15*/routes/*24.21*/.Assets.at("plugins/highstock/highstock.js"))),format.raw/*24.65*/("""'></script>
<script src='"""),_display_(Seq[Any](/*25.15*/routes/*25.21*/.Assets.at("js/angular.min.js"))),format.raw/*25.52*/("""'></script>
<script src='"""),_display_(Seq[Any](/*26.15*/routes/*26.21*/.Assets.at("js/angular-route.min.js"))),format.raw/*26.58*/("""'></script>
<script src='"""),_display_(Seq[Any](/*27.15*/routes/*27.21*/.Assets.at("js/gameApp.js"))),format.raw/*27.48*/("""'></script>

<h2 style="text-align: center;">Game Play</h2>
"""),_display_(Seq[Any](/*30.2*/defining(Controller.flash("game_created"))/*30.44*/{successMsg=>_display_(Seq[Any](format.raw/*30.57*/("""
"""),_display_(Seq[Any](/*31.2*/if(successMsg != null)/*31.24*/{_display_(Seq[Any](format.raw/*31.25*/("""
<div class="alert alert-success">
    """),_display_(Seq[Any](/*33.6*/successMsg)),format.raw/*33.16*/("""
</div>
""")))})),format.raw/*35.2*/("""
""")))})),format.raw/*36.2*/("""

<div>
    <div id="sharePanel" class="hide">
        <!-- AddThis Button BEGIN -->
        <div style="text-align: center; font-weight: bold;">
            Share Game
        </div>
        <div class="addthis_toolbox addthis_default_style addthis_32x32_style" style="text-align: center;">
            <a class="addthis_button_preferred_1"></a>
            <a class="addthis_button_preferred_2"></a>
            <a class="addthis_button_preferred_3"></a>
            <a class="addthis_button_preferred_4"></a>
        </div>
        <script type="text/javascript">var addthis_config = """),format.raw/*50.61*/("""{"""),format.raw/*50.62*/(""""data_track_addressbar": true"""),format.raw/*50.91*/("""}"""),format.raw/*50.92*/(""";</script>
        <script type="text/javascript" src="//s7.addthis.com/js/300/addthis_widget.js#pubid=ra-5271af4051bdd17d"></script>
        <!-- AddThis Button END -->

    </div>

    <div class="gamePanel" id="gamePanel" ng-app='gameApp'>
        <div ng-view class="gameScreen"></div>
    </div>
</div>
<br/>
"""),_display_(Seq[Any](/*61.2*/game_gamePlay_end())),format.raw/*61.21*/("""
"""),_display_(Seq[Any](/*62.2*/game_gamePlay_cancel())),format.raw/*62.24*/("""
"""),_display_(Seq[Any](/*63.2*/game_gamePlay_leave())),format.raw/*63.23*/("""
"""),_display_(Seq[Any](/*64.2*/game_gamePlay_play())),format.raw/*64.22*/("""
"""),_display_(Seq[Any](/*65.2*/game_gamePlay_start())),format.raw/*65.23*/("""
""")))})))}
    }
    
    def render(game:models.data.Game,gameState:com.fasterxml.jackson.databind.node.ObjectNode,stockList:com.fasterxml.jackson.databind.node.ArrayNode): play.api.templates.HtmlFormat.Appendable = apply(game,gameState,stockList)
    
    def f:((models.data.Game,com.fasterxml.jackson.databind.node.ObjectNode,com.fasterxml.jackson.databind.node.ArrayNode) => play.api.templates.HtmlFormat.Appendable) = (game,gameState,stockList) => apply(game,gameState,stockList)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Oct 31 16:34:40 EDT 2013
                    SOURCE: /Users/feiliu/git/omniwin/app/views/game_playGame.scala.html
                    HASH: a30e4fadc359b0e89b6b1e7204c734ab9a348bf2
                    MATRIX: 885->1|1124->145|1160->147|1214->193|1252->194|1318->225|1365->251|1420->271|1432->275|1461->283|1525->312|1572->338|1629->360|1641->364|1727->429|1778->453|1806->454|1861->474|1875->480|1936->520|1993->541|2008->547|2065->582|2122->603|2137->609|2194->644|2252->666|2267->672|2325->708|2386->733|2401->739|2475->791|2536->816|2551->822|2612->861|2672->885|2687->891|2747->929|2808->954|2823->960|2884->999|2917->1005|2945->1006|3006->1031|3021->1037|3092->1086|3161->1119|3176->1125|3249->1176|3416->1307|3431->1313|3503->1363|3565->1389|3580->1395|3654->1447|3716->1473|3731->1479|3797->1523|3859->1549|3874->1555|3927->1586|3989->1612|4004->1618|4063->1655|4125->1681|4140->1687|4189->1714|4285->1775|4336->1817|4387->1830|4424->1832|4455->1854|4494->1855|4569->1895|4601->1905|4641->1914|4674->1916|5289->2503|5318->2504|5375->2533|5404->2534|5754->2849|5795->2868|5832->2870|5876->2892|5913->2894|5956->2915|5993->2917|6035->2937|6072->2939|6115->2960
                    LINES: 26->1|29->1|30->2|30->2|30->2|32->4|32->4|33->5|33->5|33->5|34->6|34->6|35->7|35->7|35->7|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|47->19|47->19|47->19|48->20|48->20|48->20|50->22|50->22|50->22|51->23|51->23|51->23|52->24|52->24|52->24|53->25|53->25|53->25|54->26|54->26|54->26|55->27|55->27|55->27|58->30|58->30|58->30|59->31|59->31|59->31|61->33|61->33|63->35|64->36|78->50|78->50|78->50|78->50|89->61|89->61|90->62|90->62|91->63|91->63|92->64|92->64|93->65|93->65
                    -- GENERATED --
                */
            