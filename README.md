# 🧪 Framework de Automatización de Pruebas - OrangeHRM

Este repositorio contiene un proyecto de automatización de pruebas End-to-End (E2E) para el sistema de gestión de recursos humanos **OrangeHRM**. El proyecto utiliza **Serenity BDD** con el patrón de diseño **Screenplay**, asegurando pruebas escalables, mantenibles y con reportes detallados.

![Build Status](https://img.shields.io/badge/Build-Passing-brightgreen) ![Java](https://img.shields.io/badge/Java-21%2B-orange) ![Serenity](https://img.shields.io/badge/Serenity_BDD-Screenplay-blue)

## 🚀 Características del Proyecto

Este framework ha sido diseñado para superar desafíos comunes en la automatización de interfaces modernas (React/Vue/Angular), incluyendo:

* **Patrón Screenplay:** Separación clara entre Actores, Tareas (Tasks) y Elementos de UI.
* **Manejo Robusto de Esperas:** Implementación de estrategias `WaitUntil` para manejar Spinners de carga (`oxd-form-loader`) y evitar *Flaky Tests*.
* **Selectores Resilientes:** Uso de Xpath dinámicos y `normalize-space()` para interactuar con elementos complejos.
* **Gestión de Estado:** Pruebas atómicas que crean sus propios datos de prueba (Empleados y Usuarios) para no depender de datos preexistentes.

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java 21 (JDK 17+)
* **Framework BDD:** Serenity BDD + Cucumber
* **Motor de Browser:** Selenium WebDriver
* **Gestor de Dependencias:** Maven
* **Assertions:** Hamcrest / Serenity Screenplay Matchers

## 📂 Estructura del Proyecto (Screenplay)

El código está organizado bajo el paquete `com.coudevi` siguiendo la estructura estándar de Screenplay:

```text
src/test/java/com/coudevi
├── model            # Objetos de dominio (EmployeeData, etc.)
├── tasks            # Acciones de alto nivel (EditarRolDeUsuario, BuscarUsuario, etc.)
├── ui               # Mapeo de elementos (Page Objects / Targets)
├── questions        # Aserciones y verificaciones (RolUsuarioEsCorrecto, etc.)
├── runners          # Ejecutores de pruebas (Test Runners)
└── stepdefinitions  # "Pegamento" entre Gherkin y código Java

```
***

## 🍿 Autor Caleb Flores Tambracc