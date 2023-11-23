package by.itechart.pages;

import io.appium.java_client.android.AndroidDriver;

public class LogoSection extends BasePage {
    String logoDescription = "shared-optavia-logo";

    public LogoSection(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public String getLogoDescription() {
        return logoDescription;
    }

}
