package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static Properties prop;

    static {
        try (InputStream input = ConfigManager.class.getClassLoader().getResourceAsStream("configuration.properties")) {
            prop = new Properties();
            prop.load(input);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static String getBaseUrl()
    { return prop.getProperty("baseUrl"); }

    public static String getUsername() {
        return prop.getProperty("username");
    }

    public static String getPassword() {
        return prop.getProperty("password");
    }
}
