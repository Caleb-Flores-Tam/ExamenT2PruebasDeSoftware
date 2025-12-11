# language: en
@ui @gestion-usuarios @promover-a-admin
Feature: Elevar Rol de Usuario a Administrador
  As a System Administrator
  I want to modify a system user's role
  So that I can grant them full administration privileges

  Background:
    Given que el administrador genérico ha iniciado sesión con éxito
    And navega al módulo de Gestión de Usuarios en la sección Admin

  @promover-a-admin
  Scenario: Cambiar el rol del usuario de ESS a Administrador
    When busca al usuario "caleb.idk"
    And hace clic en el botón editar del usuario encontrado
    And actualiza el rol del usuario seleccionando "Admin"
    And guarda los cambios del usuario
    Then el usuario "caleb.idk" ahora debería tener el rol "Admin"