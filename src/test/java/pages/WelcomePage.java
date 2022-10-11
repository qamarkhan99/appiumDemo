package pages;

import base.AppDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Common_Utilities;
import java.io.IOException;
import static base.AppFactory.driver;

public class WelcomePage {
    public WelcomePage(){
        PageFactory.initElements(AppDriver.getDriver(), this);
    }

    //Welcome page - header title
    @FindBy(id = "com.booking:id/bui_empty_state_title")
    public WebElement txt_header_WelcomePage;

    //Welcome page - Start Searching button
    @FindBy(id = "com.booking:id/bui_empty_state_primary_action")
    public WebElement btn_StartSearching;

    //Welcome page - Click Profile
    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Profile']/android.widget.ImageView")
    public WebElement btn_Profile;

    //Profile - Sign out button
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[11]/android.widget.TextView")
    public WebElement btn_SignOut;

    //sign out popup - proceed button
    @FindBy(id = "android:id/button1")
    public WebElement btn_Proceed;

    //profile header for verification of sign out
    @FindBy(id = "com.booking:id/facet_profile_header_sign_in_warning")
    public WebElement title_Profile_Header;


    //sign in button
    @FindBy(id = "com.booking:id/facet_profile_header_sign_in_cta")
    public WebElement btn_Sign_In;

    public void clickButtonSignIn() throws IOException {
        Common_Utilities.waitForElement(btn_Sign_In);
        btn_Sign_In.click();
    }



    public String getHeaderTitleAfterSignOut () throws IOException {
        Common_Utilities.waitForElement(title_Profile_Header);
        String title = title_Profile_Header.getText();
        return title;
    }


    public String getHeaderWelcomePage () throws IOException {
        Common_Utilities.waitForElement(txt_header_WelcomePage);
        String title = txt_header_WelcomePage.getText();
        return title;
    }

    public void clickButtonStartSearching () throws IOException {
        Common_Utilities.waitForElement(btn_StartSearching);
        btn_StartSearching.click();
    }

    public void clickButtonProceed() throws IOException {
        Common_Utilities.waitForElement(btn_Proceed);
        btn_Proceed.click();
    }

    public void clickButtonProfile () throws IOException {
        Common_Utilities.waitForElement(btn_Profile);
        btn_Profile.click();
    }

    public void clickSignOut () throws IOException {
        //scroll down to the element and click
        Common_Utilities.verticalScroll(driver);
        Common_Utilities.waitForElement(btn_SignOut);
        btn_SignOut.click();
    }

}
