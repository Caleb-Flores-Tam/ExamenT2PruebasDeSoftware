# language: en
@ui @seguridad
Feature: Validar Permisos Limitados para Usuario ESS
  As a System User with ESS Role
  I want to log in to the system
  So that I can verify my access is restricted

  Background:
    Given que el usuario se encuentra en la pantalla de login

  @validar-sin-admin
  Scenario: Iniciar sesión con usuario ESS y verificar ausencia del menú Admin
    When ingresa las credenciales de acceso:
      | user     | password     |
      | caleb.qa | clave123     |
    Then el Dashboard debería mostrarse correctamente
    And la opción "Admin" NO debería aparecer en el menú lateral