package by.itechart.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    static String platformName;
    static String deviceName;
    static String automationName;
    static String pathToApp;
    static String login;
    static String password;
    static String logFolder;
    static String logFileName;
    static String logLevel;

    public static String getPlatformName() {
        return platformName;
    }

    public static String getDeviceName() {
        return deviceName;
    }

    public static String getAutomationName() {
        return automationName;
    }

    public static String getPathToApp() {
        return pathToApp;
    }


    public static String getLogin() {
        return login;
    }

    public static String getPassword() {
        return password;
    }

    public static String getLogFolder() {
        return logFolder;
    }

    public static String getLogFileName() {
        return logFileName;
    }

    public static String getLogLevel() {
        return logLevel;
    }

    public static void loadProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream = PropertiesLoader.class.getClassLoader().getResourceAsStream("configuration.properties")) {
            properties.load(inputStream);
            platformName = properties.getProperty("platformName");
            deviceName = properties.getProperty("deviceName");
            automationName = properties.getProperty("automationName");
            pathToApp = properties.getProperty("pathToApp");
            login = properties.getProperty("login");
            password = properties.getProperty("password");
            logFolder=properties.getProperty("logFolder");
            logFileName=properties.getProperty("logFileName");
            logLevel=properties.getProperty("logLevel");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
