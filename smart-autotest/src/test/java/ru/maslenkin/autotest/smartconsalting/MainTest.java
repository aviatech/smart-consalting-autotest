package ru.maslenkin.autotest.smartconsalting;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.maslenkin.autotest.smartconsalting.pageobject.LoginPage;
import ru.maslenkin.autotest.smartconsalting.pageobject.TablePage;

import java.util.ArrayList;

public class MainTest {
    LoginPage loginPage = new LoginPage();
    TablePage tablePage = new TablePage();
    private final String S1 = "nameTestnew";
    private final String N = "1232";
    private final String N1 = "asd";

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
        tablePage.clickAdd();
    }

    @BeforeClass
    public void setData() {
        tablePage.setS1(S1);
        tablePage.setN(N);
        tablePage.clickButtonSave();
    }

    @Test(description = "positive test", priority = 1)
    public void testNotePositive() {
        ArrayList<String> arrayList = tablePage.getValueNote(TablePage.cellLocator);
        Assert.assertEquals(arrayList.get(0), S1);
        Assert.assertEquals(arrayList.get(1), N);
    }

    @Test(priority = 2, enabled = true)
    public void testNoteLookPanel() {
        tablePage.clickLook();
        ArrayList<String> arrayList = tablePage.getValueNote(TablePage.lookPanelInputLocator);
        Assert.assertEquals(arrayList.get(0), S1);
        Assert.assertEquals(arrayList.get(1), S1);
        tablePage.closeLookPanel();
    }


    @AfterTest
    public void delete() {
        tablePage.clickDeleteNote();
        tablePage.clickDeleteButton();
        tablePage.clickConfirmDelete();
    }

    @Test(description = "negative test", priority = 5, enabled = false)
    public void testNoteNegative() {
        Assert.assertEquals(tablePage.getValueNote(TablePage.cellLocator).get(0), S1);
        Assert.assertEquals(tablePage.getValueNote(TablePage.cellLocator).get(1), N);
    }
}
