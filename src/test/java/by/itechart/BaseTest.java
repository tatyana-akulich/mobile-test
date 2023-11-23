package by.itechart;

import by.itechart.pages.LoginPage;
import by.itechart.util.LogConfigurator;
import by.itechart.util.PropertiesLoader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public WebDriverWait wait;
    AppiumDriverLocalService service;
    AndroidDriver driver;
    public static Logger log;

    @BeforeAll
    public void beforeAll() throws MalformedURLException {
        PropertiesLoader.loadProperties();
        LogConfigurator.configureLogs();
        log = LogManager.getLogger();
        connectToAppiumServer();
        driver = setDriverOptions();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static Logger getLog() {
        return log;
    }

    public void connectToAppiumServer() {
        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();
    }

    @AfterAll
    public void closeServer() {
        service.stop();
    }

    public AndroidDriver setDriverOptions() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName(PropertiesLoader.getPlatformName())
                .setDeviceName(PropertiesLoader.getDeviceName())
                .setAutomationName(PropertiesLoader.getAutomationName())
                .setApp(PropertiesLoader.getPathToApp());
        return new AndroidDriver(
                new URL("http://127.0.0.1:4723"), options
        );
    }
}
