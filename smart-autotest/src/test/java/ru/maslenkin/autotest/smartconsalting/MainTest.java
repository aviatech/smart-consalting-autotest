package ru.maslenkin.autotest.smartconsalting;

import org.testng.annotations.Test;
import ru.maslenkin.autotest.smartconsalting.pageobject.LoginPage;

public class MainTest {
    LoginPage loginPage = new LoginPage();

    @Test
    public void login() {
        loginPage.openPage();
        loginPage.setLogin();
        loginPage.setPassword();
        loginPage.pressLoginButton();
    }

}
