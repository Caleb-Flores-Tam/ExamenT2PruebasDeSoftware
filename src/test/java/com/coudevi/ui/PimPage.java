package com.coudevi.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PimPage {
    public static final Target MENU_PIM = Target.the("opción de menú PIM")
            .located(By.xpath("//span[text()='PIM']/ancestor::a"));

    public static final Target BTN_SEARCH = Target.the("botón Search")
            .located(By.cssSelector("button.orangehrm-left-space"));
    public static final Target EMPLOYEE_ROWS = Target.the("filas de la lista de empleados")
            .located(By.cssSelector(".oxd-table-row.oxd-table-row--with-border"));
    public static final Target TITLE_EMPLOYEE_INFORMATION = Target.the("título Employee Information")
            .located(By.xpath("//h5[text()='Employee Information']"));

    public static final Target FILAS_TABLA = Target.the("filas de la tabla de empleados")
            .located(By.cssSelector("div.oxd-table-body div[role='row']"));

    public static final Target INPUT_EMPLOYEE_NAME = Target.the("campo Employee Name")
            .located(By.cssSelector("div.oxd-autocomplete-wrapper input[placeholder='Type for hints...']"));

    public static final Target SECCION_LISTA_EMPLEADOS = Target.the("Sección Employee Information")
            .located(By.xpath("//h5[text()='Employee Information']"));
}
