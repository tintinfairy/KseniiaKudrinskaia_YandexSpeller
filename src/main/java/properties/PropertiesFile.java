package properties;

import enums.UriElements;
import lombok.Getter;
import org.apache.http.client.utils.URIBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
    private Properties properties;
    @Getter
    private String env;
    @Getter
    private String checkTextEndpoint;


    public String getURI(String scheme, String path) {
        return new URIBuilder()
                .setScheme(scheme)
                .setHost(env)
                .setPath(path)
                .toString();
    }

    public void createPropertiesFile(String filePath) throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(new File(filePath)));
        env = properties.getProperty("env");
        checkTextEndpoint = getURI(UriElements.HTTPS_SCHEME.getElement(), UriElements.PATH.getElement());
    }

}
