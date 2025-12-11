package com.coudevi.tasks;

import com.coudevi.ui.EmployeeListPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class HacerClickEnBotonAddEmpleado implements Task {
    public static HacerClickEnBotonAddEmpleado enEmployeeList() {
        return instrumented(HacerClickEnBotonAddEmpleado.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(EmployeeListPage.BOTON_ADD)
        );
    }
}
