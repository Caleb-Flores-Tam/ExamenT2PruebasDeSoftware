# language: en
@ui @gestion-usuarios
Feature: Asignar Rol Employee Self Service (ESS)
  As a System Administrator
  I want to create a system user for an employee
  So that I can assign them limited access permissions

  Background:
    Given que el administrador genérico ha iniciado sesión con éxito
    And navega al módulo de Gestión de Usuarios en la sección Admin

  @crear-usuario-ess
  Scenario: Crear un usuario de sistema con rol ESS para el empleado registrado
    # Hacer clic en el botón Add
    When hace clic en el botón para agregar un nuevo usuario
    # Completar formulario con Rol ESS, Empleado, Usuario, Password
    And registra un nuevo usuario con los siguientes datos:
      | userRole | employeeName  | status  | username | password     |
      | ESS      | caleb        | Enabled | caleb.lol | clave123     |
    # Hacer clic en Save
    And guarda el usuario en el sistema
    # Validar que el usuario aparece en la lista con rol ESS
    Then el usuario "caleb.lol" debería existir en la lista con el rol "ESS"