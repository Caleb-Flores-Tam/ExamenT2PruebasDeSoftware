@ui @empleados @login
Feature: Login del administrador en OrangeHRM

  Como administrador del sistema
  Quiero iniciar sesión en OrangeHRM
  Para gestionar a los empleados y realizar tareas administrativas

  @login-admin-exitoso
  Scenario: Login exitoso con credenciales válidas
    Given que el administrador abre la página de login de OrangeHRM
    When inicia sesión con usuario "Admin" y contraseña "admin123"
    Then debería visualizar el panel principal del sistema

  @login-admin-fallido
  Scenario: Login fallido con credenciales inválidas
    Given que el administrador abre la página de login de OrangeHRM
    When inicia sesión con usuario "Admin" y contraseña "clave_invalida"
    Then debería visualizar un mensaje indicando que las credenciales son incorrectas
