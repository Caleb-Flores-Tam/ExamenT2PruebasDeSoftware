package com.coudevi.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AdminUsersPage {
    // Selectores para la navegación al módulo Admin
    public static final Target ADMIN_MENU_LINK = Target.the("Menu Link Admin").located(By.xpath("//span[text()='Admin']"));
    public static final Target USER_MANAGEMENT_MENU = Target.the("Menu User Management").located(By.xpath("//span[text()='User Management']"));
    public static final Target USERS_SUBMENU = Target.the("Sub-Menu Users").located(By.xpath("//a[text()='Users']"));

    // Selector del botón para agregar
    public static final Target ADD_BUTTON = Target.the("Boton Add").located(By.xpath("//button[text()=' Add ']"));

    // Selectores del formulario de creacion de usuario
    public static final Target USER_ROLE_DROPDOWN = Target.the("Dropdown User Role").located(By.xpath("(//div[@class='oxd-select-text-input'])[1]"));
    public static final Target EMPLOYEE_NAME_INPUT = Target.the("Input Employee Name").located(By.xpath("//input[@placeholder='Type for hints...']"));
    public static final Target STATUS_DROPDOWN = Target.the("Dropdown Status").located(By.xpath("(//div[@class='oxd-select-text-input'])[2]"));
    public static final Target USERNAME_INPUT = Target.the("Input Username").located(By.xpath("(//div[@class='oxd-input-group oxd-input-field-bottom-space'])[3]//input"));
    public static final Target PASSWORD_INPUT = Target.the("Input Password").located(By.xpath("(//input[@type='password'])[1]"));
    public static final Target CONFIRM_PASSWORD_INPUT = Target.the("Input Confirm Password").located(By.xpath("(//input[@type='password'])[2]"));
    public static final Target SAVE_BUTTON = Target.the("Boton Save").located(By.xpath("//button[@type='submit']"));

    // Selectores de la tabla de resultados (Validación)
    // Localiza la fila de un usuario por su Username (primera columna de datos).
    public static final Target USER_ROLE_IN_TABLE(String username) {
        // Busca el elemento del rol (que es el tercer div de datos en esa fila).
        return Target.the("Rol del usuario " + username)
                .located(By.xpath("//div[text()='" + username + "']/ancestor::div[@role='row']/div[3]"));
    }
}