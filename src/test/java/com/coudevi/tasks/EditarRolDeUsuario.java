package com.coudevi.tasks;

import com.coudevi.ui.AdminUsersPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class EditarRolDeUsuario implements Task {

    private final String username;
    private final String newRole;

    public EditarRolDeUsuario(String username, String newRole) {
        this.username = username;
        this.newRole = newRole;
    }

    public static EditarRolDeUsuario yCambiarRolA(String username, String newRole) {
        return instrumented(EditarRolDeUsuario.class, username, newRole);
    }

    @Override
    @Step("{0} edita el usuario '{1}' y cambia el rol a '{2}'")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // 1. CLIC EN EL BOTÓN DE EDICIÓN
                // El selector debe ser robusto y usar el username pasado como parámetro.
                Click.on(AdminUsersPage.EDIT_ICON_BY_USERNAME(username)),

                // 2. ESPERAR que el formulario de edición cargue y que el Dropdown sea interactuable
                WaitUntil.the(AdminUsersPage.USER_ROLE_DROPDOWN, isClickable()).forNoMoreThan(10).seconds(),

                // 3. SELECCIONAR EL NUEVO ROL (Admin) [cite: 79]
                // Clic en el dropdown (que actualmente dice "ESS")
                Click.on(AdminUsersPage.USER_ROLE_DROPDOWN),

                // Clic en la opción 'Admin' de la lista desplegable
                Click.on(By.xpath("//*[contains(text(), '" + newRole + "')]"))
        );
    }
}