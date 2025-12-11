package com.coudevi.tasks;
import com.coudevi.ui.AdminUsersPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear; // Import necesario para limpiar
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil; // Generalmente útil para sincronización

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class BuscarUsuario implements Task {
    private final String username;

    public BuscarUsuario(String username) { this.username = username; }
    public static BuscarUsuario porUsername(String username) {
        return instrumented(BuscarUsuario.class, username);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Aseguramos que el campo de búsqueda esté listo
        actor.attemptsTo(
                // 1. Limpia el campo antes de escribir (CORRECCIÓN CRÍTICA DE SINTAXIS)
                Clear.field(AdminUsersPage.USERNAME_SEARCH_INPUT), // Usa Clear.field() o Clear.text()

                // 2. Escribe el username
                Enter.theValue(username).into(AdminUsersPage.USERNAME_SEARCH_INPUT),

                // 3. Espera a que el botón de búsqueda sea clickeable y haz click
                WaitUntil.the(AdminUsersPage.SEARCH_BUTTON, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(AdminUsersPage.SEARCH_BUTTON)
        );
    }
}