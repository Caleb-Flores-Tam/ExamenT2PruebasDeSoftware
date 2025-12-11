package com.coudevi.stepdefinitions;

import com.coudevi.model.EmployeeData;
import com.coudevi.questions.EmpleadoEstaEnLaLista;
import com.coudevi.tasks.BuscarEmpleadoPorNombre;
import com.coudevi.tasks.GuardarEmpleado;
import com.coudevi.tasks.HacerClickEnBotonAddEmpleado;
import com.coudevi.tasks.RegistrarNuevoEmpleado;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class EmployeeManagementStepDefinitions {
    @When("hace clic en el botón {string} de empleados")
    public void haceClicEnElBotonDeEmpleados(String boton) {
        Actor admin = OnStage.theActorInTheSpotlight();
        admin.attemptsTo(
                HacerClickEnBotonAddEmpleado.enEmployeeList()
        );
    }
    @And("registra un nuevo empleado con los datos:")
    public void registraUnNuevoEmpleadoConLosDatos(DataTable dataTable) {
        Actor admin = OnStage.theActorInTheSpotlight();

        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        Map<String, String> datos = rows.get(0);

        EmployeeData employee = new EmployeeData(
                datos.get("firstName"),
                datos.get("middleName"),
                datos.get("lastName"),
                datos.get("employeeId")
        );

        admin.attemptsTo(
                RegistrarNuevoEmpleado.conDatos(employee)
        );
    }
    @And("guarda el nuevo empleado")
    public void guardaElNuevoEmpleado() {
        Actor admin = OnStage.theActorInTheSpotlight();
        admin.attemptsTo(
                GuardarEmpleado.enElFormulario()
        );
    }

    @Then("el empleado {string} debería aparecer en la lista de empleados")
    public void elEmpleadoDeberiaAparecerEnLaListaDeEmpleados(String nombreCompleto) {
        Actor admin = OnStage.theActorInTheSpotlight();
        admin.attemptsTo(
                BuscarEmpleadoPorNombre.conNombre(nombreCompleto)
        );

        admin.should(
                seeThat(
                        "el empleado aparece en la lista",
                        EmpleadoEstaEnLaLista.conNombre(nombreCompleto),
                        is(true)
                )
        );
    }
}
