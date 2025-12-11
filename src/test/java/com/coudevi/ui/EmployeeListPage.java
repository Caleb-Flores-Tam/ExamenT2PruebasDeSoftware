package com.coudevi.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EmployeeListPage {
    public static final Target BOTON_ADD = Target.the("botón Add de la lista de empleados")
            .located(By.xpath("//button[normalize-space()='Add']"));
}
