package utilities;

import base.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static base.AppFactory.driver;
import static java.time.Duration.ofMillis;
import static java.util.Collections.singletonList;


public class Common_Utilities {

    public static String generateRandomEmail(int length) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890";
        String email = "";
        String temp = RandomStringUtils.random(length, allowedChars);
        email = temp.substring(0, temp.length() - 9) + "@gmail.com";
        return email;
    }

    public static boolean waitForElement(WebElement element) throws IOException {
        boolean isElementPresent = true;
        try {
            WebDriverWait wait = new WebDriverWait(AppDriver.getDriver(), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(element));
            System.out.println(element + "is visible");
            return isElementPresent;
        } catch (Exception e) {
            System.out.println("waitForElement method failed! " + e.getMessage());
            return !isElementPresent;
        }
    }


    public static void verticalScroll (AppiumDriver driver){
        WebElement element01 = driver.findElement(AppiumBy.id("com.booking:id/navigation_drawer_list"));
        int centerX = element01.getRect().x + (element01.getSize().width/2);
        double startY = element01.getRect().y + (element01.getSize().height * 0.9);
        double endY = element01.getRect().y + (element01.getSize().height * 0.1);

        // Type of pointer
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
        //Creating sequence object
        Sequence sequence = new Sequence(finger,1);
        /*
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0),PointerInput.Origin.viewport(),centerX,(int)startY));
        swipe.addAction(finger.createPointerDown(0));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), centerX, (int)endY));
        swipe.addAction((finger.createPointerUp(0)));
        driver.perform(List.of(swipe));

         */
        sequence.addAction(finger.createPointerMove(ofMillis(0), PointerInput.Origin.viewport(), centerX, (int)startY));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        sequence.addAction(new Pause(finger, ofMillis(600)));
        sequence.addAction(finger.createPointerMove(ofMillis(600), PointerInput.Origin.viewport(), centerX + 400,(int)endY));
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
        driver.perform(singletonList(sequence));
    }

    }


