package testcases;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class OpenApp extends TestBase {

    @Test
    public void clickAppButton() throws InterruptedException {
        System.out.println("Entering into click app test");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id='com.booking:id/identity_landing_social_button']")));
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.booking:id/identity_landing_social_button']")).click();
        Thread.sleep(10000);
        System.out.println("Create your account clicked");

    }
}
