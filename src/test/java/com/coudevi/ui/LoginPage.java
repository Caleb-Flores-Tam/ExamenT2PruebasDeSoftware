package com.coudevi.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static final Target USERNAME_FIELD = Target.the("campo de usuario")
            .located(By.name("username"));

    public static final Target PASSWORD_FIELD = Target.the("campo de contraseña")
            .located(By.name("password"));

    public static final Target LOGIN_BUTTON = Target.the("botón de login")
            .located(By.cssSelector("button.orangehrm-login-button"));
    public static final Target LOGIN_ERROR_MESSAGE = Target.the("mensaje de error de login")
            .located(By.cssSelector("p.oxd-alert-content-text"));
}
