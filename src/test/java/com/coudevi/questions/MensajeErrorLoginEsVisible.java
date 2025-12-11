package com.coudevi.questions;

import com.coudevi.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class MensajeErrorLoginEsVisible implements Question<Boolean> {

    public static MensajeErrorLoginEsVisible enPantalla() {
        return new MensajeErrorLoginEsVisible();
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        return LoginPage.LOGIN_ERROR_MESSAGE.resolveFor(actor).isVisible();
    }
}
