package com.coudevi.tasks;

import com.coudevi.ui.AddEmployeePage;
import com.coudevi.ui.PersonalDetailsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GuardarEmpleado implements Task {

    public static GuardarEmpleado enElFormulario() {
        return instrumented(GuardarEmpleado.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(AddEmployeePage.BOTON_SAVE),
                WaitUntil.the(PersonalDetailsPage.TITULO_PERSONAL_DETAILS, isVisible())
        );
    }
}
