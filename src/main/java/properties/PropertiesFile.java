package properties;

import lombok.Getter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
    private Properties properties;
    @Getter
    private String jsonUrl;
    @Getter
    private String checkTextEndpoint;


    public void createPropertiesFile(String filePath) throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(new File(filePath)));
    }

    public void getValuesFromPropertiesFile() {
        jsonUrl = properties.getProperty("jsonUrl");
        checkTextEndpoint = properties.getProperty("checkTextEndpoint");
    }
}
