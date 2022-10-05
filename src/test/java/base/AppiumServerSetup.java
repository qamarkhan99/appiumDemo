package base;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import java.io.File;
import java.io.IOException;

public class AppiumServerSetup {

    public static AppiumServiceBuilder serviceBuilder;
    public static AppiumDriverLocalService server;


    public static void startServer() throws InterruptedException {
        serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"));
        serviceBuilder.withAppiumJS(new File("C:\\Users\\qamar.munir\\AppData\\Local\\Programs\\Appium Server GUI\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"));
        serviceBuilder.withIPAddress("127.0.0.1");
        serviceBuilder.withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/");
        serviceBuilder.usingPort(4723);
        server = AppiumDriverLocalService.buildService(serviceBuilder);
        server.start();
        System.out.println("Server Started Successfully");
    }

    public static void stopServer() throws InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("taskkill /F /IM node.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Server stopped successfully");
    }
}
