package com.coudevi.stepdefinitions;

import com.coudevi.tasks.CrearUsuarioDeSistema;
import com.coudevi.questions.RolUsuarioEsCorrecto;
import com.coudevi.ui.AdminUsersPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static org.hamcrest.Matchers.is;

public class UserManagementStepDefinitions {

    @And("navega al módulo de Gestión de Usuarios en la sección Admin")
    public void navegaAlModuloDeGestionDeUsuariosEnLaSeccionAdmin() {
        theActorInTheSpotlight().attemptsTo(
                // 1. Clic en el menú principal "Admin" (en el sidebar)
                Click.on(AdminUsersPage.ADMIN_MENU_LINK),

                // 2. ESPERA explícita: Espera hasta 10 segundos a que el tab 'User Management' sea clickable.
                // Esto soluciona la TimeoutException.
                WaitUntil.the(AdminUsersPage.USER_MANAGEMENT_MENU, isClickable()).forNoMoreThan(10).seconds(),

                // 3. Clic en el sub-menú 'User Management' (horizontal)
                Click.on(AdminUsersPage.USER_MANAGEMENT_MENU),

                // 4. Clic en el sub-sub-menú 'Users'
                Click.on(AdminUsersPage.USERS_SUBMENU)
        );
    }

    @When("hace clic en el botón para agregar un nuevo usuario")
    public void haceClicEnElBotonParaAgregarUnNuevoUsuario() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(AdminUsersPage.ADD_BUTTON)
        );
    }

    @And("registra un nuevo usuario con los siguientes datos:")
    public void registraUnNuevoUsuarioConLosSiguientesDatos(DataTable userData) {
        theActorInTheSpotlight().attemptsTo(
                // La Task recibe directamente los nuevos datos: Caleb Test QA, caleb.qa, clave123
                CrearUsuarioDeSistema.conDatos(userData.asMaps())
        );
    }

    @And("guarda el usuario en el sistema")
    public void guardaElUsuarioEnElSistema() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(AdminUsersPage.SAVE_BUTTON)
        );
    }

    @Then("el usuario {string} debería existir en la lista con el rol {string}")
    public void elUsuarioDeberiaExistirEnLaListaConElRol(String username, String expectedRole) {
        theActorInTheSpotlight().should(
                // La Question valida que "caleb.qa" tiene el rol "ESS"
                seeThat(RolUsuarioEsCorrecto.paraElUsuario(username, expectedRole), is(true))
        );
    }
}