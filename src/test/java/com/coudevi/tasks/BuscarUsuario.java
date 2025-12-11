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
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class BuscarUsuario implements Task {
    private final String username;

    public BuscarUsuario(String username) { this.username = username; }
    public static BuscarUsuario porUsername(String username) {
        return instrumented(BuscarUsuario.class, username);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // 1. ESPERA INICIAL: Aumentamos a 15 segundos.
                // A veces la página tarda en quitar el spinner inicial.
                WaitUntil.the(AdminUsersPage.LOADING_SPINNER, isNotVisible())
                        .forNoMoreThan(15).seconds(),

                // 2. Verificar que el input sea interactuable antes de tocarlo
                WaitUntil.the(AdminUsersPage.USERNAME_SEARCH_INPUT, isClickable())
                        .forNoMoreThan(10).seconds(),

                // 3. Limpiar y Escribir
                Clear.field(AdminUsersPage.USERNAME_SEARCH_INPUT),
                Enter.theValue(username).into(AdminUsersPage.USERNAME_SEARCH_INPUT),

                // 4. Click en Buscar
                WaitUntil.the(AdminUsersPage.SEARCH_BUTTON, isClickable()),
                Click.on(AdminUsersPage.SEARCH_BUTTON),

                // 5. ESPERA FINAL (CRÍTICA):
                // Al dar clic en Buscar, el spinner vuelve a aparecer. Debemos esperar a que se vaya de nuevo.
                WaitUntil.the(AdminUsersPage.LOADING_SPINNER, isNotVisible())
                        .forNoMoreThan(15).seconds()
        );
    }
}