# language: en
@ui @seguridad
Feature: Validar Acceso Total para Nuevo Administrador
  As a System User with Admin Role
  I want to log in to the system
  So that I can verify I have full administration access

  Background:
    Given que el usuario se encuentra en la pantalla de login

  @validar-acceso-admin
  Scenario: Iniciar sesión con el usuario actualizado y verificar acceso total
    When ingresa las credenciales de acceso:
      | user     | password     |
      | caleb.floresCibertec | clave123    |
    Then el Dashboard debería mostrarse correctamente
    And la opción "Admin" DEBERÍA ser visible en el menú lateral