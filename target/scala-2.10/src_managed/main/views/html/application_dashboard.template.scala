
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
object application_dashboard extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[models.data.Game],Form[model.forms.GameForm],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(gameList : List[models.data.Game], gameForm: Form[model.forms.GameForm]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import helper.twitterBootstrap._


Seq[Any](format.raw/*1.75*/("""
"""),_display_(Seq[Any](/*4.2*/layout("Game DashBoard")/*4.26*/{_display_(Seq[Any](format.raw/*4.27*/("""
"""),_display_(Seq[Any](/*5.2*/defining(managers.UserManager.getCurrentLoggedInUser())/*5.57*/{user=>_display_(Seq[Any](format.raw/*5.64*/(""" 
<div>
    <p> Welcome, """),_display_(Seq[Any](/*7.19*/user/*7.23*/.getLastName())),format.raw/*7.37*/(""" """),_display_(Seq[Any](/*7.39*/user/*7.43*/.getFirstName())),format.raw/*7.58*/("""!</p>
</div>
""")))})),format.raw/*9.2*/("""


<ul class="nav nav-tabs" id="myTab">
    <li class="active"><a href="#gameList">Joinable Games</a></li>
    <li><a id="createGameBtn" href="#createGame">Create New Game</a></li>
</ul>

<div class="tab-content">
    <div class="tab-pane active" id="gameList">
        """),_display_(Seq[Any](/*19.10*/if(gameList.size() == 0)/*19.34*/{_display_(Seq[Any](format.raw/*19.35*/("""
        <p> No Available Games Currently!</p>
        """)))}/*21.10*/else/*21.14*/{_display_(Seq[Any](format.raw/*21.15*/("""
        <table class="table table-striped">
          <tr>
            <td>Game Title</td>
            <td>Owner</td>
            <td>Players</td>  
            <td>Duration</td>
            <td>Action</td>
          </tr>
          """),_display_(Seq[Any](/*30.12*/defining(managers.UserManager.getCurrentLoggedInUser())/*30.67*/{user=>_display_(Seq[Any](format.raw/*30.74*/("""
          """),_display_(Seq[Any](/*31.12*/for(game <- gameList) yield /*31.33*/{_display_(Seq[Any](format.raw/*31.34*/("""
            <tr>
              <td>"""),_display_(Seq[Any](/*33.20*/game/*33.24*/.getGameTitle())),format.raw/*33.39*/("""</td>
              <td>"""),_display_(Seq[Any](/*34.20*/game/*34.24*/.getOwner().getFirstName())),format.raw/*34.50*/(""" """),_display_(Seq[Any](/*34.52*/game/*34.56*/.getOwner().getLastName())),format.raw/*34.81*/("""</td>
              <td>"""),_display_(Seq[Any](/*35.20*/game/*35.24*/.getPlayers().size())),format.raw/*35.44*/("""/"""),_display_(Seq[Any](/*35.46*/game/*35.50*/.getMaxPlayers())),format.raw/*35.66*/("""</td>
              <td>"""),_display_(Seq[Any](/*36.20*/game/*36.24*/.getGameLength())),format.raw/*36.40*/("""</td>
              <td>
                  <a class="btn btn-warning" href=""""),_display_(Seq[Any](/*38.53*/routes/*38.59*/.GameController.playGame(game.getId()))),format.raw/*38.97*/("""">
                      """),_display_(Seq[Any](/*39.24*/if(game.playerInGame(user))/*39.51*/{_display_(Seq[Any](format.raw/*39.52*/("""
                        Continue
                      """)))}/*41.24*/else/*41.28*/{_display_(Seq[Any](format.raw/*41.29*/("""
                        Join!
                      """)))})),format.raw/*43.24*/("""
                  
                  </a>
              
              </td>
               
            </tr>
          """)))})),format.raw/*50.12*/("""
          </table>
        """)))})),format.raw/*52.10*/("""
        """)))})),format.raw/*53.10*/("""
    </div>

    <div class="tab-pane" id="createGame">
        <h2>Create new Game</h2>
        <a name="gameForm"></a>
        <form class='form' id="gameForm" action=""""),_display_(Seq[Any](/*59.51*/routes/*59.57*/.GameController.create())),format.raw/*59.81*/("""" method="post">
            """),_display_(Seq[Any](/*60.14*/if(gameForm.hasGlobalErrors())/*60.44*/{_display_(Seq[Any](format.raw/*60.45*/("""
            <div class="alert alert-error">
                """),_display_(Seq[Any](/*62.18*/gameForm/*62.26*/.globalError().message())),format.raw/*62.50*/("""
            </div>
            """)))})),format.raw/*64.14*/("""

            """),_display_(Seq[Any](/*66.14*/helper/*66.20*/.inputText(gameForm("gameTitle"), '_label->"Title", 'class->"input-block-level", '_showConstraints->false, 'required->""))),format.raw/*66.141*/("""   
          
            <div class="row-fluid">
                <div class="span4">
                    <p>Max Players:</p>
                    <select name="maxPlayers" class="select input-small">
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                    </select>
                </div>
                <div class="span4">
                    <p>Game length:</p>
                    <select name="gameLength" class="select input-medium">
                        <option value="7">1 week</option>
                        <option value="14">2 weeks</option>
                        <option value="21">3 weeks</option>
                        <option value="30">1 month</option>
                        <option value="60">2 month</option>
                        <option value="90">3 month</option>
                        <option value="365">1 year</option>
                    </select>
                </div>
              
                <div class="span4">
                    <p>Opening Balance:</p>
                    <select name="openBalance" class="select input-medium">
                        <option value="500">$500</option>
                        <option value="1000">$1000</option>
                        <option value="2000">$2000</option>
                        <option value="5000">$5000</option>
                        <option value="10000">$10000</option>
                        <option value="50000">$50000</option>
                    </select>
                </div>
            </div>

            <br>
            <button class="input-block-level btn btn-primary" type="submit">Create</button>
        </form>


    </div>

</div>

<script>
"""),_display_(Seq[Any](/*117.2*/if(gameForm.hasErrors())/*117.26*/{_display_(Seq[Any](format.raw/*117.27*/("""
    location.hash = "#createGame";
""")))})),format.raw/*119.2*/("""    
    $('#myTab a').click(function(e) """),format.raw/*120.37*/("""{"""),format.raw/*120.38*/("""
        e.preventDefault();
        $(this).tab('show');
    """),format.raw/*123.5*/("""}"""),format.raw/*123.6*/(""");
    var openTab = location.hash;
    if(openTab !== "")"""),format.raw/*125.23*/("""{"""),format.raw/*125.24*/("""
        $("[href="+openTab+"]").tab('show');
    """),format.raw/*127.5*/("""}"""),format.raw/*127.6*/("""
</script>
""")))})))}
    }
    
    def render(gameList:List[models.data.Game],gameForm:Form[model.forms.GameForm]): play.api.templates.HtmlFormat.Appendable = apply(gameList,gameForm)
    
    def f:((List[models.data.Game],Form[model.forms.GameForm]) => play.api.templates.HtmlFormat.Appendable) = (gameList,gameForm) => apply(gameList,gameForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Oct 31 16:34:40 EDT 2013
                    SOURCE: /Users/feiliu/git/omniwin/app/views/application_dashboard.scala.html
                    HASH: f9ebd62cee975f5ed3b4fbf97e0eb167e26017ee
                    MATRIX: 833->1|1050->74|1086->127|1118->151|1156->152|1192->154|1255->209|1299->216|1360->242|1372->246|1407->260|1444->262|1456->266|1492->281|1536->295|1843->566|1876->590|1915->591|1990->647|2003->651|2042->652|2313->887|2377->942|2422->949|2470->961|2507->982|2546->983|2619->1020|2632->1024|2669->1039|2730->1064|2743->1068|2791->1094|2829->1096|2842->1100|2889->1125|2950->1150|2963->1154|3005->1174|3043->1176|3056->1180|3094->1196|3155->1221|3168->1225|3206->1241|3319->1318|3334->1324|3394->1362|3456->1388|3492->1415|3531->1416|3607->1473|3620->1477|3659->1478|3745->1532|3900->1655|3961->1684|4003->1694|4210->1865|4225->1871|4271->1895|4337->1925|4376->1955|4415->1956|4513->2018|4530->2026|4576->2050|4641->2083|4692->2098|4707->2104|4851->2225|6897->4235|6931->4259|6971->4260|7040->4297|7110->4338|7140->4339|7230->4401|7259->4402|7346->4460|7376->4461|7454->4511|7483->4512
                    LINES: 26->1|32->1|33->4|33->4|33->4|34->5|34->5|34->5|36->7|36->7|36->7|36->7|36->7|36->7|38->9|48->19|48->19|48->19|50->21|50->21|50->21|59->30|59->30|59->30|60->31|60->31|60->31|62->33|62->33|62->33|63->34|63->34|63->34|63->34|63->34|63->34|64->35|64->35|64->35|64->35|64->35|64->35|65->36|65->36|65->36|67->38|67->38|67->38|68->39|68->39|68->39|70->41|70->41|70->41|72->43|79->50|81->52|82->53|88->59|88->59|88->59|89->60|89->60|89->60|91->62|91->62|91->62|93->64|95->66|95->66|95->66|146->117|146->117|146->117|148->119|149->120|149->120|152->123|152->123|154->125|154->125|156->127|156->127
                    -- GENERATED --
                */
            