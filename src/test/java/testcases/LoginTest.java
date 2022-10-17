package testcases;

import base.AppFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import utilities.DataProviderUtil;
import java.io.IOException;
import java.util.Hashtable;


public class LoginTest extends AppFactory {

    private LoginPage loginPage;
    private InputEmailAddressPage inputEmailAddressPage;
    private CreatePasswordPage createPasswordPage;
    private WelcomePage welcomePage;
    private SoftAssert softAssert;

    @BeforeClass
    public void init() {
        loginPage = new LoginPage();
        inputEmailAddressPage = new InputEmailAddressPage();
        createPasswordPage = new CreatePasswordPage();
        welcomePage = new WelcomePage();
        softAssert = new SoftAssert();
    }
    @Test(priority = 1,dataProviderClass = DataProviderUtil.class,dataProvider = "dp")
    public void loginTest(Hashtable<String,String> data) throws InterruptedException, IOException {
        loginPage.clickYourAccountButton();
        System.out.println("Create your account clicked");
        inputEmailAddressPage.inputEmailAddress(data.get("Email"));
        inputEmailAddressPage.clickContinueButton();
        Thread.sleep(3000);
        softAssert.assertEquals("Create a password",createPasswordPage.getHeaderCreatePasswordPage());
        createPasswordPage.inputPassword(data.get("Password"));
        createPasswordPage.inputConfirmPassword();
        createPasswordPage.clickBtnCreateAccountAndSignIn();
        //Welcome, Page verification
        Assert.assertEquals("Welcome to Booking.com!",welcomePage.getHeaderWelcomePage());
        welcomePage.clickButtonStartSearching();
        //click button profile
        welcomePage.clickButtonProfile();
        welcomePage.clickSignOut();
        welcomePage.clickButtonProceed();
    }

}
