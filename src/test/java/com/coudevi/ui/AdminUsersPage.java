package com.coudevi.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AdminUsersPage {

    public static final Target ADD_BUTTON = Target.the("Boton Add")
            .located(By.xpath("//button[normalize-space()='Add']"));

    public static final Target SUCCESS_MESSAGE = Target.the("mensaje de éxito")
            .located(By.xpath("//div[contains(@class, 'oxd-toast')]"));

    public static final Target BTN_SAVE_EDIT = Target.the("botón guardar cambios de edición")
            .located(By.cssSelector(".oxd-form-actions button[type='submit']"));

    public static final Target USERNAME_SEARCH_INPUT = Target.the("Input Username de busqueda")
            .located(By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input"));
    public static final Target SEARCH_BUTTON = Target.the("Boton Search")
            .located(By.xpath("//button[@type='submit'][contains(.,'Search')]"));
    public static final Target LOADING_SPINNER = Target.the("Spinner de carga")
            .located(By.className("oxd-form-loader"));
    public static final Target EDIT_ICON_BY_USERNAME(String username) {
        return Target.the("Icono de editar para el usuario " + username)
                .located(By.xpath("//div[text()='" + username + "']/ancestor::div[@role='row']//button/i[@class='oxd-icon bi-pencil-fill']/parent::button"));
    }

    public static final Target EMPLOYEE_SUGGESTION(String employeeName) {
        return Target.the("Sugerencia de empleado: " + employeeName)
                .located(By.xpath("//div[@role='option'][contains(.,'" + employeeName + "')]"));
    }

    public static final Target ADMIN_MENU_LINK = Target.the("Menu Link Admin").located(By.xpath("//span[text()='Admin']"));

    public static final Target USER_MANAGEMENT_MENU = Target.the("Tab User Management")
            .located(By.xpath("//nav[@aria-label='System Administration']//span[text()='User Management']"));

    public static final Target USERS_SUBMENU = Target.the("Sub-Menu Users").located(By.xpath("//a[text()='Users']"));


    public static final Target USER_ROLE_DROPDOWN = Target.the("Dropdown User Role").located(By.xpath("(//div[@class='oxd-select-text-input'])[1]"));
    public static final Target EMPLOYEE_NAME_INPUT = Target.the("Input Employee Name").located(By.xpath("//input[@placeholder='Type for hints...']"));
    public static final Target STATUS_DROPDOWN = Target.the("Dropdown Status").located(By.xpath("(//div[@class='oxd-select-text-input'])[2]"));

    public static final Target USERNAME_INPUT = Target.the("Input Username")
            .located(By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input"));
    public static final Target PASSWORD_INPUT = Target.the("Input Password")
            .located(By.xpath("//label[text()='Password']/parent::div/following-sibling::div/input"));

    public static final Target CONFIRM_PASSWORD_INPUT = Target.the("Input Confirm Password")
            .located(By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div/input"));

    public static final Target SAVE_BUTTON = Target.the("Boton Save").located(By.xpath("//button[@type='submit']"));

    public static final Target USER_ROLE_IN_TABLE(String username) {
        return Target.the("Rol del usuario " + username)
                .located(By.xpath("//div[text()='" + username + "']/ancestor::div[@role='row']/div[3]"));
    }
}