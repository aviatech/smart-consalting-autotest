package ru.maslenkin.autotest.smartconsalting;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WDriver {
    private static Logger logger = LogManager.getLogger();
    private static WDriver instance;
    static ChromeDriver chromeDriver = null;
    public static WebDriverWait waitElement = null;

    public static WDriver getInstance() {
        if (instance == null) {
            instance = new WDriver();
        }
        return instance;
    }

    private WDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeDriver = new ChromeDriver(chromeOptions);
        waitElement = new WebDriverWait(chromeDriver, 10, 250);
    }

    public WebElement findElementByXPath(String xpath) {
        WebElement element = null;
        for (int i = 0; i < 5; i++) {
            try {
                element = waitElement.until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                element = waitElement.until(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                element = waitElement.until(
                        ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

                ((JavascriptExecutor) chromeDriver).executeScript(
                        "arguments[0].scrollIntoView(true);", element);
            } catch (StaleElementReferenceException e1) {
                continue;
            } catch (Exception e) {
                File file = ((TakesScreenshot) chromeDriver).
                        getScreenshotAs(OutputType.FILE);
                try {
                    SimpleDateFormat format = new SimpleDateFormat("dd.MM.HH-mm-ss");
                    Date date = new Date();
                    FileUtils.copyFile(file, new File(
                            String.format("screenshots/%s-scr.jpg",
                                    format.format(date))));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        logger.info(String.format("Find element by locator '%s'", xpath));
        return element;
    }

    public void get(String url) {
        logger.info(String.format("Open page '%s'", url));
        chromeDriver.get(url);
    }

    public void fullScreenBrowser() {
        chromeDriver.manage().window().maximize();
    }

    public void closeBrowser() {
        chromeDriver.close();
    }

}
