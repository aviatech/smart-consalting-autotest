package ru.maslenkin.autotest.smartconsalting.pageobject;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class TablePage extends BasePage {
    public static String cellLocator = "//*[@id='page']/div/div/div[1]/div/div[2]" +
            "/div/div/div/div[2]/div/div[1]/div[1]/table/tbody/tr[1]/td[%d]/div/div/div";
    public static String lookPanelInputLocator = "//form[@name='form']/div[1]/div/input";
    //"//*[@id='page']/div/div/div[2]/div/div/div/div[3]/div[2]/form/div[%d]/div/input";


    public void clickTestType() {
        String menuItemLocator = "//a[@class='dropdown-toggle']";
        WebElement webElement = chromeDriver.findElementByXPath(menuItemLocator);
        webElement.click();
    }

    public void clickItemAutotest() {
        String autotestlocator = "//a[contains(text(),'Тестовое-автоматизатор')]";
        WebElement webElement = chromeDriver.findElementByXPath(autotestlocator);
        webElement.click();
    }

    public void clickAdd() {
        String menuAddLocator = "//span[contains(text(),'Добавить')]";
        WebElement webElement = chromeDriver.findElementByXPath(menuAddLocator);
        webElement.click();
    }

    public void setS1(String s1) {
        String s1Locator = "//form[@name='form']/div[1]/div/input";
        WebElement webElement = chromeDriver.findElementByXPath(s1Locator);
        webElement.clear();
        webElement.sendKeys(s1);
    }

    public void setN(String n) {
        String nLocator = "//form[@name='form']/div[2]/div/input";
        WebElement webElement = chromeDriver.findElementByXPath(nLocator);
        webElement.clear();
        webElement.sendKeys(n);
    }

    public void clickButtonSave() {
        String buttonSaveLocator = "//div[@class='input input-offset']";
        WebElement webElement = chromeDriver.findElementByXPath(buttonSaveLocator);
        webElement.click();
    }

    public ArrayList<String> getValueNote(String locator) {
        ArrayList<String> arrayList = new ArrayList<>();
        WebElement webElement;
        for (int i = 1; i <= 2; ++i) {
            webElement = chromeDriver
                    .findElementByXPath(String.format(locator, i));
            if (webElement.getAttribute("value") == null) {
                arrayList.add(webElement.getText());
            } else {
                arrayList.add(webElement.getAttribute("value"));
            }
        }
        return arrayList;
    }

    public void clickDeleteNote() {
        String menuDeleteLocator = "//*[@id='page']/div/div/div[1]/div/div[2]/div/div/div/div[2]/div/div[1]/div[1]/table/tbody/tr/td[3]/div/div/div/div/button";
        WebElement webElement = chromeDriver.findElementByXPath(menuDeleteLocator);
        webElement.click();
    }

    public void clickDeleteButton() {
        String buttonDeleteLocator = "//*[@id='page']/div/div/div[1]/div/div[2]/div/div/div/div[2]/div/div[1]/div[1]/table/tbody/tr/td[3]/div/div/div/div/ul/li/a";
        WebElement webElement = chromeDriver.findElementByXPath(buttonDeleteLocator);
        webElement.click();
    }

    public void clickConfirmDelete() {
        String buttonOkLocator = "/html/body/div[12]/div/div/div[3]/button[1]";
        WebElement webElement = chromeDriver.findElementByXPath(buttonOkLocator);
        webElement.click();
    }

    public void clickLook() {
        String buttonLookLocator = "//*[@id='page']/div/div/div[1]/div/div[2]/div/div/div/div[2]/div/div[1]/div[1]/table/tbody/tr/td[3]/div/div/div/a";
        WebElement webElement = chromeDriver.findElementByXPath(buttonLookLocator);
        webElement.click();
    }

    public void closeLookPanel() {
        String closeLocator = "//*[@id='page']/div/div/div[2]/div/div/div/div[2]/a[1]";
        WebElement webElement = chromeDriver.findElementByXPath(closeLocator);
        webElement.click();
    }


}
