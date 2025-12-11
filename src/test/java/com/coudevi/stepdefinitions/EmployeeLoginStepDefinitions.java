package com.coudevi.stepdefinitions;

import com.coudevi.questions.DashboardEsVisible;
import com.coudevi.questions.MensajeErrorLoginEsVisible;
import com.coudevi.questions.OpcionMenuEsVisible;
import com.coudevi.tasks.IrALaListaDeEmpleados;
import com.coudevi.tasks.LoginConCredenciales;
import com.coudevi.ui.MenuLateral;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.coudevi.util.Configuration.getUrlBase;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.is;

public class EmployeeLoginStepDefinitions {
    private Actor admin;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que el administrador abre la página de login de OrangeHRM")
    public void queElAdministradorAbreLaPaginaDeLoginDeOrangeHRM() {
        admin = OnStage.theActorCalled("Admin");
        admin.wasAbleTo(
                Open.url(getUrlBase())
        );
    }

    @When("inicia sesión con usuario {string} y contraseña {string}")
    public void iniciaSesionConUsuarioYContrasena(String username, String password) {
        admin.attemptsTo(
                LoginConCredenciales.conCredenciales(username, password)
        );
    }

    @Then("debería visualizar el panel principal del sistema")
    public void deberiaVisualizarElPanelPrincipalDelSistema() {
        admin.should(
                seeThat("el dashboard es visible",
                        DashboardEsVisible.enPantalla(), is(true))
        );
    }

    @Then("debería visualizar un mensaje indicando que las credenciales son incorrectas")
    public void deberiaVisualizarUnMensajeIndicandoQueLasCredencialesSonIncorrectas() {
        admin.should(
                seeThat("el mensaje de error de login es visible",
                        MensajeErrorLoginEsVisible.enPantalla(), is(true))
        );
    }

    // Implementación del Background del feature de Employees
    @Given("que el administrador ha iniciado sesión en OrangeHRM")
    public void queElAdministradorHaIniciadoSesionEnOrangeHRM() {
        admin = OnStage.theActorCalled("Admin");

        admin.wasAbleTo(
                Open.url(getUrlBase()),
                LoginConCredenciales.conCredenciales("Admin", "admin123")
        );
        admin.should(
                seeThat("el dashboard es visible",
                        DashboardEsVisible.enPantalla(), is(true))
        );
    }

    @Given("se encuentra en la sección \"Employee List\" del módulo PIM")
    public void seEncuentraEnLaSeccionEmployeeListDelModuloPIM() {
        admin.attemptsTo(
                IrALaListaDeEmpleados.desdeElDashboard()
        );
    }

    @Given("que el administrador genérico ha iniciado sesión con éxito")
    public void que_el_administrador_generico_ha_iniciado_sesion_con_exito() {
        queElAdministradorHaIniciadoSesionEnOrangeHRM();
    }

    @Given("que el usuario se encuentra en la pantalla de login")
    public void que_el_usuario_se_encuentra_en_la_pantalla_de_login() {
        admin = OnStage.theActorCalled("User");
        admin.wasAbleTo(
                Open.url(getUrlBase())
        );
    }

    @When("ingresa las credenciales de acceso:")
    public void ingresa_las_credenciales_de_acceso(io.cucumber.datatable.DataTable dataTable) {
        admin.attemptsTo(
                LoginConCredenciales.conDatos(dataTable) // Necesita el método estático conDatos
        );
    }

    @Then("el Dashboard debería mostrarse correctamente")
    public void el_dashboard_deberia_mostrarse_correctamente() {
        admin.should(
                seeThat("el Dashboard es visible",
                        DashboardEsVisible.enPantalla(), is(true))
        );
    }

    @Then("la opción {string} NO debería aparecer en el menú lateral")
    public void la_opcion_no_deberia_aparecer_en_el_menu_lateral(String menuOption) {
        admin.should(
                seeThat("la opción " + menuOption + " NO es visible",
                        OpcionMenuEsVisible.laOpcion(menuOption), is(false))
        );
    }

    @Then("la opción {string} DEBERÍA ser visible en el menú lateral")
    public void la_opcion_deberia_ser_visible_en_el_menu_lateral(String menuOption) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(MenuLateral.OPCION_DE_MENU.of(menuOption), isVisible()).forNoMoreThan(5).seconds()
        );

        theActorInTheSpotlight().should(
                seeThat(OpcionMenuEsVisible.laOpcion(menuOption), is(true))
        );
    }
}
