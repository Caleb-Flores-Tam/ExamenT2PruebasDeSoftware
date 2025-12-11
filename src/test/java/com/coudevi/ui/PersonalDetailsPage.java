package com.coudevi.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PersonalDetailsPage {
    public static final Target TITULO_PERSONAL_DETAILS = Target.the("título Personal Details")
            .located(By.cssSelector("h6.oxd-text.oxd-text--h6.orangehrm-main-title"));
}