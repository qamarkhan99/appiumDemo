package testCases;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class NativeAppTest {

    public static AndroidDriver driver;
    public static AppiumServiceBuilder serviceBuilder;
    public static AppiumDriverLocalService server;

    public static void main(String[] args) throws MalformedURLException {

        startServer();

        File app = new File(".\\src\\test\\resources\\app\\selendroid-test-app-0.17.0.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        //desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.samsung.android.dialer.DialtactsActivity");
        //desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.samsung.android.dialer");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        //driver.findElement(By.xpath("//android.widget.RelativeLayout[@content-desc='1,Voicemail']/android.widget.TextView\n'")).click();


        driver.quit();
        stopServer();

    }

    public static void startServer() {
        serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"));
        serviceBuilder.withAppiumJS(new File("C:\\Users\\qamar.munir\\AppData\\Local\\Programs\\Appium Server GUI\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"));
        serviceBuilder.withIPAddress("127.0.0.1");
        serviceBuilder.withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/");
        serviceBuilder.usingPort(4723);
        server = AppiumDriverLocalService.buildService(serviceBuilder);
        server.start();

    }

    public static void stopServer() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("taskkill /F /IM node.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
