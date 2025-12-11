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
import java.time.Duration;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
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
        // Este paso se integró en la Task EditarRolDeUsuario para mayor coherencia
        // Si necesitas este step vacío, simplemente déjalo sin lógica compleja aquí:
        // theActorInTheSpotlight().should(seeThat("el botón de editar es visible", is(true)));
    }

    @When("actualiza el rol del usuario seleccionando {string}")
    public void actualiza_el_rol_del_usuario_seleccionando(String newRole) {
        // Usamos el username fijo "caleb.qa" ya que se busca justo antes en el Feature 5
        theActorInTheSpotlight().attemptsTo(
                EditarRolDeUsuario.yCambiarRolA("caleb.qa", newRole)
        );
    }

    @When("guarda los cambios del usuario")
    public void guarda_los_cambios_del_usuario() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(AdminUsersPage.SAVE_BUTTON)
        );
    }

    @Then("el usuario {string} ahora debería tener el rol {string}")
    public void el_usuario_ahora_debería_tener_el_rol(String username, String expectedRole) {
        // Reutiliza la Question de validación
        theActorInTheSpotlight().should(
                seeThat(RolUsuarioEsCorrecto.paraElUsuario(username, expectedRole), is(true))
        );
    }


    @And("navega al módulo de Gestión de Usuarios en la sección Admin")
    public void navegaAlModuloDeGestionDeUsuariosEnLaSeccionAdmin() {
        theActorInTheSpotlight().attemptsTo(
                // Clic en el menú Admin (sidebar)
                Click.on(AdminUsersPage.ADMIN_MENU_LINK),

                // Espera de 5s para que carguen los elementos, esperando la tabla de usuarios
                WaitUntil.the(AdminUsersPage.ADD_BUTTON, isClickable()).forNoMoreThan(5).seconds()

                // Nota: Si el clic en Admin ya nos lleva a la pantalla de System Users,
                // simplemente esperamos un elemento de esa pantalla (como el botón Add) y terminamos.
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
                // 1. Click en Guardar (Esto inicia la acción de guardado)
                Click.on(AdminUsersPage.SAVE_BUTTON),

                // 2. ESPERA DINÁMICA (POST-GUARDADO) - Usa la sintaxis forNoMoreThan()
                // Esperamos a que el botón Add (un elemento conocido de la página recargada)
                // sea clickeable. Esto confirma que el guardado finalizó y la tabla cargó.
                WaitUntil.the(AdminUsersPage.ADD_BUTTON, isClickable()).forNoMoreThan(10).seconds()
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