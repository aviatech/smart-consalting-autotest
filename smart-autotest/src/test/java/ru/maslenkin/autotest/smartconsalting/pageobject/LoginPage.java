package ru.maslenkin.autotest.smartconsalting.pageobject;

import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public void setLogin(String login) {
        String loginLocator = "//input[@id='auth-username']";
        WebElement webElement = chromeDriver.findElementByXPath(loginLocator);
        webElement.clear();
        webElement.sendKeys(login);
    }

    public void setPassword(String password) {
        String passwordLocator = "//input[@id='auth-password']";
        WebElement webElement = chromeDriver.findElementByXPath(passwordLocator);
        webElement.clear();
        webElement.sendKeys(password);
    }

    public void pressLoginButton() {
        String submitButtonLocator = "//button[@type='submit']";
        WebElement webElement = chromeDriver.findElementByXPath(submitButtonLocator);
        webElement.click();
    }
}
