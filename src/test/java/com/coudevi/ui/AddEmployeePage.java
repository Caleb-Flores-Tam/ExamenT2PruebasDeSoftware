package com.coudevi.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AddEmployeePage {
    public static final Target CAMPO_FIRST_NAME = Target.the("campo First Name")
            .located(By.name("firstName"));

    public static final Target CAMPO_MIDDLE_NAME = Target.the("campo Middle Name")
            .located(By.name("middleName"));

    public static final Target CAMPO_LAST_NAME = Target.the("campo Last Name")
            .located(By.name("lastName"));

    public static final Target CAMPO_EMPLOYEE_ID = Target.the("campo Employee Id")
            .located(By.xpath("//label[normalize-space()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input"));

    public static final Target BOTON_SAVE = Target.the("botón Save de empleado")
            .located(By.xpath("//button[normalize-space()='Save']"));
}
