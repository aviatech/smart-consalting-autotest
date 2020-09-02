package ru.maslenkin.autotest.smartconsalting;

import org.testng.annotations.Test;
import ru.maslenkin.autotest.smartconsalting.pageobject.LoginPage;

public class MainTest {
    LoginPage loginPage = new LoginPage();

    @Test
    public void login() {
        loginPage.open();
        loginPage.setLogin("testuser");
        loginPage.setPassword("testuser123");
        loginPage.pressLoginButton();
    }

}
