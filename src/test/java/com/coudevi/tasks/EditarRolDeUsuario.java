package com.coudevi.tasks;

import com.coudevi.ui.AdminUsersPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static org.openqa.selenium.By.xpath;

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
        // Asumimos un Target que localiza el botón de edición por el username:
        // EDIT_ICON_BY_USERNAME(username)
        actor.attemptsTo(
                Click.on(AdminUsersPage.EDIT_ICON_BY_USERNAME(username)),
                WaitUntil.the(AdminUsersPage.USER_ROLE_DROPDOWN, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(AdminUsersPage.USER_ROLE_DROPDOWN),
                Click.on(xpath("//*[contains(text(), '" + newRole + "')]"))
        );
    }
}