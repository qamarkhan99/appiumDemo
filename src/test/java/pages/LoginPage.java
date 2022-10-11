package pages;

import base.AppDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Common_Utilities;
import java.io.IOException;



public class LoginPage  {


    public LoginPage() {
        PageFactory.initElements(AppDriver.getDriver(), this);
    }

    //Create your account button
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.booking:id/identity_landing_social_button_text' or text()='Create your account']")
    public WebElement btnCreateAccount;

    //Sign in with email
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView")
    public WebElement btn_Sign_In_With_Email;

    public void clickButtonSignInWithEmail() throws IOException {
        Common_Utilities.waitForElement(btn_Sign_In_With_Email);
        btn_Sign_In_With_Email.click();
    }

    public void clickYourAccountButton() throws IOException {
        Common_Utilities.waitForElement(btnCreateAccount);
        btnCreateAccount.click();
    }

}
