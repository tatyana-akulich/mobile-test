package by.itechart.pages;

import by.itechart.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;

public class BasePage {
    AndroidDriver driver;
    Logger log;

    public BasePage(AndroidDriver androidDriver) {
        driver = androidDriver;
        log = BaseTest.getLog();
    }
}
