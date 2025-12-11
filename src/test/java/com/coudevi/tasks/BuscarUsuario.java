package com.coudevi.tasks;

import com.coudevi.ui.AdminUsersPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BuscarUsuario implements Task {
    private final String username;

    public BuscarUsuario(String username) { this.username = username; }
    public static BuscarUsuario porUsername(String username) {
        return instrumented(BuscarUsuario.class, username);
    }

    @Override
    @Step("{0} busca al usuario '{1}' en la lista de usuarios del sistema")
    public <T extends Actor> void performAs(T actor) {
        // Asume que AdminUsersPage tiene USERNAME_SEARCH_INPUT y SEARCH_BUTTON
        actor.attemptsTo(
                Enter.theValue(username).into(AdminUsersPage.USERNAME_SEARCH_INPUT),
                Click.on(AdminUsersPage.SEARCH_BUTTON)
        );
    }
}