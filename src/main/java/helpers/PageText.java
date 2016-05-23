package helpers;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import static helpers.Environment.getLanguage;

public class PageText {
    private static Properties pageText;
    private static Language language = getLanguage();

    enum Language {
        en,
        ru
    }

    static {
        pageText = new Properties();
        InputStream is;
        switch (language) {
            case en:
                is = PageText.class.getResourceAsStream("/en-us.properties");
                break;
            case ru:
                is = PageText.class.getResourceAsStream("/ru-ru.properties");
                break;
            default:
                is = PageText.class.getResourceAsStream("/ru-ru.properties");
                break;
        }
        try {
            pageText.load(new InputStreamReader(is, "UTF-8"));
        }
        catch (Exception ex) {
            System.out.println("Error reading property file.");
        }
    }

    public static String getPageText(String propertyName){
        return pageText.getProperty(propertyName);
    }
}
