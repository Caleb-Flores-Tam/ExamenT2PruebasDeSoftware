package com.coudevi.tasks;

import com.coudevi.ui.PimPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BuscarEmpleadoPorNombre implements Task {
    private final String nombreCompleto;

    public BuscarEmpleadoPorNombre(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public static BuscarEmpleadoPorNombre conNombre(String nombreCompleto) {
        return instrumented(BuscarEmpleadoPorNombre.class, nombreCompleto);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PimPage.MENU_PIM),
                WaitUntil.the(PimPage.SECCION_LISTA_EMPLEADOS, isVisible())
        );

        actor.attemptsTo(
                Clear.field(PimPage.INPUT_EMPLOYEE_NAME),
                Enter.theValue(nombreCompleto).into(PimPage.INPUT_EMPLOYEE_NAME),
                Hit.the(Keys.ENTER).into(PimPage.INPUT_EMPLOYEE_NAME),
                Click.on(PimPage.BTN_SEARCH)
        );

        actor.attemptsTo(
                WaitUntil.the(PimPage.FILAS_TABLA, isVisible())
        );
    }
}
