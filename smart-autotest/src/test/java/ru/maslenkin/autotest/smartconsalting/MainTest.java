package ru.maslenkin.autotest.smartconsalting;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.maslenkin.autotest.smartconsalting.pageobject.LoginPage;
import ru.maslenkin.autotest.smartconsalting.pageobject.TablePage;

import java.util.ArrayList;

public class MainTest {
    LoginPage loginPage = new LoginPage();
    TablePage tablePage = new TablePage();
    private final String S1_CORRECT = "nameTestnew";
    private final String N_CORRECT = "1232";

    @BeforeSuite
    public void openPage() {
        loginPage.open();
    }

    @BeforeTest
    public void login() {
        loginPage.setLogin("testuser");
        loginPage.setPassword("testuser123");
        loginPage.pressLoginButton();
        tablePage.clickTestType();
        tablePage.clickItemAutotest();
    }

    @Test(description = "positive test", priority = 1)
    public void testNotePositive() {
        tablePage.clickAdd();
        tablePage.setS1(S1_CORRECT);
        tablePage.setN(N_CORRECT);
        tablePage.clickButtonSave();
        ArrayList<String> arrayList = tablePage.getValueNote(TablePage.cellLocator);
        Assert.assertEquals(arrayList.get(0), S1_CORRECT);
        Assert.assertEquals(arrayList.get(1), N_CORRECT);
    }

    @Test(priority = 2, enabled = true)
    public void testNoteLookPanel() {
        tablePage.clickLook();
        ArrayList<String> arrayList = tablePage.getValueNote(TablePage.lookPanelInputLocator);
        Assert.assertEquals(arrayList.get(0), S1_CORRECT);
        Assert.assertEquals(arrayList.get(1), N_CORRECT);
    }

    @Test(description = "negative test", priority = 4, enabled = true)
    public void testNoteNegative() {
        tablePage.clickAdd();
        tablePage.setS1(S1_CORRECT);
        String n1NotCorrect = "asd";
        tablePage.setN(n1NotCorrect);
        tablePage.clickButtonSave();
        Assert.assertEquals(tablePage.getValueNote(TablePage.lookPanelInputLocator).get(0), S1_CORRECT);
        Assert.assertEquals(tablePage.getValueNote(TablePage.lookPanelInputLocator).get(1), n1NotCorrect);
        tablePage.closeLookPanel();
        tablePage.clickConfirm();
        tablePage.findNoDataFound();
    }

    @Test(priority = 3)
    public void delete() {
        tablePage.closeLookPanel();
        tablePage.clickDeleteNote();
        tablePage.clickDeleteButton();
        tablePage.clickConfirm();
    }

    @AfterSuite
    void closeBrowserApp() {
        loginPage.close();
    }


}
