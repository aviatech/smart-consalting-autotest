package ru.maslenkin.autotest.smartconsalting.pageobject;

import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public void openPage() {
        chromeDriver.get("http://point3.smart-consulting.ru/#/login/");
    }

    public void setLogin() {
        String loginLocator = "//*[@id='auth-username']";
        WebElement webElement = chromeDriver.findElementByXPath(loginLocator);
        webElement.clear();
        webElement.sendKeys("testuser");
    }

    public void setPassword() {
        String passwordLocator = "//*[@id='auth-password']";
        WebElement webElement = chromeDriver.findElementByXPath(passwordLocator);
        webElement.clear();
        webElement.sendKeys("testuser123");

    }

    public void pressLoginButton() {
        String submitButtonLocator = "//*[@type='submi']";
        WebElement webElement = chromeDriver.findElementByXPath(submitButtonLocator);
        webElement.click();
    }
}
