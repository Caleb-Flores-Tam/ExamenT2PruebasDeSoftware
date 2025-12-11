package com.coudevi.questions;

import com.coudevi.ui.AdminUsersPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

@Subject("Valida que el usuario '#username' tiene el rol '#expectedRole'")
public class RolUsuarioEsCorrecto implements Question<Boolean> {

    private final String username;
    private final String expectedRole;

    public RolUsuarioEsCorrecto(String username, String expectedRole) {
        this.username = username;
        this.expectedRole = expectedRole;
    }

    public static RolUsuarioEsCorrecto paraElUsuario(String username, String expectedRole) {
        return new RolUsuarioEsCorrecto(username, expectedRole);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        // Obtenemos el texto de la columna de Rol para ese Username específico
        String actualRole = Text.of(AdminUsersPage.USER_ROLE_IN_TABLE(username))
                .answeredBy(actor);

        return actualRole.trim().equals(expectedRole);
    }
}