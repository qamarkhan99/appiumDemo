package configurationFileReader;

import java.io.*;
import java.util.Properties;

public class ConfigReader {
    public static Properties properties = new Properties();
    public static FileInputStream fis;


    /* public ConfigReader(){

        String propertyFilePath = "\\src\\test\\resources\\properties\\Config.properties";

        try {
            fis = new FileInputStream(System.getProperty("user.dir")+propertyFilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(fis);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration Properties not found at " +propertyFilePath);
        }

    }

     */

    public ConfigReader(){
        BufferedReader bufferedReader;
        String propertyFilePath = "src/test/resources/properties/Config.properties";
        try{
            bufferedReader = new BufferedReader(new FileReader(propertyFilePath));
            try{
                properties.load(bufferedReader);
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Property Configuration does not exist at" +propertyFilePath);
        }

    }

    // get plateFormName
    public String getPlateFormName(){
        String platformName = properties.getProperty("platformName");
        System.out.println("Test"+platformName);
        if (platformName !=null)
            return platformName;
        else{
            throw new RuntimeException("PlatformName not specified in config.property file");
        }
    }

    // get plateFormVersion
    public String getPlateFormVersion(){
        String platformVersion = properties.getProperty("platformVersion");
        if (platformVersion !=null)
            return platformVersion;
        else{
            throw new RuntimeException("PlatformVersion not specified in config.property file");
        }
    }

    // get deviceName
    public String getDeviceName(){
        String deviceName = properties.getProperty("deviceName");
        if (deviceName !=null)
            return deviceName;
        else{
            throw new RuntimeException("deviceName not specified in config.property file");
        }
    }

    // get apkPath
    public String getApkPath(){
        String apkPath = properties.getProperty("apkPath");
        if (apkPath !=null)
            return apkPath;
        else{
            throw new RuntimeException("apkPath not specified in config.property file");
        }
    }

    // get appiumServerURL
    public String getAppiumServerURL(){
        String appiumServerURL = properties.getProperty("appiumServerURL");
        if (appiumServerURL !=null)
            return appiumServerURL;
        else{
            throw new RuntimeException("appiumServerURL not specified in config.property file");
        }
    }

// app package
public String getAppPackage() {
    String appPackage = properties.getProperty("appPackage");
    if (appPackage != null)
        return appPackage;
    else {
        throw new RuntimeException("appPackage not specified in config.property file");
    }
}



}
