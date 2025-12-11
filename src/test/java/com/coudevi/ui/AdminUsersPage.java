package com.coudevi.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AdminUsersPage {

    // Nuevos Selectores para Búsqueda (Feature 5)
    public static final Target USERNAME_SEARCH_INPUT = Target.the("Input Username de busqueda")
            .located(By.xpath("(//div[@class='oxd-input-group oxd-input-field-bottom-space'])[1]//input"));
    public static final Target SEARCH_BUTTON = Target.the("Boton Search").located(By.xpath("//button[@type='submit']"));

    // Selector de Edición (Feature 5)
    public static final Target EDIT_ICON_BY_USERNAME(String username) {
        // Busca el ícono de lápiz en la fila del usuario especificado
        return Target.the("Icono de editar para el usuario " + username)
                .located(By.xpath("//div[text()='" + username + "']/ancestor::div[@role='row']//i[@class='oxd-icon bi-pencil-fill']"));
    }

    public static final Target EMPLOYEE_SUGGESTION(String employeeName) {
        // Busca cualquier elemento *dentro* del contenedor de opciones que contenga el texto.
        // Esto es más flexible que buscar por un <span> específico.
        return Target.the("Sugerencia de empleado: " + employeeName)
                .located(By.xpath("//div[@role='option'][contains(.,'" + employeeName + "')]"));
        // Usamos [contains(.,'...')], que busca el texto en cualquier nodo dentro del div[@role='option']
    }

    // Selector robusto para el link principal 'Admin' en el menú lateral (sidebar)
    public static final Target ADMIN_MENU_LINK = Target.the("Menu Link Admin").located(By.xpath("//span[text()='Admin']"));

    // Selector robusto para la PESTAÑA horizontal 'User Management'
    // A veces, la simple búsqueda por span[text()='...'] falla si el span está anidado.
    // Usaremos un selector que apunte al <a> o <span> dentro del componente de navegación principal:
    public static final Target USER_MANAGEMENT_MENU = Target.the("Tab User Management")
            .located(By.xpath("//nav[@aria-label='System Administration']//span[text()='User Management']"));

    // Selector para el sub-link 'Users' (que a menudo se abre debajo de User Management)
    public static final Target USERS_SUBMENU = Target.the("Sub-Menu Users").located(By.xpath("//a[text()='Users']"));


    // Selector del botón para agregar
    public static final Target ADD_BUTTON = Target.the("Boton Add").located(By.xpath("//button[text()=' Add ']"));

    // Selectores del formulario de creacion de usuario
    public static final Target USER_ROLE_DROPDOWN = Target.the("Dropdown User Role").located(By.xpath("(//div[@class='oxd-select-text-input'])[1]"));
    public static final Target EMPLOYEE_NAME_INPUT = Target.the("Input Employee Name").located(By.xpath("//input[@placeholder='Type for hints...']"));
    public static final Target STATUS_DROPDOWN = Target.the("Dropdown Status").located(By.xpath("(//div[@class='oxd-select-text-input'])[2]"));

    // Selector para Username: Busca la etiqueta 'Username' y luego el input dentro de su contenedor.
    public static final Target USERNAME_INPUT = Target.the("Input Username")
            .located(By.xpath("//label[text()='Username']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input"));

    // Selector para Password: Usa la misma lógica del label
    public static final Target PASSWORD_INPUT = Target.the("Input Password")
            .located(By.xpath("//label[text()='Password']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input"));

    // Selector para Confirm Password: Usa la misma lógica del label
    public static final Target CONFIRM_PASSWORD_INPUT = Target.the("Input Confirm Password")
            .located(By.xpath("//label[text()='Confirm Password']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input"));

    // Selector para Botón Save
    public static final Target SAVE_BUTTON = Target.the("Boton Save").located(By.xpath("//button[@type='submit']"));

    // Selectores de la tabla de resultados (Validación)
    // Localiza la fila de un usuario por su Username (primera columna de datos).
    public static final Target USER_ROLE_IN_TABLE(String username) {
        // Busca el elemento del rol (que es el tercer div de datos en esa fila).
        return Target.the("Rol del usuario " + username)
                .located(By.xpath("//div[text()='" + username + "']/ancestor::div[@role='row']/div[3]"));
    }
}