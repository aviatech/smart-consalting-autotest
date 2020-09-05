package ru.maslenkin.autotest.smartconsalting.pageobject;

import ru.maslenkin.autotest.smartconsalting.WDriver;

public class BasePage {
    WDriver chromeDriver = WDriver.getInstance();

    public void open() {
        chromeDriver.get("http://point3.smart-consulting.ru/#/login/");
        chromeDriver.fullScreenBrowser();
    }

    public void close() {
        chromeDriver.closeBrowser();
    }

}
