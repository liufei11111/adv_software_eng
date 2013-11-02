
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
object layout extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String)(content : Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.33*/("""
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>"""),_display_(Seq[Any](/*6.17*/title)),format.raw/*6.22*/(""" / """),_display_(Seq[Any](/*6.26*/play/*6.30*/.Play.application().configuration().getString("application.name"))),format.raw/*6.95*/("""</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <meta name="content-encoding" content="utf-8">

        <!-- Le styles -->
        <link href='"""),_display_(Seq[Any](/*13.22*/routes/*13.28*/.Assets.at("css/bootstrap.min.css"))),format.raw/*13.63*/("""' rel="stylesheet">
        <link href='"""),_display_(Seq[Any](/*14.22*/routes/*14.28*/.Assets.at("css/main.css"))),format.raw/*14.54*/("""' rel="stylesheet">

        <!-- Fav and touch icons -->
        <link rel="shortcut icon" href='"""),_display_(Seq[Any](/*17.42*/routes/*17.48*/.Assets.at("favicon.ico"))),format.raw/*17.73*/("""'>

        <script src='"""),_display_(Seq[Any](/*19.23*/routes/*19.29*/.Assets.at("js/jquery-1.9.0.min.js"))),format.raw/*19.65*/("""'></script>
        <script src='"""),_display_(Seq[Any](/*20.23*/routes/*20.29*/.Assets.at("js/bootstrap.min.js"))),format.raw/*20.62*/("""'></script>
        <script src='"""),_display_(Seq[Any](/*21.23*/routes/*21.29*/.Assets.at("js/app.js"))),format.raw/*21.52*/("""'></script>

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="../assets/js/html5shiv.js"></script>
        <![endif]-->

        <!-- Fav and touch icons -->

    </head>

    <body>

        <div class="container-narrow">

            <div class="masthead">
                <ul class="nav nav-pills pull-right">
                    """),_display_(Seq[Any](/*38.22*/if(managers.UserManager.isLoggedIn())/*38.59*/{_display_(Seq[Any](format.raw/*38.60*/("""
                    <li>
                        <a href="#">
                            <i class="icon-user"></i>"""),_display_(Seq[Any](/*41.55*/defining(managers.UserManager.getCurrentLoggedInUser())/*41.110*/{user=>_display_(Seq[Any](format.raw/*41.117*/(""" """),_display_(Seq[Any](/*41.119*/user/*41.123*/.getFirstName())),format.raw/*41.138*/(""" """),_display_(Seq[Any](/*41.140*/user/*41.144*/.getLastName()))))})),format.raw/*41.159*/("""
                        </a>
                    </li>
                    """)))})),format.raw/*44.22*/("""
                    <li class="active">
                        <a href=""""),_display_(Seq[Any](/*46.35*/routes/*46.41*/.Application.index())),format.raw/*46.61*/("""">Home</a>
                    </li>
                    <!-- <li><a href="#">About</a></li>-->
                    """),_display_(Seq[Any](/*49.22*/if(managers.UserManager.isLoggedIn())/*49.59*/{_display_(Seq[Any](format.raw/*49.60*/("""
                    <li>
                        <a href=""""),_display_(Seq[Any](/*51.35*/routes/*51.41*/.Application.dashboard())),format.raw/*51.65*/("""">Dashboard</a>
                    </li>
                    <li>
                        <a onclick="$('#createGameBtn').trigger('click');" href=""""),_display_(Seq[Any](/*54.83*/routes/*54.89*/.Application.dashboard())),format.raw/*54.113*/("""#createGame">Create Game</a>
                    </li>
                    <li><a href=""""),_display_(Seq[Any](/*56.35*/routes/*56.41*/.LoginController.logout())),format.raw/*56.66*/("""">Logout</a></li>
                    """)))})),format.raw/*57.22*/("""
                </ul>
                <h3 class="muted">
                    """),_display_(Seq[Any](/*60.22*/play/*60.26*/.Play.application().configuration().getString("application.name"))),format.raw/*60.91*/("""
                </h3>
            </div>

            <hr>
            """),_display_(Seq[Any](/*65.14*/content)),format.raw/*65.21*/("""

            <div class="footer">
                <p>&copy; Omni Win! 2013</p>
            </div>

        </div> <!-- /container -->
    </body>
</html>
"""))}
    }
    
    def render(title:String,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Oct 30 19:24:24 EDT 2013
                    SOURCE: /Users/feiliu/git/omniwin/app/views/layout.scala.html
                    HASH: 75f08dacc27f70720d502053eba5382eb15c6619
                    MATRIX: 780->1|905->32|1032->124|1058->129|1097->133|1109->137|1195->202|1508->479|1523->485|1580->520|1657->561|1672->567|1720->593|1855->692|1870->698|1917->723|1979->749|1994->755|2052->791|2122->825|2137->831|2192->864|2262->898|2277->904|2322->927|2757->1326|2803->1363|2842->1364|2995->1481|3060->1536|3106->1543|3145->1545|3159->1549|3197->1564|3236->1566|3250->1570|3292->1585|3401->1662|3512->1737|3527->1743|3569->1763|3722->1880|3768->1917|3807->1918|3903->1978|3918->1984|3964->2008|4149->2157|4164->2163|4211->2187|4336->2276|4351->2282|4398->2307|4469->2346|4584->2425|4597->2429|4684->2494|4793->2567|4822->2574
                    LINES: 26->1|29->1|34->6|34->6|34->6|34->6|34->6|41->13|41->13|41->13|42->14|42->14|42->14|45->17|45->17|45->17|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|66->38|66->38|66->38|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|72->44|74->46|74->46|74->46|77->49|77->49|77->49|79->51|79->51|79->51|82->54|82->54|82->54|84->56|84->56|84->56|85->57|88->60|88->60|88->60|93->65|93->65
                    -- GENERATED --
                */
            