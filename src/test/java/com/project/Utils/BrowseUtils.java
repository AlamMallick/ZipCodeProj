package com.project.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BrowseUtils {

    public static void sleep(int sec){

       // Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        sec*=1000;
        try {
            Thread.sleep(sec);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void scrollDown(int pixels){
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript(("window.scrollBy(0, "+ pixels +")"));
        }

}
