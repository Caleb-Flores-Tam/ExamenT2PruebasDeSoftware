package com.coudevi.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuLateral {

    public static final Target OPCION_ADMIN = Target.the("Opcion Admin del menu").located(By.xpath("//span[contains(text(), 'Admin')]"));
    public static final Target OPCION_DE_MENU(String optionName) {
        return Target.the("Opción de menú " + optionName)
                .located(By.xpath("//span[text()='" + optionName + "']"));
    }
    public static final Target OPCION_DE_MENU = Target.the("Cualquier opción del menú lateral")
            .locatedBy("//span[text()='{0}']");

    private MenuLateral() {
    }
}