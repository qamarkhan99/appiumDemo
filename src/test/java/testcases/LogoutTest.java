package testcases;

import base.AppFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.io.IOException;
import java.net.MalformedURLException;

public class LogoutTest extends AppFactory {
    private LoginPage loginPage;
    private InputEmailAddressPage inputEmailAddressPage;
    private CreatePasswordPage createPasswordPage;
    private WelcomePage welcomePage;
    private SoftAssert softAssert;
    private EnterPasswordPage enterPasswordPage;

    @BeforeClass
    public void init() throws MalformedURLException, InterruptedException {
        loginPage = new LoginPage();
        inputEmailAddressPage = new InputEmailAddressPage();
        createPasswordPage = new CreatePasswordPage();
        welcomePage = new WelcomePage();
        softAssert = new SoftAssert();
        enterPasswordPage = new EnterPasswordPage();
    }
        @Test(priority = 2)
        public void verifyLogoutTest() throws IOException, InterruptedException {
        welcomePage.clickButtonSignIn();
        loginPage.clickButtonSignInWithEmail();
        inputEmailAddressPage.inputEmailAddressForSignIn();
        inputEmailAddressPage.clickContinueButton();
        Thread.sleep(3000);
        createPasswordPage.inputPassword();
        enterPasswordPage.clickButtonSignIn();
       // welcomePage.clickButtonStartSearching();
        welcomePage.clickButtonProfile();
        welcomePage.clickSignOut();
        welcomePage.clickButtonProceed();
        //Sign out verification
        softAssert.assertEquals("Sign in to see deals and Genius discounts, manage your trips, and more", welcomePage.getHeaderTitleAfterSignOut());

        }


}
