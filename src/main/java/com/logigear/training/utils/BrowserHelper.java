package com.logigear.training.utils;

import com.logigear.training.drivermanager.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class BrowserHelper {
    public static void setUpBrowser(String browser) {
        switch (browser) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                DriverManager.setDriver(new ChromeDriver());
                break;
            case "IE":
                WebDriverManager.iedriver().arch32().setup();
                DriverManager.setDriver(new InternetExplorerDriver());
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                DriverManager.setDriver(new FirefoxDriver());
                break;
            default:
                throw new RuntimeException();
        }
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }
}
