package com.coudevi.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DashboardPage {
    public static final Target DASHBOARD_HEADER = Target.the("título del dashboard")
            .located(By.cssSelector("h6.oxd-topbar-header-breadcrumb-module"));
}
