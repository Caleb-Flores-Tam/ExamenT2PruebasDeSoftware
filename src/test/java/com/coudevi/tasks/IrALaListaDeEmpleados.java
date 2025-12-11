package com.coudevi.tasks;

import com.coudevi.ui.PimPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IrALaListaDeEmpleados implements Task {

    public static IrALaListaDeEmpleados desdeElDashboard() {
        return instrumented(IrALaListaDeEmpleados.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PimPage.MENU_PIM),
                WaitUntil.the(PimPage.TITLE_EMPLOYEE_INFORMATION, isVisible())
                        .forNoMoreThan(10).seconds()
        );
    }
}
