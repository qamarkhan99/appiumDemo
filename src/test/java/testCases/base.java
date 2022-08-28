package testCases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;


public class base {
    public static AndroidDriver driver;
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME,"Chrome");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android");
        //desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
        driver.get("http://google.com");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("q")).sendKeys("Appium");
        Thread.sleep(10000);
        driver.quit();

    }
}
