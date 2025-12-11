package com.coudevi.questions;

import com.coudevi.ui.AdminUsersPage;
import com.coudevi.ui.MenuLateral; // Importar el Target que creaste

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.Visibility;

public class OpcionMenuEsVisible implements Question<Boolean> {

    private final String opcionMenu;

    public OpcionMenuEsVisible(String opcionMenu) {
        this.opcionMenu = opcionMenu;
    }

    public static OpcionMenuEsVisible laOpcion(String opcionMenu) {
        return new OpcionMenuEsVisible(opcionMenu);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        // Usa el Target de MenuLateral con el parámetro:
        return Visibility.of(MenuLateral.OPCION_DE_MENU.of(opcionMenu)).answeredBy(actor);
    }
}