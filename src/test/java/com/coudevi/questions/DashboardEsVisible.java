package com.coudevi.questions;

import com.coudevi.ui.DashboardPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class DashboardEsVisible implements Question<Boolean> {

    public static DashboardEsVisible enPantalla() {
        return new DashboardEsVisible();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return DashboardPage.DASHBOARD_HEADER.resolveFor(actor).isVisible();
    }
}
