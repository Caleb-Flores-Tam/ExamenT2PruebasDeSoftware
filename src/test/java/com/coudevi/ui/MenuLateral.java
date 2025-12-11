package com.coudevi.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

// Definimos los Targets del menú lateral de la aplicación
public class MenuLateral {

    // El localizador más robusto es por el texto del enlace (<a>) en el menú.
    // Usamos un placeholder {0} que será reemplazado por la opción que buscamos ("Admin", "PIM", "Leave", etc.).
    //public static final Target OPCION_DE_MENU = Target.the("la opción de menú llamada '{0}'")
            //.located(By.xpath("//*[@class='oxd-main-menu-item-wrapper']/a/span[text()='{0}']"));
    public static final Target OPCION_DE_MENU = Target.the("Opcion de menu")
            .locatedBy("//span[text()='{0}']");
    private MenuLateral() {
        // Clase de utilidades estática
    }
}