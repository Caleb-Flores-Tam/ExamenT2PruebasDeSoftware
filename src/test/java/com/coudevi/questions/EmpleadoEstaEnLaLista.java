package com.coudevi.questions;

import com.coudevi.tasks.BuscarEmpleadoPorNombre;
import com.coudevi.ui.PimPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.WebElement;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EmpleadoEstaEnLaLista implements Question<Boolean> {
    private final String nombreCompleto;

    private EmpleadoEstaEnLaLista(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public static EmpleadoEstaEnLaLista conNombre(String nombreCompleto) {
        return new EmpleadoEstaEnLaLista(nombreCompleto);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        List<String> filas = PimPage.EMPLOYEE_ROWS.resolveAllFor(actor)
                .stream()
                .map(WebElement::getText)
                .toList();

        System.out.println("FILAS ENCONTRADAS:");
        filas.forEach(System.out::println);
        return filas.stream()
                .anyMatch(fila -> fila.contains(nombreCompleto));
    }

}