package helpers;

import java.io.InputStream;
import java.util.Properties;
import helpers.PageText.Language;
//import base.DriverContainer.Driver;

public class Environment {
    private static Properties environment;
    static {
        environment = new Properties();
        InputStream is = Environment.class.getResourceAsStream("/environment.properties");
        try {
            environment.load(is);
        }
        catch (Exception ex) {
            System.out.println("Error reading property file.");
        }
    }

    public static String getEnvironment(String propertyName){
        return environment.getProperty(propertyName);
    }

    public static Language getLanguage() {
        String value = environment.getProperty("Global.language");
        return Language.valueOf(value);
    }
//
//    public static Driver getBrowser() {
//        String value = environment.getProperty("Global.browser");
//        return Driver.valueOf(value);
//    }
}
