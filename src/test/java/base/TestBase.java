package base;

import configurationFileReader.ConfigReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import java.net.URL;
import static base.AppiumServerSetup.startServer;
import static base.AppiumServerSetup.stopServer;



public class TestBase {
    public static AppiumDriver driver;
    ConfigReader configReader = new ConfigReader();


    @BeforeTest
    public void initDriver() throws MalformedURLException, InterruptedException {
        startServer();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName",configReader.getPlateFormName());
        desiredCapabilities.setCapability("platformVersion",configReader.getPlateFormVersion());
        desiredCapabilities.setCapability("deviceName",configReader.getDeviceName());
        desiredCapabilities.setCapability("deviceName",configReader.getAppPackage());
        desiredCapabilities.setCapability("app",System.getProperty("user.dir")+configReader.getApkPath());
        driver = new AndroidDriver(new URL(configReader.getAppiumServerURL()),desiredCapabilities);
        System.out.println("Android Driver Initialized");
    }

    @AfterTest
    public void quitDriver() throws InterruptedException {
        if (null != driver) {
            driver.quit();
            System.out.println("Android Driver Session Closed");
        }
        stopServer();
    }
}
