package by.itechart.pages;

import by.itechart.util.PropertiesLoader;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    By loginInput = AppiumBy.accessibilityId("login-username-input");
    By passwordInput = AppiumBy.accessibilityId("login-password-input");
    By loginButton = AppiumBy.accessibilityId("login-login-button");

    public LoginPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public LoginPage enterValidLogin() {
        WebElement login = driver.findElement(loginInput);
        login.sendKeys(PropertiesLoader.getLogin());
        return this;
    }

    public LoginPage enterValidPassword() {
        WebElement password = driver.findElement(passwordInput);
        password.sendKeys(PropertiesLoader.getPassword());
        return this;
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public By getLoginInput() {
        return loginInput;
    }
}
