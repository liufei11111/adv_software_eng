
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
object game_gamePlay_play extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<div class="gameScreen hide" id="playScreen">
    <div>
        <div class="gameTitle" style="margin-top: 10px;">
            """),format.raw/*4.13*/("""{"""),format.raw/*4.14*/("""{"""),format.raw/*4.15*/("""gameState.title"""),format.raw/*4.30*/("""}"""),format.raw/*4.31*/("""}"""),format.raw/*4.32*/("""
        </div>
    </div>

    <div class="row-fluid">
        <div class="span9">
            <div class="nowTrading"> 
                <div>
                    <div class="gameHeading" style="margin-right: -15px;">
                        Now Trading
                    </div>
                    <div class="arrow arrow-left"></div>
                    <div class="clearfix"></div>
                </div>
                <div class="stockList row-fluid" title="Click on company name to see Price Trend">
                    <div class="span5" ng-repeat="stock in stockList|orderBy: 'ticker'">
                        <a href="#" onclick="return false;" title="View price history of """),format.raw/*20.90*/("""{"""),format.raw/*20.91*/("""{"""),format.raw/*20.92*/("""stock.company"""),format.raw/*20.105*/("""}"""),format.raw/*20.106*/("""}"""),format.raw/*20.107*/("""" ng-click="showHistory(stock.ticker)">
                            <span class="label label-info">
                                """),format.raw/*22.33*/("""{"""),format.raw/*22.34*/("""{"""),format.raw/*22.35*/("""stock.ticker"""),format.raw/*22.47*/("""}"""),format.raw/*22.48*/("""}"""),format.raw/*22.49*/("""
                            </span> 
                            """),format.raw/*24.29*/("""{"""),format.raw/*24.30*/("""{"""),format.raw/*24.31*/("""stock.company"""),format.raw/*24.44*/("""}"""),format.raw/*24.45*/("""}"""),format.raw/*24.46*/("""
                        </a>

                        <a ng-click="buy(stock)" class="btn btn-mini btn-success" onclick="return false;" ng-if="stock.price>0">
                            buy at $"""),format.raw/*28.37*/("""{"""),format.raw/*28.38*/("""{"""),format.raw/*28.39*/("""format(stock.price)"""),format.raw/*28.58*/("""}"""),format.raw/*28.59*/("""}"""),format.raw/*28.60*/("""
                        </a>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>

            <div class="row-fluid">
                <div class="span7">
                    <div>
                        <div class="gameHeading">
                            Portfolio
                        </div>
                        <div class="arrow arrow-left"></div>
                        <div class="clearfix"></div>
                    </div>

                    <div class="clearfix"></div>

                    <div class="stockList row-fluid" ng-if="gameState.myPortfolio.length > 0" style="max-width: 360px;">
                        <table class="table table-striped">
                            <tr>
                                <td>Ticker</td>
                                <td>Qty</td>
                                <td>Value</td>
                                <td></td>
                            </tr>
                            <tr ng-repeat="portfolioStock in gameState.myPortfolio">
                                <td>
                                    <a href="#" onclick="return false;" title="View price history of """),format.raw/*57.102*/("""{"""),format.raw/*57.103*/("""{"""),format.raw/*57.104*/("""stock.company"""),format.raw/*57.117*/("""}"""),format.raw/*57.118*/("""}"""),format.raw/*57.119*/("""" ng-click="showHistory(portfolioStock.ticker)">
                                        <span class="label label-info">
                                            """),format.raw/*59.45*/("""{"""),format.raw/*59.46*/("""{"""),format.raw/*59.47*/("""portfolioStock.ticker"""),format.raw/*59.68*/("""}"""),format.raw/*59.69*/("""}"""),format.raw/*59.70*/("""
                                        </span> 
                                    </a>
                                </td>

                                <td>
                                    """),format.raw/*65.37*/("""{"""),format.raw/*65.38*/("""{"""),format.raw/*65.39*/("""portfolioStock.quantity"""),format.raw/*65.62*/("""}"""),format.raw/*65.63*/("""}"""),format.raw/*65.64*/("""
                                </td>
                                <td>
                                    $"""),format.raw/*68.38*/("""{"""),format.raw/*68.39*/("""{"""),format.raw/*68.40*/("""format(portfolioStock.quantity * portfolioStock.currentPrice)"""),format.raw/*68.101*/("""}"""),format.raw/*68.102*/("""}"""),format.raw/*68.103*/("""
                                </td>
                                <td>
                                    <a ng-click="sell(portfolioStock)" class="btn btn-mini btn-success" onclick="return false;" ng-if="portfolioStock.currentPrice>0">
                                        sell at $"""),format.raw/*72.50*/("""{"""),format.raw/*72.51*/("""{"""),format.raw/*72.52*/("""format(portfolioStock.currentPrice)"""),format.raw/*72.87*/("""}"""),format.raw/*72.88*/("""}"""),format.raw/*72.89*/("""
                                    </a>
                                </td>
                            </tr>

                        </table>

                    </div>

                    <div ng-if="gameState.myPortfolio.length < 1" class="alert alert-info">
                        You stock portfolio is empty.
                    </div>
                </div>
                <div class="span5">
                    <div>
                        <div class="gameHeading" style="margin-left: 0;">
                            My Account
                        </div>
                        <div class="arrow arrow-left" style="margin-left: 10px;"s></div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="alert alert-info">
                        <div>
                            <strong>Opening Bal.</strong> $ """),format.raw/*95.61*/("""{"""),format.raw/*95.62*/("""{"""),format.raw/*95.63*/("""format(gameState.myAccount.openingBalance)"""),format.raw/*95.105*/("""}"""),format.raw/*95.106*/("""}"""),format.raw/*95.107*/("""
                        </div>

                        <div>
                            <strong>Current Bal.</strong> $ """),format.raw/*99.61*/("""{"""),format.raw/*99.62*/("""{"""),format.raw/*99.63*/("""format(gameState.myAccount.currentBalance)"""),format.raw/*99.105*/("""}"""),format.raw/*99.106*/("""}"""),format.raw/*99.107*/("""
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="span3 gameInfo">
            <div>
                <div class="gameHeading">
                    Game Status
                </div>
                <div class="arrow arrow-left" style="margin-left: 10px;"s></div>
                <div class="clearfix"></div>
            </div>
            <div class="tradingInfo" style="padding-left: 15px;">
                <span>Trading Day </span> """),format.raw/*115.43*/("""{"""),format.raw/*115.44*/("""{"""),format.raw/*115.45*/("""gameState.currentGameDay"""),format.raw/*115.69*/("""}"""),format.raw/*115.70*/("""}"""),format.raw/*115.71*/(""" of """),format.raw/*115.75*/("""{"""),format.raw/*115.76*/("""{"""),format.raw/*115.77*/("""gameState.gameLength"""),format.raw/*115.97*/("""}"""),format.raw/*115.98*/("""}"""),format.raw/*115.99*/("""
            </div>

            <div>
                <div class="gameHeading">
                    Net Worth
                </div>
                <div class="arrow arrow-left" style="margin-left: 10px;"s></div>
                <div class="clearfix"></div>
            </div>
            <div class="netWorth">
                $"""),format.raw/*126.18*/("""{"""),format.raw/*126.19*/("""{"""),format.raw/*126.20*/("""format(computeNetWorth())"""),format.raw/*126.45*/("""}"""),format.raw/*126.46*/("""}"""),format.raw/*126.47*/("""
            </div>

            <div>
                <div class="gameHeading">
                    Leader Board
                </div>
                <div class="arrow arrow-left" style="margin-left: 10px;"s></div>
                <div class="clearfix"></div>
            </div>

            <div style="overflow: auto; height: 120px;">
                <div ng-repeat="player in playersArray()| orderBy:'rank'">
                    <span class="label label-info">"""),format.raw/*139.52*/("""{"""),format.raw/*139.53*/("""{"""),format.raw/*139.54*/("""pos(player.rank)"""),format.raw/*139.70*/("""}"""),format.raw/*139.71*/("""}"""),format.raw/*139.72*/("""</span> """),format.raw/*139.80*/("""{"""),format.raw/*139.81*/("""{"""),format.raw/*139.82*/("""player.firstName"""),format.raw/*139.98*/("""}"""),format.raw/*139.99*/("""}"""),format.raw/*139.100*/(""" """),format.raw/*139.101*/("""{"""),format.raw/*139.102*/("""{"""),format.raw/*139.103*/("""player.lastName"""),format.raw/*139.118*/("""}"""),format.raw/*139.119*/("""}"""),format.raw/*139.120*/("""
                </div>
            </div>
        </div>

        <div class="clearfix"></div>
    </div>
    <div class="modal hide" id="chartModal" style="width:720px;">
        <div class="modal-header">
            <a href="#" class="close" data-dismiss="modal">&times;</a>
            <h3>"""),format.raw/*149.17*/("""{"""),format.raw/*149.18*/("""{"""),format.raw/*149.19*/("""stockHistoryTitle"""),format.raw/*149.36*/("""}"""),format.raw/*149.37*/("""}"""),format.raw/*149.38*/("""</h3>
            <div class="alert alert-info">
                This chart shows price trends up to yesterday, the dates are not real.
            </div>
        </div>
        <div class="modal-body">
            <div id="chartContainer" style="width: 690px;"></div>
        </div>
    </div>
    <div class="modal hide" id="buyStockModal">
        <div class="modal-header">
            <a href="#" class="close" data-dismiss="modal">&times;</a>
            <h3>Buy """),format.raw/*161.21*/("""{"""),format.raw/*161.22*/("""{"""),format.raw/*161.23*/("""selectedStock.companyName"""),format.raw/*161.48*/("""}"""),format.raw/*161.49*/("""}"""),format.raw/*161.50*/(""" Stock</h3>
        </div>
        <div class="modal-body">
            <form ng-submit="buyStock()" class="form-horizontal" style="font-family: Verdana, Calibri, sans-serif">
                <div class="control-group">
                    <label class="control-label">Ticker</label>
                    <div class="controls">
                        <span class="label label-info">"""),format.raw/*168.56*/("""{"""),format.raw/*168.57*/("""{"""),format.raw/*168.58*/("""selectedStock.ticker"""),format.raw/*168.78*/("""}"""),format.raw/*168.79*/("""}"""),format.raw/*168.80*/("""</span>
                        <input type="hidden" name="ticker" ng-model="selectedStock.ticker" value=""""),format.raw/*169.99*/("""{"""),format.raw/*169.100*/("""{"""),format.raw/*169.101*/("""selectedStock.ticker"""),format.raw/*169.121*/("""}"""),format.raw/*169.122*/("""}"""),format.raw/*169.123*/(""""/>
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label">Company</label>
                    <div class="controls">
                        """),format.raw/*176.25*/("""{"""),format.raw/*176.26*/("""{"""),format.raw/*176.27*/("""selectedStock.company"""),format.raw/*176.48*/("""}"""),format.raw/*176.49*/("""}"""),format.raw/*176.50*/("""
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label">Current Price:</label>
                    <div class="controls">
                        $"""),format.raw/*182.26*/("""{"""),format.raw/*182.27*/("""{"""),format.raw/*182.28*/("""format(selectedStock.price)"""),format.raw/*182.55*/("""}"""),format.raw/*182.56*/("""}"""),format.raw/*182.57*/("""
                        <input type="hidden" ng-model="selectedStock.price" name="price" value=""""),format.raw/*183.97*/("""{"""),format.raw/*183.98*/("""{"""),format.raw/*183.99*/("""selectedStock.price"""),format.raw/*183.118*/("""}"""),format.raw/*183.119*/("""}"""),format.raw/*183.120*/(""""/>
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label">Quantity:</label>
                    <div class="controls">
                        <input type="number" pattern="^\d+$" required="" ng-model="selectedStock.quantity" name="quantity" class="input-small" min="0"/>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label">
                        Total Amount
                    </label>
                    <div class="controls">
                        $"""),format.raw/*198.26*/("""{"""),format.raw/*198.27*/("""{"""),format.raw/*198.28*/("""format(selectedStock.quantity * selectedStock.price)"""),format.raw/*198.80*/("""}"""),format.raw/*198.81*/("""}"""),format.raw/*198.82*/("""
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label">
                        Current Balance
                    </label>
                    <div class="controls">
                        $"""),format.raw/*206.26*/("""{"""),format.raw/*206.27*/("""{"""),format.raw/*206.28*/("""format(gameState.myAccount.currentBalance)"""),format.raw/*206.70*/("""}"""),format.raw/*206.71*/("""}"""),format.raw/*206.72*/("""
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label">
                        After Purchase
                    </label>
                    <div class="controls">
                        $"""),format.raw/*215.26*/("""{"""),format.raw/*215.27*/("""{"""),format.raw/*215.28*/("""format(gameState.myAccount.currentBalance - selectedStock.quantity * selectedStock.price)"""),format.raw/*215.117*/("""}"""),format.raw/*215.118*/("""}"""),format.raw/*215.119*/("""
                    </div>
                </div>


                <div ng-if="selectedStock.quantity > 0 && (gameState.myAccount.currentBalance - selectedStock.quantity * selectedStock.price) >= 0">
                    <button type="submit" class="btn btn-success">Buy Stock</button>
                </div>

                <div ng-if="selectedStock.quantity < 1 || (gameState.myAccount.currentBalance - selectedStock.quantity * selectedStock.price) < 0">
                    <button type="submit" class="btn btn-success" disabled="">Buy Stock</button>
                </div>

            </form>
        </div>
    </div>

    <div class="modal hide" id="sellStockModal">
        <div class="modal-header">
            <a href="#" class="close" data-dismiss="modal">&times;</a>
            <h3>Sell """),format.raw/*235.22*/("""{"""),format.raw/*235.23*/("""{"""),format.raw/*235.24*/("""stockToSell.companyName"""),format.raw/*235.47*/("""}"""),format.raw/*235.48*/("""}"""),format.raw/*235.49*/(""" Stock</h3>
        </div>

        <div class="modal-body">
            <form ng-submit="sellStock()" class="form-horizontal" style="font-family: Verdana, Calibri, sans-serif">
                <div class="control-group">
                    <label class="control-label">Ticker</label>
                    <div class="controls">
                        <span class="label label-info">"""),format.raw/*243.56*/("""{"""),format.raw/*243.57*/("""{"""),format.raw/*243.58*/("""stockToSell.ticker"""),format.raw/*243.76*/("""}"""),format.raw/*243.77*/("""}"""),format.raw/*243.78*/("""</span>
                        <input type="hidden" name="ticker" ng-model="stockToSell.ticker" value=""""),format.raw/*244.97*/("""{"""),format.raw/*244.98*/("""{"""),format.raw/*244.99*/("""stockToSell.ticker"""),format.raw/*244.117*/("""}"""),format.raw/*244.118*/("""}"""),format.raw/*244.119*/(""""/>
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label">Company</label>
                    <div class="controls">
                        """),format.raw/*251.25*/("""{"""),format.raw/*251.26*/("""{"""),format.raw/*251.27*/("""stockToSell.company"""),format.raw/*251.46*/("""}"""),format.raw/*251.47*/("""}"""),format.raw/*251.48*/("""
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label">Current Price:</label>
                    <div class="controls">
                        $"""),format.raw/*257.26*/("""{"""),format.raw/*257.27*/("""{"""),format.raw/*257.28*/("""format(stockToSell.currentPrice)"""),format.raw/*257.60*/("""}"""),format.raw/*257.61*/("""}"""),format.raw/*257.62*/("""
                        <input type="hidden" ng-model="stockToSell.currentPrice" name="price" value=""""),format.raw/*258.102*/("""{"""),format.raw/*258.103*/("""{"""),format.raw/*258.104*/("""stockToSell.currentPrice"""),format.raw/*258.128*/("""}"""),format.raw/*258.129*/("""}"""),format.raw/*258.130*/(""""/>
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label">Quantity:</label>
                    <div class="controls">
                        <input type="number" pattern="^\d+$" required="" ng-model="stockToSell.quantityToSell" name="quantity" class="input-small" min="1" max=""""),format.raw/*265.161*/("""{"""),format.raw/*265.162*/("""{"""),format.raw/*265.163*/("""stockToSell.quantity"""),format.raw/*265.183*/("""}"""),format.raw/*265.184*/("""}"""),format.raw/*265.185*/(""""/>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label">
                        Total Amount
                    </label>
                    <div class="controls">
                        $"""),format.raw/*273.26*/("""{"""),format.raw/*273.27*/("""{"""),format.raw/*273.28*/("""format(stockToSell.quantityToSell * stockToSell.currentPrice)"""),format.raw/*273.89*/("""}"""),format.raw/*273.90*/("""}"""),format.raw/*273.91*/("""
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label">
                        Current Balance
                    </label>
                    <div class="controls">
                        $"""),format.raw/*281.26*/("""{"""),format.raw/*281.27*/("""{"""),format.raw/*281.28*/("""format(gameState.myAccount.currentBalance)"""),format.raw/*281.70*/("""}"""),format.raw/*281.71*/("""}"""),format.raw/*281.72*/("""
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label">
                        After Sale
                    </label>
                    <div class="controls">
                        $"""),format.raw/*290.26*/("""{"""),format.raw/*290.27*/("""{"""),format.raw/*290.28*/("""format(gameState.myAccount.currentBalance + stockToSell.quantityToSell * stockToSell.currentPrice)"""),format.raw/*290.126*/("""}"""),format.raw/*290.127*/("""}"""),format.raw/*290.128*/("""
                    </div>
                </div>


                <div ng-if="stockToSell.quantityToSell > 0 && stockToSell.quantityToSell <= stockToSell.quantity">
                    <button type="submit" class="btn btn-success">Sell Stock</button>
                </div>

                <div ng-if="stockToSell.quantityToSell < 1 || stockToSell.quantityToSell > stockToSell.quantity">
                    <button type="submit" class="btn btn-success" disabled="">Sell Stock</button>
                </div>

            </form>
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
                    SOURCE: /Users/feiliu/git/omniwin/app/views/game_gamePlay_play.scala.html
                    HASH: 9853ba53a6c4219b095364c41ee84996076107df
                    MATRIX: 868->0|1021->126|1049->127|1077->128|1119->143|1147->144|1175->145|1891->833|1920->834|1949->835|1991->848|2021->849|2051->850|2211->982|2240->983|2269->984|2309->996|2338->997|2367->998|2461->1064|2490->1065|2519->1066|2560->1079|2589->1080|2618->1081|2842->1277|2871->1278|2900->1279|2947->1298|2976->1299|3005->1300|4241->2507|4271->2508|4301->2509|4343->2522|4373->2523|4403->2524|4596->2689|4625->2690|4654->2691|4703->2712|4732->2713|4761->2714|4992->2917|5021->2918|5050->2919|5101->2942|5130->2943|5159->2944|5300->3057|5329->3058|5358->3059|5448->3120|5478->3121|5508->3122|5828->3414|5857->3415|5886->3416|5949->3451|5978->3452|6007->3453|6924->4342|6953->4343|6982->4344|7053->4386|7083->4387|7113->4388|7264->4511|7293->4512|7322->4513|7393->4555|7423->4556|7453->4557|8004->5079|8034->5080|8064->5081|8117->5105|8147->5106|8177->5107|8210->5111|8240->5112|8270->5113|8319->5133|8349->5134|8379->5135|8739->5466|8769->5467|8799->5468|8853->5493|8883->5494|8913->5495|9408->5961|9438->5962|9468->5963|9513->5979|9543->5980|9573->5981|9610->5989|9640->5990|9670->5991|9715->6007|9745->6008|9776->6009|9807->6010|9838->6011|9869->6012|9914->6027|9945->6028|9976->6029|10300->6324|10330->6325|10360->6326|10406->6343|10436->6344|10466->6345|10964->6814|10994->6815|11024->6816|11078->6841|11108->6842|11138->6843|11549->7225|11579->7226|11609->7227|11658->7247|11688->7248|11718->7249|11853->7355|11884->7356|11915->7357|11965->7377|11996->7378|12027->7379|12287->7610|12317->7611|12347->7612|12397->7633|12427->7634|12457->7635|12721->7870|12751->7871|12781->7872|12837->7899|12867->7900|12897->7901|13023->7998|13053->7999|13083->8000|13132->8019|13163->8020|13194->8021|13863->8661|13893->8662|13923->8663|14004->8715|14034->8716|14064->8717|14375->8999|14405->9000|14435->9001|14506->9043|14536->9044|14566->9045|14877->9327|14907->9328|14937->9329|15056->9418|15087->9419|15118->9420|15950->10223|15980->10224|16010->10225|16062->10248|16092->10249|16122->10250|16535->10634|16565->10635|16595->10636|16642->10654|16672->10655|16702->10656|16835->10760|16865->10761|16895->10762|16943->10780|16974->10781|17005->10782|17265->11013|17295->11014|17325->11015|17373->11034|17403->11035|17433->11036|17697->11271|17727->11272|17757->11273|17818->11305|17848->11306|17878->11307|18010->11409|18041->11410|18072->11411|18126->11435|18157->11436|18188->11437|18587->11806|18618->11807|18649->11808|18699->11828|18730->11829|18761->11830|19072->12112|19102->12113|19132->12114|19222->12175|19252->12176|19282->12177|19593->12459|19623->12460|19653->12461|19724->12503|19754->12504|19784->12505|20091->12783|20121->12784|20151->12785|20279->12883|20310->12884|20341->12885
                    LINES: 29->1|32->4|32->4|32->4|32->4|32->4|32->4|48->20|48->20|48->20|48->20|48->20|48->20|50->22|50->22|50->22|50->22|50->22|50->22|52->24|52->24|52->24|52->24|52->24|52->24|56->28|56->28|56->28|56->28|56->28|56->28|85->57|85->57|85->57|85->57|85->57|85->57|87->59|87->59|87->59|87->59|87->59|87->59|93->65|93->65|93->65|93->65|93->65|93->65|96->68|96->68|96->68|96->68|96->68|96->68|100->72|100->72|100->72|100->72|100->72|100->72|123->95|123->95|123->95|123->95|123->95|123->95|127->99|127->99|127->99|127->99|127->99|127->99|143->115|143->115|143->115|143->115|143->115|143->115|143->115|143->115|143->115|143->115|143->115|143->115|154->126|154->126|154->126|154->126|154->126|154->126|167->139|167->139|167->139|167->139|167->139|167->139|167->139|167->139|167->139|167->139|167->139|167->139|167->139|167->139|167->139|167->139|167->139|167->139|177->149|177->149|177->149|177->149|177->149|177->149|189->161|189->161|189->161|189->161|189->161|189->161|196->168|196->168|196->168|196->168|196->168|196->168|197->169|197->169|197->169|197->169|197->169|197->169|204->176|204->176|204->176|204->176|204->176|204->176|210->182|210->182|210->182|210->182|210->182|210->182|211->183|211->183|211->183|211->183|211->183|211->183|226->198|226->198|226->198|226->198|226->198|226->198|234->206|234->206|234->206|234->206|234->206|234->206|243->215|243->215|243->215|243->215|243->215|243->215|263->235|263->235|263->235|263->235|263->235|263->235|271->243|271->243|271->243|271->243|271->243|271->243|272->244|272->244|272->244|272->244|272->244|272->244|279->251|279->251|279->251|279->251|279->251|279->251|285->257|285->257|285->257|285->257|285->257|285->257|286->258|286->258|286->258|286->258|286->258|286->258|293->265|293->265|293->265|293->265|293->265|293->265|301->273|301->273|301->273|301->273|301->273|301->273|309->281|309->281|309->281|309->281|309->281|309->281|318->290|318->290|318->290|318->290|318->290|318->290
                    -- GENERATED --
                */
            