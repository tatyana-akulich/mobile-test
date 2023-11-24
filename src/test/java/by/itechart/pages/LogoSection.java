package by.itechart.pages;

import io.appium.java_client.AppiumDriver;

public class LogoSection extends BasePage {
    String logoDescription = "shared-optavia-logo";

    public LogoSection(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public String getLogoDescription() {
        return logoDescription;
    }

}
