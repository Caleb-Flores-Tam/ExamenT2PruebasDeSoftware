package com.coudevi.tasks;

import com.coudevi.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actions.Enter.theValue;
import static net.serenitybdd.screenplay.actions.Click.on;

public class LoginConCredenciales implements Task {
    private final String username;
    private final String password;
    public LoginConCredenciales(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public LoginConCredenciales(List<Map<String, String>> credentials) {
        this.username = credentials.get(0).get("user"); // Mapea al encabezado 'user'
        this.password = credentials.get(0).get("password"); // Mapea al encabezado 'password'
    }
    public static LoginConCredenciales conCredenciales(String username, String password){
        return instrumented(LoginConCredenciales.class, username, password);
    }

    public static LoginConCredenciales conDatos(DataTable credentials){
        return instrumented(LoginConCredenciales.class, credentials.asMaps());
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                theValue(username).into(LoginPage.USERNAME_FIELD),
                theValue(password).into(LoginPage.PASSWORD_FIELD),
                on(LoginPage.LOGIN_BUTTON)
        );
    }
}