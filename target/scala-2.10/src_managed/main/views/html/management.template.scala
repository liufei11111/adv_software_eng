
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
object management extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[List[models.data.Stock],String,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(stockList : List[models.data.Stock], message : String, tabToDisplay : String=null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import helper.twitterBootstrap._


Seq[Any](format.raw/*1.85*/("""
"""),format.raw/*4.1*/("""

"""),_display_(Seq[Any](/*6.2*/layout("Management DashBoard")/*6.32*/{_display_(Seq[Any](format.raw/*6.33*/("""


"""),_display_(Seq[Any](/*9.2*/defining(managers.UserManager.getCurrentLoggedInUser())/*9.57*/{user=>_display_(Seq[Any](format.raw/*9.64*/(""" 
<div>
    <p> Welcome, Admin """),_display_(Seq[Any](/*11.25*/user/*11.29*/.getLastName())),format.raw/*11.43*/(""" """),_display_(Seq[Any](/*11.45*/user/*11.49*/.getFirstName())),format.raw/*11.64*/("""!</p>
</div>
""")))})),format.raw/*13.2*/("""



  <div class="alert fade in">
      <button type="button" class="close" data_dismiss="alert">x</button>
      <strong id="message">"""),_display_(Seq[Any](/*19.29*/message)),format.raw/*19.36*/("""</strong>
  </div>


<ul class="nav nav-tabs" id="adminTab">
    <li class=''><a href="#stockTab">Modify Stock Pool</a></li>
    <li class=''><a href="#userTab">Enable/Disable User</a></li>
</ul>

<div class="tab-content">
      <div class='tab-pane' id="stockTab">
      <div>
          <form class="form" id="addStockForm" action=""""),_display_(Seq[Any](/*31.57*/routes/*31.63*/.ManagementController.addStock())),format.raw/*31.95*/("""" method="post">
          <fieldset>
          <legend>Add a new Stock</legend>
          <input type="text" name="companyName" placeholder="Type Company Name">
          <input type="text" name="ticker" placeholder="Type a ticker…">
          <span class="help-block">Should the stock be automatically enabled?</span>
          <label class="checkbox">
          <input type="checkbox" name="isEnabled" value=1> Enable
          </label>
          <button type="submit" class="btn">Add it</button>
          <legend></legend>
          </fieldset>
          </form>
      </div>
      
      <table class="table table-striped">
        <tr>
            <td>Company Name</td>
            <td>Ticker</td>
            <td>isEnabled</td>
            <td>Enable/Disable</td>  
            <td>Delete</td>
          </tr>
      """),_display_(Seq[Any](/*54.8*/for(stock <- stockList) yield /*54.31*/{_display_(Seq[Any](format.raw/*54.32*/("""
           <tr>
            <td>"""),_display_(Seq[Any](/*56.18*/stock/*56.23*/.getCompanyName())),format.raw/*56.40*/("""</td>
            <td>"""),_display_(Seq[Any](/*57.18*/stock/*57.23*/.getTicker())),format.raw/*57.35*/("""</td>
            <td>"""),_display_(Seq[Any](/*58.18*/stock/*58.23*/.getIsEnabled())),format.raw/*58.38*/("""</td>
            <td>
              <form class='form' id="toggleStockForm" action=""""),_display_(Seq[Any](/*60.64*/routes/*60.70*/.ManagementController.toggleStock())),format.raw/*60.105*/("""" method="post">
                <input type="hidden" readonly="" name="ticker" value="""),_display_(Seq[Any](/*61.71*/stock/*61.76*/.getTicker())),format.raw/*61.88*/(""" class="input-block-level">
                 <input type="hidden" readonly="" name="companyName" value="""),_display_(Seq[Any](/*62.77*/stock/*62.82*/.getCompanyName())),format.raw/*62.99*/(""" class="input-block-level">
                <input type="hidden" readonly="" name="isEnabled" value="""),_display_(Seq[Any](/*63.74*/stock/*63.79*/.getIsEnabled())),format.raw/*63.94*/(""" class="input-block-level">
               <button class="input-block-level btn btn-primary" type="submit">
                 """),_display_(Seq[Any](/*65.19*/if(stock.getIsEnabled() == 1)/*65.48*/{_display_(Seq[Any](format.raw/*65.49*/("""
                    Disable
                 """)))}/*67.19*/else/*67.23*/{_display_(Seq[Any](format.raw/*67.24*/("""
                    Enable
                 """)))})),format.raw/*69.19*/("""
                </button>
              </form>
            </td>
             <td>
                <form class='form' id="deleteStockForm" action=""""),_display_(Seq[Any](/*74.66*/routes/*74.72*/.ManagementController.deleteStock())),format.raw/*74.107*/("""" method="post">
                <input type="hidden" readonly="" name="ticker" value="""),_display_(Seq[Any](/*75.71*/stock/*75.76*/.getTicker())),format.raw/*75.88*/(""" class="input-block-level">
                <input type="hidden" readonly="" name="companyName" value="""),_display_(Seq[Any](/*76.76*/stock/*76.81*/.getCompanyName())),format.raw/*76.98*/(""" class="input-block-level">
                <input type="hidden" readonly="" name="isEnabled" value="""),_display_(Seq[Any](/*77.74*/stock/*77.79*/.getIsEnabled())),format.raw/*77.94*/(""" class="input-block-level">
               <button class="input-block-level btn btn-primary" type="submit">
                 Delete
                </button>
              </form>
            </td>
           </tr>
        
                  
      """)))})),format.raw/*86.8*/("""
      </table>
    </div>
        

    <div class='tab-pane' id="userTab">
         <table class="table table-striped">
        <tr>
            <td>First Name</td>
            <td>Last Name</td>
            <td>Email</td>
            <td>Status</td>  
            <td>Enable/Disable</td>
          </tr>
      """),_display_(Seq[Any](/*100.8*/for(account <- managers.UserManager.getUserList()) yield /*100.58*/{_display_(Seq[Any](format.raw/*100.59*/("""
           <tr>
            <td>"""),_display_(Seq[Any](/*102.18*/account/*102.25*/.getFirstName())),format.raw/*102.40*/("""</td>
            <td>"""),_display_(Seq[Any](/*103.18*/account/*103.25*/.getLastName())),format.raw/*103.39*/("""</td>
            <td>"""),_display_(Seq[Any](/*104.18*/account/*104.25*/.getEmail())),format.raw/*104.36*/("""</td>
            <td>"""),_display_(Seq[Any](/*105.18*/account/*105.25*/.getIsEnabled())),format.raw/*105.40*/("""</td>
            
            <td>
              <form class='form' id="toggleUserForm" action=""""),_display_(Seq[Any](/*108.63*/routes/*108.69*/.ManagementController.playerToggle())),format.raw/*108.105*/("""" method="post">
                <input type="hidden" readonly="" name="email" value="""),_display_(Seq[Any](/*109.70*/account/*109.77*/.getEmail())),format.raw/*109.88*/(""" class="input-block-level">
                
               <button class="input-block-level btn btn-primary" type="submit">
                 """),_display_(Seq[Any](/*112.19*/if(account.getIsEnabled() == 1)/*112.50*/{_display_(Seq[Any](format.raw/*112.51*/("""
                    Disable
                 """)))}/*114.19*/else/*114.23*/{_display_(Seq[Any](format.raw/*114.24*/("""
                    Enable
                 """)))})),format.raw/*116.19*/("""
                </button>
              </form>
            </td>
           </tr>
        
                  
      """)))})),format.raw/*123.8*/("""
      </table>
      
    </div>

</div>

<script>

    $('#adminTab a').click(function(e) """),format.raw/*132.40*/("""{"""),format.raw/*132.41*/("""
        e.preventDefault();
        $(this).tab('show');
    """),format.raw/*135.5*/("""}"""),format.raw/*135.6*/(""");
  
    $('#adminTab a[href="#"""),_display_(Seq[Any](/*137.28*/tabToDisplay)),format.raw/*137.40*/(""""]').tab('show'); // Select tab by name

    
      if ($("#message").text() == "")"""),format.raw/*140.38*/("""{"""),format.raw/*140.39*/("""
        $(".alert").alert('close'); 
      """),format.raw/*142.7*/("""}"""),format.raw/*142.8*/("""
      
  
    $( ".close" ).click(function() """),format.raw/*145.36*/("""{"""),format.raw/*145.37*/("""
     $( ".alert").alert('close');
    """),format.raw/*147.5*/("""}"""),format.raw/*147.6*/(""");
  
</script>
""")))})))}
    }
    
    def render(stockList:List[models.data.Stock],message:String,tabToDisplay:String): play.api.templates.HtmlFormat.Appendable = apply(stockList,message,tabToDisplay)
    
    def f:((List[models.data.Stock],String,String) => play.api.templates.HtmlFormat.Appendable) = (stockList,message,tabToDisplay) => apply(stockList,message,tabToDisplay)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Oct 31 16:44:07 EDT 2013
                    SOURCE: /Users/feiliu/git/omniwin/app/views/management.scala.html
                    HASH: 136ac23b9788f41c9f6b2da84d2d112f9d9efda2
                    MATRIX: 810->1|1037->84|1064->136|1101->139|1139->169|1177->170|1215->174|1278->229|1322->236|1390->268|1403->272|1439->286|1477->288|1490->292|1527->307|1572->321|1744->457|1773->464|2143->798|2158->804|2212->836|3072->1661|3111->1684|3150->1685|3220->1719|3234->1724|3273->1741|3332->1764|3346->1769|3380->1781|3439->1804|3453->1809|3490->1824|3612->1910|3627->1916|3685->1951|3808->2038|3822->2043|3856->2055|3996->2159|4010->2164|4049->2181|4186->2282|4200->2287|4237->2302|4399->2428|4437->2457|4476->2458|4542->2505|4555->2509|4594->2510|4672->2556|4858->2706|4873->2712|4931->2747|5054->2834|5068->2839|5102->2851|5241->2954|5255->2959|5294->2976|5431->3077|5445->3082|5482->3097|5763->3347|6113->3661|6180->3711|6220->3712|6291->3746|6308->3753|6346->3768|6406->3791|6423->3798|6460->3812|6520->3835|6537->3842|6571->3853|6631->3876|6648->3883|6686->3898|6821->3996|6837->4002|6897->4038|7020->4124|7037->4131|7071->4142|7251->4285|7292->4316|7332->4317|7399->4364|7413->4368|7453->4369|7532->4415|7683->4534|7804->4626|7834->4627|7924->4689|7953->4690|8023->4723|8058->4735|8170->4818|8200->4819|8272->4863|8301->4864|8376->4910|8406->4911|8473->4950|8502->4951
                    LINES: 26->1|32->1|33->4|35->6|35->6|35->6|38->9|38->9|38->9|40->11|40->11|40->11|40->11|40->11|40->11|42->13|48->19|48->19|60->31|60->31|60->31|83->54|83->54|83->54|85->56|85->56|85->56|86->57|86->57|86->57|87->58|87->58|87->58|89->60|89->60|89->60|90->61|90->61|90->61|91->62|91->62|91->62|92->63|92->63|92->63|94->65|94->65|94->65|96->67|96->67|96->67|98->69|103->74|103->74|103->74|104->75|104->75|104->75|105->76|105->76|105->76|106->77|106->77|106->77|115->86|129->100|129->100|129->100|131->102|131->102|131->102|132->103|132->103|132->103|133->104|133->104|133->104|134->105|134->105|134->105|137->108|137->108|137->108|138->109|138->109|138->109|141->112|141->112|141->112|143->114|143->114|143->114|145->116|152->123|161->132|161->132|164->135|164->135|166->137|166->137|169->140|169->140|171->142|171->142|174->145|174->145|176->147|176->147
                    -- GENERATED --
                */
            