package base;

import configurationFileReader.ConfigReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.ExcelReader;
import java.net.MalformedURLException;
import java.net.URL;
import static base.AppiumServerSetup.startServer;
import static base.AppiumServerSetup.stopServer;

public class AppFactory {
    public static AppiumDriver driver;
    public static DesiredCapabilities desiredCapabilities;
    public static ConfigReader configReader;
    public static ExcelReader excel;


@BeforeSuite(alwaysRun = true)
    public void initDriver() throws MalformedURLException, InterruptedException {
        startServer();
        configReader = new ConfigReader();
        excel = new ExcelReader();
        desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName",configReader.getPlateFormName());
        desiredCapabilities.setCapability("platformVersion",configReader.getPlateFormVersion());
        desiredCapabilities.setCapability("deviceName",configReader.getDeviceName());
        //desiredCapabilities.setCapability("deviceName",configReader.getAppPackage());
        desiredCapabilities.setCapability("deviceName",configReader.getAppActivity());
        desiredCapabilities.setCapability("app",System.getProperty("user.dir")+configReader.getApkPath());
        driver = new AndroidDriver(new URL(configReader.getAppiumServerURL()),desiredCapabilities);
        AppDriver.setDriver(driver);
        System.out.println("Android Driver Initialized");
    }

@AfterSuite(alwaysRun = true)
    public void quitDriver() throws InterruptedException {
        if (null != driver) {
            driver.quit();
            System.out.println("Android Driver Session Closed");
        }
        stopServer();
    }
}
