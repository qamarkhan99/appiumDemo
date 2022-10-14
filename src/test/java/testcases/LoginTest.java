package testcases;

import base.AppFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import java.io.IOException;
import java.net.MalformedURLException;



public class LoginTest extends AppFactory {

    private LoginPage loginPage;
    private InputEmailAddressPage inputEmailAddressPage;
    private CreatePasswordPage createPasswordPage;
    private WelcomePage welcomePage;
    private SoftAssert softAssert;

    @BeforeClass
    public void init() throws MalformedURLException, InterruptedException {
        loginPage = new LoginPage();
        inputEmailAddressPage = new InputEmailAddressPage();
        createPasswordPage = new CreatePasswordPage();
        welcomePage = new WelcomePage();
        softAssert = new SoftAssert();
    }
    @Test(priority = 1)
    public void verifyLoginTest() throws InterruptedException, IOException {
        loginPage.clickYourAccountButton();
        System.out.println("Create your account clicked");
        inputEmailAddressPage.inputEmailAddress();
        inputEmailAddressPage.clickContinueButton();
        Thread.sleep(3000);
        softAssert.assertEquals("Create a password",createPasswordPage.getHeaderCreatePasswordPage());
        createPasswordPage.inputPassword();
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
