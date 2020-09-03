package ru.maslenkin.autotest.smartconsalting;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.maslenkin.autotest.smartconsalting.pageobject.LoginPage;
import ru.maslenkin.autotest.smartconsalting.pageobject.TablePage;

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
    public void testNoteS1Positive() {
        Assert.assertEquals(tablePage.getValueNote().get(0), S1);
    }

    @Test(description = "positive test", priority = 2)
    public void testNoteNPositive() {
        Assert.assertEquals(tablePage.getValueNote().get(1), N);
    }

    @Test(priority = 3)
    public void testNoteLookPanel() {
        tablePage.clickLook();
        tablePage.closeLookPanel();

        //*[@id="page"]/div/div/div[2]/div/div/div/div[3]/div[2]/form/div[1]/div/input
    }


  /*  @AfterTest
    public void delete() {
        tablePage.clickDeleteNote();
        tablePage.clickDeleteButton();
        tablePage.confirmDelete();
    }*/

    @Test(description = "negative test", priority = 5, enabled = false)
    public void testNoteNegative() {
        Assert.assertEquals(tablePage.getValueNote().get(0), S1);
        Assert.assertEquals(tablePage.getValueNote().get(1), N);
    }




}
