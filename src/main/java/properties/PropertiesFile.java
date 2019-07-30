package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

    private static Properties properties;

    public static String getPropertyByName(String key) {
        return properties.getProperty(key);
    }

    public static String getEnv() {
        return getPropertyByName("env");
    }

    public void createPropertiesFile(String filePath) throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(new File(filePath)));
    }

}
