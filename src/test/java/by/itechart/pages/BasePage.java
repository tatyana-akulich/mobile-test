package by.itechart.pages;

import by.itechart.BaseTest;
import by.itechart.util.PropertiesLoader;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    AndroidDriver driver;
    Logger log;
    WebDriverWait wait;
    String platform;

    public BasePage(AndroidDriver androidDriver) {
        driver = androidDriver;
        log = BaseTest.getLog();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        platform = PropertiesLoader.getPlatform();
    }
}
