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

    // 1. Constructor Original (para uso individual)
    public LoginConCredenciales(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // 2. Constructor de Sobrecarga (para uso con DataTable)
    public LoginConCredenciales(List<Map<String, String>> credentials) {
        // Asumimos que solo hay una fila en el DataTable para el login.
        this.username = credentials.get(0).get("user"); // Mapea al encabezado 'user'
        this.password = credentials.get(0).get("password"); // Mapea al encabezado 'password'
    }

    // Método estático para usar el constructor original (si aún lo usas)
    public static LoginConCredenciales conCredenciales(String username, String password){
        return instrumented(LoginConCredenciales.class, username, password);
    }

    // Método estático necesario para invocar desde la Step Definition con DataTable
    public static LoginConCredenciales conDatos(DataTable credentials){
        // Usamos el constructor de sobrecarga que recibe la lista de Mapas
        return instrumented(LoginConCredenciales.class, credentials.asMaps());
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Asegúrate de que los nombres de Target sean correctos, si los cambiaste:
                // LoginPage.USERNAME_FIELD y LoginPage.PASSWORD_FIELD
                theValue(username).into(LoginPage.USERNAME_FIELD),
                theValue(password).into(LoginPage.PASSWORD_FIELD),
                on(LoginPage.LOGIN_BUTTON)
        );
    }
}