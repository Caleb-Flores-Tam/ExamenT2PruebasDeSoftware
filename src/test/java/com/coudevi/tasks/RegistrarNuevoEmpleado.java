package com.coudevi.tasks;

import com.coudevi.model.EmployeeData;
import com.coudevi.ui.AddEmployeePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegistrarNuevoEmpleado implements Task {
    private final EmployeeData employee;

    public RegistrarNuevoEmpleado(EmployeeData employee) {
        this.employee = employee;
    }
    public static RegistrarNuevoEmpleado conDatos(EmployeeData employee) {
        return instrumented(RegistrarNuevoEmpleado.class, employee);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(employee.getFirstName()).into(AddEmployeePage.CAMPO_FIRST_NAME),
                Enter.theValue(employee.getMiddleName()).into(AddEmployeePage.CAMPO_MIDDLE_NAME),
                Enter.theValue(employee.getLastName()).into(AddEmployeePage.CAMPO_LAST_NAME),
                Clear.field(AddEmployeePage.CAMPO_EMPLOYEE_ID),
                Enter.theValue(employee.getEmployeeId()).into(AddEmployeePage.CAMPO_EMPLOYEE_ID)
        );
    }
}
