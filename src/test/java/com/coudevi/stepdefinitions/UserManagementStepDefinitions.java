package com.coudevi.stepdefinitions;

import com.coudevi.tasks.BuscarUsuario;
import com.coudevi.tasks.CrearUsuarioDeSistema;
import com.coudevi.questions.RolUsuarioEsCorrecto;
import com.coudevi.tasks.EditarRolDeUsuario;
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
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.is;

public class UserManagementStepDefinitions {

    @When("busca al usuario {string}")
    public void busca_al_usuario(String username) {
        theActorInTheSpotlight().attemptsTo(
                BuscarUsuario.porUsername(username)
        );
    }
    @When("hace clic en el botón editar del usuario encontrado")
    public void hace_clic_en_el_botón_editar_del_usuario_encontrado() {
    }

    @When("actualiza el rol del usuario seleccionando {string}")
    public void actualiza_el_rol_del_usuario_seleccionando(String newRole) {
        String usernameDeEdicion = "caleb.lol";

        theActorInTheSpotlight().attemptsTo(
                EditarRolDeUsuario.yCambiarRolA(usernameDeEdicion, newRole)
        );
    }

    @When("guarda los cambios del usuario")
    public void guarda_los_cambios_del_usuario() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(AdminUsersPage.BTN_SAVE_EDIT),

                WaitUntil.the(AdminUsersPage.SUCCESS_MESSAGE, isVisible())
                        .forNoMoreThan(10).seconds()
        );
    }

    @Then("el usuario {string} ahora debería tener el rol {string}")
    public void el_usuario_ahora_debería_tener_el_rol(String username, String expectedRole) {
        theActorInTheSpotlight().attemptsTo(
                BuscarUsuario.porUsername(username)
        );

        theActorInTheSpotlight().should(
                seeThat(RolUsuarioEsCorrecto.paraElUsuario(username, expectedRole), is(true))
        );
    }

    @And("navega al módulo de Gestión de Usuarios en la sección Admin")
    public void navegaAlModuloDeGestionDeUsuariosEnLaSeccionAdmin() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(AdminUsersPage.ADMIN_MENU_LINK),
                WaitUntil.the(AdminUsersPage.ADD_BUTTON, isClickable()).forNoMoreThan(5).seconds()
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
                CrearUsuarioDeSistema.conDatos(userData.asMaps())
        );
    }


    @And("guarda el usuario en el sistema")
    public void guardaElUsuarioEnElSistema() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(AdminUsersPage.SAVE_BUTTON),

                WaitUntil.the(AdminUsersPage.SUCCESS_MESSAGE, isVisible())
                        .forNoMoreThan(10).seconds()
        );
    }

    @Then("el usuario {string} debería existir en la lista con el rol {string}")
    public void elUsuarioDeberiaExistirEnLaListaConElRol(String username, String expectedRole) {
        theActorInTheSpotlight().attemptsTo(
                BuscarUsuario.porUsername(username)
        );
        theActorInTheSpotlight().should(
                seeThat(RolUsuarioEsCorrecto.paraElUsuario(username, expectedRole), is(true))
        );
    }
}