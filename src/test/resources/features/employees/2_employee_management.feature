@ui @empleados
Feature: Gestión de empleados en OrangeHRM
  Como administrador del sistema
  Quiero gestionar la información de los empleados
  Para mantener actualizada la base de datos de personal

  Background:
    Given que el administrador ha iniciado sesión en OrangeHRM
    And se encuentra en la sección "Employee List" del módulo PIM

  @crear-empleado
  Scenario: Registrar un nuevo empleado de forma exitosa
    When hace clic en el botón "Add" de empleados
    And registra un nuevo empleado con los datos:
      | firstName | middleName | lastName | employeeId |
      | mario   | tito         | caceres  | 8888       |
    And guarda el nuevo empleado
    Then el empleado "mario" debería aparecer en la lista de empleados