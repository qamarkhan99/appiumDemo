package pages;

import base.AppDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Common_Utilities;

import java.io.IOException;

public class InputEmailAddressPage {

    public InputEmailAddressPage(){
        PageFactory.initElements(AppDriver.getDriver(), this);
    }

    //Email Address Field
    @FindBy(id = "com.booking:id/identity_text_input_edit_text")
    public WebElement txtEmailAddress;

    //Continue Button
    @FindBy(id = "com.booking:id/identity_landing_social_button_text")
    public WebElement btnContinue;

    public void inputEmailAddress () throws IOException {
        Common_Utilities.waitForElement(txtEmailAddress);
        String randomEmailGenerator = Common_Utilities.generateRandomEmail(15);
        txtEmailAddress.sendKeys(randomEmailGenerator);
    }

    public void inputEmailAddressForSignIn () throws IOException {
        Common_Utilities.waitForElement(txtEmailAddress);
        txtEmailAddress.sendKeys("khan14@gmail.com");
    }

    public void clickContinueButton() throws IOException {
        Common_Utilities.waitForElement(btnContinue);
        btnContinue.click();
    }

}
