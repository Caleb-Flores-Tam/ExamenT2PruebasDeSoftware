package com.coudevi.stepdefinitions;

import com.coudevi.questions.DashboardEsVisible;
import com.coudevi.questions.MensajeErrorLoginEsVisible;
import com.coudevi.tasks.IrALaListaDeEmpleados;
import com.coudevi.tasks.LoginConCredenciales;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.coudevi.util.Configuration.getUrlBase;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
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
}
