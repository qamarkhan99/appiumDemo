package pages;

import base.AppDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Common_Utilities;

import java.io.IOException;

public class EnterPasswordPage {

    public EnterPasswordPage (){
         PageFactory.initElements(AppDriver.getDriver(), this);
}

    //Password - Text Field
    @FindBy(id = "com.booking:id/identity_text_input_edit_text")
    public WebElement txtPassword;

    //sign in button
    @FindBy(xpath = "//android.widget.Button[@resource-id='com.booking:id/identity_landing_social_button']")
    public WebElement btn_Sign_In;

    public void clickButtonSignIn() throws IOException {
        Common_Utilities.waitForElement(btn_Sign_In);
        btn_Sign_In.click();
    }

    public void inputPassword() throws IOException {
        Common_Utilities.waitForElement(txtPassword);
        txtPassword.sendKeys("Testing123");
    }
}
