
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
object application_index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Form[model.forms.LoginForm],Form[model.forms.RegisterForm],String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(loginForm: Form[model.forms.LoginForm], registerForm : Form[model.forms.RegisterForm], formToDisplay : String=null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import helper.twitterBootstrap._


Seq[Any](format.raw/*1.118*/("""
"""),format.raw/*4.1*/("""

"""),_display_(Seq[Any](/*6.2*/layout("Welcome to Omni Win")/*6.31*/{_display_(Seq[Any](format.raw/*6.32*/("""
<div class="jumbotron">
    <h1>
        Super awesome Stock Market Game!
    </h1>
    <p class="lead">
        Welcome to Omni Win! A place where everyone can be a winner. """),_display_(Seq[Any](/*12.71*/if(managers.UserManager.isLoggedIn())/*12.108*/{_display_(Seq[Any](format.raw/*12.109*/("""Enter your dashboard to begin!""")))}/*12.140*/else/*12.144*/{_display_(Seq[Any](format.raw/*12.145*/("""Sign up or Register to begin playing""")))})),format.raw/*12.182*/(""".
    </p>
    """),_display_(Seq[Any](/*14.6*/if(!managers.UserManager.isLoggedIn())/*14.44*/{_display_(Seq[Any](format.raw/*14.45*/("""
    
    <a class="btn btn-large btn-success" href="#" id="signupBtn">Sign up today</a> 
    <a class="btn btn-large btn-primary" href="#" id="loginBtn">Login to Play</a>
    """)))}/*18.6*/else/*18.10*/{_display_(Seq[Any](format.raw/*18.11*/("""
    
    """),_display_(Seq[Any](/*20.6*/if(managers.UserManager.getCurrentLoggedInUser().isAdmin())/*20.65*/{_display_(Seq[Any](format.raw/*20.66*/("""
    <a class="btn btn-large btn-info" href=""""),_display_(Seq[Any](/*21.46*/routes/*21.52*/.ManagementController.index())),format.raw/*21.81*/("""">Management Dashboard</a>
    """)))}/*22.6*/else/*22.10*/{_display_(Seq[Any](format.raw/*22.11*/("""
    <a class="btn btn-large btn-info" href=""""),_display_(Seq[Any](/*23.46*/routes/*23.52*/.Application.dashboard())),format.raw/*23.76*/("""">View Dashboard</a>
    """)))})),format.raw/*24.6*/("""
    
    """)))})),format.raw/*26.6*/("""
</div>
"""),_display_(Seq[Any](/*28.2*/if(!managers.UserManager.isLoggedIn())/*28.40*/{_display_(Seq[Any](format.raw/*28.41*/("""
<a name="loginForm"></a>
<form class='form  """),_display_(Seq[Any](/*30.21*/if(formToDisplay == null || !formToDisplay.equals("login"))/*30.80*/{_display_(Seq[Any](format.raw/*30.81*/("""hide""")))})),format.raw/*30.86*/("""' id="loginForm" action=""""),_display_(Seq[Any](/*30.112*/routes/*30.118*/.LoginController.login())),format.raw/*30.142*/("""" method="post">
    """),_display_(Seq[Any](/*31.6*/if(loginForm.hasGlobalErrors())/*31.37*/{_display_(Seq[Any](format.raw/*31.38*/("""
    <div class="alert alert-error">
        """),_display_(Seq[Any](/*33.10*/loginForm/*33.19*/.globalError().message())),format.raw/*33.43*/("""
    </div>
    """)))})),format.raw/*35.6*/("""
    """),_display_(Seq[Any](/*36.6*/helper/*36.12*/.inputText(loginForm("email"), '_label->"E-Mail", 'class->"input-block-level", '_showConstraints->false, 'required->""))),format.raw/*36.131*/("""
    """),_display_(Seq[Any](/*37.6*/helper/*37.12*/.inputPassword(loginForm("password"), '_label->"Password", 'class->"input-block-level", '_showConstraints->false))),format.raw/*37.125*/("""

    <button class="input-block-level btn btn-primary" type="submit">Login</button>
</form>



<a name="registerForm"></a>
<form class='form """),_display_(Seq[Any](/*45.20*/if(formToDisplay == null || !formToDisplay.equals("register"))/*45.82*/{_display_(Seq[Any](format.raw/*45.83*/("""hide""")))})),format.raw/*45.88*/("""' id="registerForm" action=""""),_display_(Seq[Any](/*45.117*/routes/*45.123*/.LoginController.register())),format.raw/*45.150*/("""" method="post">
    """),_display_(Seq[Any](/*46.6*/if(registerForm.hasGlobalErrors())/*46.40*/{_display_(Seq[Any](format.raw/*46.41*/("""
    <div class="alert alert-error">
        """),_display_(Seq[Any](/*48.10*/registerForm/*48.22*/.globalError().message())),format.raw/*48.46*/("""
    </div>
    """)))})),format.raw/*50.6*/("""
    """),_display_(Seq[Any](/*51.6*/helper/*51.12*/.inputText(registerForm("firstName"), '_label->"First Name", 'class->"input-block-level", '_showConstraints->false, 'required->""))),format.raw/*51.142*/("""
    """),_display_(Seq[Any](/*52.6*/helper/*52.12*/.inputText(registerForm("lastName"), '_label->"Last Name", 'class->"input-block-level", '_showConstraints->false, 'required->""))),format.raw/*52.140*/("""
    """),_display_(Seq[Any](/*53.6*/helper/*53.12*/.inputText(registerForm("email"), '_label->"E-Mail", 'class->"input-block-level", '_showConstraints->false, 'required->""))),format.raw/*53.134*/("""

    """),_display_(Seq[Any](/*55.6*/helper/*55.12*/.inputPassword(registerForm("password"), '_label->"Password", 'class->"input-block-level", '_showConstraints->false))),format.raw/*55.128*/("""

    """),_display_(Seq[Any](/*57.6*/helper/*57.12*/.inputPassword(registerForm("password2"), '_label->"Re-type Password", 'class->"input-block-level", '_showConstraints->false))),format.raw/*57.137*/("""

    <button class="input-block-level btn btn-primary" type="submit">Signup Now!</button>
</form>
<script>
    $(applicationIndexAction);
</script>
""")))})),format.raw/*64.2*/("""
<hr>


""")))})))}
    }
    
    def render(loginForm:Form[model.forms.LoginForm],registerForm:Form[model.forms.RegisterForm],formToDisplay:String): play.api.templates.HtmlFormat.Appendable = apply(loginForm,registerForm,formToDisplay)
    
    def f:((Form[model.forms.LoginForm],Form[model.forms.RegisterForm],String) => play.api.templates.HtmlFormat.Appendable) = (loginForm,registerForm,formToDisplay) => apply(loginForm,registerForm,formToDisplay)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Oct 30 19:24:23 EDT 2013
                    SOURCE: /Users/feiliu/git/omniwin/app/views/application_index.scala.html
                    HASH: 6ab403f26e9319ee316d6527e821218092470cc7
                    MATRIX: 845->1|1106->117|1133->169|1170->172|1207->201|1245->202|1457->378|1504->415|1544->416|1595->447|1609->451|1649->452|1719->489|1770->505|1817->543|1856->544|2051->721|2064->725|2103->726|2149->737|2217->796|2256->797|2338->843|2353->849|2404->878|2454->910|2467->914|2506->915|2588->961|2603->967|2649->991|2706->1017|2748->1028|2792->1037|2839->1075|2878->1076|2960->1122|3028->1181|3067->1182|3104->1187|3167->1213|3183->1219|3230->1243|3287->1265|3327->1296|3366->1297|3448->1343|3466->1352|3512->1376|3560->1393|3601->1399|3616->1405|3758->1524|3799->1530|3814->1536|3950->1649|4129->1792|4200->1854|4239->1855|4276->1860|4342->1889|4358->1895|4408->1922|4465->1944|4508->1978|4547->1979|4629->2025|4650->2037|4696->2061|4744->2078|4785->2084|4800->2090|4953->2220|4994->2226|5009->2232|5160->2360|5201->2366|5216->2372|5361->2494|5403->2501|5418->2507|5557->2623|5599->2630|5614->2636|5762->2761|5943->2911
                    LINES: 26->1|32->1|33->4|35->6|35->6|35->6|41->12|41->12|41->12|41->12|41->12|41->12|41->12|43->14|43->14|43->14|47->18|47->18|47->18|49->20|49->20|49->20|50->21|50->21|50->21|51->22|51->22|51->22|52->23|52->23|52->23|53->24|55->26|57->28|57->28|57->28|59->30|59->30|59->30|59->30|59->30|59->30|59->30|60->31|60->31|60->31|62->33|62->33|62->33|64->35|65->36|65->36|65->36|66->37|66->37|66->37|74->45|74->45|74->45|74->45|74->45|74->45|74->45|75->46|75->46|75->46|77->48|77->48|77->48|79->50|80->51|80->51|80->51|81->52|81->52|81->52|82->53|82->53|82->53|84->55|84->55|84->55|86->57|86->57|86->57|93->64
                    -- GENERATED --
                */
            