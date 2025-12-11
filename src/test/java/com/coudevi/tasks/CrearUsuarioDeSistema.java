package com.coudevi.tasks;

import com.coudevi.ui.AdminUsersPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Map;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static org.openqa.selenium.By.xpath;

public class CrearUsuarioDeSistema implements Task {

    private final List<Map<String, String>> userData;

    public CrearUsuarioDeSistema(List<Map<String, String>> userData) {
        this.userData = userData;
    }

    public static CrearUsuarioDeSistema conDatos(List<Map<String, String>> userData) {
        return instrumented(CrearUsuarioDeSistema.class, userData);
    }

    @Override
    @Step("{0} registra un nuevo usuario de sistema con rol ESS")
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> data = userData.get(0);
        String role = data.get("userRole");
        String employeeName = data.get("employeeName");
        String status = data.get("status");
        String username = data.get("username");
        String password = data.get("password");

        actor.attemptsTo(
                Click.on(AdminUsersPage.USER_ROLE_DROPDOWN),
                Click.on(xpath("//*[contains(text(), '" + role + "')]")),
                Enter.theValue(employeeName).into(AdminUsersPage.EMPLOYEE_NAME_INPUT),
                WaitUntil.the(AdminUsersPage.EMPLOYEE_SUGGESTION(employeeName), isClickable()).forNoMoreThan(10).seconds(),
                Click.on(AdminUsersPage.EMPLOYEE_SUGGESTION(employeeName)),
                Click.on(AdminUsersPage.STATUS_DROPDOWN),
                Click.on(xpath("//*[contains(text(), '" + status + "')]")),
                Enter.theValue(username).into(AdminUsersPage.USERNAME_INPUT),
                Enter.theValue(password).into(AdminUsersPage.PASSWORD_INPUT),
                Enter.theValue(password).into(AdminUsersPage.CONFIRM_PASSWORD_INPUT)
        );
    }
}