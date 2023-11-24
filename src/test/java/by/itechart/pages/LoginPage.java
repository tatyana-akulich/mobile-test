package by.itechart.pages;

import by.itechart.util.PropertiesLoader;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    By loginInput = AppiumBy.accessibilityId("login-username-input");
    By passwordInput = AppiumBy.accessibilityId("login-password-input");
    By loginButton = AppiumBy.accessibilityId("login-login-button");

    public LoginPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
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

    public void login(){
        log.warn("Wait until login page is loaded");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLoginInput()));
        enterValidLogin().enterValidPassword().clickLoginButton();
    }
}
