package ru.maslenkin.autotest.smartconsalting.pageobject;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class TablePage extends BasePage {
    public static String cellLocator = "//tr[@class='grid-row data  odd ng-scope active']/td[%d]";
    public static String lookPanelInputLocator = "//form[@name='form']/div[%d]/div/input";

    public void clickTestType() {
        String menuItemLocator = "//a[@class='dropdown-toggle']";
        WebElement webElement = chromeDriver.findElementByXPath(menuItemLocator);
        webElement.click();
    }

    public void clickItemAutotest() {
        String autotestlocator = "//ul[@class='dropdown-panel-menu dt-scroll-container']/li[2]";
        WebElement webElement = chromeDriver.findElementByXPath(autotestlocator);
        webElement.click();
    }

    public void clickAdd() {
        String menuAddLocator = "//button[@type='button']/span[@class='button-title ng-binding']";
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
            webElement = chromeDriver.findElementByXPath(String.format(locator, i));
            if (webElement.getAttribute("value") != null) {
                arrayList.add(webElement.getAttribute("value"));
            } else {
                arrayList.add(webElement.getText());
            }
        }
        return arrayList;
    }

    public void clickDeleteNote() {
        String menuDeleteLocator = "//button[@class='btn btn-simple-icon dropdown-toggle']";
        WebElement webElement = chromeDriver.findElementByXPath(menuDeleteLocator);
        webElement.click();
    }

    public void clickDeleteButton() {
        String buttonDeleteLocator = "//ul[@class='dropdown-menu dropdown-panel-fixed']";
        WebElement webElement = chromeDriver.findElementByXPath(buttonDeleteLocator);
        webElement.click();
    }

    public void clickConfirm() {
        String buttonOkLocator = "/html/body/div[12]/div/div/div[3]/button[1]";
        WebElement webElement = chromeDriver.findElementByXPath(buttonOkLocator);
        webElement.click();
    }

    //div[@class='ng-isolate-scope grid-cell-actionlink']/div/a
    public void clickLook() {
        String buttonLookLocator = "//a[@class='btn btn-simple-icon grid-action-btn']";
        WebElement webElement = chromeDriver.findElementByXPath(buttonLookLocator);
        webElement.click();
    }

    public void closeLookPanel() {
        String closeLocator = "//div[@class='form-panel-header dt-sidepage-header']/a/i";
        WebElement webElement = chromeDriver.findElementByXPath(closeLocator);
        webElement.click();
    }

    public void findNoDataFound() {
        String noDataFoundLocator = "//td[ contains(text(), 'Данных не найдено')]";
        WebElement webElement = chromeDriver.findElementByXPath(noDataFoundLocator);
    }


}
