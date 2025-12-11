package com.coudevi.tasks;

import com.coudevi.ui.AdminUsersPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;

import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Map;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.openqa.selenium.By.xpath;

public class CrearUsuarioDeSistema implements Task {

    private final List<Map<String, String>> userData;

    public CrearUsuarioDeSistema(List<Map<String, String>> userData) {
        this.userData = userData;
    }

    public static CrearUsuarioDeSistema conDatos(List<Map<String, String>> userData) {
        return new CrearUsuarioDeSistema(userData);
    }

    @Override
    @Step("{0} registra un nuevo usuario de sistema")
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> data = userData.get(0);
        String role = data.get("userRole");
        String employeeName = data.get("employeeName");
        String status = data.get("status");
        String username = data.get("username");
        String password = data.get("password");

        actor.attemptsTo(
                // 1. Seleccionar Rol (Dropdown)
                Click.on(AdminUsersPage.USER_ROLE_DROPDOWN),
                Click.on(xpath("//*[contains(text(), '" + role + "')]")),

                // 2. Ingresar Nombre de Empleado (Autocomplete)
                Enter.theValue(employeeName).into(AdminUsersPage.EMPLOYEE_NAME_INPUT),
                // Espera a que la lista de sugerencias aparezca
                WaitUntil.the(xpath("//*[contains(text(), '" + employeeName + "')]"), isVisible()).forNoMoreThan(10).seconds(),
                // Selecciona el primer resultado
                SendKeys.of(Keys.ARROW_DOWN, Keys.ENTER).into(AdminUsersPage.EMPLOYEE_NAME_INPUT),

                // 3. Seleccionar Estado (Dropdown)
                Click.on(AdminUsersPage.STATUS_DROPDOWN),
                Click.on(xpath("//*[contains(text(), '" + status + "')]")),

                // 4. Ingresar Username y Passwords
                Enter.theValue(username).into(AdminUsersPage.USERNAME_INPUT),
                Enter.theValue(password).into(AdminUsersPage.PASSWORD_INPUT),
                Enter.theValue(password).into(AdminUsersPage.CONFIRM_PASSWORD_INPUT)
        );
    }
}