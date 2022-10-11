package pages;

import base.AppDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Common_Utilities;

import java.io.IOException;

public class CreatePasswordPage {

    public CreatePasswordPage(){
        PageFactory.initElements(AppDriver.getDriver(), this);
    }

    //Password - Text Field
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")
    public WebElement txtPassword;

    //Confirm Password - Text Field
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")
    public WebElement txtConfirmPassword;

    //Create Password page - header title
    @FindBy(id = "com.booking:id/identity_header_title")
    public WebElement txt_header_createPassword;

    //Create account and sign in button
    @FindBy(id = "com.booking:id/identity_landing_social_button_text")
    public WebElement btn_createAccount_SignIn;


    public void inputPassword() throws IOException {
        Common_Utilities.waitForElement(txtPassword);
        txtPassword.sendKeys("Testing123");
    }

    public void inputConfirmPassword() throws IOException {
        Common_Utilities.waitForElement(txtConfirmPassword);
        txtConfirmPassword.sendKeys("Testing123");
    }

    public String getHeaderCreatePasswordPage () throws IOException {
        Common_Utilities.waitForElement(txt_header_createPassword);
        String title = txt_header_createPassword.getText();
        return title;
    }

    public void clickBtnCreateAccountAndSignIn (){
        btn_createAccount_SignIn.click();
    }

}
