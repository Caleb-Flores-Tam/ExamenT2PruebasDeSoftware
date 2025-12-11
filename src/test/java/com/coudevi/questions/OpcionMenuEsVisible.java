package com.coudevi.questions;

import com.coudevi.ui.MenuLateral; // Importar el Target que creaste

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.Visibility;

public class OpcionMenuEsVisible implements Question<Boolean> {

    private final String opcionMenu;

    // Constructor para inicializar la opción de menú a buscar
    public OpcionMenuEsVisible(String opcionMenu) {
        this.opcionMenu = opcionMenu;
    }

    // Método estático para usar la Question fácilmente en el Step Definition
    public static OpcionMenuEsVisible laOpcion(String opcionMenu) {
        return new OpcionMenuEsVisible(opcionMenu);
    }

    // Lógica de la Question: pregunta si el Target es visible
    @Override
    public Boolean answeredBy(Actor actor) {
        // Reemplaza el placeholder {0} en el Target con la opción de menú provista
        return Visibility.of(MenuLateral.OPCION_DE_MENU.of(opcionMenu))
                .answeredBy(actor);
    }
}