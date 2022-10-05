package testcases;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class OpenApp extends TestBase {

    @Test
    public void clickAppButton()  {
        System.out.println("Entering into click app test");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.permissioncontroller:id/permission_deny_button")));
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_deny_button")).click();
        System.out.println("deny clicked");
    }
}
